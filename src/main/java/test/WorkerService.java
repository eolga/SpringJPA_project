package test;

import org.springframework.beans.factory.annotation.Autowired;
import test.entity2.Message;

import java.util.Comparator;
import java.util.List;

public class WorkerService {
    @Autowired
    private Producer producer;

    @Autowired
    private FixedChanges fixedChanges;

    @Autowired
    private ReplicationService replicationService;

    public void collectAndSendDBChange() {
        List<Message> dbChanges = fixedChanges.collectChange();
        dbChanges.stream().sorted(Comparator.comparing(Message::getDateTime))
                .forEach(o -> producer.send("myQueue", o) );
    }
}
