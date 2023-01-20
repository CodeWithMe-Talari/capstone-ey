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
 *      Sling Model to fetch Article Banner Component properties
 *
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ArticleBannerModel {
	
	@ValueMapValue
	private String bannerImage;
	
	@ValueMapValue
	private String bannerText;
	
	@ValueMapValue(name ="jcr:created")
	private Date jcrCreated;
	
	private String pagePath;
	
	private String createdDateStr;
	
	@PostConstruct
	public void init() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d,yyyy");
		 createdDateStr = dateFormatter.format(jcrCreated);
	}

	
	public String getPagePath() {
		return pagePath;
	}
	
	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}
	
	public String getCreatedDateStr() {
		return createdDateStr;
	}
	
	public String getBannerImage() {
		return bannerImage;
	}


	public String getBannerText() {
		return bannerText;
	}
	

}
