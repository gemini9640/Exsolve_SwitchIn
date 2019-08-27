package com.exl_si.service.impl;

import java.util.HashMap;
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
		try {
			List<SubFile> uploadedFiles = UploadUtil.uploadFileByIOStream(request, AppProperties.UPLOAD_PATH+"/"+memberId+"/"+type+"/", FileObjectEnums.SIMEMBER_FILE);
			if(uploadedFiles != null && !uploadedFiles.isEmpty()) {
				if(memberFileMapper.batchInsert(SIMemberHelper.assembleInitMemberFile(memberId, type, uploadedFiles)) > 0)
					return ServerResponse.createBySuccess(uploadedFiles.get(0));
			} return ServerResponse.createByErrorMsg("upload fail");
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
	
	public ServerResponse<SIMember> query(String username) {
		SIMember member = memberMapper.selectByPrimaryKey(username);
		if(member == null)
			return ServerResponse.createByServerError("user not found, username not exist");
		return ServerResponse.createBySuccess(member);
	} 
	
	public ServerResponse<SIMember> login(String username, String password) {
		SIMember member = memberMapper.login(username, ServiceHelper.encriptPassword(password));
		if(member == null)
			return ServerResponse.createByServerError("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(member);
	} 
	
	public ServerResponse save(SIMember member, MultipartHttpServletRequest request) {
		if(memberMapper.selectByUsername(member.getUsername()) != null)
			return ServerResponse.createByServerError("member is already exist.");
		SequenceNoHelper.setMemberSequenceId(member, sequenceNoMapper);
		if(memberMapper.insertSelective(member)>0) {
			SequenceNoHelper.updateMemberSequenceNo(sequenceNoMapper);
			ServerResponse uploadResp = uploadProfile(request, member.getId(), FileType.PROFILE.getDesc());
			if(uploadResp.isSuccess())
				return ServerResponse.createBySuccess(SIMemberHelper.assembleSIMemberWithAssociated(member, uploadResp.getData()));
			else 
				return ServerResponse.createBySuccess(uploadResp.getMsg(), SIMemberHelper.assembleSIMemberWithAssociated(member, null));
		} else 
			return ServerResponse.createByServerError("register fail");
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
	
	public ServerResponse update(SIMember member) {
		if(memberMapper.updateByPrimaryKeySelective(member)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse changePassword(String username, String oldPass, String newPass) {
		if(memberMapper.selectByKeyAndPass(username, ServiceHelper.encriptPassword(oldPass)) != null) {
			memberMapper.updateByPrimaryKeySelective(SIMemberHelper.assembleSIMember4ChangePassword(username, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByServerError("update fail");
	}
	
	public ServerResponse changePasswordWithoutCheckPassword(String username, String password) {
		if(memberMapper.selectByUsername(username) == null)
			return ServerResponse.createByServerError("member not found");
		else {
			password = ServiceHelper.encriptPassword(password);
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
