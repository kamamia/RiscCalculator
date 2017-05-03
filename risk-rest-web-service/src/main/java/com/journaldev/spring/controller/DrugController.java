package com.journaldev.spring.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.journaldev.spring.model.DrugTest;

import org.mcgill.risk.spring.AppMainDrug;
import org.mcgill.risk.spring.AppMainLocale;
import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.LocalizedValue;
import org.mcgill.risk.spring.model.Drug;
import org.mcgill.risk.spring.model.LocalizedValueTrippRisk;
import org.mcgill.risk.spring.model.TripDrug;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.mcgill.risk.spring.service.DrugService;
import org.mcgill.risk.spring.service.LocalizedValueTrippRiskService;
import org.mcgill.risk.spring.service.TrippDrugService;
import org.mcgill.risk.spring.service.TrippProfileService;
import org.risk.calculator.RiskCalculator;
import org.risk.model.TrippDrug;
//import org.risk.model.TrippMessage;
import org.risk.model.TrippProfileRisk;

////////////
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 * Handles requests for the Drug service.
 * </p>
 * 
 * @author akamami
 * //
 * 
 * @see DrugService
 * @see TrippDrugService
 * @see RiskCalculator
 * @see TrippProfileRisk
 */
@Controller
public class DrugController {

	public static final Logger logger = LoggerFactory
			.getLogger(DrugController.class);

	// Map to store drugs, ideally we should use database
	Map<Integer, DrugTest> drugData = new HashMap<Integer, DrugTest>();

	@RequestMapping(value = DrugRestURIConstants.DUMMY_DR, method = RequestMethod.GET)
	public @ResponseBody DrugTest getDummyDrug() {
		logger.info("Start getDummyDrug");
		DrugTest dr = new DrugTest();
		dr.setId(9999);
		dr.setName("Dummy");
		dr.setCreatedDate(new Date());
		drugData.put(9999, dr);

		return dr;
	}

	@RequestMapping(value = DrugRestURIConstants.GET_DR, method = RequestMethod.GET)
	public @ResponseBody DrugTest getDrug(@PathVariable("id") int drId) {
		logger.info("Start getDrug. ID=" + drId);

		return drugData.get(drId);
	}

	@RequestMapping(value = DrugRestURIConstants.GET_ALL_DR, method = RequestMethod.GET)
	public @ResponseBody List<DrugTest> getAllDrugs() {
		logger.info("Start getAllDrugs.");
		List<DrugTest> drs = new ArrayList<DrugTest>();
		Set<Integer> drIdKeys = drugData.keySet();
		for (Integer i : drIdKeys) {
			drs.add(drugData.get(i));
		}
		return drs;
	}

	@RequestMapping(value = DrugRestURIConstants.CREATE_DR, method = RequestMethod.POST)
	public @ResponseBody DrugTest createDrug(@RequestBody DrugTest dr) {
		logger.info("Start createDrug.");
		dr.setCreatedDate(new Date());
		drugData.put(dr.getId(), dr);
		return dr;
	}

	@RequestMapping(value = DrugRestURIConstants.DELETE_DR, method = RequestMethod.PUT)
	public @ResponseBody DrugTest deleteDrug(@PathVariable("id") int drId) {
		logger.info("Start deleteDrug.");
		DrugTest dr = drugData.get(drId);
		drugData.remove(drId);
		return dr;
	}

	@RequestMapping(value = DrugRestURIConstants.GET_ALL_G_DR, method = RequestMethod.GET)
	public @ResponseBody List<Drug> getAllGDrugs() {
		logger.info("Start getAllGDrugs.");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		/*
		 * Get all Drugs list from database
		 */
		List<Drug> drugs = service.findAllDrugs();

		context.close();

		return drugs;
	}

