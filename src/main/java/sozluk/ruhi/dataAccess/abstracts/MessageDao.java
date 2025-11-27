package sozluk.ruhi.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sozluk.ruhi.entities.concretes.Message;

public interface MessageDao extends JpaRepository<Message, Integer>{

}
