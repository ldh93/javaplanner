package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXEventsManager;
import com.spring.domain.SchedulerVO;

@Repository
public class SchedulerDAOImpl implements SchedulerDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.spring.mapper.SchedulerMapper";

	@Override
	public Iterable<DHXEv> getEvent() {
		
      	DHXEventsManager.date_format = "yyyy-MM-dd HH:mm:ss";
      	List evs = new ArrayList();
      		
		    List<SchedulerVO> resultset = session.selectList(namespace + ".getEvent");
		    
		    for(int i = 0; i < resultset.size(); i++){
		      	DHXEvent e = new DHXEvent();
		      	e.setId(resultset.get(i).getEvent_id());
		          e.setText(resultset.get(i).getEvent_name());
		          e.setStart_date(resultset.get(i).getStart_date());
		          e.setEnd_date(resultset.get(i).getEnd_date());
		      	evs.add(e);
		    }
      	DHXEventsManager.date_format = "MM/dd/yyyy HH:mm";
		return evs;
	}

	@Override
	public void updateEvent(SchedulerVO schedule) throws Exception {
		session.update(namespace + ".updateEvent", schedule);
	}

	@Override
	public void insertEvent(SchedulerVO schedule) throws Exception {
		session.insert(namespace + ".insertEvent", schedule);
	}

	@Override
	public void deleteEvent(Integer id) throws Exception{
		session.delete(namespace + ".deleteEvent", id);
	}
}