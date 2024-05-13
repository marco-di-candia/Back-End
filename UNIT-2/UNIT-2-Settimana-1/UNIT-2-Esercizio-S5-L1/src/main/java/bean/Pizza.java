package bean;

import lombok.Data;

import java.util.List;

@Data
public class Pizza extends PrezzoPerCalorie {
	private String nome;
	private List<Incredienti> incredienti;

}
