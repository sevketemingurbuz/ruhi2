package sozluk.ruhi.business.discussion.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sozluk.ruhi.business.common.response.SpiritDetailResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionSpiritsResponse {
	
	private String title;
	private List<SpiritDetailResponse> spirits;
	
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	
	public String getReleaseDateTime( ) { //Dto tarafina alinacak
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(releaseDateTime);
	}

}
