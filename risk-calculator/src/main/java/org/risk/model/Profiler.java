package org.risk.model;

import java.util.List;

/**
 * <p>
 * Profiler POJO
 * </p>
 * 
 * @author akamami
 * //
 * 
 * @see TrippProfile
 * @see TrippPat
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class Profiler {

	private TrippPat tripppPat;
	private List<TrippProfile> trippProfiles;

	/**
	 * Return {@linkplain TrippPat type}
	 */
	public TrippPat getTripppPat() {
		return tripppPat;
	}

	/**
	 * Set tripppPat
	 */
	public void setTripppPat(TrippPat tripppPat) {
		this.tripppPat = tripppPat;
	}

	/**
	 * @return {@linkplain TrippProfile type}
	 */
	public List<TrippProfile> getTrippProfiles() {
		return trippProfiles;
	}

	/**
	 * Set trippProfiles
	 */
	public void setTrippProfiles(List<TrippProfile> trippProfiles) {
		this.trippProfiles = trippProfiles;
	}

}
