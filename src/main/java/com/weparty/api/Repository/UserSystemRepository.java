package com.weparty.api.Repository;

import com.weparty.api.Model.UserSystemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSystemRepository extends JpaRepository<UserSystemModel, Integer> {
}
