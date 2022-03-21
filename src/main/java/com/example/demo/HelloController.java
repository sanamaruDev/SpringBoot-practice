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

@Controller
public class HelloController{

	@Autowired
	UpdateAttendanceService service;
		
	/*
	 * 出勤時間登録
	 */
	@ResponseBody
	@PostMapping("/hello")
	public AttendanceForm registAttendance(@RequestBody AttendanceForm attendanceForm) {
		
		WorkingTime workingTime = new WorkingTime();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		workingTime.setUser_name(auth.getName());
		// yyyymmdd形式
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		workingTime.setWorking_date(sdf.format(date));
		// hhmm形式
		workingTime.setAttendance_time(String.format("%2s", attendanceForm.getDdlAttendanceHour().replace(" ", "0"))
				+ String.format("%2s", attendanceForm.getDdlAttendanceTime().replace(" ", "0")));
	
		service.UpdateAttendance(workingTime);
		
		return attendanceForm;
	}

	/*
	 * サインアウト
	 */
	@ResponseBody
	@PostMapping("/SignOut")
	public AttendanceForm SignOut(@RequestBody AttendanceForm attendanceForm) {
		
		return attendanceForm;
	}
}
