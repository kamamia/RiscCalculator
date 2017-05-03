package org.mcgill.risk.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRIPP_DRUG")
public class TripDrug {

	@Id
	@Column(name = "ID", nullable = false)
	private Integer id;

	@JoinColumn(name = "DRUG_ID", unique = true)
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private Drug drug;

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
	private LocalizedValue tripdrugclassno;

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
		if (!(obj instanceof TripDrug))
			return false;
		TripDrug other = (TripDrug) obj;
		if (id != other.id && this.drug.getDin() != other.drug.getDin())
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "TripDrug [id=" + id + ", tripDrugClass.getDescriptionEn()="
				+ tripdrugclassno.getDescriptionEn() + ", altdose="
				+ this.altdose + ", altduration=" + this.altduration
				+ ", drugid=" + this.drug.getDin() + ", strength="
				+ this.strength + ", whodose=" + this.whodose + "]";
	}

	public Integer getWhodose() {
		return whodose;
	}

	public void setWhodose(int whodose) {
		this.whodose = whodose;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
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

	public LocalizedValue getTripdrugclassno() {
		return tripdrugclassno;
	}

	public void setTripdrugclassno(LocalizedValue tripdrugclassno) {
		this.tripdrugclassno = tripdrugclassno;
	}

}
