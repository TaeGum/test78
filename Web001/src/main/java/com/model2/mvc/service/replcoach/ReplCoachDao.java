package com.model2.mvc.service.replcoach;

import java.util.List;
import java.util.Map;

import com.model2.mvc.service.domain.ReplCoach;

public interface ReplCoachDao {

	public void addCoachRepl(ReplCoach replcoach) throws Exception;

	public List<ReplCoach> getCoachReplList() throws Exception;

	public void updateCoachRepl(ReplCoach replcoach) throws Exception;


}
