package sozluk.ruhi.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sozluk.ruhi.entities.concretes.Spirit;

public interface SpiritDao extends JpaRepository<Spirit, Long>{
	
	@Query("SELECT s FROM Spirit s WHERE s.discussion.id = :discussionId ORDER BY s.isLead DESC")
	List<Spirit> getLeadAndSpiritsByDiscussionId(@Param("discussionId") int id); //fazladan bir spirit getiriyor
	
	List<Spirit> getSpiritsByDiscussionIdAndIsLeadFalse(int discussionId);
	
	Spirit getSpiritByDiscussionIdAndIsLeadTrue(int discussionId);

}
