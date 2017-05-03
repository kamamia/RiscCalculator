package org.mcgill.risk.spring.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.mcgill.risk.spring.dao.AbstractDao;
import org.mcgill.risk.spring.dao.DrugDao;
import org.mcgill.risk.spring.dao.LocalizedValueDao;
import org.mcgill.risk.spring.model.LocalizedValue;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Localized Value DAO implementation class
 * </p>
 * 
 * //
 * @author akamami
 * @see AbstractDao
 * @see LocalizedValueDao
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Repository("localizedValueDao")
public class LocalizedValueDoaImpl extends AbstractDao implements LocalizedValueDao {

	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.dao.LocalizedValueDao#findAllLocalizedValue()
	 */
	@SuppressWarnings("unchecked")
	public List<LocalizedValue> findAllLocalizedValue() {
		Criteria criteria = getSession().createCriteria(LocalizedValue.class);

		System.out.println(" findAllLocalizedValue -> list size " + criteria.list().size());

		return (List<LocalizedValue>) criteria.list();
	}

}
