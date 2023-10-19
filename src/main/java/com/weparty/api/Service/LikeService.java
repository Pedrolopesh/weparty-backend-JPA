package com.weparty.api.Service;

import com.weparty.api.Model.LikeModel;
import com.weparty.api.Repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<LikeModel> index() {
        return (List<LikeModel>) likeRepository.findAll();
    }

    public Object store (LikeModel likeModel) {
        try {
            return likeRepository.save(likeModel);
        } catch (Exception e) {
            return e;
        }
    }
}
