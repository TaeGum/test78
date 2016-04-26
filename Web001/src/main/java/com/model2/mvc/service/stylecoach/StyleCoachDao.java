package com.model2.mvc.service.stylecoach;

import java.util.List;

import com.model2.mvc.service.domain.StyleCoach;

public interface StyleCoachDao {

	public void addStyleCoach(StyleCoach styleCoach) throws Exception;

	public List<StyleCoach> getStyleCoachList() throws Exception;
	
}
