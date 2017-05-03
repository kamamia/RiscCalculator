package org.mcgill.risk.spring;

import java.util.List;

import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.Drug;
import org.mcgill.risk.spring.service.DrugService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/*created to test 
 to chech with Hicham
 */

/**
 * @author akamami
 *
 */
public class AppMainDrug {

	public void showAll() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		/*
		 * Get all drugs list from database
		 */
		List<Drug> drugs = service.findAllDrugs();
		for (Drug dr : drugs) {
			System.out.println(dr);
		}

		context.close();
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		AppMainDrug app = new AppMainDrug();
		app.showAll();
	}
}
