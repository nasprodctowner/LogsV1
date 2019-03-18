package logsv1.Entity;

import javax.persistence.*;

@Entity
@Table(name = "test.LOGS")
public class Logs {

    private int idLogs;
    private String msg;


    public Logs(String msg) {
        this.msg = msg;
    }

    public Logs() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdLogs() {
        return idLogs;
    }

    public void setIdLogs(int idLogs) {
        this.idLogs = idLogs;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

