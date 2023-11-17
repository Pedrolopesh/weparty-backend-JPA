package com.weparty.api.Controller;

import com.weparty.api.Model.LikeEventModel;
import com.weparty.api.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LikeEventModel addLike(@RequestBody LikeEventModel likeEventModel) {
        return (LikeEventModel) likeService.store(likeEventModel);
    }

    @GetMapping
    public List<LikeEventModel> listAll() {
        return likeService.index();
    }
}
