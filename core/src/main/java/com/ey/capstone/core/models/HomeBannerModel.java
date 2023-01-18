package com.ey.capstone.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class,
		SlingHttpServletRequest.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class HomeBannerModel {

	@ValueMapValue
	private String[] articleLinks;

	@SlingObject
	ResourceResolver resolver;

	List<ArticleBannerModel> bannerList;

	@PostConstruct
	public void init() {

		if (articleLinks != null) {
			bannerList = new ArrayList<>();
			for (String articleLink : articleLinks) {
				Resource articleBannerResource = resolver
						.getResource(articleLink + "/jcr:content/root/container/article_banner");
				if (articleBannerResource != null) {
					ArticleBannerModel articleBanner = articleBannerResource.adaptTo(ArticleBannerModel.class);
					if (articleBanner != null) {
						articleBanner.setPagePath(articleLink);
						if (bannerList.size() < 5) {
							bannerList.add(articleBanner);
						}
					}
				}
			}
		}

	}

	public List<ArticleBannerModel> getBannerList() {
		return bannerList;
	}

}
