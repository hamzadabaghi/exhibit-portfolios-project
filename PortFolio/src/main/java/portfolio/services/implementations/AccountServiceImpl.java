package portfolio.services.implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import portfolio.entities.AppRole;
import portfolio.entities.AppUser;
import portfolio.repositories.RoleRepository;
import portfolio.repositories.UserRepository;
import portfolio.services.AccountService;
import portfolio.services.ProfilePicturesService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	ProfilePicturesService profilePicturesService;

	@Override
	public AppUser saveUser(AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role = roleRepository.findByRoleName(roleName);
		AppUser user = userRepository.findByUsername(username);
		user.getRoles().add(role);

	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveImageUser(String username, MultipartFile file) throws IOException {

		/* current path */

		String userDirectory = System.getProperty("user.dir");

		/* path to save */
		String folderSavingProfilePicture = "\\src\\main\\resources\\static\\IMG\\users\\";

		folderSavingProfilePicture = userDirectory + folderSavingProfilePicture;

		/* saving */

		byte[] bytes = file.getBytes();
		Path path = Paths.get(folderSavingProfilePicture + file.getOriginalFilename());
		Files.write(path, bytes);

		/* current user */
		AppUser user = this.findUserByUsername(username);

		profilePicturesService.saveImageToUser(user.getId(), file.getOriginalFilename());

	}

	@Override
	public List<AppUser> getAllUser() {

		return userRepository.findAll();
	}

}
