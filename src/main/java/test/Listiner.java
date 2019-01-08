package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

import javax.xml.bind.Marshaller;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

public class Listiner {
    private static final Logger logger = LoggerFactory.getLogger(Marshaller.Listener.class);

    @Autowired
    private ReplicationService replicationService;

    @JmsListener(destination = "myQueue")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;

            try {
                test.entity2.Message message = new ObjectMapper().readValue(textMessage.getText(), test.entity2.Message.class);
                replicationService.execReplication(message);
            } catch (IOException e) {
                logger.error("Error listener", e);
            }

        }
    }
}
