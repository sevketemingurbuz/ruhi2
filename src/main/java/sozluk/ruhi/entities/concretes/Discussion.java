package sozluk.ruhi.entities.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "discussions")
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "title")
	private String title;
	
	@OneToMany(mappedBy = "discussion") //many-to-many condition
	private List<DiscussionCondition> discussionConditions;
	
	@OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
	private List<Spirit> spirits = new ArrayList<Spirit>();
	
	@OneToOne
	@JoinColumn(name= "lead_spirit_id")
	private Spirit leadSpirit;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name= "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();
	
}
