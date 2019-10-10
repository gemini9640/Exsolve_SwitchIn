package com.exl_si.helper;

import java.util.ArrayList;
import java.util.List;

import com.exl_si.db.VoucherPicture;
import com.exl_si.db.vo.SubFile;
import com.exl_si.utils.UuidUtil;

public class VoucherHelper {
	public static List<VoucherPicture> assembleInitPicture(String voucherId, String type, List<SubFile> files) {
		List<VoucherPicture> VoucherPictures = new ArrayList<VoucherPicture>();
		for(int i = 0; i< files.size(); i++) {
			VoucherPicture picture = (VoucherPicture)files.get(i);
			picture.setId(UuidUtil.get32UUID());
			picture.setVoucherId(voucherId);
			picture.setType(type);
			picture.setIndx(-1);
			VoucherPictures.add(picture);
		}
		return VoucherPictures;
	}
	
//	public static VoucherPicture assembleInitPicture(String VoucherId, String type, List<SubFile> files) {
//		VoucherPicture picture = (VoucherPicture)files.get(0);
//		picture.setId(UuidUtil.get32UUID());
//		picture.setVoucherId(VoucherId);
//		picture.setType(type);
//		picture.setIndx(-1);
//		return picture;
//	}
	
	public static VoucherPicture assembleEdittedPicture(VoucherPicture file, List<SubFile> files) {
		VoucherPicture voucherPicture = (VoucherPicture) files.get(0);
		file.setNameNew(voucherPicture.getNameNew());
		file.setNameOld(voucherPicture.getNameOld());
		file.setPath(voucherPicture.getPath());
		return file;
	}
}
