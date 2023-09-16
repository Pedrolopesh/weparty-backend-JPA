package com.weparty.api.Repository;

import com.weparty.api.Model.UserConnectionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConnectionsRepository extends JpaRepository<UserConnectionsModel, Integer> {
}
