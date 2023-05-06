package com.example.springdynamicsecurity.dao;

import com.example.springdynamicsecurity.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDAO extends JpaRepository<Topic, Integer> {

}
