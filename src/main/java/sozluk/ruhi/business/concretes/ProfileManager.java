package sozluk.ruhi.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sozluk.ruhi.business.abstracts.ProfileService;
import sozluk.ruhi.dataAccess.abstracts.ProfileDao;
import sozluk.ruhi.entities.concretes.Profile;

@Service
public class ProfileManager implements ProfileService{
	
	ProfileDao profileDao;
	
	@Autowired
	ProfileManager(ProfileDao profileDao){
		this.profileDao= profileDao;
	}
	
	@Override
	public List<Profile> getAll(){
		return this.profileDao.findAll();
	}

}
