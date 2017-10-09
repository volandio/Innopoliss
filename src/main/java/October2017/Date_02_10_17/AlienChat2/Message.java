package October2017.Date_02_10_17.AlienChat2;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String message;
    private Date date;

    public Message(String username, String message, Date date2){
        this.message = message;
        this.username = username;
        this.date = date2;
    }

    public String getName(){
        return username;
    }

    public String getMessage(){
        return message;
    }

    public Date gerDate(){
        return date;
    }

}
