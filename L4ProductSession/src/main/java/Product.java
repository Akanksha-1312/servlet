

public class Product {
	private int id;
	private String pname;
	private String pprice;
	private String date;

	
	
	public Product(int id, String pname, String pprice, String date) {
		super();
		this.id = id;
		this.pname = pname;
		this.pprice = pprice;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	
	@Override
	public String toString() {
		return "Product [moid=" + id + ", pname=" + pname + ", pprice=" + pprice + ", date=" + date + "]";
	}
}
