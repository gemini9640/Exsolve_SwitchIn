package com.exl_si.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.exl_si.common.AppProperties;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.SIMember;
import com.exl_si.db.SIMemberFile;
import com.exl_si.db.vo.SIMemberWithAssociated;
import com.exl_si.db.vo.SubFile;
import com.exl_si.enums.MemberEnums;
import com.exl_si.enums.MemberEnums.FileType;
import com.exl_si.db.vo.FileObjectProvider.FileObjectEnums;
import com.exl_si.exception.UploadException;
import com.exl_si.helper.SIMemberHelper;
import com.exl_si.helper.SequenceNoHelper;
import com.exl_si.helper.ServiceHelper;
import com.exl_si.mapper.SIMemberFileMapper;
import com.exl_si.mapper.SIMemberMapper;
import com.exl_si.mapper.SequenceNoMapper;
import com.exl_si.service.SIMemberService;
import com.exl_si.utils.DeleteFileUtil;
import com.exl_si.utils.UploadUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("memberService")
public class SIMemberServiceImpl implements SIMemberService{
	@Autowired
	private SIMemberMapper memberMapper;
	@Autowired
	private SIMemberFileMapper memberFileMapper;
	@Autowired
	private SequenceNoMapper sequenceNoMapper;
	
	private ServerResponse uploadProfile(MultipartHttpServletRequest request, String memberId, String type) {
		String baseFolder = AppProperties.UPLOAD_PATH+"/si_member/"+memberId+"/"+type+"/";
		try {
			SIMemberFile profilePic = memberFileMapper.selectByMemberId(memberId);
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, baseFolder, FileObjectEnums.SIMEMBER_FILE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(profilePic != null) {
					DeleteFileUtil.delete(AppProperties.UPLOAD_PATH+profilePic.getPath());
					memberFileMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleEdittedMemberFile(profilePic, uploadedFiles));
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
				}else if(memberFileMapper.batchInsert(SIMemberHelper.assembleInitMemberFile(memberId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} else if(profilePic != null)
				return ServerResponse.createBySuccess("no file to upload", profilePic);
			return ServerResponse.createByErrorMsg("nothing to do for uploading profile picture!");
		} catch (UploadException ue) {
			if(ue.getIoe() != null) {
				ue.getIoe().printStackTrace();
				if(ue.getPath() != null)
					DeleteFileUtil.delete(ue.getPath());
			} else 
				ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMsg(e.getMessage());
		} 
	}
	
	public ServerResponse<SIMemberWithAssociated> query(String id) {
		SIMember member = memberMapper.selectByPrimaryKey(id);
		if(member == null)
			return ServerResponse.createByServerError("member not found, id not exist");
		SIMemberFile profilePic = memberFileMapper.selectByMemberId(id); 
		return ServerResponse.createBySuccess(SIMemberHelper.assembleSIMemberWithAssociated(member,  profilePic));
	} 
	
	public ServerResponse<SIMemberWithAssociated> login(String username, String password) {
		SIMember member = memberMapper.login(username, ServiceHelper.encriptPassword(username, password));
		if(member == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		SIMemberFile profilePic = memberFileMapper.selectByMemberId(member.getId());
		return ServerResponse.createBySuccess(SIMemberHelper.assembleSIMemberWithAssociated(member,  profilePic));
	} 
	
	public ServerResponse<SIMemberWithAssociated> save(SIMember member, MultipartHttpServletRequest request) {
		if(memberMapper.selectByUsername(member.getUsername()) != null)
			return ServerResponse.createByServerError("member is already exist.");
		SequenceNoHelper.setMemberSequenceId(member, sequenceNoMapper);
		member.setPassword(ServiceHelper.encriptPassword(member.getUsername(), member.getPassword()));
		member.setMemberType(MemberEnums.VIP.NORMAL.getCode());
		if(memberMapper.insertSelective(member)>0) {
			SequenceNoHelper.updateMemberSequenceNo(sequenceNoMapper);
			if(request != null) {
				ServerResponse uploadResp = uploadProfile(request, member.getId(), FileType.PROFILE.getDesc());
				if(uploadResp.isSuccess())
					return ServerResponse.createBySuccess(SIMemberHelper.assembleSIMemberWithAssociated(member, (SIMemberFile) uploadResp.getData()));
				else 
					return ServerResponse.createBySuccess(uploadResp.getMsg(), SIMemberHelper.assembleSIMemberWithAssociated(member, null));
			}
			return ServerResponse.createBySuccessMsg("add member success");
		} else 
			return ServerResponse.createByServerError("add member fail");
	}
	
	public ServerResponse<SIMemberWithAssociated> update(SIMember member, MultipartHttpServletRequest request) {
		if(memberMapper.updateByPrimaryKeySelective(member)>0) {
			if(request != null) {
				ServerResponse uploadResp = uploadProfile(request, member.getId(), FileType.PROFILE.getDesc());
				if(uploadResp.isSuccess())
					return ServerResponse.createBySuccess(SIMemberHelper.assembleSIMemberWithAssociated(member, (SIMemberFile) uploadResp.getData()));
				else 
					return ServerResponse.createBySuccess(uploadResp.getMsg(), SIMemberHelper.assembleSIMemberWithAssociated(member, null));
			}
			return ServerResponse.createBySuccess("update success", SIMemberHelper.assembleSIMemberWithAssociated(member, null));
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMember> list = memberMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse<PageInfo> selectPageByProperties(Map<String, Object> properties, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SIMember> list = memberMapper.selectByPropertiesSelelctives(properties);
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(memberMapper.selectByKeyAndPass(username, ServiceHelper.encriptPassword(username, oldPass)) != null) {
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(memberMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(username, password);
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, password));
			return ServerResponse.createBySuccess();
		}
	}
	
	public ServerResponse initUploadFile(List<SIMemberFile> memberFiles) {
		if(memberFileMapper.batchInsert(memberFiles) > 0)
			return ServerResponse.createBySuccess();
		return ServerResponse.createByServerError("member file init fail");
	}
	
}
