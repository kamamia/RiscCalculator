package org.mcgill.risk.spring.service;

import java.util.List;

import org.mcgill.risk.spring.model.Drug;

/**
 * <p>
 * Drug service interface
 * </p>
 * 
 * @author aKamami
 * @author htazouti
 * @see Drug
 * @since January 29, 2015
 * @version 1.0
 */
public interface DrugService {

	/**
	 * @return
	 */
	List<Drug> findAllDrugs();

	/**
	 * Return a list of drugs
	 * 
	 * @param drug name
	 * 
	 */
	List<Drug> findAllTradeDrugsByName(String name);

	/**
	 * Return a list of drugs
	 * @param name
	 */
	List<Drug> findAllCodegenDrugsByName(String name);

	/**
	 * Return a drug
	 * @param  drug din
	 * @return
	 */
	Drug findByDin(String din);

}
