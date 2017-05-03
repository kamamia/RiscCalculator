package org.mcgill.risk.spring.serviceimpl;

import java.util.List;

import org.mcgill.risk.spring.dao.TrippProfileDao;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.mcgill.risk.spring.service.TrippProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * Implementation of tripp profile servies
 * <p>
 * 
 * //
 * @see TrippProfileService
 * @since January 29, 2015
 * @version 1.0
 */
@Service("trippProfileService")
@Transactional
public class TrippProfileServiceImpl implements TrippProfileService {

	@Autowired
	private TrippProfileDao dao;

	public List<TrippProfile> getAllTrippProfiles() {
		return dao.getAllTrippProfiles();
	}

	@Override
	public List<TrippProfileRisk> getAllTrippRiskProfiles() {
		return dao.getAllTrippRiskProfiles();
	}

	@Override
	public TrippProfile addTrippProfile(TrippProfile trippProfile) {
		return dao.mergeTrippProfile(trippProfile);

	}

	@Override
	public TrippProfile mergeTrippProfile(TrippProfile trippProfile) {
		return dao.mergeTrippProfile(trippProfile);

	}

	@Override
	public TrippProfile getTrippProfileById(Long id) {
		return dao.getTrippProfileById(id);
	}

	@Override
	public TrippProfileRisk addTrippProfileRisk(TrippProfileRisk trippProfileRisk) {
		return dao.addTrippProfileRisk(trippProfileRisk);
	}

	@Override
	public TrippProfileRiskDrug addTrippProfileRiskDrug(TrippProfileRiskDrug trippProfileRiskDrug) {
		return dao.addTrippProfileRiskDrug(trippProfileRiskDrug);
	}

}
