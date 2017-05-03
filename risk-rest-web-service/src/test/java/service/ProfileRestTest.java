package service;

import static org.junit.Assert.*;

/*To remove to check with Hicham
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mcgill.risk.spring.model.TrippProfile;
import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.controller.DrugRestURIConstants;

/**
 * <p>
 * Tests for all rest web services
 * </p>
 * 
 * @author htazouti
 *
 */
public class ProfileRestTest {

	public static final String HOST = "localhost";

	public static final String SERVER_URI = "http://" + HOST
			+ ":8080/risk-rest-web-service-0.1";

	public String token;

	@Before
	public void init() {
		RestTemplate restTemplate = new RestTemplate();
		String user = "trrc";
		String password = "moxxi";
		String json = restTemplate.getForObject(SERVER_URI+ "/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="
								+ user + "&password=" + password, String.class);
		JSONObject jobj = new JSONObject(json);
		token = jobj.getString("value");
	}

	// @Test
	public void testGetAllTripDrug() {
		RestTemplate restTemplate = new RestTemplate();
		String jsonFromServer = restTemplate.getForObject(SERVER_URI
				+ DrugRestURIConstants.GET_RISK_TRIPP_DR + "/?access_token="
				+ token, String.class);
		// JSONArray js=new JSONArray(jsonFromServer);/

		JSONArray jsArray = new JSONArray(jsonFromServer);
		assertTrue("should not be null", jsArray.getJSONObject(0) != null);
		

	}

	/**
	 * Test for adding new tripp profile
	 */
	// @Test
	// public void addNewTrippProfile(){
	//
	// RestTemplate restTemplate = new RestTemplate();
	// TrippProfile trippProfile =new TrippProfile();
	//
	// trippProfile.setPatientId(new BigDecimal(300));
	// trippProfile.setSessionID("sessionfrom webservice");
	// trippProfile.setCreationDate(new Date());
	// trippProfile.setAge(new BigDecimal(20));
	// trippProfile.setFemale(true);
	// trippProfile.setConditionGB(false);drdr
	// trippProfile.setConditionCI(false);
	// trippProfile.setFallCount(3);
	// trippProfile.setRiskNonMod(new BigDecimal(6));
	// trippProfile.setHazardNonMod(new BigDecimal(5));
	//
	// TrippProfile response =
	// restTemplate.postForObject(SERVER_URI+DrugRestURIConstants.CREATE_TRIPP_PROFILE+"/?access_token="+token
	// , trippProfile,TrippProfile.class);
	//
	// assertTrue("TrippProfile succeuffly created",response!=null);
	//
	// //assertTrue(true);
	//
	// }

	//@Test
	
	public void testReadExcel() {
		
		/*try {
			FileInputStream file = new FileInputStream(
					new File(
							"C:/java/projects/TRRC/risk-rest-web-service/src/main/resources/doc/RestWS.xlsx"));
		*/
	}
	
	@Test
	public  void testGetAllRisktrippDrugTEST() {
		RestTemplate restTemplate = new RestTemplate();
		
		
	
		String json= restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/advil/?access_token="+ token, String.class);
		
		
		System.out.println("json->"+json+"<-");

	}
	
	//@Test
	public void testIsTrippDrug(){
		RestTemplate restTemplate = new RestTemplate();
		String jsonFromServer = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.VERIFY_IS_TRIPP_DRUG+"13073304/?access_token="+ token, String.class);
		
		assertTrue("The drug is tripp drug", jsonFromServer.equals("true"));
		
	}

}
