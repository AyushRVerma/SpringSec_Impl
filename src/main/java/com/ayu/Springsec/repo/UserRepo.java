package com.ayu.Springsec.repo;

import com.ayu.Springsec.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

      UserModel findByUsername(String username); ;
}
