import java.time.LocalDate;
import java.util.List;

public class Order{
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryData;

	private List<Product> Product;
	private Coustumer Coustumer;

	public Order(long id,String status,LocalDate orderDate,  LocalDate deliveryData, List<Product> Product, Coustumer Coustumer ) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryData = deliveryData;
		this.Product = Product;
		this.Coustumer = Coustumer;
	}



	public String getStatus() {
		return status;
	}


	public LocalDate getDeliveryData() {
		return deliveryData;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}

	public Coustumer getCoustumer() {
		return Coustumer;
	}

	public List<Product> getProduct() {
		return Product;
	}

	public long getId() {
		return id;
	}
}
