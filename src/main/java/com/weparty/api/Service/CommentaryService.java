package com.weparty.api.Service;

import com.weparty.api.Model.CommentaryModel;
import com.weparty.api.Repository.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryService {
    @Autowired
    private CommentaryRepository commentaryRepository;

    public List<CommentaryModel> index() {
        return (List<CommentaryModel>) commentaryRepository.findAll();
    }

    public Object store(CommentaryModel commentaryModel) {
        try {
            return commentaryRepository.save(commentaryModel);
        } catch (Exception e) {
            return e;
        }
    }
}
