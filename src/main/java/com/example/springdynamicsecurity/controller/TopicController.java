package com.example.springdynamicsecurity.controller;

import com.example.springdynamicsecurity.model.Topic;
import com.example.springdynamicsecurity.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class TopicController {

    @Autowired
    private TopicService service;

    @GetMapping("/topic/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable("id") Integer id) {
        Topic topic = service.getTopicById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = service.getAllTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @PostMapping("/topic")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic, UriComponentsBuilder builder) {
        Topic newTopic = service.addTopic(topic);

        if (newTopic.getTopicId() == 0) {
            return new ResponseEntity<>(new Topic(), HttpStatus.CONFLICT);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/user/topic/{id}").
                buildAndExpand(topic.getTopicId()).toUri());

        return new ResponseEntity<Topic>(newTopic,httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/topic")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
        Topic topic1 = service.updateTopic(topic);
        System.out.println("id is : " + topic1.getTopicId());
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @DeleteMapping("/topic/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable("id") Integer id) {
        service.deleteTopic(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
