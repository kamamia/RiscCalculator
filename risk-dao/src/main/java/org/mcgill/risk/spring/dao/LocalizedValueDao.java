package org.mcgill.risk.spring.dao;

import java.util.List;
import org.mcgill.risk.spring.model.LocalizedValue;

/**
 * <p>
 * Localized Value interface
 * </p>
 * 
 * @author htazouti
 * @author akamami
 * @see LocalizedValue
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface LocalizedValueDao {

	/**
	 * Return all localized value
	 */
	List<LocalizedValue> findAllLocalizedValue();

}
