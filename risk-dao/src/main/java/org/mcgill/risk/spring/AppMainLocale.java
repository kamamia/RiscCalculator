package org.mcgill.risk.spring;

import java.util.List;

import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.service.LocalizedValueService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/*created to test 
 to check with Hicham
 */

public class AppMainLocale {

	public void showAll() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		LocalizedValueService service = (LocalizedValueService) context
				.getBean("localizedValueService");

		List<LocalizedValue> locs = service.findAllLocalizedValue();
		for (LocalizedValue loc : locs) {
			System.out.println(loc);
		}

		context.close();
	}

	public static void main(String args[]) {
		AppMainLocale aPP = new AppMainLocale();
		aPP.showAll();

	}
}
