package sozluk.ruhi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sozluk.ruhi.business.abstracts.UserService;
import sozluk.ruhi.business.requests.CreateUserRequest;
import sozluk.ruhi.business.responses.AllUsersResponse;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService= userService;
	}
	
	@GetMapping("/getAll")
	public List<AllUsersResponse> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateUserRequest userRequest) {
		this.userService.add(userRequest);
	}
	


}
