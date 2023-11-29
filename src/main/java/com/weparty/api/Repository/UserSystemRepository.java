package com.weparty.api.Repository;

import com.weparty.api.Model.UserSystemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystemModel, Integer> {
    Optional<UserSystemModel> findByEmailAndPassword(String email, String password);
}
