package logsv1;

import logsv1.Entity.Logs;

import javax.ejb.*;
import javax.jms.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@MessageDriven(mappedName = "uneBALLogsV1")
public class LogsBean implements MessageListener {

    public LogsBean() {
    }

    @PersistenceContext(unitName="logsPU")
    private EntityManager em;

    public void onMessage(Message inMessage) {
        TextMessage msg = null;
        Logs log = new Logs();

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                System.out.println("Message recu: " + msg.getText());

                log.setMsg(msg.getText());
                em.persist(log);

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
