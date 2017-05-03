package org.mcgill.risk.spring.dao;

import java.util.List;

import org.mcgill.risk.spring.model.Drug;

/**
 * <p>
 * Drug Dao class
 * </p>
 * 
 * //
 * @author akamami
 * @see Drug
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface DrugDao {

	/**
	 * Find all drugs
	 * 
	 * @return List of Drugs
	 */
	List<Drug> findAllDrugs();

	/**
	 * Find all drugs by name
	 * 
	 * @param name
	 * @return
	 */
	List<Drug> findAllTradeDrugsByName(String name);

	/**
	 * @param din
	 * @return List of Drugs
	 */
	Drug findByDin(String din);

	/**
	 * Find all drugs by generic name
	 * 
	 * @param name
	 * @return List of Drugs
	 */
	List<Drug> findAllCodegenDrugsByName(String name);

}
