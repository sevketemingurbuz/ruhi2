package sozluk.ruhi.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sozluk.ruhi.business.discussion.dto.CreateDiscussionRequest;
import sozluk.ruhi.business.discussion.dto.DiscussionSpiritsResponse;
import sozluk.ruhi.business.discussion.service.DiscussionService;

@RestController
@RequestMapping("/api/discussion")
public class DiscussionController {
	
	private final DiscussionService discussionService;
	
	public DiscussionController(DiscussionService discussionService) {
		this.discussionService= discussionService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateDiscussionRequest discussionRequest) {
		this.discussionService.add(discussionRequest);
	}
	
	@GetMapping("/getLeadAndSpiritsByDiscussion")
	public DiscussionSpiritsResponse getSpiritsAndLeadDiscussion(int id) {
		return this.discussionService.getSpiritsAndLeadByDiscussion(id);
	}

}
