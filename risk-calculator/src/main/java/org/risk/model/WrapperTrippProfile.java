package org.risk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * TrippRisk POJO
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * @see TrippProfileRisk
 * @see TrippDrug
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class WrapperTrippProfile {
	
	private TrippProfileRisk trippprofilerisk;
	private List<TrippDrug> trippdrugs;

	/**
	 * Constructor
	 */
	public WrapperTrippProfile() {
		trippprofilerisk = new TrippProfileRisk();
		trippdrugs = new ArrayList<TrippDrug>();
	}

	/**Getters and Setters**/
	public List<TrippDrug> getTrippdrugs() {
		return trippdrugs;
	}

	public void setTrippdrugs(List<TrippDrug> trippdrugs) {
		this.trippdrugs = trippdrugs;
	}

	public TrippProfileRisk getTrippprofilerisk() {
		return trippprofilerisk;
	}

	public void setTrippprofilerisk(TrippProfileRisk trippprofilerisk) {
		this.trippprofilerisk = trippprofilerisk;
	}

	@Override
	public String toString() {

		return "WrapperTrippProfile=: [ trippprofilerisk=" + this.trippprofilerisk + " trippdrugs=" + trippdrugs + "]";

	}

}
