package sozluk.ruhi.business.common.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpiritDetailResponse {
	
	private String content;
	private String userName;
	
	@JsonFormat(pattern = "HH:mm dd-MM-yyyy")
	private LocalDateTime releaseDateTime;
	
	
}
