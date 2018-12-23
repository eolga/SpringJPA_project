package test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import test.entity.*;
import test.repository.*;

import java.util.List;

@RestController
public class RController {

    private final ClothesRepository clothesRepository;
    private  final CoatRepository coatRepository;
    private final IssuePointRepository issuePointRepository;
    private final OrderPosRepository orderPosRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public RController(ClothesRepository clothesRepository, CoatRepository coatRepository, IssuePointRepository issuePointRepository, OrderPosRepository orderPosRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.clothesRepository = clothesRepository;
        this.coatRepository = coatRepository;
        this.issuePointRepository = issuePointRepository;
        this.orderPosRepository = orderPosRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }
    @RequestMapping(value = "/api/goodgroup/all/", method = RequestMethod.GET)
    public ResponseEntity listAllClothes() {

        List<Clothes> entities = clothesRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/goodgroup/", method = RequestMethod.POST)
    public ResponseEntity<?> createClothes (@RequestBody List<Clothes> entities/*, UriComponentsBuilder ucBuilder*/) {

        boolean isConflict = false;
        for (Clothes entity : entities)
        {
            if (clothesRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                clothesRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }

        /*HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/orderposition/{id}").buildAndExpand(serviceUser.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);*/
    }


    @RequestMapping(value = "/api/goodunit/all/", method = RequestMethod.GET)
    public ResponseEntity listAllCoats() {

        List<Coat> entities = coatRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/goodunit/", method = RequestMethod.POST)
    public ResponseEntity<?> createCoat(@RequestBody List<Coat> entities, UriComponentsBuilder ucBuilder) {

        boolean isConflict = false;
        for (Coat entity : entities)
        {
            if (coatRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                coatRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/api/orderposition/all/", method = RequestMethod.GET)
    public ResponseEntity listAllOrderPos() {

        List<OrderPos> entities = orderPosRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/orderposition/", method = RequestMethod.POST)
    public ResponseEntity<?> createOrderPos(@RequestBody List<OrderPos> entities, UriComponentsBuilder ucBuilder) {

        boolean isConflict = false;
        for (OrderPos entity : entities)
        {
            if (orderPosRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                orderPosRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/api/orderunit/all/", method = RequestMethod.GET)
    public ResponseEntity listAllOrders() {

        List<Order> entities = orderRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/orderunit/", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody List<Order> entities, UriComponentsBuilder ucBuilder) {

        boolean isConflict = false;
        for (Order entity : entities)
        {
            if (orderRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                orderRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/api/servicepoint/all/", method = RequestMethod.GET)
    public ResponseEntity listAllIssuePoints() {

        List<IssuePoint> entities = issuePointRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/servicepoint/", method = RequestMethod.POST)
    public ResponseEntity<?> createIssuePoint(@RequestBody List<IssuePoint> entities, UriComponentsBuilder ucBuilder) {

        boolean isConflict = false;
        for (IssuePoint entity : entities)
        {
            if (issuePointRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                issuePointRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }


    @RequestMapping(value = "/api/serviceuser/all/", method = RequestMethod.GET)
    public ResponseEntity listAllUsers() {

        List<User> entities = userRepository.getAll();
        if (entities.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/serviceuser/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody List<User> entities, UriComponentsBuilder ucBuilder) {

        boolean isConflict = false;
        for (User entity : entities)
        {
            if (userRepository.isExists(entity)) {
                isConflict = true;
            }
            else {
                userRepository.save(entity);
            }
        }
        if (isConflict) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        else {
            return new ResponseEntity(HttpStatus.CREATED);
        }
    }

/* private final TestRepository testRepository;
    private final Test2Repository test2Repository;

    public RController(TestRepository testRepository, Test2Repository test2Repository) {
        this.testRepository = testRepository;
        this.test2Repository = test2Repository;
    }

    @RequestMapping("Controller")
    public TestEntity controller (@RequestParam(name = "name", defaultValue = "") String name){

        TestEntity ent = new TestEntity();

        ent.setName(name);
        ent.setTest2s(new HashSet<Test2>());

        for (int i = 0; i < 5; i++) {

            Test2 t2 = new Test2();

            t2.setName("Наименование " + i.toString());
            t2.setTestEntity(ent);
            ent.getTest2s().add(t2);

        }
    }   testRepository.save(ent);
        test2Repository.saveAll(ent.getTest2s());

        return ent;
    }*/
}
