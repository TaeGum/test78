package com.model2.mvc.service.record;

import java.util.Map;

import com.model2.mvc.service.domain.Record;

public interface RecordService {

	public void addRecord(Record record) throws Exception;

	public Map<String, Object> getRecordList() throws Exception;

	public Record getRecord(int recNumber) throws Exception;


}
