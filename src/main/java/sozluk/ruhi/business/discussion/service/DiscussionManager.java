package sozluk.ruhi.business.discussion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sozluk.ruhi.business.common.response.SpiritDetailResponse;
import sozluk.ruhi.business.discussion.dto.CreateDiscussionRequest;
import sozluk.ruhi.business.discussion.dto.DiscussionSpiritsResponse;
import sozluk.ruhi.dataAccess.abstracts.DiscussionDao;
import sozluk.ruhi.dataAccess.abstracts.SpiritDao;
import sozluk.ruhi.dataAccess.abstracts.UserDao;
import sozluk.ruhi.entities.concretes.Discussion;
import sozluk.ruhi.entities.concretes.Spirit;
import sozluk.ruhi.entities.concretes.User;

@Service
public class DiscussionManager implements DiscussionService{
	
	private final DiscussionDao discussionDao;
	private final SpiritDao spiritDao;
	private final UserDao userDao;
	
	public DiscussionManager(DiscussionDao discussionDao, SpiritDao spiritDao, UserDao userDao) {
		this.discussionDao= discussionDao;
		this.userDao= userDao;
		this.spiritDao= spiritDao;
	}
	
	@Override
	@Transactional
	public void add(CreateDiscussionRequest discussionRequest) {
		User user = userDao.findById(discussionRequest.getUserId()).orElseThrow();
		Discussion discussion = new Discussion();
		discussion.setTitle(discussionRequest.getTitle());
		discussion.setUser(user);
		
		Spirit spirit = new Spirit();
		spirit.setContent(discussionRequest.getCreateLeadSpiritRequest().getContent());
		spirit.setLead(true);
		spirit.setUser(user);
		spirit.setDiscussion(discussion);
		
		/*List<Spirit> spirits = new ArrayList<>();
		spirits.add(spirit);
		discussion.setSpirits(spirits);*/ //uzun versiyon
		discussion.getSpirits().add(spirit); //kisaltilmis versiyonu
		
		discussionDao.save(discussion);
	}
	
	@Override
	public DiscussionSpiritsResponse getSpiritsAndLeadByDiscussion(int id) {
		
		Discussion discussion = this.discussionDao.findById(id).orElseThrow();
		DiscussionSpiritsResponse discussionSpiritsResponse = new DiscussionSpiritsResponse();
		
		discussionSpiritsResponse.setTitle(discussion.getTitle());
		
		List<Spirit> spirits = this.spiritDao.getLeadAndSpiritsByDiscussionId(id);
		List<SpiritDetailResponse> spiritDetailResponses = new ArrayList<SpiritDetailResponse>();
		
		
	
		
		for (Spirit spirit:spirits) {
			SpiritDetailResponse spiritDetailDto = new SpiritDetailResponse();
			spiritDetailDto.setContent(spirit.getContent());
			spiritDetailDto.setReleaseDateTime(spirit.getCreatedAt());
			spiritDetailDto.setUserName(spirit.getUser().getUserName());
			spiritDetailResponses.add(spiritDetailDto);
		}
		discussionSpiritsResponse.setSpirits(spiritDetailResponses);
			
		return discussionSpiritsResponse;
	}
	
	

}
