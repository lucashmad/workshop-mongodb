package com.example.workshopmongodb.repository;

import com.example.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    // do and, ele vai comparar mendate e o maindate se e maior ou igual a outra
    // e or vai encontrar se os posts estao no corpo, no title, ou na lista de comments

    @Query("{ { $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> searchControl(String text, Date menDate, Date maiDate);
}
