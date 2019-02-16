package com.boss.cuncis.footballschedule.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DetailResponse{

	@SerializedName("events")
	private List<Detail> events;

	public List<Detail> getEvents(){
		return events;
	}
}