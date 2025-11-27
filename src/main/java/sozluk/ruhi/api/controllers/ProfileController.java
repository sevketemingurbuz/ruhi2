package sozluk.ruhi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sozluk.ruhi.business.abstracts.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	ProfileService profileService;
	
	@Autowired
	ProfileController(ProfileService profileService){
		this.profileService= profileService;
	}
	
	/*@GetMapping("getAll")
	public List<Profile> getAll(){
		return this.profilService.getAll();
	}*/

}
