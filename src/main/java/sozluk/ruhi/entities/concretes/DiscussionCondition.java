package sozluk.ruhi.entities.concretes;

import java.time.LocalDateTime;

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
@Table(name= "discussion_condition")
@AllArgsConstructor
@NoArgsConstructor
public class DiscussionCondition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name= "discussion_id")
	private Discussion discussion;
	
	@ManyToOne
	@JoinColumn(name= "condition_id")
	private Condition condition; //6.55-8.58 => 2.03 14.05-16.15 ==>   4.13
	
	//@Column(name= "created_at")
	//private LocalDateTime createdAt;
	

}
