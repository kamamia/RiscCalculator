package org.mcgill.risk.spring.serviceimpl;

import java.util.List;

import org.mcgill.risk.spring.dao.DrugDao;
import org.mcgill.risk.spring.model.Drug;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * Drug service implementation
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * @see DrugService
 * @see DrugDao
 * @see Drug
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Service("drugService")
@Transactional
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugDao dao;

	public List<Drug> findAllDrugs() {

		return dao.findAllDrugs();
	}

	@Override
	public List<Drug> findAllTradeDrugsByName(String name) {

		return dao.findAllTradeDrugsByName(name);
	}

	@Override
	public Drug findByDin(String din) {

		return dao.findByDin(din);
	}

	@Override
	public List<Drug> findAllCodegenDrugsByName(String name) {

		return dao.findAllCodegenDrugsByName(name);
	}

}
