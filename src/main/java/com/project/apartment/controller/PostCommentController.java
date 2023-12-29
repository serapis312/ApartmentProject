package com.project.apartment.controller;

import com.project.apartment.domain.post.QryCommentList;
import com.project.apartment.domain.post.QryResult;
import com.project.apartment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board/comment")
public class PostCommentController {

    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public QryCommentList list(@RequestParam("id") Long id){
        return postService.listComment(id);
    }

    @PostMapping("/write")
    public QryResult write(
            @RequestParam("postId") Long postId,
            @RequestParam("userId") Long userId,
            String content){
        return postService.writeComment(postId, userId, content);
    }

    @PostMapping("/delete")
    public QryResult delete(@RequestParam("id") Long id){
        return postService.deleteComment(id);
    }

}
