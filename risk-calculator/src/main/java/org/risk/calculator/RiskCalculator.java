package org.risk.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.service.TrippDrugService;
import org.risk.model.TrippProfileRisk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * <p>
 * This is the risk calculator business logic and formula
 * </p>
 * 
 * @author akamami
 * //
 * 
 * @see TrippProfileRisk
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class RiskCalculator {

	private static final Logger LOG = LoggerFactory.getLogger(RiskCalculator.class);

	private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	private static final BigDecimal BASELINE = new BigDecimal(2.06);
	private static final BigDecimal BASELINE_DIFF = BigDecimal.ONE.subtract(BASELINE.divide(ONE_HUNDRED));

	private static final BigDecimal HAZ_NM_COVARIATE_AGE = new BigDecimal(0.037);
	private static final BigDecimal HAZ_NM_COVARIATE_FEMALE = new BigDecimal(0.048);
	private static final BigDecimal HAZ_NM_COVARIATE_GB = new BigDecimal(0.124);
	private static final BigDecimal HAZ_NM_COVARIATE_CI = new BigDecimal(0.256);
	private static final BigDecimal HAZ_NM_COVARIATE_PREVIOUSFALLS = new BigDecimal(0.4552);

	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_2 = new BigDecimal(0.355);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_2_X = new BigDecimal(0.286);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_4 = new BigDecimal(0.192);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_4_X = new BigDecimal(0.182);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_5 = new BigDecimal(0.13);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_7_X = new BigDecimal(0.409);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_9 = new BigDecimal(0.225);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_13 = new BigDecimal(0.017);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_13_X = new BigDecimal(0.113);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_16 = new BigDecimal(0.092);

	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_17 = new BigDecimal(0.046);
	private static final BigDecimal HAZ_TOT_COVARIATE_CLASS_18 = new BigDecimal(0.305);

	/*
	 * to be considered To check with Hicham
	 */
	private static final BigDecimal MIN_AGE = new BigDecimal(65.25);
	private static final BigDecimal MAX_VALUE_HAZARD = new BigDecimal("99999999999999999999.999999"); // Sync
	// TripPatientRisk.HAZARD_PRECISION
	// and TripPatientRisk.HAZARD_SCALE

	private BigDecimal class_2, class_4, class_5, class_7, class_9, class_13, class_16, class_17, class_18;

	/**
	 * Constructor
	 */
	public RiskCalculator() {

		reSetDrugClassValues();

	}

	/**
	 * Constrcuctor
	 * 
	 * @param class_2
	 * @param class_4
	 * @param class_5
	 * @param class_7
	 * @param class_9
	 * @param class_13
	 * @param class_16
	 * @param class_17
	 * @param class_18
	 */
	public RiskCalculator(BigDecimal class_2, BigDecimal class_4, BigDecimal class_5, BigDecimal class_7, BigDecimal class_9, BigDecimal class_13, BigDecimal class_16,
		BigDecimal class_17, BigDecimal class_18) {

		this.class_2 = class_2;
		this.class_4 = class_4;
		this.class_5 = class_5;
		this.class_7 = class_7;
		this.class_9 = class_9;
		this.class_13 = class_13;
		this.class_16 = class_16;
		this.class_17 = class_17;
		this.class_18 = class_18;

	}

	/**
	 * Initialize / reset the class values
	 */
	private void reSetDrugClassValues() {
		this.class_2 = BigDecimal.ZERO;
		this.class_4 = BigDecimal.ZERO;
		this.class_5 = BigDecimal.ZERO;
		this.class_7 = BigDecimal.ZERO;
		this.class_9 = BigDecimal.ZERO;
		this.class_13 = BigDecimal.ZERO;
		this.class_16 = BigDecimal.ZERO;
		this.class_17 = BigDecimal.ZERO;
		this.class_18 = BigDecimal.ZERO;
	}

	private BigDecimal booleanToBigDecimal(boolean value) {

		if (value) {
			return BigDecimal.ONE;
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal formatAge_65(BigDecimal age) {
		return this.round(age.subtract(new BigDecimal(65)), 2);
	}

	private BigDecimal round(BigDecimal d, int decimalPlace) {
		d = d.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return d;
	}

	private BigDecimal computeX(BigDecimal class16, BigDecimal class17, BigDecimal class18) {
		BigDecimal maxVal = class16.max(class17).max(class18); // max returns:
		// the
		// BigDecimal
		// whose value
		// is the
		// greater or
		// either if
		// equal
		if (maxVal.compareTo(BigDecimal.ZERO) == 1) {
			return BigDecimal.ONE;
		}

		return BigDecimal.ZERO;
	}

	/**
	 * Calculate the risk without medication
	 * 
	 * @param age65in
	 *            patient age
	 * @param genderin
	 *            patient age
	 * @param gbin
	 *            Profile has experienced gait and balance disorder in last 2
	 *            years: 1=Yes; 0=No
	 * @param ciin
	 *            PROFILE has experienced cognitive impairment in last 2 years:
	 *            1=Yes; 0=No
	 * @param fallsin
	 *            number of fails
	 * @return TrippProfileRisk
	 */
	public TrippProfileRisk doRiskCalculation(BigDecimal age65in, int genderin, int gbin, int ciin, int fallsin) {

		// reset the class values
		reSetDrugClassValues();
		// calculat the hazard mod
		BigDecimal hazardMod = this.calculateHazardMod();
		// calculate the hazard non mod
		BigDecimal hazard_nm = calculateHazardNM(age65in, genderin, gbin, ciin, fallsin);
		// calculate
		BigDecimal Risk_Nm = calculateRiskNm(hazard_nm);
		// Calculate the total hazard
		BigDecimal hazardTotal = this.calculateHazardTotal(calculateHazardNM(age65in, genderin, gbin, ciin, fallsin), hazardMod);

		hazardTotal = (MAX_VALUE_HAZARD.min(hazardTotal));
		// calculate the total risk
		BigDecimal RiskTotal = this.calculateRiskTotal(hazardTotal);

		return new TrippProfileRisk( RiskTotal, hazardMod, hazardTotal, hazard_nm, Risk_Nm);

	}

	/**
	 * Calculate the risk with medication
	 * 
	 * @param age65in
	 *            patient age
	 * @param genderin
	 *            patient age
	 * @param gbin
	 *            Profile has experienced gait and balance disorder in last 2
	 *            years: 1=Yes; 0=No
	 * @param ciin
	 *            PROFILE has experienced cognitive impairment in last 2 years:
	 *            1=Yes; 0=No
	 * @param fallsin
	 *            number of fails
	 * @param trippDrugsList
	 *            a list of risk drugs
	 * @return TrippProfileRisk
	 */
	public TrippProfileRisk doRiskCalculation(BigDecimal age65in, int genderin, int gbin, int ciin, int fallsin, List<org.risk.model.TrippDrug> trippDrugsList) {

		doCombinedStandardizedDosCalculation(trippDrugsList);
		// calculat the hazard mod
		BigDecimal hazardMod = this.calculateHazardMod();
		// calculate the hazard non mod
		BigDecimal hazard_nm = calculateHazardNM(age65in, genderin, gbin, ciin, fallsin);
		// calculate
		BigDecimal Risk_Nm = calculateRiskNm(hazard_nm);
		// Calculate the total hazard
		BigDecimal hazardTotal = this.calculateHazardTotal(calculateHazardNM(age65in, genderin, gbin, ciin, fallsin), hazardMod);

		hazardTotal = (MAX_VALUE_HAZARD.min(hazardTotal));

		BigDecimal RiskTotal = this.calculateRiskTotal(hazardTotal);

		return new TrippProfileRisk(RiskTotal, hazardMod, hazardTotal, hazard_nm, Risk_Nm);

	}


	/**
	 * 
	 * @param activeDispensedTrippDrugs
	 */
	private void doCombinedStandardizedDosCalculation(List<org.risk.model.TrippDrug> activeDispensedTrippDrugs) {
		this.reSetDrugClassValues();

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		TrippDrugService trippservice = (TrippDrugService) context.getBean("trippdrugService");

		if (activeDispensedTrippDrugs != null) {

			for (org.risk.model.TrippDrug dd : activeDispensedTrippDrugs) {
				BigDecimal standardizedDosage = BigDecimal.ZERO;
				org.mcgill.risk.spring.model.TripDrug td = trippservice.findByDin(dd.getDin());
		if(dd.getTdd()!=null)
		{//if if(dd.getTdd()==null)
			
				standardizedDosage = dd.getTdd();
				
			}
		else{
				
				// If an alternative dosage was specified on the TrippDrug,
				// don't even bother with the formula
				if (td.getAltdose() != null)
				{// if
					standardizedDosage = new BigDecimal(td.getAltdose());
				} else {

					// Use the alternative duration of the TrippDrug if one was
					// specified, otherwise use the
					// dispensed drug duration if one was specified.

					BigDecimal duration = BigDecimal.ZERO;
					if (td.getAltduration() != null) {
						duration = new BigDecimal(td.getAltduration());
					} else if (dd.getDuration() != null) {
						duration = new BigDecimal(dd.getDuration());
					}

					// Use the quantity of the dispensed drug if one was
					// specified.

					BigDecimal quantity = dd.getQuantity();
					if (quantity == null) {
						quantity = BigDecimal.ZERO;
					}

					// Only proceed with standardized dosage calculation both
					// the quantity and duration are different than 0.
					// This could happen if we have incomplete data about a
					// dispensed drug, i.e. one of quantity of duration
					// was not provided or is equal to 0.
					if (BigDecimal.ZERO.compareTo(duration) != 0 && BigDecimal.ZERO.compareTo(quantity) != 0) {

						standardizedDosage = standardizedDoseCalculation(new BigDecimal(td.getStrength()), quantity, duration, new BigDecimal(td.getWhodose()));

					}
					
				}// if(dd.getTdd()!=null)
				}//else

				
				// sum classes
				if ("2".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_2 = this.class_2.add(standardizedDosage);

				} else if ("4".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_4 = this.class_4.add(standardizedDosage);

				} else if ("5".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_5 = this.class_5.add(standardizedDosage);

				} else if ("7".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_7 = this.class_7.add(standardizedDosage);

				} else if ("9".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_9 = this.class_9.add(standardizedDosage);

				} else if ("13".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_13 = this.class_13.add(standardizedDosage);

				} else if ("16".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_16 = this.class_16.add(standardizedDosage);

				} else if ("17".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_17 = this.class_17.add(standardizedDosage);

				} else if ("18".equals(td.getTripdrugclassno().getBusinessId())) {
					this.class_18 = this.class_18.add(standardizedDosage);

				}
			}

		}
	}

	// 3. Drug Classes
	// 4. Standardized Dose Calculation
	// 5. Conditions
	// 6. Fall Count History
	// 7. Risk Computation

	private BigDecimal standardizedDoseCalculation(BigDecimal strength, BigDecimal quantity, BigDecimal duration, BigDecimal standardWhoDose) {
		return (strength.multiply(quantity)).divide(duration.multiply(standardWhoDose), 6, RoundingMode.HALF_EVEN);
	}

	/**
	 * calculate the hazard non mod
	 * 
	 * @param age65in
	 * @param genderin
	 * @param gbin
	 * @param ciin
	 * @param fallsin
	 * @return
	 */
	private BigDecimal calculateHazardNM(BigDecimal age65in, int genderin, int gbin, int ciin, int fallsin) {

		BigDecimal age65 = this.formatAge_65(age65in).multiply(HAZ_NM_COVARIATE_AGE);
		BigDecimal gender = this.booleanToBigDecimal(genderin == 1).multiply(HAZ_NM_COVARIATE_FEMALE);
		BigDecimal gb = this.booleanToBigDecimal(gbin == 1).multiply(HAZ_NM_COVARIATE_GB);
		BigDecimal ci = this.booleanToBigDecimal(ciin == 1).multiply(HAZ_NM_COVARIATE_CI);
		BigDecimal falls = new BigDecimal(fallsin).multiply(HAZ_NM_COVARIATE_PREVIOUSFALLS);

		return round(new BigDecimal(Math.exp(age65.add(gender.add(gb.add(ci.add(falls)))).doubleValue())), 6);
	}

	/**
	 * Calculate the risk total
	 * 
	 * @param hazard_total
	 * @return
	 */
	private BigDecimal calculateRiskTotal(BigDecimal hazard_total) {

		Double p = Math.pow(BASELINE_DIFF.doubleValue(), hazard_total.doubleValue());
		BigDecimal valP = new BigDecimal(p);
		BigDecimal valPMin1 = BigDecimal.ONE.subtract(valP);
		BigDecimal valPMin1_100 = valPMin1.multiply(ONE_HUNDRED);

		return this.round(valPMin1_100, 2);

	}

	/**
	 * 
	 * @param hazard_nm
	 * @return
	 */
	private BigDecimal calculateRiskNm(BigDecimal hazard_nm) {

		Double p = Math.pow(BASELINE_DIFF.doubleValue(), hazard_nm.doubleValue());
		BigDecimal valP = new BigDecimal(p);
		BigDecimal valPMin1 = BigDecimal.ONE.subtract(valP);
		BigDecimal valPMin1_100 = valPMin1.multiply(ONE_HUNDRED);
		return this.round(valPMin1_100, 2);

	}

	/**
	 * Calculate the hazard mod
	 * 
	 * @return the hazard mod
	 */
	private BigDecimal calculateHazardMod() {

		BigDecimal valX = this
			.computeX(HAZ_TOT_COVARIATE_CLASS_16.multiply(class_16), HAZ_TOT_COVARIATE_CLASS_17.multiply(class_17), HAZ_TOT_COVARIATE_CLASS_18.multiply(class_18));

		// formula
		BigDecimal hazard_modBExp = BigDecimal.ZERO;
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_2.multiply(class_2));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_4.multiply(class_4));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_5.multiply(class_5));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_9.multiply(class_9));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_13.multiply(class_13));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_16.multiply(class_16));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_17.multiply(class_17));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_18.multiply(class_18));
		hazard_modBExp = hazard_modBExp.subtract(HAZ_TOT_COVARIATE_CLASS_2_X.multiply(class_2).multiply(valX));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_4_X.multiply(class_4).multiply(valX));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_7_X.multiply(class_7).multiply(valX));
		hazard_modBExp = hazard_modBExp.add(HAZ_TOT_COVARIATE_CLASS_13_X.multiply(class_13).multiply(valX));

		Double hazard_modExp = Math.exp(hazard_modBExp.doubleValue());

		return round((new BigDecimal(hazard_modExp)), 6);
	}

	/**
	 * Calculate the total hazard
	 * 
	 * @param hazard_mod
	 * @param hazard_nm
	 * @return
	 */
	private BigDecimal calculateHazardTotal(BigDecimal hazard_mod, BigDecimal hazard_nm) {

		return this.round(hazard_nm.multiply(hazard_mod), 6);
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_2() {
		return class_2;
	}

	/**
	 * @param class_2
	 */
	public void setClass_2(BigDecimal class_2) {
		this.class_2 = class_2;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_4() {
		return class_4;
	}

	/**
	 * @param class_4
	 */
	public void setClass_4(BigDecimal class_4) {
		this.class_4 = class_4;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_5() {
		return class_5;
	}

	/**
	 * @param class_5
	 */
	public void setClass_5(BigDecimal class_5) {
		this.class_5 = class_5;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_7() {
		return class_7;
	}

	/**
	 * @param class_7
	 */
	public void setClass_7(BigDecimal class_7) {
		this.class_7 = class_7;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_9() {
		return class_9;
	}

	/**
	 * @param class_9
	 */
	public void setClass_9(BigDecimal class_9) {
		this.class_9 = class_9;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_13() {
		return class_13;
	}

	/**
	 * @param class_13
	 */
	public void setClass_13(BigDecimal class_13) {
		this.class_13 = class_13;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_16() {
		return class_16;
	}

	/**
	 * @param class_16
	 */
	public void setClass_16(BigDecimal class_16) {
		this.class_16 = class_16;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_17() {
		return class_17;
	}

	/**
	 * @param class_17
	 */
	public void setClass_17(BigDecimal class_17) {
		this.class_17 = class_17;
	}

	/**
	 * @return
	 */
	public BigDecimal getClass_18() {
		return class_18;
	}

	/**
	 * @param class_18
	 */
	public void setClass_18(BigDecimal class_18) {
		this.class_18 = class_18;
	}

}
