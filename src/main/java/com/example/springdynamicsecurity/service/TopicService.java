package com.example.springdynamicsecurity.service;

import com.example.springdynamicsecurity.model.Topic;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface TopicService {

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Topic> getAllTopics();

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Topic getTopicById(int topicId);

    @Secured({"ROLE_ADMIN"})
    Topic addTopic(Topic topic);
    @Secured({"ROLE_ADMIN"})
    Topic updateTopic(Topic topic);

    @Secured({"ROLE_ADMIN"})
    void deleteTopic(int topicId);
}
