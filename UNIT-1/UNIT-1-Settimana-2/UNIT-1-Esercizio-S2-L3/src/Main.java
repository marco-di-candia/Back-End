import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
	public static void main(String[] args) {

		//Prodoti
		Product p1 = new Product("Books", 120, "Harry Potter e la pietra", 1);
		Product p2 = new Product("Tech", 2100, "PC Gaming", 4);
		Product p3 = new Product("Tech", 1000, "Notebook", 5);
		Product p4 = new Product("Books", 110, "Harry Potter e i doni della morte", 2);
		Product p5 = new Product("Books", 120, "Harry Potter e la maledizione dell'erede", 3);
		Product p6 = new Product("Baby", 160, "BabyMonitor", 6);
		Product p7 = new Product("Baby", 132, "MiniSedia", 7);
		Product p8 = new Product("Baby", 112, "BabyPC", 8);
		Product p9 = new Product("Boys", 100, "boysthing", 9);
		Product p10 = new Product("Boys", 142, "boysthing", 10);
		Product p11 = new Product("Boys", 122, "boysthing", 11);

		List<Product> prodotti = List.of(p1,p2,p3,p4,p5,p6, p7, p8,p9,p10,p11);

		//clienti
		Coustumer mario = new Coustumer(102L,"mario",2);
		Coustumer francesco = new Coustumer(104L,"francesco",2);
		Coustumer antonio = new Coustumer(103L,"antonio",2);

		List<Coustumer> clienti = List.of(mario,francesco,antonio);

		//ordini
		Order o1 = new Order(1000l,"aperto", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 3, 10),
				List.of(p1, p2, p3), mario);

		Order o2 = new Order(1001l,"chiuso", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 3, 10),
				List.of(p1, p2, p3), antonio);

		Order o3 = new Order(1002l,"chiuso", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 20),
				List.of(p1, p5, p4), francesco);



		List<Product> books = List.of(p1, p2, p3, p4, p5);

		books.stream().filter(b -> b.getCategory().equals("Books") && b.getPrice() > 100).forEach(System.out::println);



		System.out.println();
		System.out.println("baby products");


		System.out.println();
		System.out.println();

		List<Order> ordini = List.of(o1,o2,o3);

		List<Order> ord = ordini.stream().
				filter(o->o.getProduct().stream().
						anyMatch(product -> product.getCategory().equals("Baby"))).toList();

		ord.forEach(ordine -> System.out.println(ordine));


		List<Product> l3 = prodotti.stream().filter(prodotto -> prodotto.getCategory().equals("Boys")).
				peek(prodotto -> prodotto.setPrice(prodotto.getPrice()*0.9)).
				collect(Collectors.toList());

		l3.forEach(prodotto -> System.out.println(prodotto));

		//esercizio4
		List<Product> l4 = ordini.stream().filter(ordine -> ordine.getCoustumer().getTier()==2 &&
						ordine.getDeliveryData().isAfter(LocalDate.of(2021,1,31)) &&
						ordine.getOrderDate().isBefore(LocalDate.of(2021,4,2))).
				flatMap(ordine -> ordine.getProduct().stream()).collect(Collectors.toList());

		l4.forEach(prodotto -> System.out.println(prodotto));







	}
}