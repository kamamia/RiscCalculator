package org.mcgill.risk.spring.dao;

import java.util.List;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;

/**
 * <p>
 * Tripp profile DAO interface
 * </p>
 * 
 * @author htazouti
 * @author akamami
 * @see TrippProfile
 * @see TrippProfileRisk
 * @see TrippProfileRiskDrug
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface TrippProfileDao {

	/**
	 * @return
	 */
	List<TrippProfile> getAllTrippProfiles();

	/**
	 * @return
	 */
	List<TrippProfileRisk> getAllTrippRiskProfiles();

	/**
	 * @param trippProfile
	 */
	public void addTrippProfile(TrippProfile trippProfile);

	/**
	 * @param id
	 * @return
	 */
	public TrippProfile getTrippProfileById(Long id);

	/**
	 * @param trippProfile
	 * @return
	 */
	public TrippProfile mergeTrippProfile(TrippProfile trippProfile);

	/**
	 * @param trippProfileRisk
	 * @return
	 */
	public TrippProfileRisk addTrippProfileRisk(TrippProfileRisk trippProfileRisk);

	/**
	 * @param trippProfileRiskDrug
	 * @return
	 */
	public TrippProfileRiskDrug addTrippProfileRiskDrug(TrippProfileRiskDrug trippProfileRiskDrug);

}
