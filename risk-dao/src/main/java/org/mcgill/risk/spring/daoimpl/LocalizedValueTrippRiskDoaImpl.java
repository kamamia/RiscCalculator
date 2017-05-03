package org.mcgill.risk.spring.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.mcgill.risk.spring.dao.AbstractDao;
import org.mcgill.risk.spring.dao.LocalizedValueDao;
import org.mcgill.risk.spring.dao.LocalizedValueTrippRiskDao;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * LocalizedValueTrippRisk DAO implementation class
 * </p>
 * 
 * //
 * @author akamami
 * @see AbstractDao
 * @see LocalizedValueTrippRiskDao
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Repository("localizedValueTrippRiskDao")
public class LocalizedValueTrippRiskDoaImpl extends AbstractDao implements LocalizedValueTrippRiskDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<LocalizedValueTrippRisk> findAllLocalizedTrippRiskValue() {
		Criteria criteria = getSession().createCriteria(LocalizedValueTrippRisk.class);
		System.out.println(" findAllLocalizedTrippRiskValue -> list size " + criteria.list().size());
		return (List<LocalizedValueTrippRisk>) criteria.list();
	}

}
