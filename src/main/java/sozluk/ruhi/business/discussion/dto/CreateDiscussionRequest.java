package sozluk.ruhi.business.discussion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiscussionRequest {
	
	private String title;
	private int userId;
	private CreateLeadSpiritRequest createLeadSpiritRequest;

}
