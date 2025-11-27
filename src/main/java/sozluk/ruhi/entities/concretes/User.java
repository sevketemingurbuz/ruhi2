package sozluk.ruhi.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name= "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "user_name")
	private String userName;

	@Column(name= "email")
	private String email;
	
	@Column(name= "password")
	private String password;

	@Column(name= "role")
	private Role role;
	
	@Column(name= "is_active")
	private boolean isActive;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Profile profile;
	
	@OneToMany(mappedBy = "user")
	private List<Discussion> discussions;    
	
	@OneToMany(mappedBy = "user")
	private List<Spirit> spirits;
	
	@Column(name= "created_at")
	private LocalDateTime releaseDateTime = LocalDateTime.now();
}
