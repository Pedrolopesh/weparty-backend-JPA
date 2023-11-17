package com.weparty.api.Service;

import com.weparty.api.Model.LikeEventModel;
import com.weparty.api.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<LikeEventModel> index() {
        return (List<LikeEventModel>) likeRepository.findAll();
    }

    public Object store (LikeEventModel likeEventModel) {
        try {
            return likeRepository.save(likeEventModel);
        } catch (Exception e) {
            return e;
        }
    }
}
