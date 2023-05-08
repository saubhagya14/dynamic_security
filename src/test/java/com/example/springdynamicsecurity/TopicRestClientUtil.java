package com.example.springdynamicsecurity;


import com.example.springdynamicsecurity.model.Topic;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpResponse;


public class TopicRestClientUtil {
    public void addTopic() {
        HttpHeaders headers = getHeaders();
        String url = "http://localhost:8081/user/topic";
        Topic topic = new Topic();
        topic.setCategory("UI");
        topic.setTitle("Angular");

        HttpEntity<Topic> requestEnity = new HttpEntity<Topic>(topic, headers);
        URI uri = new RestTemplate().postForLocation(url, requestEnity);
        System.out.println("Path is : " + uri.getPath());

    }

    public void getAllTopic() {
        HttpHeaders headers = getHeaders();
        String url = "http://localhost:8081/user/topics";

        HttpEntity<String> requHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<Topic[]> responseEntity = new RestTemplate().exchange(url, HttpMethod.GET, requHttpEntity, Topic[].class);
        System.out.println("status code is : " + responseEntity.getStatusCode());

        Topic[] topics = responseEntity.getBody();

        for(Topic topic : topics) {
            System.out.println(topic.toString());
        }
    }

    public void getTopicById(int id) {
        HttpHeaders headers = getHeaders();
        String url = "http://localhost:8081/user/topic/" + id;

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Topic> topicHttpResponse = new RestTemplate().exchange(url,HttpMethod.GET,httpEntity,Topic.class);
        System.out.println("code is :" + topicHttpResponse.getStatusCode());
        System.out.println("response is : " + topicHttpResponse.toString());

    }

    private HttpHeaders getHeaders() {
        String credential = "Saubhagya:Saubhagya";
        String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "Basic " + encodedCredential);
        return httpHeaders;
    }

    public static void main(String[] args) {
        TopicRestClientUtil topicRestClientUtil = new TopicRestClientUtil();
        //topicRestClientUtil.addTopic();
        topicRestClientUtil.getAllTopic();
        topicRestClientUtil.getTopicById(5);
    }
}
