package com.AskIt.AuthService.Repository;

import com.AskIt.EntityService.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

//    @Query(" SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
//    Boolean checkUser(String email);

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);



}
