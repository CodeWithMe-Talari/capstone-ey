package com.ey.capstone.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.ey.capstone.core.services.TrendingArticleService;

/**
 *      @author Talari Poornachander
 * 
 *      Sling Model to fetch Trending Articles Component properties
 *
 */

@Model(adaptables = Resource.class,
		defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TrendingArticleModel {

	@OSGiService
	TrendingArticleService trendingArticleService;

	@ValueMapValue
	private String title;

	List<ArticleBannerModel> bannerList;

	@PostConstruct
	public void init() {

		bannerList = trendingArticleService.getTrendingArticles();
	}

	public String getTitle() {
		return title;
	}

	public List<ArticleBannerModel> getBannerList() {
		return bannerList;
	}
	
}
