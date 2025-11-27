package sozluk.ruhi.business.spirit.service;

import org.springframework.stereotype.Service;

import sozluk.ruhi.business.spirit.dto.CreateSpiritRequest;
import sozluk.ruhi.dataAccess.abstracts.DiscussionDao;
import sozluk.ruhi.dataAccess.abstracts.SpiritDao;
import sozluk.ruhi.dataAccess.abstracts.UserDao;
import sozluk.ruhi.entities.concretes.Discussion;
import sozluk.ruhi.entities.concretes.Spirit;
import sozluk.ruhi.entities.concretes.User;

@Service
public class SpiritManager {
	
	private final SpiritDao spiritDao;
	private final UserDao userDao;
	private final DiscussionDao discussionDao;
	
	public SpiritManager(SpiritDao spiritDao, UserDao userDao, DiscussionDao discussionDao) {
		this.spiritDao= spiritDao;
		this.userDao= userDao;
		this.discussionDao= discussionDao;
	}
	
	public void add(CreateSpiritRequest createSpiritRequest) {
		User user = this.userDao.findById(createSpiritRequest.getUserId()).orElseThrow();
		Discussion discussion = this.discussionDao.findById(createSpiritRequest.getDiscussionId()).orElseThrow();
		Spirit spirit = new Spirit();
		spirit.setContent(createSpiritRequest.getContent());
		spirit.setLead(false);
		spirit.setUser(user);
		spirit.setDiscussion(discussion);
		
		this.spiritDao.save(spirit);
	}

}
