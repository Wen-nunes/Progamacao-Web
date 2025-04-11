package com.example.projeto2003.repository;

import com.example.projeto2003.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long> {

    @Override
    Optional<Phone> findById(Long id);
}
