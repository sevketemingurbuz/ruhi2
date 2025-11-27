package sozluk.ruhi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sozluk.ruhi.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	


}
