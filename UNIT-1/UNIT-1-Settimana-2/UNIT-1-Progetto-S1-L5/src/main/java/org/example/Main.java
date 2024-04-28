package org.example;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

		List<Libreria> librerias = new ArrayList<>();


		librerias.add(new Libri(2000, 121214, 100, "Harrt Potter", "J. K. Rowling", "Aventura"));
		librerias.add(new Riviste(2023, 214251, 100, "forbes", "Settimanale"));
		librerias.add(new Libri(2020, 987654, 300, "Sapiens", "Yuval Noah Harari", "Storia"));

		System.out.println(librerias);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		List<Libreria> rRemove = librerias.stream().filter(l -> l.getCodiceIsbn() != 214251).toList();

		rRemove.forEach(System.out::println);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		List<Libreria> cercaC = librerias.stream().filter(c -> c.getCodiceIsbn() == 987654).toList();

		cercaC.forEach(System.out::println);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		List<Libreria> carcaA = librerias.stream().filter(l -> Objects.equals(l.getAutore(), "J. K. Rowling")).toList();

		carcaA.forEach(System.out::println);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		List<Libreria> carcaDate = librerias.stream().filter(d -> d.getAnno() == 2020).toList();

		carcaDate.forEach(System.out::println);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		String libreriaS = librerias.stream().map(l -> l.getTitolo() + "-" + l.getAutore() + "-" + l.getAnno() + "-" + l.getCodiceIsbn() + "-" + l.getNumeroPagine() + "-" + l.getGenere() + "-" + (l instanceof Riviste ? ((Riviste) l).getPeriodicita() : "")).collect(Collectors.joining("\n"));

		System.out.println(libreriaS);

		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		File file = new File("./../Stampa Libreria/Stampa.txt");

		try {

			FileUtils.writeStringToFile(file, libreriaS, Charset.defaultCharset());

			System.out.println("Libreria");

			String fileContents = FileUtils.readFileToString(file, Charset.defaultCharset());

			String[] arrS = fileContents.split("\n");


			Arrays.stream(arrS).forEach(System.out::println);


		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}


	}
}