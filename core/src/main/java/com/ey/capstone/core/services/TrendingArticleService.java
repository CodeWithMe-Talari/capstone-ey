package com.ey.capstone.core.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

import com.ey.capstone.core.models.ArticleBannerModel;

/**
 *      @author Talari Poornachander
 * 
 *      Service Interface for TrendingArticlesModel Sling Model
 *
 */
public interface TrendingArticleService {
	
	/**
	 *     To get the list of Articles to display
	 *     in Trending Articles Component
	 */
	
	public List<ArticleBannerModel> getTrendingArticles();
	
	/**
	 *     To get the resolver for Trending Articles Service
	 */
	
	public ResourceResolver getResourceResolver();

}
