package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.WorkerService;

@RestController
public class JMS {

    @Autowired
    private WorkerService workerService;
    @GetMapping("/exec")
    public ResponseEntity exec() {
        workerService.collectAndSendDBChange();
        return new ResponseEntity( HttpStatus.OK);
    }
}