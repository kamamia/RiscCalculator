package org.mcgill.risk.spring.service;

import java.util.List;

import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;


/**
 * <p>
 * LocalizedValueTrippRisk service interface
 * </p>
 * 
 * @author aKamami
 * //
 * @see LocalizedValueTrippRisk
 * @since January 29, 2015
 * @version 1.0
 */
public interface LocalizedValueTrippRiskService {

	/**
	 * Return a list of LocalizedValueTrippRisk
	 */
	List<LocalizedValueTrippRisk> findAllLocalizedTrippRiskValue();

}
