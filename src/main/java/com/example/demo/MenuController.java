package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	/**
     * メニュー画面へ遷移
     * @return メニュー画面へのパス
     */
    @GetMapping("/menu")
    public String menu(){
    	return "menu";
    }
    
	/**
     * 出勤時間登録画面へ遷移
     * @return 出勤時間登録画面へのパス
     */
    @GetMapping("/hello")
    public String hello(Model model){
        // 本日日付
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    	model.addAttribute("today", sdf.format(cal.getTime()));
        // 時間ドロップダウン
    	model.addAttribute("lstHours", this.createDropDownListHours());
        // 分ドロップダウン
    	model.addAttribute("lstMinutes", this.createDropDownListMinutes());
    	return "hello";
    }

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
