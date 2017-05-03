package org.mcgill.risk.spring.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <p>
 * This is the entity t for the tripp profile
 * <p>
 * 
 * @author htazouti
 *
 */
@Entity
@Table(name = "TRIPP_PROFILE")
public class TrippProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRIPP_PROFILE_SEQ")
	@SequenceGenerator(name = "TRIPP_PROFILE_SEQ", sequenceName = "TRIPP_PROFILE_SEQ", allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "PATIENT_ID", nullable = false)
	private BigDecimal patientId;

	@Column(name = "AGE", nullable = false)
	private BigDecimal age;

	@Column(name = "FEMALE", nullable = false)
	private Boolean female;

	@Column(name = "CONDITION_GB", nullable = false)
	private Boolean conditionGB;

	@Column(name = "CONDITION_CI", nullable = false)
	private Boolean conditionCI;

	@Column(name = "FALL_COUNT", nullable = false)
	private Integer fallCount;

	@Column(name = "RISK_NON_MOD", nullable = false)
	private BigDecimal riskNonMod;

	@Column(name = "HAZARD_NON_MOD", nullable = false)
	private BigDecimal hazardNonMod;

	@Column(name = "SESSION_ID")
	private String sessionID;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPatientId() {
		return patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public Boolean getFemale() {
		return female;
	}

	public void setFemale(Boolean female) {
		this.female = female;
	}

	public Boolean getConditionGB() {
		return conditionGB;
	}

	public void setConditionGB(Boolean conditionGB) {
		this.conditionGB = conditionGB;
	}

	public Boolean getConditionCI() {
		return conditionCI;
	}

	public void setConditionCI(Boolean conditionCI) {
		this.conditionCI = conditionCI;
	}

	public Integer getFallCount() {
		return fallCount;
	}

	public void setFallCount(Integer fallCount) {
		this.fallCount = fallCount;
	}

	public BigDecimal getRiskNonMod() {
		return riskNonMod;
	}

	public void setRiskNonMod(BigDecimal riskNonMod) {
		this.riskNonMod = riskNonMod;
	}

	public BigDecimal getHazardNonMod() {
		return hazardNonMod;
	}

	public void setHazardNonMod(BigDecimal hazardNonMod) {
		this.hazardNonMod = hazardNonMod;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
