package com.restapiuser.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restapiuser.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	@Query("SELECT firstName ,lastName from UserEntity WHERE id =:id")
	String findFirstNameByID(Long id);
	
	@Query("SELECT firstName FROM UserEntity")
	List<String> fetchAllFirstNames();
	
	@Query("SELECT firstName,lastName FROM UserEntity")
	List<String> getAllFirstLastNames();
	
	@Query("SELECT u from UserEntity u where u.address=:c")
	public List<UserEntity> getUserByAddress(@Param("c") String address);
	
	

	

}
