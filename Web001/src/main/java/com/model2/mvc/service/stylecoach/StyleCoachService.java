package com.model2.mvc.service.stylecoach;

import java.util.Map;

import com.model2.mvc.service.domain.StyleCoach;

public interface StyleCoachService {

	public void addStyleCoach(StyleCoach styleCoach)throws Exception;

	public Map<String, Object> getStyleCoachList() throws Exception;

}
