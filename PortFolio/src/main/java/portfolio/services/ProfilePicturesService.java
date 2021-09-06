package portfolio.services;

public interface ProfilePicturesService {

	public void saveImageToUser(Long idUser, String imageName);

	public String loadPictureUser(Long idUser);

}
