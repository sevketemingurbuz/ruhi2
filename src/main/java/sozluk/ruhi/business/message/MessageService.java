package sozluk.ruhi.business.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sozluk.ruhi.dataAccess.abstracts.MessageDao;
import sozluk.ruhi.entities.concretes.Message;

@Service
public class MessageService {
	
	private final MessageDao messageDao;
	
	public MessageService(MessageDao messageDao) {
		this.messageDao= messageDao;
	}
	
	public void add(MessageRequest messageRequest) {
		Message message = new Message();
		message.setText(messageRequest.text());
		this.messageDao.save(message);
	}
	
	public List<Message> getAll(){
		List<Message> messages = this.messageDao.findAll();
		List<MessageResponse> messageResponses = new ArrayList<MessageResponse>();
		
		for (Message message:messages) {
			MessageResponse messageDto = new MessageResponse(message.getId(), message.getText());
			messageResponses.add(messageDto);	
		}
		return messages;
		
		
		
	}

}
