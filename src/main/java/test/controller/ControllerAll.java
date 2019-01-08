package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.repository.*;

import java.util.Random;

@RestController
@RequestMapping("ControllerAll")

public class ControllerAll {

    private final OrderRepository orderRepository;
    private final OrderPosRepository orderPosRepository;
    private final UserRepository userRepository;
    private final CoatRepository coatRepository;
    private final ClothesRepository clothesRepository;
    private final IssuePointRepository issuepointRepository;


    private Random random = new Random();
@Autowired
    public ControllerAll(OrderRepository orderRepository, OrderPosRepository orderPosRepository, UserRepository userRepository, CoatRepository coatRepository, ClothesRepository clothesRepository, IssuePointRepository issuepointRepository) {
        this.orderRepository = orderRepository;
        this.orderPosRepository = orderPosRepository;
        this.userRepository = userRepository;
        this.coatRepository = coatRepository;
        this.clothesRepository = clothesRepository;
        this.issuepointRepository = issuepointRepository;
    }
}
