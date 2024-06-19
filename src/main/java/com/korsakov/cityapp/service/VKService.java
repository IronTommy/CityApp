package com.korsakov.cityapp.service;

import org.springframework.cache.annotation.Cacheable;
import com.korsakov.cityapp.model.VKPostResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VKService {

    private static final Logger logger = LoggerFactory.getLogger(VKService.class);

    @Value("${vk.api.version}")
    private String apiVersion;

    @Value("${vk.group.id}")
    private String groupId;

    @Value("${vk.api.token}")
    private String apiToken;

    private static final String VK_API_URL = "https://api.vk.com/method/wall.get";

    @Cacheable(value = "vkPosts", key = "#offset + '-' + #count")
    public VKPostResponse getVKPosts(int offset, int count) {
        logger.info("Fetching posts from VK API: offset={}, count={}", offset, count);
        RestTemplate restTemplate = new RestTemplate();
        String url = VK_API_URL + "?owner_id=-" + groupId + "&access_token=" + apiToken + "&v=" + apiVersion
                + "&offset=" + offset + "&count=" + count;
        return restTemplate.getForObject(url, VKPostResponse.class);
    }
}
