package com.model2.mvc.service.replcoach;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.ReplCoach;

public interface ReplCoachService {

	public void addCoachRepl(ReplCoach replcoach) throws Exception;

	public Map<String, Object> getCoachReplList() throws Exception;

	public void updateCoachRepl(ReplCoach replcoach) throws Exception;

}
