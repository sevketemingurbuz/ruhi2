package sozluk.ruhi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sozluk.ruhi.entities.concretes.Discussion;

public interface DiscussionDao extends JpaRepository<Discussion, Integer>{

}
