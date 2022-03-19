package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.WorkingTime;
import com.example.demo.repository.WorkingTimeMapper;

@Service
public class UpdateAttendanceService {

	@Autowired
	private WorkingTimeMapper mapper;

	public void UpdateAttendance(WorkingTime workingTime) {
		
		// レコード取得
		WorkingTime result = mapper.findByNameDate(workingTime);
		
		if (result == null) {
			// 追加
			mapper.create(workingTime);
		} else {
			// 更新
			mapper.updateAttendance(workingTime);
		}
		
	}
}
