package com.ey.capstone.core.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

import com.ey.capstone.core.models.ArticleBannerModel;

public interface TrendingArticleService {
	
	public List<ArticleBannerModel> getTrendingArticles();
	
	public ResourceResolver getResourceResolver();

}
