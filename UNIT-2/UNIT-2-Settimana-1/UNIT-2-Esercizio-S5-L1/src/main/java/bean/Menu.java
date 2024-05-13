package bean;

import lombok.Data;

import java.util.List;

@Data
public class Menu extends Pizza {
	private List<Pizza> pizza;
	private List<Incredienti> incredienti;
	private List<Bevande> bevante;
	private List<PrezzoPerCalorie> prezzoPerCalories;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Menu\n");
		sb.append("Pizza:\n");
		if (pizza != null) {
			for (Pizza p : pizza) {
				sb.append("- ").append(p.getNome()).append(" (Ingredienti: ");
				List<Incredienti> incredienti = p.getIncredienti();
				if (incredienti != null) {
					for (int i = 0; i < incredienti.size(); i++) {
						sb.append(incredienti.get(i).getIncredinte());
						if (i < incredienti.size() - 1) {
							sb.append(", ");
						}
					}
				}
				sb.append(") - Calorie: ").append(p.getCalorie()).append(" - Prezzo: ").append(p.getPrezzo()).append(" Euro \n");
			}
		}
		sb.append("Ingredienti:\n");
		if (incredienti != null) {
			for (Incredienti i : incredienti) {
				sb.append("- ").append(i.getIncredinte()).append(" - Calorie: ").append(i.getCalorie()).append(" - Prezzo: ").append(i.getPrezzo()).append(" Euro \n");
			}
		} else {
			sb.append("- Nessun ingrediente specificato\n");
		}
		sb.append("Bevande:\n");
		if (bevante != null) {
			for (Bevande b : bevante) {
				sb.append("- ").append(b.getBevanda()).append(" - Calorie: ").append(b.getCalorie()).append(" - Prezzo: ").append(b.getPrezzo()).append(" Euro \n");
			}
		} else {
			sb.append("- Nessuna bevanda specificata\n");
		}
		return sb.toString();
	}


}

