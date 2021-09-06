package portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import portfolio.entities.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	public AppUser findByUsername(String username);
	
	
}
