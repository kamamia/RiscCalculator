package org.mcgill.risk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRIPP_DRUG")
public class TrippDrugRisk {

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	@Column(name = "DRUG_ID", nullable = false)
	private Integer drugid;

	@Column(name = "STRENGTH", nullable = true)
	private Integer strength;

	@Column(name = "WHO_DOSE", nullable = true)
	private Integer whodose;

	@Column(name = "ALT_DURATION", nullable = true)
	private Integer altduration;

	@Column(name = "ALT_DOSE", nullable = true)
	private Integer altdose;

	@ManyToOne
	@JoinColumn(name = "TRIPP_DRUG_CLASS_LVID")
	private LocalizedValueTrippRisk tripdrugclassno;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TrippDrugRisk))
			return false;
		TrippDrugRisk other = (TrippDrugRisk) obj;
		if (id != other.id && this.drugid != other.drugid)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "TripDrug [id=" + id + ", tripDrugClass.getDescriptionEn()="
				+ tripdrugclassno.getDescriptionEn() + ", altdose="
				+ this.altdose + ", altduration=" + this.altduration
				+ ", drugid=" + this.drugid + ", strength=" + this.strength
				+ ", whodose=" + this.whodose + "]";
	}

	public Integer getWhodose() {
		return whodose;
	}

	public void setWhodose(int whodose) {
		this.whodose = whodose;
	}

	public Integer getDrugid() {
		return drugid;
	}

	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public Integer getAltduration() {
		return altduration;
	}

	public void setAltduration(int altduration) {
		this.altduration = altduration;
	}

	public Integer getAltdose() {
		return altdose;
	}

	public void setAltdose(int altdose) {
		this.altdose = altdose;
	}

	public LocalizedValueTrippRisk getTripdrugclassno() {
		return tripdrugclassno;
	}

	public void setTripdrugclassno(LocalizedValueTrippRisk tripdrugclassno) {
		this.tripdrugclassno = tripdrugclassno;
	}

}
