package org.mcgill.risk.spring.service;

import java.util.List;


import org.mcgill.risk.spring.model.TripDrug;

/**
 * <p>
 * Tripp Drug service interface
 * </p>
 * 
 * @author aKamami
 * @author htazouti
 * @see TripDrug
 * @since January 29, 2015
 * @version 1.0
 */
public interface TrippDrugService {

	/**
	 * Return all tripp drugs
	 */
	List<TripDrug> findAllTripDrugs();

	/**
	 * @param name
	 * @return
	 */
	List<TripDrug> findAllTripDrugsByName(String name);

	/**
	 * @param name
	 * @return list off tripp drugs
	 */
	List<TripDrug> findAllRiskTripDrugsByName(String name);

	/**
	 * @return
	 */
	List<TripDrug> findAllRiskTripDrugs();

	/**
	 * @param drug din
	 * @return
	 */
	TripDrug findByDin(String din);

	/**
	 * Verify if drug is a tripp drug or not
	 * @param drug Id
	 * @return true if tripp drug
	 */
	Boolean isTrippDrug(String drugId);

}
