package test.controller;

import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.Coat;
import test.entity.Order;
import test.entity.OrderPos;
import test.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("ControllerAll")

public class OrderPosController {
    private final OrderRepository orderRepository;
    private final OrderPosRepository orderPosRepository;
    private final UserRepository userRepository;
    private final IssuePointRepository issuePointRepository;
    private final CoatRepository coatRepository;
    private final ClothesRepository clothesRepository;
    private Random random = new Random();

    public OrderPosController(OrderRepository orderRepository, OrderPosRepository orderPosRepository, UserRepository userRepository, IssuePointRepository issuePointRepository, CoatRepository coatRepository, ClothesRepository clothesRepository) {
        this.orderRepository = orderRepository;
        this.orderPosRepository = orderPosRepository;
        this.userRepository = userRepository;
        this.issuePointRepository = issuePointRepository;
        this.coatRepository = coatRepository;
        this.clothesRepository = clothesRepository;
    }

    @GetMapping("/orderPos")
    Iterable<OrderPos> getAllOrderPos() {
        return (List<OrderPos>) orderPosRepository.findAll();
    }

    @GetMapping("/orderPos/{orderPosId}")
    Optional<OrderPos> getorderPosId(@PathVariable Integer orderPosId){
        return orderPosRepository.findById(orderPosId);
    }

    @RequestMapping("/orderPosCreate")
    OrderPos createOrderPos(@RequestParam(name = "idOrder", defaultValue = "") Integer idOrder,
                            @RequestParam(name = "idCoat", defaultValue = "") Integer idCoat,
                            @RequestParam(name  = "quantity", defaultValue = "") Integer quantity,
                            @RequestParam(name  = "price", defaultValue = "") Integer price,
                            @RequestParam(name  = "name", defaultValue = "") String name) {
        OrderPos orderPos = new OrderPos();
        Optional<Coat> maybeCoat = coatRepository.findById(idCoat);
        Coat coat = maybeCoat
                .orElseThrow(() -> new ExpressionException(String.valueOf(idCoat)));

        Optional<Order> maybeOrder = orderRepository.findById(idOrder);
        Order order = maybeOrder
                .orElseThrow(() -> new ExpressionException(String.valueOf(idOrder)));

        coat.setOrderPoss(new HashSet<OrderPos>());
        order.setOrderPoses(new HashSet<OrderPos>());

        orderPos.setCaot(coat);
        orderPos.setOrder(order);

        orderPos.setQuantity(quantity);
        orderPos.setPrise(price);
        orderPos.setGoodName(name);

        order.getOrderPoses().add(orderPos);
        coat.getOrderPoss().add(orderPos);
        return orderPosRepository.save(orderPos);
    }

    @RequestMapping("/orderPosUp")
    OrderPos updateOrderPos(@RequestParam(name = "id", defaultValue = "") Integer id,
                            @RequestParam(name = "idOrder", defaultValue = "") Integer idOrder,
                            @RequestParam(name = "idCoat", defaultValue = "") Integer idCoat,
                            @RequestParam(name  = "quantity", defaultValue = "") Integer quantity,
                            @RequestParam(name  = "price", defaultValue = "") Integer price,
                            @RequestParam(name  = "name", defaultValue = "") String name) {
        OrderPos orderPosition = new OrderPos();
        if (orderPosRepository.findAll().size()<id){
            orderPosition = createOrderPos(idOrder, idCoat, quantity, price, name);
        }
        else{
            Optional<OrderPos> maybeOrder = orderPosRepository.findById(id);
            OrderPos orderPos = maybeOrder
                    .orElseThrow(() -> new ExpressionException(String.valueOf(idOrder)));
            orderPos.setQuantity(quantity);
            orderPos.setPrise(price);
            orderPos.setGoodName(name);
            orderPosition = orderPos;
            orderPosRepository.save(orderPos);
        }

        return orderPosition;
    }

    @GetMapping("/orderPosDel/{pGroupId}")
    OrderPos deleteOrderPos(@PathVariable Integer pGroupId) throws Exception {
        OrderPos orderPos = orderPosRepository.findById(pGroupId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(pGroupId)));
        orderPosRepository.delete(orderPos);
        return  orderPos;
    }

}
