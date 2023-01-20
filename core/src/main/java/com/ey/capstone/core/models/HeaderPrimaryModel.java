package com.ey.capstone.core.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

/**
 *      @author Talari Poornachander
 * 
 *      Sling Model to fetch  Header Primary Component properties
 *
 */
@Model(adaptables = Resource.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderPrimaryModel {

	
	@ValueMapValue
	private String trendingText;
	
	@ValueMapValue
	private String trendingDesc;
	
	private String todayDateString;
	
	@PostConstruct
	public void init() {

		SimpleDateFormat format = new SimpleDateFormat("EEEE, d MMMM yyyy");
		todayDateString = format.format(new Date());
	}

	public String getTrendingText() {
		return trendingText;
	}

	public String getTrendingDesc() {
		return trendingDesc;
	}

	public String getTodayDateString() {
		return todayDateString;
	}
	
}
