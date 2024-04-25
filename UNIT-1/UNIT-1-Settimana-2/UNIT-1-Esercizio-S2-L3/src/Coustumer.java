public class Coustumer {
	private Long id;
	private String name;
	private Integer tier;


	public Coustumer(Long id1, String name1, Integer tier) {

		this.id = id1;
		this.name = name1;
		this.tier = tier;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public Integer getTier() {
		return tier;
	}
}
