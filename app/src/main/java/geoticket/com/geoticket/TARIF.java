package geoticket.com.geoticket;

/**
 * Created by osow on 23/06/17.
 */

public enum TARIF {
	TARIF1("TARIF 1", "150"),
	TARIF2("TARIF 2", "15"),
	TARIF3("TARIF 3", "1554"),
	TARIF4("TARIF 4", "154"),
	TARIF5("TARIF 5", "54"),
	TARIF6("TARIF 6", "5469"),
	TARIF7("TARIF 7", "300"),
	TARIF8("TARIF 8", "200"),
	TARIF9("TARIF 9", "280"),
	TARIF10("TARIF 10", "20");
	
	private String name;
	
	private String price;
	
	public String getName () {
		
		return name;
	}
	
	public void setName (String name) {
		
		this.name = name;
	}
	
	public String getPrice () {
		
		return price;
	}
	
	public void setPrice (String price) {
		
		this.price = price;
	}
	
	TARIF (String name, String price) {
		
		this.name = name;
		this.price = price;
	}
}
