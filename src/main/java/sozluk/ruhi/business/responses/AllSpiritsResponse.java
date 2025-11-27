package sozluk.ruhi.business.responses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllSpiritsResponse {

	private String content;
	//private AllUsersResponse userId; bi terslik var 
	private String userName;
	
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	
	public String getReleaseDateTime( ) { //Dto tarafina alinacak
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(releaseDateTime);
	}
	
}
