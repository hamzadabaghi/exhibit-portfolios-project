package portfolio.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portfolio.entities.ProfilePictures;
import portfolio.repositories.ProfileImagesRepository;
import portfolio.services.ProfilePicturesService;

@Service
public class ProfilePicturesServiceImpl implements ProfilePicturesService {

	@Autowired
	private ProfileImagesRepository profileImagesRepository;

	@Override
	public void saveImageToUser(Long idUser, String imageName) {

		/*
		 * we have to delete the old one before saving another but , there is no time ,
		 * not yet
		 */
		ProfilePictures oldPicture = profileImagesRepository.findByUserId(idUser);
		if (oldPicture == null) {
			profileImagesRepository.save(new ProfilePictures(null, idUser, imageName));
		} else {
			profileImagesRepository.deleteById(oldPicture.getIdImage());
			profileImagesRepository.save(new ProfilePictures(null, idUser, imageName));
		}
	}

	@Override
	public String loadPictureUser(Long userId) {

		ProfilePictures profilePicture = profileImagesRepository.findByUserId(userId);
		return profilePicture != null ? profilePicture.getImageProfile() : "default.jpg";
	}

}
