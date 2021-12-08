package com.qa.test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.main.function.KecepatanFunction;

public class TestFunctionKecepatan {
	
	KecepatanFunction function;

	@Before
	public void setUp() throws Exception {
		
		function = new KecepatanFunction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHitungKecepatan() {
		for (String isi : readfile("skenario_kecepatan.csv")) {
			
			String [] data = isi.split(",");
			
			String jarak = data[0];
			String waktu = data[1];
			String jawab = data[2];
			System.out.println(jarak + waktu + jawab);
			assertEquals(Double.parseDouble(jawab), function.hitungKecepatan(jarak, waktu),0.9);
		}
		
		
	}
	
	
	public List<String> readfile(String namefile){
		List<String> penampung = new ArrayList<String>();
	
		try {
			
			InputStream myFile = getClass().getClassLoader().getSystemResourceAsStream(namefile);
			Scanner reader = new Scanner(myFile);
			while(reader.hasNextLine()) {
				penampung.add(reader.nextLine());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return penampung;
	}

}
