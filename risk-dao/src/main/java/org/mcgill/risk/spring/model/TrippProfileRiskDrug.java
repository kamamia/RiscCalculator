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
 * This is the entity for the tripp profile drug
 * <p>
 * It store all tripp drugs.
 * 
 * @author htazouti
 *
 */
@Entity
@Table(name = "TRIPP_PROFILE_RISK_DRUG")
public class TrippProfileRiskDrug {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRIPP_PROFILE_RISK_DRUG_SEQ")
	@SequenceGenerator(name = "TRIPP_PROFILE_RISK_DRUG_SEQ", sequenceName = "TRIPP_PROFILE_RISK_DRUG_SEQ", allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "DRUG_ID")
	private Long drugId;

	@JoinColumn(name = "TRIPP_PROFILE_RISK_ID")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private TrippProfileRisk trippProfileRisk;

	@Column(name = "DURATION_DAYS", nullable = false)
	private Integer durationDays;

	@Column(name = "QUANTITY", nullable = false)
	private BigDecimal quantity;

	@Column(name = "DRUG_TYPE", nullable = false)
	private String drugType;

	@Column(name = "STATUS", nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDrugId() {
		return drugId;
	}

	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}

	public TrippProfileRisk getTrippProfileRisk() {
		return trippProfileRisk;
	}

	public void setTrippProfileRisk(TrippProfileRisk trippProfileRisk) {
		this.trippProfileRisk = trippProfileRisk;
	}

	public Integer getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(Integer durationDays) {
		this.durationDays = durationDays;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
