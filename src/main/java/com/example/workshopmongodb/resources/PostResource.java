package com.example.workshopmongodb.resources;

import com.example.workshopmongodb.domain.Post;
import com.example.workshopmongodb.repository.util.URL;
import com.example.workshopmongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> postList = postService.findByTitle(text);
        return ResponseEntity.ok().body(postList);
    }

    @GetMapping(value = "searchControl")
    public ResponseEntity<List<Post>> searchControl(
            @RequestParam(value = "text", defaultValue = "")  String text,
            @RequestParam(value = "menDate", defaultValue = "") String menDate,
            @RequestParam(value = "maiDate", defaultValue = "") String mainDate ) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(menDate, new Date(0L));
        Date max = URL.convertDate(mainDate, new Date());
        List<Post> postList = postService.searchControl(text, min, max);
        return ResponseEntity.ok().body(postList);
    }

}
