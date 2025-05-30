package com.example.projeto2003.repository;

import com.example.projeto2003.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface RepositoryUser extends JpaRepository<User,Long> {

    Optional<User> findById(Long id);

}
