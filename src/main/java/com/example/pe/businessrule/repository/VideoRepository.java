package com.example.pe.businessrule.repository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import com.example.pe.businessrule.model.Video;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class VideoRepository.
 * 
 * @author pradeesh.kumar
 */
@Repository

/** The Constant log. */
@Slf4j
public class VideoRepository implements InitializingBean {
	
	private static VideoRepository instance;
	
	/**
	 * Retrieves video for specified id
	 *
	 * @param videoId the video id
	 * @return the video
	 */
	public Video getVideo(int videoId) {
		Video v = new Video();
		v.setDuration(12);
		v.setItemName("First Aid");
		v.setUrl("https://exaple.com/videostream?id=123");
		return v;
	}
	
	/**
	 * Adds the video to user.
	 *
	 * @param v the v
	 * @param userId the user id
	 */
	public void addVideoToUser(Video v, int userId) {
		log.info("Added video: {} to the user: {}", v.getItemName(), userId);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		instance = new VideoRepository();
	}
	
	public static VideoRepository get() {
		return instance;
	}

}
