package org.mcgill.risk.spring.serviceimpl;

import java.util.List;

import org.mcgill.risk.spring.dao.LocalizedValueTrippRiskDao;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;
import org.mcgill.risk.spring.service.LocalizedValueTrippRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Localized Value Tripp Risk service implementation
 * </p>
 * 
 * @author akamami
 * //
 * @see LocalizedValueTrippRiskService
 * @see LocalizedValueTrippRiskDao
 * @see LocalizedValueTrippRisk
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Service("localizedValueTrippRiskService")
@Transactional
public class LocalizedValueTrippRiskServiceImpl implements LocalizedValueTrippRiskService {

	@Autowired
	private LocalizedValueTrippRiskDao dao;

	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.service.LocalizedValueTrippRiskService#findAllLocalizedTrippRiskValue()
	 */
	@Override
	public List<LocalizedValueTrippRisk> findAllLocalizedTrippRiskValue() {
		return dao.findAllLocalizedTrippRiskValue();
	}

}
