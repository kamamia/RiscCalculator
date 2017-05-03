package com.journaldev.spring.controller;

/**
 * <p>
 * Rest URI constantes
 * </p>
 * 
 * @author akamami
 * @author htazouti
 *
 */
public class DrugRestURIConstants {

	public static final String DUMMY_DR = "/rest/drug/dummy";
	public static final String GET_DR = "/rest/drug/{id}";
	public static final String GET_ALL_DR = "/rest/drugs";
	public static final String CREATE_DR = "/rest/drug/create";
	public static final String DELETE_DR = "/rest/drug/delete/{id}";
	public static final String GET_ALL_G_DR = "/rest/g/drugs";
	public static final String GET_DR_BY_CODEGEN_NAME = "/rest/g/codegen/byname/{name}";
	public static final String GET_DR_BY_NAME = "/rest/g/drugs/byname/{name}";
	public static final String GET_resp = "/rest/g/drugs/resp/{age}/{sexe}/{fails}";

	public static final String GET_TRIPP_DR_BY_NAME = "/rest/trippdr/trippbn/{name}";

	public static final String GET_RISK_TRIPP_DR_BY_NAME = "/rest/risk/trippdr/trippbn/{name}";

	public static final String GET_RISK_TRIPP_DR = "/rest/allrisk/alltrippdr/alltrippbn";

	public static final String GET_RISK_TRIPP_DR_CL = "/rest/allriskcl/alltrippdrcl/alltrippbncl";

	public static final String CREATE_TRIPP_PROFILE_GET_LIST = "/gimi/tripp/getlist/{list}";

	public static final String VERIFY_IS_TRIPP_DRUG = "/rest/drug/verify/";

}
