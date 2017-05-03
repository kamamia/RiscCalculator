package org.mcgill.risk.spring.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mcgill.risk.spring.dao.AbstractDao;
import org.mcgill.risk.spring.dao.DrugDao;
import org.mcgill.risk.spring.model.Drug;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Drug DAO implementation class
 * </p>
 * 
 * //
 * @author akamami
 * @see AbstractDao
 * @see DrugDao
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Repository("drugDao")
public class DrugDoaImpl extends AbstractDao implements DrugDao {

	
	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.dao.DrugDao#findAllDrugs()
	 */
	@SuppressWarnings("unchecked")
	public List<Drug> findAllDrugs() {
		Criteria criteria = getSession().createCriteria(Drug.class);

		System.out.println(" findAllDrugs -> list size " + criteria.list().size());

		return (List<Drug>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.dao.DrugDao#findAllTradeDrugsByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> findAllTradeDrugsByName(String name) {

		Criteria criteria = getSession().createCriteria(Drug.class, "drug");
		criteria.createAlias("drug.trademarkName", "trademarkName");
		criteria.add(Restrictions.like("trademarkName.descriptionEn", "%" + name + "%").ignoreCase());
		return (List<Drug>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.dao.DrugDao#findByDin(java.lang.String)
	 */
	@Override
	public Drug findByDin(String din) {

		Criteria criteria = getSession().createCriteria(Drug.class, "drug");

		criteria.add(Restrictions.eq("din", din));

		return criteria.list().size() > 0 ? (Drug) criteria.list().get(0) : null;
	}

	/* (non-Javadoc)
	 * @see org.mcgill.risk.spring.dao.DrugDao#findAllCodegenDrugsByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Drug> findAllCodegenDrugsByName(String name) {

		// NON to check with Hicham

		Criteria criteria = getSession().createCriteria(Drug.class, "drug");
		criteria.createAlias("drug.codegen", "codegenname");
		criteria.createAlias("codegenname.description", "descLoc");
		criteria.add(Restrictions.like("descLoc.descriptionEn", "%" + name + "%").ignoreCase());

		return (List<Drug>) criteria.list();

	}

}
