package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.WorkingTime;

@Mapper
public interface WorkingTimeMapper {

	WorkingTime findByNameDate(WorkingTime workingTime);

	void create(WorkingTime workingTime);

	void updateAttendance(WorkingTime workingTime);
}
