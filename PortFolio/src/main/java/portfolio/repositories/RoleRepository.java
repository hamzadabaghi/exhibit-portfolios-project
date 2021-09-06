package portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import  portfolio.entities.AppRole;


@Repository
public interface RoleRepository  extends JpaRepository<AppRole, Long>{
	
	public AppRole findByRoleName(String roleName);
	
	
}
