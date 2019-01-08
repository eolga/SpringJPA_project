package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.IssuePoint;
import test.entity.Order;
import test.entity.User;
import test.repository.IssuePointRepository;
import test.repository.OrderRepository;
import test.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControllerAll")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final IssuePointRepository issuePointRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository,
                           IssuePointRepository issuePointRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.issuePointRepository = issuePointRepository;
    }

    @GetMapping("/orders")
    Iterable<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @GetMapping("/orders/{orderId}")
    Optional<Order> getOrderId(@PathVariable Integer orderId){
        return orderRepository.findById(orderId);
    }

    @RequestMapping("/orderCreate")
    Order createOrder(@RequestParam(name = "idClient", defaultValue = "") Integer idC,
                      @RequestParam(name = "idPoint", defaultValue = "") Integer idPoint,
                      @RequestParam(name  = "phone", defaultValue = "") String phone,
                      @RequestParam(name  = "remark", defaultValue = "") String remark) {
        Order order = new Order();
        Optional<IssuePoint> maybeIssuePoint = issuePointRepository.findById(idPoint);
        IssuePoint point = maybeIssuePoint
                .orElseThrow(() -> new ExpressionException(String.valueOf(idPoint)));

        Optional<User> maybeUser = userRepository.findById(idC);
        User user = maybeUser
                .orElseThrow(() -> new ExpressionException(String.valueOf(idC)));

        point.setOrder(new HashSet<Order>());
        user.setUser2(new HashSet<Order>());

        order.setIssuePoint(point);
        order.setUser(user);

        order.setPhone(phone);
        order.setRemark(remark);

        point.getOrder().add(order);
        user.getUser2().add(order);
        return orderRepository.save(order);
    }

    @RequestMapping(value = "/ordersUp")
    Order updateOrder(@RequestParam(value = "id", defaultValue = "") Integer id,
                      @RequestParam(name = "idClient", defaultValue = "") Integer idC,
                      @RequestParam(name = "idPoint", defaultValue = "") Integer idPoint,
                      @RequestParam(name  = "phone", defaultValue = "") String phone,
                      @RequestParam(name  = "remark", defaultValue = "") String remark) {
        Order orderr = new Order();
        if (issuePointRepository.findAll().size()<id){
            orderr = createOrder(idC, idPoint, phone, remark);
        }
        else{
            Optional<Order> maybeOrder= orderRepository.findById(id);
            Order order = maybeOrder
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            order.setPhone(phone);
            order.setRemark(remark);
            orderr = order;
            orderRepository.save(order);
        }

        return orderr;
    }


    @GetMapping(value="/ordersDel/{orderId}")
    Order deleteOrder(@PathVariable Integer orderId) throws Exception {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(orderId)));
        orderRepository.delete(order);
        return order;
    }
}
