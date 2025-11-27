package sozluk.ruhi.business.spirit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSpiritRequest {
	
	private String content;
	private int userId;
	private int discussionId;

}
