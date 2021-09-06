package portfolio.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import portfolio.entities.AppRole;
import portfolio.entities.AppUser;

public interface AccountService {

	public List<AppUser> getAllUser();

	public AppUser saveUser(AppUser user);

	public AppRole saveRole(AppRole role);

	public void addRoleToUser(String username, String roleName);

	public AppUser findUserByUsername(String username);

	public void saveImageUser(String username, MultipartFile file) throws IOException;

}
