package com.StudentLibrary.Studentlibrary.Repositories;

import com.StudentLibrary.Studentlibrary.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer>  {

    @Query("SELECT DISTINCT u FROM User u WHERE u.email = :username")
     Optional<User> findByEmail(String username);
}
