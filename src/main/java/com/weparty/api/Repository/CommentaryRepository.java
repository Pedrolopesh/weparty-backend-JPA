package com.weparty.api.Repository;

import com.weparty.api.Model.CommentaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryModel, Integer> {
}
