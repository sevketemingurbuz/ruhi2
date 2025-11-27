package sozluk.ruhi.entities.concretes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "articles")
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "article_id")
	private int articleId;
	
	@Column(name= "content")
	private String content;
	
	@Column(name= "title")
	private String title;
	
	@Column(name= "release_date_time")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
	

	public String getReleaseDateTime( ) { //Dto tarafina alinacak
		return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(releaseDateTime);
	}
	
	@ManyToOne
	@JoinColumn(name= "profile_id")
	private Profile profile;


}
