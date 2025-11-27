package sozluk.ruhi.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sozluk.ruhi.business.message.MessageRequest;
import sozluk.ruhi.business.message.MessageService;
import sozluk.ruhi.entities.concretes.Message;

@RestController
@RequestMapping("/api/message")
public class MessageController {
	
	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService= messageService;
	}
	
	@GetMapping("/getall")
	public List<Message> getAll() {
		return this.messageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(MessageRequest messageRequest) {
		this.messageService.add(messageRequest);
	}
}