	@RequestMapping(value = "/gimi/test", method = RequestMethod.GET)
	public @ResponseBody List<LocalizedValueTrippRisk> getRiskTrippDrugClTEST() {
		logger.info("Start getRiskTrippDrug ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		LocalizedValueTrippRiskService service = (LocalizedValueTrippRiskService) context
				.getBean("localizedValueTrippRiskService");

		List<LocalizedValueTrippRisk> loctripriskdrug = service
				.findAllLocalizedTrippRiskValue();

		logger.info("Start  ###############  getRiskTrippDrugCl. drugs.size()="
				+ loctripriskdrug.size());

		context.close();

		return loctripriskdrug;
	}

	@RequestMapping(value = DrugRestURIConstants.GET_RISK_TRIPP_DR_CL, method = RequestMethod.GET)
	public @ResponseBody List<LocalizedValueTrippRisk> getRiskTrippDrugCl() {
		logger.info("Start getRiskTrippDrug ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		LocalizedValueTrippRiskService service = (LocalizedValueTrippRiskService) context
				.getBean("localizedValueTrippRiskService");

		List<LocalizedValueTrippRisk> loctripriskdrug = service
				.findAllLocalizedTrippRiskValue();

		logger.info("Start  ###############  getRiskTrippDrugCl. drugs.size()="
				+ loctripriskdrug.size());

		context.close();

		return loctripriskdrug;
	}

	// GET_RISK_TRIPP_DR coresponding link is
	// "/rest/allrisk/alltrippdr/alltrippbn/";

	@RequestMapping(value = DrugRestURIConstants.GET_RISK_TRIPP_DR, method = RequestMethod.GET)
	public @ResponseBody List<TripDrug> getRiskTrippDrug() {
		logger.info("Start getRiskTrippDrug ");

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		TrippDrugService service = (TrippDrugService) context
				.getBean("trippdrugService");

		//
		// /*
		// * Get all TrippDrugs list from database
		// */
		List<TripDrug> tripdrug = service.findAllRiskTripDrugs();

		logger.info("Start getRiskTrippDrug. drugs.size()=" + tripdrug.size());
		for (TripDrug tdr : tripdrug) {
			System.out.println(tdr);
		}

		context.close();

		return tripdrug;
	}

	// GET_RISK_TRIPP_DR_BY_NAME coresponding link is
	// "/rest/risk/trippdr/trippbn/{name}";

	@RequestMapping(value = DrugRestURIConstants.GET_RISK_TRIPP_DR_BY_NAME, method = RequestMethod.GET)
	public @ResponseBody List<TripDrug> getRiskTrippDrugByName(
			@PathVariable("name") String name) {
		logger.info("Start getRiskTrippDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		TrippDrugService service = (TrippDrugService) context
				.getBean("trippdrugService");

		//
		// /*
		// * Get all trippDrugs list from database
		// */
		List<TripDrug> tripdrug = service.findAllTripDrugsByName(name);

		logger.info("Start getDrugByName. drugs.size()=" + tripdrug.size());
		for (TripDrug tdr : tripdrug) {
			System.out.println(tdr);
		}

		context.close();

		return tripdrug;
	}

	// GET_TRIPP_DR_BY_NAME

	@RequestMapping(value = DrugRestURIConstants.GET_TRIPP_DR_BY_NAME, method = RequestMethod.GET)
	public @ResponseBody List<TripDrug> getTrippDrugByName(
			@PathVariable("name") String name) {
		logger.info("Start getDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		TrippDrugService service = (TrippDrugService) context
				.getBean("trippdrugService");

		//
		// /*
		// * Get all trippDrugs list from database
		// */
		List<TripDrug> tripdrug = service.findAllTripDrugsByName(name);

		logger.info("Start getDrugByName. drugs.size()=" + tripdrug.size());
		for (TripDrug tdr : tripdrug) {
			System.out.println(tdr);
		}

		context.close();

		return tripdrug;
	}

	@RequestMapping(value = DrugRestURIConstants.GET_DR_BY_NAME, method = RequestMethod.GET)
	public @ResponseBody List<Drug> getDrugByName(
			@PathVariable("name") String name) {
		logger.info("Start getDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");
		TrippDrugService trippDrugService = (TrippDrugService) context
				.getBean("trippdrugService");

		List<Drug> drugs = service.findAllTradeDrugsByName(name);

		logger.info("Start getDrugByName. drugs.size()=" + drugs.size());
		for (Drug dr : drugs) {
			dr.setTripp(trippDrugService.isTrippDrug(dr.getId().toString()));
			System.out.println(dr);
		}

		context.close();

		return drugs;
	}

	// GET_DR_BY_CODEGEN_NAME corresponding link is
	// "/rest/g/codegen/byname/{name}";

	@RequestMapping(value = DrugRestURIConstants.GET_DR_BY_CODEGEN_NAME, method = RequestMethod.GET)
	public @ResponseBody List<Drug> getDrugByNameCodegen(
			@PathVariable("name") String name) {
		logger.info("Start getDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		List<Drug> drugs = service.findAllCodegenDrugsByName(name);

		logger.info("Start getDrugByNameCodegen. drugs.size()=" + drugs.size());
		for (Drug dr : drugs) {
			System.out.println(dr);
		}

		context.close();

		return drugs;
	}

	@RequestMapping(value = "/rest/g1/asf/resp/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Drug> getTESTDrugByName(
			@PathVariable("name") String name) {
		logger.info("Start getDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		List<Drug> drugs = service.findAllTradeDrugsByName(name);

		logger.info("Start getDrugByName. drugs.size()=" + drugs.size());
		for (Drug dr : drugs) {
			System.out.println(dr);
		}

		context.close();

		return drugs;
	}

	@RequestMapping(value = "/rest/g2/cadegen/resp/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Drug> getTESTDrugCodegenByName(
			@PathVariable("name") String name) {
		logger.info("Start getDrugByName. name=" + name);

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		DrugService service = (DrugService) context.getBean("drugService");

		List<Drug> drugs = service.findAllCodegenDrugsByName(name);

		logger.info("Start getDrugByName. drugs.size()=" + drugs.size());
		for (Drug dr : drugs) {
			System.out.println(dr);
		}

		context.close();

		return drugs;
	}

	@RequestMapping(value = "/rest/g2/asf2/resp2/{age}/{sexe}/{fails}", method = RequestMethod.GET)
	public @ResponseBody TrippProfileRisk getRisk(@PathVariable("age") int age,
			@PathVariable("sexe") int sexe, @PathVariable("fails") int fails) {
		logger.info("******************************* getRisk  ******************************************");

		RiskCalculator rc = new RiskCalculator();

		TrippProfileRisk ret = rc.doRiskCalculation(new BigDecimal(age), sexe,
				0, 0, fails);

		return ret;
	}

	/*
	 * Used for tests to check with Hicham
	 */

	@RequestMapping(value = "/rest/tripp/getlist/", method = RequestMethod.POST)
	public @ResponseBody String createTrippProfileGetList() {

		logger.debug("*******************************Adding createTrippProfileGetList******************************************");

		logger.debug("*******************************Adding createTrippProfileGetList ******************************************");

		return "OK";

	}

	@RequestMapping(value = "/gimi/tripp/getlist/", method = RequestMethod.POST)
	public @ResponseBody List<LocalizedValueTrippRisk> getRiskTrippDrugClTESTG(
			@RequestParam(value = "jsonObject") String jsonObject) {
		logger.info("Start getRiskTrippDrugClTESTG ");

		logger.info("Start  ###############  getRiskTrippDrugCl. drugs.size()="
				+ jsonObject.toString());

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		LocalizedValueTrippRiskService service = (LocalizedValueTrippRiskService) context
				.getBean("localizedValueTrippRiskService");

		List<LocalizedValueTrippRisk> loctripriskdrug = service
				.findAllLocalizedTrippRiskValue();

		context.close();

		return loctripriskdrug;
	}

	@RequestMapping(value = "/gimi/print/getlist/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void printRequestBody(@RequestBody String jsonString) {

		String decoded = "{}";

		try {

			decoded = URLDecoder.decode(jsonString, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();

			logger.info(" Can not decode  ############### jsonObject getDummyDrugJson ->");
		}

		JSONObject JSO = new JSONObject(decoded);

		JSONObject pat = (JSONObject) JSO.get("trippProfile");

	}

	@RequestMapping(value = "/gimi/print/getlisttr/", method = RequestMethod.POST)
	public @ResponseBody TrippProfileRisk printRequestBodyTR(
			@RequestBody String jsonString) {

		String decoded = "{}";
		try {
			decoded = URLDecoder.decode(jsonString, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}

		JSONObject JSO = new JSONObject(decoded);

		JSONObject pat = (JSONObject) JSO.get("trippProfile");

		Integer patid = (Integer) pat.get("patid");
		Integer sexe = (Integer) pat.get("sexe");
		Integer age = (Integer) pat.get("age");
		Integer fails = (Integer) pat.get("fails");

		RiskCalculator rc = new RiskCalculator();
		TrippProfileRisk ret = rc.doRiskCalculation(new BigDecimal(age), sexe,
				0, 0, fails);

		return ret;

	}

	@RequestMapping(value = "/rest/print/getlisttr/", method = RequestMethod.POST)
	public @ResponseBody List<TrippProfileRisk> printRequestBodyAuth(
			@RequestBody String jsonString) {

		String decoded = "{}";
		try {
			decoded = URLDecoder.decode(jsonString, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}

		JSONObject JSO = new JSONObject(decoded);

		JSONObject pat = (JSONObject) JSO.get("trippProfile");

		Integer patid = (Integer) pat.get("patid");
		Integer sexe = (Integer) pat.get("sexe");
		String age = (String) pat.get("age");
		Integer fails = (Integer) pat.get("fails");

		Integer gb = (Integer) pat.get("gb");
		Integer ci = (Integer) pat.get("ci");

		JSONArray listOfTrippDrugs = JSO.getJSONArray("drugs");

		logger.info("Object listOfTrippDrugs ->" + listOfTrippDrugs + "<-");

		List<org.risk.model.TrippDrug> activeDispensedTrippDrugs = JSONArrayToListTrippDrug(listOfTrippDrugs);

		RiskCalculator rc = new RiskCalculator();

		TrippProfileRisk retFirst = rc.doRiskCalculation(new BigDecimal(age),
				sexe, gb, ci, fails);

		TrippProfileRisk retModif = rc.doRiskCalculation(new BigDecimal(age),
				sexe, gb, ci, fails, activeDispensedTrippDrugs);

		List<TrippProfileRisk> ret = new ArrayList<TrippProfileRisk>();
		ret.add(retFirst);
		ret.add(retModif);
		return ret;

	}

	@RequestMapping(value = "/rest/printsave/getlisttr/", method = RequestMethod.POST)
	public @ResponseBody List<TrippProfileRisk> printsaveRequestBodyAuth(
			@RequestBody String jsonString,
			javax.servlet.http.HttpServletRequest request) {

		List<TrippProfileRisk> ret = new ArrayList<TrippProfileRisk>();

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		TrippProfileService trippProfileService = (TrippProfileService) context
				.getBean("trippProfileService");

		DrugService drugservice = (DrugService) context.getBean("drugService");

		String sessionId = request.getSession().getId();
		try {

			String decoded = "{}";

			decoded = URLDecoder.decode(jsonString, "UTF-8");

			JSONObject JSO = new JSONObject(decoded);

			JSONObject pat = (JSONObject) JSO.get("trippProfile");

			Integer patid = (Integer) pat.get("patid");
			Integer sexe = (Integer) pat.get("sexe");
			String age = (String) pat.get("age");
			Integer fails = (Integer) pat.get("fails");

			Integer gb = (Integer) pat.get("gb");
			Integer ci = (Integer) pat.get("ci");

			org.risk.model.TrippProfile tp = new org.risk.model.TrippProfile();

			tp.setAge(new BigDecimal(age));
			tp.setCi(new BigDecimal(ci));
			tp.setFails(new BigDecimal(fails));
			tp.setGb(new BigDecimal(gb));
			tp.setId(new BigDecimal(patid));
			tp.setSexe(new BigDecimal(sexe));

			JSONArray listOfTrippDrugs = JSO.getJSONArray("drugs");

			List<org.risk.model.TrippDrug> activeDispensedTrippDrugs = JSONArrayToListTrippDrug(listOfTrippDrugs);

			RiskCalculator rc = new RiskCalculator();

			TrippProfileRisk retFirst = rc.doRiskCalculation(
					new BigDecimal(age), sexe, gb, ci, fails);

			TrippProfileRisk retModif = rc.doRiskCalculation(
					new BigDecimal(age), sexe, gb, ci, fails,
					activeDispensedTrippDrugs);

			org.risk.model.WrapperTrippProfile WT1 = new org.risk.model.WrapperTrippProfile();

			WT1.setTrippprofilerisk(retFirst);

			org.risk.model.WrapperTrippProfile WT2 = new org.risk.model.WrapperTrippProfile();

			WT2.setTrippprofilerisk(retModif);

			WT2.setTrippdrugs(activeDispensedTrippDrugs);

			List<org.risk.model.WrapperTrippProfile> WTL = new ArrayList<org.risk.model.WrapperTrippProfile>();

			WTL.add(WT1);
			WTL.add(WT2);

			org.risk.model.WraperProfiler WP = new org.risk.model.WraperProfiler();

			WP.setTrippProfile(tp);

			WP.setWrappertrippProfiles(WTL);

			addTrippAllProfile(trippProfileService, drugservice, WP, rc,
					sessionId);

			ret.add(retFirst);
			ret.add(retModif);

		} catch (Exception e) {

			logger.info(" Can not decode  ############### jsonObject printRequestBodyAuth 444 ->"
					+ e.getMessage() + "<--");

			String message = "";

			if (e.getMessage() != null && e.getMessage().trim().length() > 0) {

				message = e.getMessage();

			} else {
				message = "You have a malformed string or parameters";
			}

			TrippProfileRisk tr = new TrippProfileRisk();
			tr.setMessage(message);
			ret.add(tr);
			e.getMessage();
		}

		return ret;

	}

	private void addTrippAllProfile(TrippProfileService trippProfileService,
			DrugService drugservice, org.risk.model.WraperProfiler WP,
			RiskCalculator rc, String sessionId) {

		org.mcgill.risk.spring.model.TrippProfile trippProfile = new org.mcgill.risk.spring.model.TrippProfile();

		trippProfile.setPatientId(WP.getTrippProfile().getId());
		trippProfile.setSessionID(sessionId);
		trippProfile.setCreationDate(new Date());
		trippProfile.setAge(WP.getTrippProfile().getAge());
		trippProfile
				.setFemale(WP.getTrippProfile().getSexe() == new BigDecimal(1));
		trippProfile
				.setConditionGB(WP.getTrippProfile().getGb() == new BigDecimal(
						1));
		trippProfile
				.setConditionCI(WP.getTrippProfile().getCi() == new BigDecimal(
						1));
		trippProfile.setFallCount(WP.getTrippProfile().getFails().intValue());
		trippProfile.setRiskNonMod(WP.getWrappertrippProfiles().get(0)
				.getTrippprofilerisk().getRisk_Nm());
		trippProfile.setHazardNonMod(WP.getWrappertrippProfiles().get(0)
				.getTrippprofilerisk().getHazard_nm());

		org.mcgill.risk.spring.model.TrippProfile persistedTrippProfile = trippProfileService
				.addTrippProfile(trippProfile);

		org.mcgill.risk.spring.model.TrippProfileRisk trippProfileRisk1 = new org.mcgill.risk.spring.model.TrippProfileRisk();

		trippProfileRisk1.setTrippProfile(persistedTrippProfile);
		trippProfileRisk1.setRiskTotal(WP.getWrappertrippProfiles().get(0)
				.getTrippprofilerisk().getRiskTotal());
		trippProfileRisk1.setHazardTotal(WP.getWrappertrippProfiles().get(0)
				.getTrippprofilerisk().getHazardTotal());
		trippProfileRisk1.setHazardMod(WP.getWrappertrippProfiles().get(0)
				.getTrippprofilerisk().getHazardMod());
		trippProfileRisk1.setClass_2(new BigDecimal(0));
		trippProfileRisk1.setClass_4(new BigDecimal(0));
		trippProfileRisk1.setClass_5(new BigDecimal(0));
		trippProfileRisk1.setClass_9(new BigDecimal(0));
		trippProfileRisk1.setClass_16(new BigDecimal(0));
		trippProfileRisk1.setClass_17(new BigDecimal(0));
		trippProfileRisk1.setClass_18(new BigDecimal(0));
		trippProfileRisk1.setClass_7(new BigDecimal(0));
		trippProfileRisk1.setClass_13(new BigDecimal(0));

		org.mcgill.risk.spring.model.TrippProfileRisk persistedTrippProfileRisk1 = trippProfileService
				.addTrippProfileRisk(trippProfileRisk1);

		// @Table(name="TRIPP_PROFILE_RISK")

		// 2
		// Open Declaration List<WrapperTrippProfile>
		// org.risk.model.WraperProfiler.getWrappertrippProfiles()

		List<org.risk.model.WrapperTrippProfile> WP_WrapPList = WP
				.getWrappertrippProfiles();

		WP_WrapPList.remove(0);

		for (org.risk.model.WrapperTrippProfile WrP : WP_WrapPList) {

			org.mcgill.risk.spring.model.TrippProfileRisk trippProfileRisk2 = new org.mcgill.risk.spring.model.TrippProfileRisk();
			trippProfileRisk2.setTrippProfile(persistedTrippProfile);

			/*
			 * trippProfileRisk2.setRiskTotal(WP.getWrappertrippProfiles().get(1)
			 * .getTrippprofilerisk().getRiskTotal());
			 * trippProfileRisk2.setHazardTotal
			 * (WP.getWrappertrippProfiles().get(
			 * 1).getTrippprofilerisk().getHazardTotal());
			 * trippProfileRisk2.setHazardMod
			 * (WP.getWrappertrippProfiles().get(1)
			 * .getTrippprofilerisk().getHazardMod());
			 */

			trippProfileRisk2.setRiskTotal(WrP.getTrippprofilerisk()
					.getRiskTotal());
			trippProfileRisk2.setHazardTotal(WrP.getTrippprofilerisk()
					.getHazardTotal());
			trippProfileRisk2.setHazardMod(WrP.getTrippprofilerisk()
					.getHazardMod());

			/*
			 * trippProfileRisk2.setClass_2(rc.getClass_2()); this has to be
			 * checked in case of many risk tries
			 */

			trippProfileRisk2.setClass_2(rc.getClass_2());
			trippProfileRisk2.setClass_4(rc.getClass_4());
			trippProfileRisk2.setClass_5(rc.getClass_5());
			trippProfileRisk2.setClass_9(rc.getClass_9());
			trippProfileRisk2.setClass_16(rc.getClass_16());
			trippProfileRisk2.setClass_17(rc.getClass_17());
			trippProfileRisk2.setClass_18(rc.getClass_18());
			trippProfileRisk2.setClass_7(rc.getClass_7());
			trippProfileRisk2.setClass_13(rc.getClass_13());
			org.mcgill.risk.spring.model.TrippProfileRisk persistedTrippProfileRisk2 = trippProfileService
					.addTrippProfileRisk(trippProfileRisk2);

			/*
			 * List<org.risk.model.TrippDrug>
			 * trdr=WP.getWrappertrippProfiles().get(1).getTrippdrugs();
			 */

			List<org.risk.model.TrippDrug> trdr = WrP.getTrippdrugs();

			for (org.risk.model.TrippDrug TrippDrug : trdr)

			{

				org.mcgill.risk.spring.model.TrippProfileRiskDrug trippProfileRiskDrug = new org.mcgill.risk.spring.model.TrippProfileRiskDrug();

				org.mcgill.risk.spring.model.Drug drDin = drugservice
						.findByDin(TrippDrug.getDin());

				trippProfileRiskDrug.setDrugId(new Long(drDin.getDin()));
				trippProfileRiskDrug
						.setTrippProfileRisk(persistedTrippProfileRisk2);
				trippProfileRiskDrug.setQuantity(TrippDrug.getQuantity());
				trippProfileRiskDrug.setDurationDays(TrippDrug.getDuration());
				trippProfileRiskDrug.setStatus("NEW");
				trippProfileRiskDrug.setDrugType(drDin.getTrademarkName()
						.getCodeType());
				trippProfileService
						.addTrippProfileRiskDrug(trippProfileRiskDrug);

			}// end trdr LIST

		}// end WRP LIST
	}

	private List<org.risk.model.TrippDrug> JSONArrayToListTrippDrug(
			JSONArray listOfTrippDrugs) {
		List<org.risk.model.TrippDrug> activeDispensedTrippDrugs = new ArrayList<org.risk.model.TrippDrug>();

		for (int i = 0; i < listOfTrippDrugs.length(); i++) {

			JSONObject JSONTrippDrug = listOfTrippDrugs.getJSONObject(i);
			String din = JSONTrippDrug.getString("din");
			String codegen = JSONTrippDrug.getString("codegen");
			String quantity = JSONTrippDrug.getString("quantity");
			String duration = JSONTrippDrug.getString("duration");

			org.risk.model.TrippDrug temp = new org.risk.model.TrippDrug(din,
					codegen, new BigDecimal(quantity), new Integer(duration));
			activeDispensedTrippDrugs.add(temp);

		}

		logger.info("JSONArrayToListTrippDrug size->"
				+ activeDispensedTrippDrugs.size() + "<-");
		return activeDispensedTrippDrugs;
	}

	@RequestMapping(value = "/gimi/g2/asf2/resp2/{age}/{sexe}/{fails}", method = RequestMethod.GET)
	public @ResponseBody TrippProfileRisk getRiskGimi(
			@PathVariable("age") int age, @PathVariable("sexe") int sexe,
			@PathVariable("fails") int fails) {

		logger.info(" Can not decode  ############### jsonObject getRiskGimi 444444 ->");

		logger.info("age_sexe_fails->" + age + " " + sexe + " " + fails + "<-");
		RiskCalculator rc = new RiskCalculator();

		TrippProfileRisk ret = rc.doRiskCalculation(new BigDecimal(age), sexe,
				0, 0, fails);

		return ret;
	}

}
