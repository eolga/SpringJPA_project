package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.entity.*;
import test.repository.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
public class HelloEndpoint {

    private final OrderRepository orderRepository;
    private final OrderPosRepository orderPosRepository;
    private final UserRepository userRepository;
    private final IssuePointRepository issuePointRepository;
    private final CoatRepository coatRepository;
    private final ClothesRepository clothesRepository;

    private Random random = new Random();

    @Autowired
    public HelloEndpoint(OrderRepository orderRepository, OrderPosRepository orderPosRepository, UserRepository userRepository, IssuePointRepository issuePointRepository, CoatRepository coatRepository, ClothesRepository clothesRepository) {

        this.orderRepository = orderRepository;
        this.orderPosRepository = orderPosRepository;
        this.userRepository = userRepository;
        this.issuePointRepository = issuePointRepository;
        this.coatRepository = coatRepository;
        this.clothesRepository = clothesRepository;
    }

    @RequestMapping("hi/hello")
    String abc(){

        User user = new User();
        IssuePoint issuePoint = new IssuePoint();
        Clothes clothes = new Clothes();

        user.setName("User" +String.valueOf(random.nextInt()));
        user.setPhone("88005553535");

        userRepository.save(user);

        issuePoint.setIssuePointName("Point" +String.valueOf(random.nextInt()));
        issuePoint.setAddress("Lenina" +String.valueOf(random.nextInt()));
        issuePointRepository.save(issuePoint);

        clothes.setClothesName("GoodClothes");
        clothes.setRemark("FreshClothes");
        clothesRepository.save(clothes);


        for(Integer i = 0; i<=5; i++) {
            Order order1 = new Order();
            Coat coat = new Coat();

            Set<Order> order = new HashSet<Order>();

            order1.setUser(user);
            order1.setIssuePoint(issuePoint);
            order1.setPhone("8- " + String.valueOf(random.nextInt()));
            order1.setRemark("Remark " + i.toString());

            user.setOrder(order);
            issuePoint.setOrder(order);
            orderRepository.save(order1);

            Set<Coat> coats = new HashSet<Coat>();
            clothes.setCoat(coats);


            coat.setClothes(clothes);
            coat.setCoatName(String.valueOf(random.nextInt()));
            coat.setCoatPrice(random.nextInt());

            coatRepository.save(coat);

            if (i == 5) {
                for(int j=0;j<=5; j++){
                    OrderPos orderPos = new OrderPos();
                    order1.setOrderPoses(new HashSet<OrderPos>());
                    coat.setOrderPos(new HashSet<OrderPos>());


                    orderPos.setPrice(random.nextInt());
                    orderPos.setQuantity(random.nextInt());
                    orderPos.setGoodName(String.valueOf(random.nextInt()));

                    orderPos.setOrder(order1);
                    orderPos.setCoat(coat);

                    orderPosRepository.save(orderPos);
                }


            }

        }

       /* Order  order = new Order();

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
