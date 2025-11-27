package sozluk.ruhi.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sozluk.ruhi.business.abstracts.UserService;
import sozluk.ruhi.business.requests.CreateUserRequest;
import sozluk.ruhi.business.responses.AllUsersResponse;
import sozluk.ruhi.dataAccess.abstracts.UserDao;
import sozluk.ruhi.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private final UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao= userDao;
	}
	
	@Override
	public List<AllUsersResponse> getAll(){
		List<User> users = this.userDao.findAll();
		List<AllUsersResponse> usersResponses = new ArrayList<AllUsersResponse>();  
		for(User user: users) {
			AllUsersResponse userResponseItem = new AllUsersResponse();
			userResponseItem.setId(user.getId());
			userResponseItem.setUserName(user.getUserName());
			userResponseItem.setEmail(user.getEmail());
			usersResponses.add(userResponseItem);
		}
		return usersResponses;
	}
	
	@Override
	public User add(CreateUserRequest userRequest) {
		User user = new User();
		user.setUserName(userRequest.getUserName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setActive(true);
		
		userDao.save(user);
		
		return user;
		
	}

}
