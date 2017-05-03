package org.risk.model;

import java.math.BigDecimal;

/**
 * <p>
 * TrippProfileRisk POJO
 * </p>
 * 
 * @author akamami
 * //
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class TrippProfileRisk {

	private BigDecimal trippid;

	private BigDecimal RiskTotal;

	private BigDecimal hazardMod;

	private BigDecimal hazardTotal;

	private BigDecimal hazard_nm;

	private BigDecimal Risk_Nm;

	private String message;

	/**
	 * First constructor
	 * 
	 * @param RiskTotal
	 * @param hazardMod
	 * @param hazardTotal
	 * @param hazard_nm
	 * @param Risk_Nm
	 */
	public TrippProfileRisk(BigDecimal RiskTotal, BigDecimal hazardMod, BigDecimal hazardTotal, BigDecimal hazard_nm, BigDecimal Risk_Nm) {

		this.RiskTotal = RiskTotal;
		this.hazardMod = hazardMod;
		this.hazardTotal = hazardTotal;
		this.hazard_nm = hazard_nm;

		this.Risk_Nm = Risk_Nm;

	}

	/**
	 * Second Constructor
	 * 
	 * @param trippid
	 * @param RiskTotal
	 * @param hazardMod
	 * @param hazardTotal
	 * @param hazard_nm
	 * @param Risk_Nm
	 */
	public TrippProfileRisk(BigDecimal trippid, BigDecimal RiskTotal, BigDecimal hazardMod, BigDecimal hazardTotal, BigDecimal hazard_nm, BigDecimal Risk_Nm) {
		this.trippid = trippid;
		this.RiskTotal = RiskTotal;
		this.hazardMod = hazardMod;
		this.hazardTotal = hazardTotal;
		this.hazard_nm = hazard_nm;

		this.Risk_Nm = Risk_Nm;

	}

	/** Getters and setters **/

	public BigDecimal getHazard_nm() {
		return hazard_nm;
	}

	public void setHazard_nm(BigDecimal hazard_nm) {
		this.hazard_nm = hazard_nm;
	}

	public BigDecimal getRisk_Nm() {
		return Risk_Nm;
	}

	public void setRisk_Nm(BigDecimal risk_Nm) {
		Risk_Nm = risk_Nm;
	}

	public TrippProfileRisk() {
	}

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

	@Override
	public String toString() {

		return "TrippProfileRisk=: [ trippid=" + this.trippid + " RiskTotal=" + RiskTotal + " hazardMod=" + hazardMod + " hazardTotal=" + hazardTotal + "]";

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
