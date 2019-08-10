package com.exl_si.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.db.vo.FileObjectProvider;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.db.vo.SubFile;
import com.exl_si.exception.UploadException;


public class UploadUtil {
	final public static String allow_suffix_List="jpg,gif,png,jpeg";  
	
	private static boolean checkFileSuffix(String suffix){  
        return allow_suffix_List.contains(suffix.trim().toLowerCase());
	}  
	
	public static void showByImageIO(String filePath, OutputStream ops) throws IOException{
		File file = new File(filePath);
		BufferedImage image = ImageIO.read(file);
		ImageIO.write(image, "png", ops);
	}
	
	@SuppressWarnings("resource")
	public static void showByIOStream(String filePath, OutputStream ops) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
        int count = 0;
        byte[] buffer = new byte[1024 * 1024];
        while ((count = fis.read(buffer)) != -1) {
        	ops.write(buffer, 0, count);
        	ops.flush();
        }
	}
	
	public static List<SubFile> uploadImageByThumbnails(MultipartHttpServletRequest request, String uploadPath, FileObjectEnums obj) throws UploadException, InstantiationException, IllegalAccessException {
		return upload(request, uploadPath, obj, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException {
				Thumbnails.of(multipartFile.getInputStream()).scale(1.0).toFile(uploadPath);
            } 
		});
	}

	public static List<SubFile> uploadImageByImageIO(MultipartHttpServletRequest request, String uploadPath, FileObjectEnums obj) throws UploadException, InstantiationException, IllegalAccessException {
		return upload(request, uploadPath, obj, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException {
                BufferedImage img = ImageIO.read(multipartFile.getInputStream());
                BufferedImage inputbig = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_BGR);
                Graphics2D g = (Graphics2D) inputbig.getGraphics();
                g.drawImage(img, 0, 0,img.getWidth(),img.getHeight(),null); //画图
                g.dispose();
                inputbig.flush();
                ImageIO.write(inputbig, "JPEG", new File(uploadPath));
            }
		});
	}
	
	@SuppressWarnings("resource")
	public static List<SubFile> uploadFileByIOStream(MultipartHttpServletRequest request, String uploadPath, FileObjectEnums obj) throws UploadException, InstantiationException, IllegalAccessException {
		return upload(request, uploadPath, obj, new UploadMethod() {
			@Override
			public void upload(MultipartFile multipartFile, String uploadPath) throws IOException  {
				InputStream is = null;  
	            OutputStream os = null;  
	            is = multipartFile.getInputStream();  
	            os = new FileOutputStream(uploadPath);  
	            byte[] buffer = new byte[1024];  
	            int len = 0;  
	                
	            while((len = is.read(buffer))>0){  
	              os.write(buffer, 0, len);  
	              os.flush();
	            } 
			}
		});
	}
	
	private static List<SubFile> upload(MultipartHttpServletRequest request, String uploadPath, FileObjectEnums obj, UploadMethod method) throws UploadException, InstantiationException, IllegalAccessException{
		List<SubFile> resultList = new ArrayList<SubFile>();
		List<MultipartFile> multipartFiles = request.getFiles("file");
		String fullPath = null;
		try {
			for(MultipartFile multipartFile : multipartFiles) { 
	    		SubFile updateFile = FileObjectProvider.newFileObject(obj);
		        if (StringUtils.isNotEmpty(multipartFile.getOriginalFilename())) {  
		            String filename = multipartFile.getOriginalFilename();  
		            String suffix = filename.substring(filename.lastIndexOf(".")+1, filename.length());
		            if(checkFileSuffix(suffix)) {
		            	String dateStr = DateUtils.fmtyyyyMMddHHmmss(new Date());
		                String newFileName = dateStr + "_"+filename;
		                newFileName.replace(" ", "");
		                fullPath = uploadPath+newFileName;
		                method.upload(multipartFile, fullPath);
		                updateFile.setNameOld(filename);
		                updateFile.setNameNew(newFileName);
		                updateFile.setPath(fullPath);
		                resultList.add(updateFile);
		            } else 
		            	throw new UploadException("file type must be \""+allow_suffix_List+"\"");
		        } else 
		        	throw new UploadException("file must have a name");
	    	}
	    	return resultList;
		} catch(IOException ioe) {
			throw new UploadException(ioe, fullPath);
		}
	}
	
	private interface UploadMethod {
		void upload(MultipartFile multipartFile, String uploadPath) throws IOException;
	}
}
