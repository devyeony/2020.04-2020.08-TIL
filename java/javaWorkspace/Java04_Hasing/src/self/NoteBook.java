package self;

public class NoteBook {
	private String brandName;
	private int price;
	
	public NoteBook(String brandName, int price) {
		super();
		this.brandName = brandName;
		this.price = price;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNoteBook() {
		return "�귣�� : " + brandName + "���� : " + price;
	}
}