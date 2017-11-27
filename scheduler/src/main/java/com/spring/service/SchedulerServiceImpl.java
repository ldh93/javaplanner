package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhtmlx.planner.DHXEv;
import com.spring.dao.SchedulerDAO;
import com.spring.domain.SchedulerVO;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired
	private SchedulerDAO dao;

	@Override
	public Iterable<DHXEv> getEvent(){
		return dao.getEvent();
	}

	@Override
	public void updateEvent(SchedulerVO schedule) throws Exception{
		dao.updateEvent(schedule);
	}

	@Override
	public void insertEvent(SchedulerVO schedule) throws Exception{
		dao.insertEvent(schedule);
	}

	@Override
	public void deleteEvent(Integer id) throws Exception{
		dao.deleteEvent(id);
	}

}