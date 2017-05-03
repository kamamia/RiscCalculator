package org.mcgill.risk.spring.dao;

import java.util.List;

import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;


/**
 * <p>
 * Localized Value interface for TRipp risk
 * </p>
 * 
 * @author htazouti
 * @author akamami
 * @see LocalizedValueTrippRisk
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface LocalizedValueTrippRiskDao {

	List<LocalizedValueTrippRisk> findAllLocalizedTrippRiskValue();

}
