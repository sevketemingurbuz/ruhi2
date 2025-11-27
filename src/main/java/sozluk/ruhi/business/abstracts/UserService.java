package sozluk.ruhi.business.abstracts;

import java.util.List;

import sozluk.ruhi.business.requests.CreateUserRequest;
import sozluk.ruhi.business.responses.AllUsersResponse;
import sozluk.ruhi.entities.concretes.User;

public interface UserService {

	public List<AllUsersResponse> getAll();
	
	User add(CreateUserRequest userRequest);
	
}
