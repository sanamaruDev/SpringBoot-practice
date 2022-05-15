package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.WorkingTime;

@Controller
public class ViewWorkingTimeListController {

	@GetMapping("/viewWorkingTimeList")
	public String viewWorkingTimeList(Model model) {
		
		List<WorkingTime> workTimeList = new ArrayList<>();
		
		WorkingTime workTime = new WorkingTime();
		workTime.setWorking_date("2022/04/30");
		workTime.setAttendance_time("09:00");
		workTime.setLeaving_time("18:00");
		
		workTimeList.add(workTime);
		
		model.addAttribute("workingTimelist", workTimeList);
		
		return "viewWorkingTimeList";
	}
	
}
