package logsv1;

import javax.ejb.*;
import javax.jms.*;

@MessageDriven(mappedName = "uneBALLogsV1")
public class LogsBean implements MessageListener {

    public LogsBean() {
    }

    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                System.out.println("Message recu: " + msg.getText());
            } else {
                System.out.println(
                        "Message of wrong type: "
                        + inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
}
