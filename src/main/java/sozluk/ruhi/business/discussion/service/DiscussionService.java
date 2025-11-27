package sozluk.ruhi.business.discussion.service;

import sozluk.ruhi.business.discussion.dto.CreateDiscussionRequest;
import sozluk.ruhi.business.discussion.dto.DiscussionSpiritsResponse;

public interface DiscussionService{

	void add(CreateDiscussionRequest discussionRequest);
	DiscussionSpiritsResponse getSpiritsAndLeadByDiscussion(int id);
} 
