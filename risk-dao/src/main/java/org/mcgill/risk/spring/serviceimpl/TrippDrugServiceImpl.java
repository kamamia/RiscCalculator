package org.mcgill.risk.spring.serviceimpl;

import java.util.List;

import org.mcgill.risk.spring.dao.LocalizedValueTrippRiskDao;
import org.mcgill.risk.spring.dao.TrippDrugDao;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;
import org.mcgill.risk.spring.model.TripDrug;
import org.mcgill.risk.spring.service.LocalizedValueTrippRiskService;
import org.mcgill.risk.spring.service.TrippDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * Tripp drug  service implementation
 * </p>
 * 
 * @author akamami
 * //
 * @see TrippDrugService
 * @see TrippDrugDao
 * @see TripDrug
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Service("trippdrugService")
@Transactional
public class TrippDrugServiceImpl implements TrippDrugService {

	@Autowired
	private TrippDrugDao dao;

	public List<TripDrug> findAllTripDrugs() {

		return dao.findAllTripDrugs();
	}

	@Override
	public List<TripDrug> findAllTripDrugsByName(String name) {

		return dao.findAllTripDrugsByName(name);

	}

	@Override
	public List<TripDrug> findAllRiskTripDrugsByName(String name) {
		return dao.findAllRiskTripDrugsByName(name);

	}

	@Override
	public List<TripDrug> findAllRiskTripDrugs() {

		return dao.findAllRiskTripDrugs();
	}

	@Override
	public TripDrug findByDin(String din) {

		return dao.findByDin(din);
	}

	@Override
	public Boolean isTrippDrug(String drugId) {
		return dao.isTrippDrug(drugId);
	}

}
