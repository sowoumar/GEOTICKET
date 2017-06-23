package geoticket.com.geoticket;

/**
 * Created by oumar on 22/06/17.
 */

public class Ticket {
    private long id;
    private String ticket;

    private String prix;
    private String dateVente;
    
    
    
    public String getDateVente () {
        
        return dateVente;
    }
    
    public void setDateVente (String dateVente) {
        
        this.dateVente = dateVente;
    }
    
    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

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
        return ticket + " | " + prix + " | " +  dateVente;
    }
	
	
}
