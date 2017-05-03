package dao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.Drug;
import org.mcgill.risk.spring.model.TripDrug;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.mcgill.risk.spring.service.DrugService;
import org.mcgill.risk.spring.service.TrippDrugService;
import org.mcgill.risk.spring.service.TrippProfileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.AssertThrows;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class daoAlltest {

	@Test
	public void testDrugFindByDin() {

		System.out.println("Start testDrugFindByDin ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		String din = "00596426";
		Drug drug = service.findByDin(din);

		System.out.println("Start getRiskTrippDrug. tripdrug.id="
				+ drug.getId());

		context.close();

		assertTrue(din.equalsIgnoreCase(drug.getDin()));

	}

	@Test
	public void testAllTradeDrugsByName() {

		System.out.println("Start testAllTradeDrugsByName ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		String name = "CLOZAPINE";
		List<Drug> drugs = service.findAllTradeDrugsByName(name);

		System.out.println("Start getRiskTrippDrug. drugs.size()="
				+ drugs.size());

		Iterator it = drugs.iterator();

		while (it.hasNext()) {
			System.out.println(" " + (Drug) it.next());

		}

		context.close();

		assertTrue(drugs.size() > 0);

	}

	@Test
	public void testfindAllCodegenDrugsByName() {

		System.out.println("Start testfindAllCodegenDrugsByName ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		String name = "CLOZAPINE";
		List<Drug> drugs = service.findAllCodegenDrugsByName(name);

		System.out.println("Start getRiskTrippDrug. drugs.size()="
				+ drugs.size());

		Iterator it = drugs.iterator();

		while (it.hasNext()) {
			System.out.println(" " + (Drug) it.next());

		}

		context.close();

		assertTrue(drugs.size() > 0);

	}

}
