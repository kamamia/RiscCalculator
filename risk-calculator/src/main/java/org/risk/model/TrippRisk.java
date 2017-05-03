package org.risk.model;

import java.math.BigDecimal;

/**
 * <p>
 * TrippRisk POJO
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class TrippRisk {

	private BigDecimal trippid;

	private BigDecimal RiskTotal;

	private BigDecimal hazardMod;

	private BigDecimal hazardTotal;

	/**
	 * Constructor
	 * 
	 * @param trippid
	 * @param RiskTotal
	 * @param hazardMod
	 * @param hazardTotal
	 */
	public TrippRisk(BigDecimal trippid, BigDecimal RiskTotal, BigDecimal hazardMod, BigDecimal hazardTotal) {
		this.trippid = trippid;
		this.RiskTotal = RiskTotal;
		this.hazardMod = hazardMod;
		this.hazardTotal = hazardTotal;

	}

	/**
	 * Empty constructor
	 */
	public TrippRisk() {
	}

	/**
	 * Constructor
	 * 
	 * @param RiskTotal
	 * @param hazardMod
	 * @param hazardTotal
	 */
	public TrippRisk(BigDecimal RiskTotal, BigDecimal hazardMod, BigDecimal hazardTotal) {

		this.RiskTotal = RiskTotal;
		this.hazardMod = hazardMod;
		this.hazardTotal = hazardTotal;

	}

	/** Getters and Setters **/
	public BigDecimal getRiskTotal() {
		return RiskTotal;
	}

	public void setRiskTotal(BigDecimal riskTotal) {
		RiskTotal = riskTotal;
	}

	public BigDecimal getHazardMod() {
		return hazardMod;
	}

	public void setHazardMod(BigDecimal hazardMod) {
		this.hazardMod = hazardMod;
	}

	public BigDecimal getHazardTotal() {
		return hazardTotal;
	}

	public void setHazardTotal(BigDecimal hazardTotal) {
		this.hazardTotal = hazardTotal;
	}

	public BigDecimal getTrippid() {
		return trippid;
	}

	public void setTrippid(BigDecimal trippid) {
		this.trippid = trippid;
	}

}
