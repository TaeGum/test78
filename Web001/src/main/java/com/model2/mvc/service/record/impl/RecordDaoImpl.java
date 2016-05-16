package com.model2.mvc.service.record.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.domain.Record;
import com.model2.mvc.service.record.RecordDao;

@Repository("recordDaoImpl")
public class RecordDaoImpl implements RecordDao {

	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}	
	
	//Constructor
	public RecordDaoImpl() {
		System.out.println(this.getClass());
	}

	@Override
	public void addRecord(Record record) throws Exception {
		sqlSession.insert("RecordMapper.addRecord", record);
	}
	
	@Override
	public List<Record> getRecordList() throws Exception {
		return sqlSession.selectList("RecordMapper.getRecordList");
	}

	@Override
	public Record getRecord(int recNumber) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("RecordMapper.getRecord", recNumber);
	}
	
}
