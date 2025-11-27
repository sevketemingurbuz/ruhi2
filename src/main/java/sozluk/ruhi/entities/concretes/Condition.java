package sozluk.ruhi.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "conditions")
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;
	
	@OneToMany(mappedBy = "condition")
	private List<DiscussionCondition> discussionConditions;

}
