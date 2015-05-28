package edu.javacourse.jms;

import java.util.Calendar;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Stateless
@LocalBean
public class SendMessageBean {


    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(mappedName = "java:/queue/test")
    private Queue queue;

    @Resource(mappedName = "java:/topic/test")
    private Topic topic;

    public void sendMessageToQueue() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 20; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText() + " "+Calendar.getInstance().getTime().toString());
                messageProducer.send(message);
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void sendMessageToTopic() {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(topic);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 10; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText() + " "+Calendar.getInstance().getTime().toString());
                messageProducer.send(message);
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
