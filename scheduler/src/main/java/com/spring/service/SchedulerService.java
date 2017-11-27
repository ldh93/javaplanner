package com.spring.service;

import com.dhtmlx.planner.DHXEv;

import com.spring.domain.SchedulerVO;

public interface SchedulerService {

	public Iterable<DHXEv> getEvent();

	public void updateEvent(SchedulerVO schedule) throws Exception;

	public void insertEvent(SchedulerVO schedule) throws Exception;

	public void deleteEvent(Integer id) throws Exception;
	
}