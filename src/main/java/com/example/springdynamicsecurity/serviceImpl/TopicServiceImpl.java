package com.example.springdynamicsecurity.serviceImpl;

import com.example.springdynamicsecurity.dao.TopicDAO;
import com.example.springdynamicsecurity.model.Topic;
import com.example.springdynamicsecurity.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicDAO topicDAO;


    @Override
    public List<Topic> getAllTopics() {
        return topicDAO.findAll();
    }

    @Override
    public Topic getTopicById(int topicId) {
        return topicDAO.findById(topicId).orElse(new Topic());
    }

    @Override
    public Topic addTopic(Topic topic) {
        return topicDAO.save(topic);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        return topicDAO.save(topic);
    }

    @Override
    public void deleteTopic(int topicId) {
    topicDAO.deleteById(topicId);
    }
}
