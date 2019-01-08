package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.entity2.Message;
import test.repository.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FixedChanges {
    private static final Logger logger = LoggerFactory.getLogger(FixedChanges.class);

    @Autowired
    private Order2Repository order2Repository;
    private OrderPos2Repository orderPos2Repository;
    private User2Repository user2Repository;
    private IssuePoint2Repository issuePoint2Repository;
    private Coat2Repositoty coat2Repository;
    private Clothes2Repository clothes2tRepository;


    public List<Message> collectChange() {
        List<Message> messages = new CopyOnWriteArrayList<>();

        issuePoint2Repository.findAll().parallelStream()
                .forEach(issuePoint2 -> {
                    issuePoint2.setRead(true);
                    issuePoint2Repository.save(issuePoint2);
                    try {
                        String value = new ObjectMapper().writeValueAsString(issuePoint2);
                        messages.add(new Message("IssuePoint", value, issuePoint2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        orderPos2Repository.findAll().parallelStream()
                .forEach(orderPos2 -> {
                    orderPos2.setRead(true);
                    orderPos2Repository.save(orderPos2);
                    try {
                        String value = new ObjectMapper().writeValueAsString(orderPos2);
                        messages.add(new Message("OrderPos", value, orderPos2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        order2Repository.findAll().parallelStream()
                .forEach(order2 -> {
                    order2.setRead(true);
                    order2Repository.save(order2);
                    try {
                        String value = new ObjectMapper().writeValueAsString(order2);
                        messages.add(new Message("Order", value, order2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        coat2Repository.findAll().parallelStream()
                .forEach( coat2 -> {
                    coat2.setRead(true);
                    coat2Repository.save( coat2);
                    try {
                        String value = new ObjectMapper().writeValueAsString( coat2);
                        messages.add(new Message("Product", value,  coat2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        clothes2tRepository.findAll().parallelStream()
                .forEach(clothes2 -> {
                    clothes2.setRead(true);
                    clothes2tRepository.save(clothes2);
                    try {
                        String value = new ObjectMapper().writeValueAsString(clothes2);
                        messages.add(new Message("ProductGroup", value, clothes2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        user2Repository.findAll().parallelStream()
                .forEach(user2 -> {
                    user2.setRead(true);
                    user2Repository.save(user2);
                    try {
                        String value = new ObjectMapper().writeValueAsString(user2);
                        messages.add(new Message("User", value, user2.getStamp()));
                    } catch (JsonProcessingException e) {
                        logger.error("Error", e);
                    }
                });

        return messages;
    }
}
