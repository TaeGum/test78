package com.model2.mvc.service.record;

import java.util.List;

import com.model2.mvc.service.domain.Record;

public interface RecordDao {

	public void addRecord(Record record) throws Exception;

	public List<Record> getRecordList() throws Exception;

	public Record getRecord(int recNumber) throws Exception;

}
