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
    
}
