package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		
	/**
     * 退勤時間登録画面へ遷移
     * @return 退勤時間登録画面へのパス
     */
    @GetMapping("/leaving")
    public String leaving(Model model){
        // 本日日付
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    	model.addAttribute("today", sdf.format(cal.getTime()));
        // 時間ドロップダウン
    	model.addAttribute("lstHours", this.createDropDownListHours());
        // 分ドロップダウン
    	model.addAttribute("lstMinutes", this.createDropDownListMinutes());
    	return "leaving";
    }

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

    private List<String> createDropDownListHours() {
    	List<String> lstHours = new ArrayList<>();
    	for (int i = 17; i <= 27; i++) {
	    	lstHours.add(String.valueOf(i));
		}
        return lstHours;
    }
    
    private List<String> createDropDownListMinutes() {
    	List<String> lstMinutes = new ArrayList<>();
    	lstMinutes.add("00");
    	lstMinutes.add("15");
    	lstMinutes.add("30");
    	lstMinutes.add("45");
        return lstMinutes;
    }
}
