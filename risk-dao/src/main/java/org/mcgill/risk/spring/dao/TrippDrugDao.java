package org.mcgill.risk.spring.dao;

import java.util.List;

import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.model.TripDrug;

/**
 * <p>
 * Tripp drug DAO interface
 * </p>
 * 
 * @author htazouti
 * @author akamami
 * @see TripDrug
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface TrippDrugDao {

	/**
	 * Return all tripp drugs
	 */
	List<TripDrug> findAllTripDrugs();

	/**
	 * @param darug
	 *            name Return all tripp drug for the specific name
	 */
	List<TripDrug> findAllTripDrugsByName(String name);

	/**
	 * @param name
	 * @return
	 */
	List<TripDrug> findAllRiskTripDrugsByName(String name);

	/**
	 * Return all tripp drug
	 */
	List<TripDrug> findAllRiskTripDrugs();

	/**
	 * @param drug
	 *            din Return a tripp drug
	 */
	TripDrug findByDin(String din);

	/**
	 * Verifi if drug is tripp
	 * 
	 * @param drugId
	 * @return true if tripp drug 
	 */
	Boolean isTrippDrug(String drugId);

}
