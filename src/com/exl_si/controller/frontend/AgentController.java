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
import com.exl_si.db.EXLAgent;
import com.exl_si.service.EXLAgentService;
import com.exl_si.utils.DateUtils;
import com.exl_si.utils.StringUtils;

@Controller
@RequestMapping("/agent")
//@CrossOrigin(origins = "dev.switch-in.com.my,mobile.switch-in.com.my", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
public class AgentController {
	@Autowired
	private EXLAgentService agentService;
	
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
	@ResponseBody
    public ServerResponse edit(EXLAgent agent, MultipartHttpServletRequest request) {
		if(StringUtils.isEmpty(agent.getId()))
			return ServerResponse.createByErrorMsg("agent id not found");
		
		Timestamp lastupdatetime = DateUtils.convertToTimestamp(new Date());
		agent.setLastupdatetime(lastupdatetime);
		return agentService.update(agent, request);
	}
}
