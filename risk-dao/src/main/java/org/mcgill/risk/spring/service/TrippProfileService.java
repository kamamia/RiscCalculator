package org.mcgill.risk.spring.service;

import java.util.List;

import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;

/**
 * <P>
 * Interface for all tripp profiles services
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * @see TrippProfile
 * @see TrippProfileRisk
 * @since January 29, 2015
 * @version 1.0
 *
 */
public interface TrippProfileService {

	/**
	 * Return all tripp profile
	 */
	public List<TrippProfile> getAllTrippProfiles();

	/**
	 * Return all tripp risk profiles
	 */
	public List<TrippProfileRisk> getAllTrippRiskProfiles();

	/**
	 * @param trippProfile
	 * @return
	 */
	public TrippProfile addTrippProfile(TrippProfile trippProfile);

	/**
	 * @param profile
	 *            id
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
