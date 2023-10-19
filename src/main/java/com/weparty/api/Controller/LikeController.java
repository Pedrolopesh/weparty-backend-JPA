package com.weparty.api.Controller;

import com.weparty.api.Model.LikeModel;
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
    public LikeModel addLike(@RequestBody LikeModel likeModel) {
        return (LikeModel) likeService.store(likeModel);
    }

    @GetMapping
    public List<LikeModel> listAll() {
        return likeService.index();
    }
}
