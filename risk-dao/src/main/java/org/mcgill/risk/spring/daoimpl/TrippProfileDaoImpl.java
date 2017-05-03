package org.mcgill.risk.spring.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.mcgill.risk.spring.dao.AbstractDao;
import org.mcgill.risk.spring.dao.TrippProfileDao;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.springframework.stereotype.Repository;

@Repository("trippprofiledao")
public class TrippProfileDaoImpl extends AbstractDao implements TrippProfileDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrippProfile> getAllTrippProfiles() {

		Criteria criteria = getSession().createCriteria(TrippProfile.class);

		return (List<TrippProfile>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrippProfileRisk> getAllTrippRiskProfiles() {
		Criteria criteria = getSession().createCriteria(TrippProfileRisk.class);

		return (List<TrippProfileRisk>) criteria.list();
	}

	@Override
	public void addTrippProfile(TrippProfile trippProfile) {
		persist(trippProfile);
	}

	public TrippProfile getTrippProfileById(Long id) {
		Criteria criteria = getSession().createCriteria(TrippProfile.class)
				.add(Restrictions.idEq(id));
		return (TrippProfile) criteria.uniqueResult();

	}

	@Override
	public TrippProfile mergeTrippProfile(TrippProfile trippProfile) {

		return (TrippProfile) merge(trippProfile);
	}

	@Override
	public TrippProfileRisk addTrippProfileRisk(
			TrippProfileRisk trippProfileRisk) {
		return (TrippProfileRisk) merge(trippProfileRisk);
	}

	@Override
	public TrippProfileRiskDrug addTrippProfileRiskDrug(
			TrippProfileRiskDrug trippProfileRiskDrug) {
		return (TrippProfileRiskDrug) merge(trippProfileRiskDrug);
	}

}
