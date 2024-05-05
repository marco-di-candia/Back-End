package org.example;




import org.example.dao.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {

		List<Libreria> librerias = new ArrayList<>();


		librerias.add(new Libri(2000, 121214, 100, "Harrt Potter", "J. K. Rowling", "Aventura"));
		librerias.add(new Riviste(2023, 214251, 100, "forbes", Periodicita.SETTIMANALE));
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

		//---------------------------------------------------------------

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3-L5");
		EntityManager em = emf.createEntityManager();

		//---------------------------------------------------------------

		UtenteDao utenteDao = new UtenteDao(em);
		PrestitoDao prestitoDao = new PrestitoDao(em);
		LibriDao libriDao = new LibriDao(em);
		RivisteDao rivisteDao = new RivisteDao(em);

		//---------------------------------------------------------------

		Utente u1 = new Utente();
		u1.setNome("Mario");
		u1.setCognome("Rossi");
		u1.setData_nascita(LocalDate.of(1990, 5, 15));

		utenteDao.save(u1);

//		//---------------------------------------------------------------
//
//		Prestito p1 = new Prestito();
//		p1.setUtente(u1);
//		p1.setData_inizio_prestito(LocalDate.now());
//		LocalDate dataRestituzionePrevista = LocalDate.now().plusDays(30);
//		p1.setData_restituzione_prestita(dataRestituzionePrevista);
//		p1.setData_restituzione_effetiva(dataRestituzionePrevista);
//
//		prestitoDao.save(p1);
//
//		//---------------------------------------------------------------
//
//		Libri libri = new Libri();
//		libri.setAnno(2000);
//		libri.setTitolo("Game Of Thrones");
//		libri.setNumeroPagine(50000);
//		libri.setAutore("George R. R. Martin");
//		libri.setGenere("Serie TV");
//
//		libriDao.save(libri);
//
//		Libri libri1 = new Libri();
//		libri1.setAnno(2002);
//		libri1.setTitolo("Harry Potter");
//		libri1.setNumeroPagine(50000);
//		libri1.setAutore("J. K. Rowling");
//		libri1.setGenere("Film");
//
//		libriDao.save(libri1);
//
//		//---------------------------------------------------------------
//
//		Riviste riviste = new Riviste();
//		riviste.setAnno(2023);
//		riviste.setTitolo("Forbes");
//		riviste.setNumeroPagine(50);
//		riviste.setPeriodicita(Periodicita.MENSILE);
//
//		rivisteDao.save(riviste);
//
//		//---------------------------------------------------------------
//
//
//
//		System.out.println("-------------------------------------------------");
//
//		List<Libri> n1 =  libriDao.searchByIsbn(38);
//
//		n1.forEach(System.out::println);
//
//		System.out.println("-------------------------------------------------");
//
//		libriDao.delete(34);
//
//		System.out.println("-------------------------------------------------");
//
//		List<Libri> n2 = libriDao.searchByAnno(2000);
//
//		n2.forEach(System.out::println);
//
//		System.out.println("-------------------------------------------------");
//
//		List<Libri> n3 = libriDao.searchByAutore("J. K. Rowling");
//
//		n3.forEach(System.out::println);

//		System.out.println("-------------------------------------------------");
//
//		List<Libri> n4 = libriDao.searchByTitolo("H");
//
//		n4.forEach(System.out::println);

//		System.out.println("-------------------------------------------------");
//
//		List<Prestito> n5 = prestitoDao.getPrestitiAttiviPerUtente(24);
//
//		n5.forEach(System.out::println);

		System.out.println("-------------------------------------------------");

		Prestito pScaduto = new Prestito();
		pScaduto.setUtente(u1);
		pScaduto.setData_inizio_prestito(LocalDate.now().minusDays(30));
		pScaduto.setData_restituzione_prestita(LocalDate.now().minusDays(5)); 
		pScaduto.setData_restituzione_effetiva(LocalDate.now().minusDays(3));

		prestitoDao.save(pScaduto);


		List<Prestito> n6 = prestitoDao.getPrestitiScadutiNonRestituiti();

		n6.forEach(System.out::println);






























	}
}