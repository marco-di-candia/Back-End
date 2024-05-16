package com.epicode.U5D1;

import com.epicode.U5D1.entities.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class Esercizio30102023ApplicationTests {

	private static ApplicationContext ctx;

	@BeforeAll
	public static void accedi(){
		ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		System.out.println("acceso avunuto");
	}


	@Test
	void contextLoads() {
		Table table = ctx.getBean("table1", Table.class);
		Assertions.assertEquals(5,table.getCopertiMax());
	}


	@AfterAll
	public static void chiusura(){
		ctx = null;
		System.out.println("fine");
	}

}
