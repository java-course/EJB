package edu.javacourse.jms;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "MessageDrivenBean1", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
})
public class MessageReceiverBean1 implements MessageListener {

    public MessageReceiverBean1() {

    }

    @PostConstruct
    public void before() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void after() {
        System.out.println("PreDestroy");
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Bean 1:" + textMessage.getText() + " " + Calendar.getInstance().getTime().toString());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

    @AroundInvoke
    public Object myInterceptor(InvocationContext ctx) throws Exception {
        //System.out.println("Around 1:" + mc.getCallerPrincipal().getName());
        return ctx.proceed();
    }

}
