package com.boss.cuncis.footballschedule.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MatchResponse{

	@SerializedName("events")
	private List<Match> events;

	public List<Match> getEvents(){
		return events;
	}
}