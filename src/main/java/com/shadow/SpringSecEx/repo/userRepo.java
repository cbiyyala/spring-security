package com.shadow.SpringSecEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shadow.SpringSecEx.model.users;
@Repository
public interface userRepo extends JpaRepository<users, Long> {

    users findByUsername(String username);

}
