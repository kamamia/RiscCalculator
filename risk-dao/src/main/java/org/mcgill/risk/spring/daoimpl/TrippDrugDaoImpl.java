package org.mcgill.risk.spring.daoimpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.mcgill.risk.spring.dao.AbstractDao;
import org.mcgill.risk.spring.dao.TrippDrugDao;
import org.mcgill.risk.spring.model.TripDrug;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * LocalizedValueTrippRisk DAO implementation class
 * </p>
 * @autho aKamami
 * //
 *
 * @see TrippDrugDao
 */
@Repository("trippdrugDao")
public class TrippDrugDaoImpl extends AbstractDao implements TrippDrugDao {

	@SuppressWarnings("unchecked")
	public List<TripDrug> findAllTripDrugs() {
		Criteria criteria = getSession().createCriteria(TripDrug.class);

		System.out.println(" findAllTripDrugs -> list size " + criteria.list().size());

		return (List<TripDrug>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripDrug> findAllTripDrugsByName(String name) {
		Criteria criteria = getSession().createCriteria(TripDrug.class, "tripdrug");
		criteria.createAlias("tripdrug.tripdrugclassno", "tripdrugclassno");
		criteria.add(Restrictions.like("tripdrugclassno.descriptionEn", name).ignoreCase());
		return (List<TripDrug>) criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripDrug> findAllRiskTripDrugsByName(String name) {

		Criteria criteria = getSession().createCriteria(TripDrug.class, "tripdrug");
		criteria.createAlias("tripdrug.tripdrugclassno", "tripdrugclassno");

		Criterion rest1 = Restrictions.like("tripdrugclassno.descriptionEn", name).ignoreCase();

		Criterion rest2 = Restrictions.in("tripdrugclassno.businessId", Arrays.asList("2", "4", "5", "7", "9", "13", "16", "17", "18"));

		criteria.add(Restrictions.and(rest1, rest2));

		return (List<TripDrug>) criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TripDrug> findAllRiskTripDrugs() {

		Criteria criteria = getSession().createCriteria(TripDrug.class, "tripdrug");

		criteria.createAlias("tripdrug.tripdrugclassno", "tripdrugclassno");

		Criterion rest = Restrictions.in("tripdrugclassno.businessId", Arrays.asList("2", "4", "5", "7", "9", "13", "16", "17", "18"));

		criteria.add(rest);

		return (List<TripDrug>) criteria.list();

	}

	@Override
	public TripDrug findByDin(String din) {

		Criteria criteria = getSession().createCriteria(TripDrug.class, "tripdrug");

		criteria.createAlias("tripdrug.drug", "tripdrugdrug");

		Criterion rest = Restrictions.eq("tripdrugdrug.din", din);
		criteria.add(rest);
		return (criteria.list() != null && criteria.list().size() > 0) ? (TripDrug) criteria.list().get(0) : null;
	}

	/**
	 * Check id ad drug is a part of tripps drug or not
	 */
	@Override
	public Boolean isTrippDrug(String drugId) {

		Criteria criteria = getSession().createCriteria(TripDrug.class, "tripdrug");
		Criterion rest = Restrictions.eq("tripdrug.drug.id", new Integer(drugId));
		criteria.add(rest);
		return (criteria.list() != null && criteria.list().size() > 0) ? true : false;
	}

}
