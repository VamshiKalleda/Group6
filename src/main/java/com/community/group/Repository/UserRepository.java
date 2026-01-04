package com.community.group.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.group.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	Optional<User> findByuserName(String userName);

}
