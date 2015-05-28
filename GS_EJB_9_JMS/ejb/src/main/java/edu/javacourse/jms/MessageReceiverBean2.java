package edu.javacourse.jms;

import java.util.Calendar;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageDrivenBean2", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test")
})
public class MessageReceiverBean2 implements MessageListener {

    public MessageReceiverBean2() {
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Bean 2:" + textMessage.getText() + " " + Calendar.getInstance().getTime().toString());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }
}
