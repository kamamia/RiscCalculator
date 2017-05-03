package org.risk.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * WraperProfiler POJO
 * </p>
 * 
 * @author akamami
 * @author htazouti
 * @see TrippProfile
 * @see WrapperTrippProfile
 * @since January 29, 2015
 * @version 1.0
 *
 */
public class WraperProfiler {
	private TrippProfile trippProfile;
	private List<WrapperTrippProfile> wrappertrippProfiles;

	/**
	 * Constructor
	 */
	public WraperProfiler() {
		trippProfile = new TrippProfile();
		wrappertrippProfiles = new ArrayList<WrapperTrippProfile>();
	}

	/**Getters and Setters**/
	public TrippProfile getTrippProfile() {
		return trippProfile;
	}

	public void setTrippProfile(TrippProfile trippProfile) {
		this.trippProfile = trippProfile;
	}

	public List<WrapperTrippProfile> getWrappertrippProfiles() {
		return wrappertrippProfiles;
	}

	public void setWrappertrippProfiles(List<WrapperTrippProfile> wrappertrippProfiles) {
		this.wrappertrippProfiles = wrappertrippProfiles;
	}

	@Override
	public String toString() {

		return "WraperProfiler=: [ trippProfile=" + this.trippProfile + " wrappertrippProfiles=" + wrappertrippProfiles + "]";

	}

}
