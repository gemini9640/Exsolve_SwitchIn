package com.exl_si.controller.frontend;

import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.exl_si.common.ServerResponse;
import com.exl_si.db.EXLClient;
import com.exl_si.service.EXLClientService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/client")
//@CrossOrigin(origins = "dev.switch-in.com.my,mobile.switch-in.com.my", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClientController {
	@Autowired
	private EXLClientService clientService;
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(EXLClient client, MultipartHttpServletRequest request) {
		if(StringUtils.isEmpty(client.getId()))
			return ServerResponse.createByErrorMsg("agent id not found");
		
		Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
		client.setLastupdatetime(lastupdatetime);
		return clientService.update(client, request);
	}
}
