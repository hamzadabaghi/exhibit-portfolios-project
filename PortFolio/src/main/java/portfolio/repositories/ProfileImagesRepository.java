package portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import portfolio.entities.ProfilePictures;

public interface ProfileImagesRepository extends JpaRepository<ProfilePictures,Long>{


	
	public ProfilePictures findByUserId(Long userId);
	
}
