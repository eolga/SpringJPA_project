package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.entity.ChangeAll;
import test.repository.ChangeRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ControllerAll")
public class ChangeAllController {

    private final ChangeRepository changeRepository;

    @Autowired
    public ChangeAllController(ChangeRepository changeRepository) {
        this.changeRepository = changeRepository;
    }

    @GetMapping("/changeControllerAll")
    Iterable<ChangeAll> getAllChangeController() {
        return (List<ChangeAll>) changeRepository.findAll();
    }

    @GetMapping("/ichangeControllerId/{ipId}")
    Optional<ChangeAll> getIPId(@PathVariable Integer ipId) {
        return changeRepository.findById(ipId);
    }
}