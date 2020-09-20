package com.example.pe.businessrule.payment.postprocessor;

import com.example.pe.businessrule.model.Item;
import com.example.pe.businessrule.model.Video;
import com.example.pe.businessrule.repository.VideoRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * For video “Learning to Ski,” add a free “First Aid” video to the packing slip.
 * 
 * @author pradeesh.kumar
 */
@Slf4j
public class VideoItemPostProcessor implements PaymentPostProcessor {
	
	private static final int AD_VIDEO_ID = 123;
	private static final String VID_LEARNINGTOSKI = "Learning to Ski";
	
	private VideoRepository vidRepo;
	
	public VideoItemPostProcessor() {
		this.vidRepo = VideoRepository.get();
	}
	
	@Override
	public void process(Item item) {
		if (item.getItemName().equalsIgnoreCase(VID_LEARNINGTOSKI)) {
			log.info("Retrieving ad video from db");
			Video ad = vidRepo.getVideo(AD_VIDEO_ID);
			vidRepo.addVideoToUser(ad, item.getUserId());
			log.info("Added free {} video", ad.getItemName());
		}
	}

}
