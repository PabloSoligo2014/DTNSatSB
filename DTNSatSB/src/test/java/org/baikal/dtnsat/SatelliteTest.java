package org.baikal.dtnsat;

import static org.junit.Assert.*;

import org.baikal.dtnsat.model.Orbit;
import org.baikal.dtnsat.model.Satellite;
import org.baikal.dtnsat.repository.SatelliteRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes=DtnSatSbApplication.class) 
public class SatelliteTest {

	@Autowired
	private SatelliteRepository repo;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void CreateSearchAndDeleteSatellite() {
		
		
		
		Satellite sat = new Satellite("MiSat");
		sat.setOrbit(new Orbit(0.01, 10000.0, 0.0, 0.0, 0.0, 	0.0));
		
		
		
		repo.save(sat);
		
		
		//System.out.println("Cantidad de satelites: "+repo.count());
		assertEquals("Error en la cantidad de satelites", 1, repo.count());
		
		repo.delete(sat);
		
		assertEquals("Error en la cantidad de satelites", 0, repo.count());
		
		
		//fail("Not yet implemented");
		
	}

}
