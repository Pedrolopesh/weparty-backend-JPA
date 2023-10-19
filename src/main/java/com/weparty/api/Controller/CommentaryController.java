package com.weparty.api.Controller;

import com.weparty.api.Model.CommentaryModel;
import com.weparty.api.Service.CommentaryService;
import com.weparty.api.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coment")
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentaryModel addComent(@RequestBody CommentaryModel commentaryModel) {
        return (CommentaryModel) commentaryService.store(commentaryModel);
    }

    @GetMapping
    public List<CommentaryModel> listAll() {
        return commentaryService.index();
    }
}
