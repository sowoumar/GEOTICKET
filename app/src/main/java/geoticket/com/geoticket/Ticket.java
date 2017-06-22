package geoticket.com.geoticket;

/**
 * Created by oumar on 22/06/17.
 */

public class Ticket {
    private long id;
    private String ticket;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    // Sera utilisée par ArrayAdapter dans la ListView
    @Override
    public String toString() {
        return ticket;
    }
}