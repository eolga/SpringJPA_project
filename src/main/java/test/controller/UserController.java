package test.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;
import test.entity.User;
import test.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControllerAll")
public class UserController {
    private final UserRepository userRepository;

      public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/user")
    Iterable<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    Optional<User> getUserId(@PathVariable Integer userId){
        return userRepository.findById(userId);
    }


    @GetMapping("/createUser")
    User createUser( @RequestParam(name  = "name", defaultValue = "") String name,
                         @RequestParam(name  = "phone", defaultValue = "") String phone) {

        User user = new User();
        user.setName(name);
        user.setPhone(phone);

        return userRepository.save(user);
    }


    @RequestMapping("/upUser")
    User updateUser (@RequestParam(name = "id", defaultValue = "") Integer id,
                         @RequestParam(name  = "name", defaultValue = "") String name,
                         @RequestParam(name  = "phone", defaultValue = "") String phone) {
        User user1 = new User();
        if (userRepository.findAll().size()<id){
            user1 = createUser(name, phone);
        }
        else{
            Optional<User> maybeUser = userRepository.findById(id);
            User user = maybeUser
                    .orElseThrow(() -> new ExpressionException(String.valueOf(id)));
            user.setName(name);
            user.setPhone(phone);
            user1 = user;
            return userRepository.save(user);
        }
        return user1;
    }

    @GetMapping("/userDel/{userId}")
    User deleteUser (@PathVariable Integer userId) throws Exception {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ExpressionException(String.valueOf(userId)));
        userRepository.delete(user);
        return user;
    }
}
