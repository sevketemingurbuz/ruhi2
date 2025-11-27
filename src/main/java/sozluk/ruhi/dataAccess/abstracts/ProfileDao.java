package sozluk.ruhi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sozluk.ruhi.entities.concretes.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{

}
