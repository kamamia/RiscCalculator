package org.mcgill.risk.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * This is the entity t for the tripp profile
 * <p>
 * It store all client tripp profile.
 * 
 * //
 *
 */

@Entity
@Table(name = "TRIPP_PROFILE_RISK")
public class TrippProfileRisk {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRIPP_PROFILE_RISK_SEQ")
	@SequenceGenerator(name = "TRIPP_PROFILE_RISK_SEQ", sequenceName = "TRIPP_PROFILE_RISK_SEQ", allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@JoinColumn(name = "TRIPP_PROFILE_ID")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private TrippProfile trippProfile;

	@Column(name = "RISK_TOTAL", nullable = false)
	private BigDecimal riskTotal;

	@Column(name = "HAZARD_TOTAL", nullable = false)
	private BigDecimal hazardTotal;

	@Column(name = "HAZARD_MOD", nullable = false)
	private BigDecimal hazardMod;

	@Column(name = "CLASS_2", nullable = false)
	private BigDecimal class_2;

	@Column(name = "CLASS_4", nullable = false)
	private BigDecimal class_4;

	@Column(name = "CLASS_5", nullable = false)
	private BigDecimal class_5;

	@Column(name = "CLASS_7", nullable = false)
	private BigDecimal class_7;

	@Column(name = "CLASS_9", nullable = false)
	private BigDecimal class_9;

	@Column(name = "CLASS_13", nullable = false)
	private BigDecimal class_13;

	@Column(name = "CLASS_16", nullable = false)
	private BigDecimal class_16;

	@Column(name = "CLASS_17", nullable = false)
	private BigDecimal class_17;

	@Column(name = "CLASS_18", nullable = false)
	private BigDecimal class_18;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrippProfile getTrippProfile() {
		return trippProfile;
	}

	public void setTrippProfile(TrippProfile trippProfile) {
		this.trippProfile = trippProfile;
	}

	public BigDecimal getRiskTotal() {
		return riskTotal;
	}

	public void setRiskTotal(BigDecimal riskTotal) {
		this.riskTotal = riskTotal;
	}

	public BigDecimal getHazardTotal() {
		return hazardTotal;
	}

	public void setHazardTotal(BigDecimal hazardTotal) {
		this.hazardTotal = hazardTotal;
	}

	public BigDecimal getHazardMod() {
		return hazardMod;
	}

	public void setHazardMod(BigDecimal hazardMod) {
		this.hazardMod = hazardMod;
	}

	public BigDecimal getClass_2() {
		return class_2;
	}

	public void setClass_2(BigDecimal class_2) {
		this.class_2 = class_2;
	}

	public BigDecimal getClass_4() {
		return class_4;
	}

	public void setClass_4(BigDecimal class_4) {
		this.class_4 = class_4;
	}

	public BigDecimal getClass_5() {
		return class_5;
	}

	public void setClass_5(BigDecimal class_5) {
		this.class_5 = class_5;
	}

	public BigDecimal getClass_7() {
		return class_7;
	}

	public void setClass_7(BigDecimal class_7) {
		this.class_7 = class_7;
	}

	public BigDecimal getClass_9() {
		return class_9;
	}

	public void setClass_9(BigDecimal class_9) {
		this.class_9 = class_9;
	}

	public BigDecimal getClass_13() {
		return class_13;
	}

	public void setClass_13(BigDecimal class_13) {
		this.class_13 = class_13;
	}

	public BigDecimal getClass_16() {
		return class_16;
	}

	public void setClass_16(BigDecimal class_16) {
		this.class_16 = class_16;
	}

	public BigDecimal getClass_17() {
		return class_17;
	}

	public void setClass_17(BigDecimal class_17) {
		this.class_17 = class_17;
	}

	public BigDecimal getClass_18() {
		return class_18;
	}

	public void setClass_18(BigDecimal class_18) {
		this.class_18 = class_18;
	}

}
