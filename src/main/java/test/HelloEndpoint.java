package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.entity.Order;
import test.entity.OrderPos;
import test.repository.OrderPosRepository;
import test.repository.OrderRepository;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
public class HelloEndpoint {

    private final OrderRepository orderRepository;

    private final OrderPosRepository orderPosRepository;

    private Random random = new Random();

    public HelloEndpoint (
        OrderRepository orderRepository,
        OrderPosRepository orderPosRepository) {
        this.orderRepository = orderRepository;
        this.orderPosRepository = orderPosRepository;
    }


    @RequestMapping("hi/hello")
    String abc(){

        Order  order = new Order();

        order.setCoat(String.valueOf(random.nextInt()));
        order.setCoat(String.valueOf(random.nextInt()) + String.valueOf(random.nextInt()));

        Set<OrderPos> orderPoses = new HashSet<OrderPos>();
        orderRepository.save(order);

        for (int i = 0; i <= 5; i++) {

            OrderPos orderPos = new OrderPos();
            orderPos.setPrice(random.nextDouble());
            orderPos.setOrder(order);
           // orderPos.setPrice(random.nextDouble());
            orderPos.setQuantity(random.nextInt());
            orderPos.setGoodname(String.valueOf(random.nextInt()));

            // orderPoses.add(orderPos);
            orderPosRepository.save(orderPos);

        }



        /*Coat testEnt = new Coat();
        testEnt.setName("Name");

        testRep.save(testEnt);

        String text = "";

       testEnt = null;

        Iterator<Coat> iterator = testRep.findByNameLikeAnything("Name").iterator();
        while (iterator.hasNext()){
            testEnt = iterator.next();
            text = testEnt.getId().toString() + " " + testEnt.getName() + "; ";
        }*/

        return "OK";
    }

}
