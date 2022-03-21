package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.WorkingTime;
import com.example.demo.service.UpdateAttendanceService;
import com.example.demo.service.UpdateLeavingService;

@Controller
public class LeavingController{

	@Autowired
	UpdateLeavingService service;
		
	/*
	 * 退勤時間登録
	 */
	@ResponseBody
	@PostMapping("/leaving")
	public LeavingForm registLeaving(@RequestBody LeavingForm leavingForm) {
		
		WorkingTime workingTime = new WorkingTime();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		workingTime.setUser_name(auth.getName());
		// yyyymmdd形式
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		workingTime.setWorking_date(sdf.format(date));
		// hhmm形式
		workingTime.setLeaving_time(String.format("%2s", leavingForm.getDdlLeavingHour().replace(" ", "0"))
				+ String.format("%2s", leavingForm.getDdlLeavingTime().replace(" ", "0")));
	
		service.UpdateLeaving(workingTime);
		
		return leavingForm;
	}

//	/*
//	 * サインアウト
//	 */
//	@ResponseBody
//	@PostMapping("/SignOut")
//	public LeavingForm SignOut(@RequestBody LeavingForm leavingForm) {
//		
//		return leavingForm;
//	}
}
