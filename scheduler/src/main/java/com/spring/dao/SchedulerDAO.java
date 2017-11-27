package com.spring.dao;

import com.dhtmlx.planner.DHXEv;
import com.spring.domain.SchedulerVO;

public interface SchedulerDAO {

	Iterable<DHXEv> getEvent();

	public void updateEvent(SchedulerVO schedule) throws Exception;

	public void insertEvent(SchedulerVO schedule) throws Exception;

	public void deleteEvent(Integer id) throws Exception;
	
}