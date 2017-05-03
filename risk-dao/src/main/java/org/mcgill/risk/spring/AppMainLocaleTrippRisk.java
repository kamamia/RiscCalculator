package org.mcgill.risk.spring;

import java.util.List;

import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;
import org.mcgill.risk.spring.service.LocalizedValueTrippRiskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/*created to test 
 to check with Hicham
 */

public class AppMainLocaleTrippRisk {

	public void showAll() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		LocalizedValueTrippRiskService service = (LocalizedValueTrippRiskService) context
				.getBean("localizedValueTrippRiskService");

		List<LocalizedValueTrippRisk> locstr = service
				.findAllLocalizedTrippRiskValue();
		for (LocalizedValueTrippRisk loctr : locstr) {
			System.out.println(loctr);
		}

		context.close();
	}

	public static void main(String args[]) {
		AppMainLocaleTrippRisk aPP = new AppMainLocaleTrippRisk();
		aPP.showAll();

	}
}
