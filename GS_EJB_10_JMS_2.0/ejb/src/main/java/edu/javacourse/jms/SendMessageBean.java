package edu.javacourse.jms;

import java.util.Calendar;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
@LocalBean
public class SendMessageBean {


//    @Resource(mappedName = "java:/ConnectionFactory")
//    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/test")
    private Queue queue;

    @Resource(mappedName = "java:/topic/test")
    private Topic topic;

    @Inject
    //@JMSConnectionFactory("java:/AnotherConnectionFactory")
    JMSContext context; // uses default connection factory

    public void sendMessageToQueue() {
        try {

            JMSProducer producer = context.createProducer();

            for (int i = 0; i < 20; i++) {
                producer.send(queue, ("This is message " + (i + 1)));
            }

        } catch (Exception  ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessageToTopic() {
        try {
            JMSProducer producer = context.createProducer();
            for (int i = 0; i < 10; i++) {
                producer.send(topic, ("This is message " + (i + 1)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
