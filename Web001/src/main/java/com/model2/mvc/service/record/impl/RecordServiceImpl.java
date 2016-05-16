package com.model2.mvc.service.record.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.domain.Record;
import com.model2.mvc.service.domain.ReplCoach;
import com.model2.mvc.service.record.RecordDao;
import com.model2.mvc.service.record.RecordService;

@Service("recordServiceImpl")
public class RecordServiceImpl implements RecordService {

	//Field
	@Autowired
	@Qualifier("recordDaoImpl")
	private RecordDao recordDao;
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao=recordDao;
	}
	
	//Constructor
	public RecordServiceImpl() {
		System.out.println(this.getClass());
	}
	
	@Override
	public void addRecord(Record record) throws Exception {
		recordDao.addRecord(record);
	}

	
	@Override
	public Map<String, Object> getRecordList() throws Exception {
		
		List<Record> list = recordDao.getRecordList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}

	@Override
	public Record getRecord(int recNumber) throws Exception {
		// TODO Auto-generated method stub
		return recordDao.getRecord(recNumber);
	}
	
}
