package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import test.entity2.*;
import test.repository.*;

import java.io.IOException;

public class ReplicationService {
    @Autowired
    private ChangeRepository changeRepository;
    private OrderRepository orderRepository;
    private OrderPosRepository orderPosRepository;
    private UserRepository userRepository;
    private IssuePointRepository ussuePointRepository;
    private CoatRepository coatRepository;
    private ClothesRepository clothesRepository;

    public void execReplication(Message message) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (message.getName().equalsIgnoreCase("Point")) {
            IssuePoint2 issuePoint2 = objectMapper.readValue(message.getJson(), IssuePoint2.class);
            if (issuePoint2.getOperation().equalsIgnoreCase("D")) {
                ussuePointRepository.delete(issuePoint2.getIssuePoint());
            } else {
                ussuePointRepository.save(issuePoint2.getIssuePoint());
            }
        } else if (message.getName().equalsIgnoreCase("Order")) {
            Order2 order2 = objectMapper.readValue(message.getJson(), Order2.class);
            if (order2.getOperation().equalsIgnoreCase("D")) {
                orderRepository.delete(order2.getOrder());
            } else {
                orderRepository.save(order2.getOrder());
            }
        } else if (message.getName().equalsIgnoreCase("OrderPos")) {
            OrderPos2 orderPos2 = objectMapper.readValue(message.getJson(), OrderPos2.class);
            if (orderPos2.getOperation().equalsIgnoreCase("D")) {
                orderPosRepository.delete(orderPos2.getOrderPos());
            } else {
                orderPosRepository.save(orderPos2.getOrderPos());
            }

        } else if (message.getName().equalsIgnoreCase("Product")) {
            Coat2 coat2 = objectMapper.readValue(message.getJson(), Coat2.class);
            if (coat2.getOperation().equalsIgnoreCase("D")) {
                coatRepository.delete(coat2.getCoat());
            } else {
                coatRepository.save(coat2.getCoat());
            }

        } else if (message.getName().equalsIgnoreCase("ProductGroup")) {
            Clothes2 clothes2 = objectMapper.readValue(message.getJson(), Clothes2.class);
            if (clothes2.getOperation().equalsIgnoreCase("D")) {
                clothesRepository.delete(clothes2.getClothes());
            } else {
                clothesRepository.save(clothes2.getClothes());
            }
        } else if (message.getName().equalsIgnoreCase("User")) {
            User2 user2 = objectMapper.readValue(message.getJson(), User2.class);
            if (user2.getOperation().equalsIgnoreCase("D")) {
                userRepository.delete(user2.getUser());
            } else {
                userRepository.save(user2.getUser());
            }
        }
    }
}
