package com.weparty.api.Repository;

import com.weparty.api.Model.LikeEventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEventModel, Integer> {
}
