package org.mcgill.risk.spring.serviceimpl;

import java.util.List;

import org.mcgill.risk.spring.dao.LocalizedValueDao;
import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.service.LocalizedValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * Localized Value service implementation
 * </p>
 * 
 * @author akamami
 * //
 * @see LocalizedValueService
 * @see LocalizedValueDao
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Service("localizedValueService")
@Transactional
public class LocalizedValueServiceImpl implements LocalizedValueService {

	@Autowired
	private LocalizedValueDao dao;

	public List<LocalizedValue> findAllLocalizedValue() {

		return dao.findAllLocalizedValue();
	}

}
