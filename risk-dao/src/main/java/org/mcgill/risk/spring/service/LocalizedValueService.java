package org.mcgill.risk.spring.service;

import java.util.List;
import org.mcgill.risk.spring.model.LocalizedValue;


/**
 * <p>
 * Localized Value service interface
 * </p>
 * 
 * @author aKamami
 * @author htazouti
 * @see LocalizedValue
 * @since January 29, 2015
 * @version 1.0
 */
public interface LocalizedValueService {

	/**
	 * Return all Localized Value
	 */
	List<LocalizedValue> findAllLocalizedValue();

}
