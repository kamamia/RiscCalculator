package com.journaldev.spring;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.controller.DrugController;
import com.journaldev.spring.controller.DrugRestURIConstants;
import com.journaldev.spring.model.DrugTest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mcgill.risk.spring.model.Codegen;
import org.mcgill.risk.spring.model.Drug;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.mcgill.risk.spring.model.Drug;


/*this is used insted of  TestSpringRestExample.java 

TestSpringRestExample.java can be removed to check with Hicham
*/
public class TestSpringRestExampleTC {
	public static final String HOST = "localhost";
	
	private static final Logger logger = LoggerFactory.getLogger(TestSpringRestExampleTC.class);
	
	
//	public static final String HOST = "198.168.138.243";
	
	
//	public static final String HOST = "132.216.183.7";

	//public static final String SERVER_URI = "http://localhost:9090/SpringRestExample";
	
//	public static final String SERVER_URI = "http://localhost:8080/SpringRest-1.0";
	
//	public static final String SERVER_URI = "http://localhost:8080/risk-rest-web-service-0.1";
	
//	public static final String SERVER_URI = "http://132.216.183.7:8080/risk-rest-web-service-0.1";
	
	//public static final String SERVER_URI = "http://localhost:8080/risk-rest-web-service-0.1";
	
	
	public static final String SERVER_URI = "http://"+ HOST+":8080/risk-rest-web-service-0.1";
	
	//DrugRestURIConstants.GET_TRIPP_DR_BY_NAME
	
	
	
	public static void main(String args[]){
//		testGetAllGDrug();
//		testGetDummyDrug();
//		System.out.println("*****");
//		testCreateDrug();
//		System.out.println("*****");
//		testGetDrug();
//		System.out.println("*****");
//		testGetAllDrug();
//		System.out.println("JSON");
	/////testGetDummyDrugJSON();
	
	/////testGetAllGDrugByName() ;
	//	testGetAllGDrugByNameTEST() ;
//////////////	testPutGet() ;
		
	// testGetAlltrippDrugByNameTEST();
		
		
	/*	
	 testGetAllRisktrippDrugByNameTEST();
	 testGetAllRisktrippDrugTEST();
	 */
	
		// testGetAllRisktrippClassDrugTEST();
		 
 // testGetAllRisktrippClassDrugTEST_TC();
  

		 
	//	testGetAllRisktrippClassDrugGIMITEST_TC() ;
		// non   testGetAllRisktrippClassDrugGIMITEST_TC_LIST();
		
	//	testGetAllRisktrippClassDrugGIMIprint_getlisttr();
// work properly 	testGetAllRisktrippClassDrugGIMIprint_getlisttr_auth();
	
	// GOOD testGetAllRisktrippClassDrugGIMIprint_getlisttr_authRealDIN();
	
	testPrintSaveAllRisktrippClassDrugGIMIprint_getlisttr_authRealDIN() ;
	
	
	//testGetAllRisktrippDrugTESTAuth();
	
	// GOOD	testGetAllDrugsByTradeTESTAuth();
	
	
// GOOD	testGetAllDrugsByCodegenTESTAuth();
	
	
	
	}
	
	
	private static void tetsDrugTest(){
		
		testGetDummyDrug();
		System.out.println("*****");
		testCreateDrug();
		System.out.println("*****");
		testGetDrug();
		System.out.println("*****");
		testGetAllDrug();
		System.out.println("JSON");
		testGetDummyDrugJSON();
		
	}
	
	
	private static void testGetAllRisktrippClassDrugTEST_TC() {
		RestTemplate restTemplate = new RestTemplate();
		
		//http://localhost:8080/risk-rest-web-service-0.1/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=beingjavaguys&password=spring@java
	//	String json= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=beingjavaguys&password=spring@java", String.class);
//String user="beingjavaguys";
//String password="springggg";

String user="trrc";
String password="moxxi";
		String json= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

		//	String json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl", String.class);
		//restTemplate.
		JSONObject jobj= new JSONObject(json);
		 logger.info(json);
		
//		System.out.println("json->"+json+"<-");
//		
//		System.out.println("json->"+jobj.getString("value")+"<-");
//		
		 logger.info(jobj.getString("value"));
		 json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl/?access_token="+jobj.getString("value"), String.class);
		 
//		 System.out.println("json->"+json+"<-");
		 
		 logger.info(json);
		

	}
	
	//  /gimi/test
	
	
	
	private static void testGetAllRisktrippClassDrugGIMITEST_TC() {
		RestTemplate restTemplate = new RestTemplate();
		
		//http://localhost:8080/risk-rest-web-service-0.1/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=beingjavaguys&password=spring@java
		String json= restTemplate.getForObject(SERVER_URI+"/gimi/test", String.class);
	//	String json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl", String.class);
		//restTemplate.
	//	JSONObject jobj= new JSONObject(json);
		 logger.info(json);
		


	}
	
	
	
	// /rest/allrisk/alltrippdr/alltrippbn/
	// /rest/allriskcl/alltrippdrcl/alltrippbncl
	
	private static void testGetAllRisktrippClassDrugTEST() {
		RestTemplate restTemplate = new RestTemplate();
		
		
		
		String json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl", String.class);
		//restTemplate.
		
		
		System.out.println("json->"+json+"<-");

	}
	
	
	
	private static void testGetAllRisktrippDrugTEST() {
		RestTemplate restTemplate = new RestTemplate();
		
		
		
		String json= restTemplate.getForObject(SERVER_URI+"/rest/allrisk/alltrippdr/alltrippbn", String.class);
		
		
		
		System.out.println("json->"+json+"<-");

	}
	
	
	
	private static void testGetAllRisktrippDrugByNameTEST() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
	
		//List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_DR_BY_NAME+name, List.class);
		
//		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/ADVIL", List.class);
		
	//	/rest/g/drugs/byname/{name}
		
	//	System.out.println(drugs.size());
		
		
		
		String json= restTemplate.getForObject(SERVER_URI+"/rest/risk/trippdr/trippbn/AntipsyCHotic", String.class);
		
		
		
		System.out.println("json->"+json+"<-");
//		for(LinkedHashMap map : drugs){
//			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
//		}
	}
	
	
	
	
	private static void testGetAlltrippDrugByNameTEST() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		String name="ADVIL";
		//List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_DR_BY_NAME+name, List.class);
		
//		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/ADVIL", List.class);
		
	//	/rest/g/drugs/byname/{name}
		
	//	System.out.println(drugs.size());
		
		
		String json= restTemplate.getForObject(SERVER_URI+"/rest/trippdr/trippbn/AntipsyCHotic", String.class);
		
		
		
		System.out.println("json->"+json+"<-");
//		for(LinkedHashMap map : drugs){
//			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
//		}
	}
	
	
	
	

	private static void testGetAllGDrugByNameTEST() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		String name="ADVIL";
		//List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_DR_BY_NAME+name, List.class);
		
//		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/ADVIL", List.class);
		
	//	/rest/g/drugs/byname/{name}
		
	//	System.out.println(drugs.size());
		
		//  GIMI  NOW
		String json= restTemplate.getForObject(SERVER_URI+"/rest/g1/asf/resp/ADVIL", String.class);
		
		System.out.println("json->"+json+"<-");
//		for(LinkedHashMap map : drugs){
//			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
//		}
	}
	
	
	/*private static void testGetAllGDrugByName() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		String name="ADVIL";
		//List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_DR_BY_NAME+name, List.class);
		
//		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/ADVIL", List.class);
		
	//	/rest/g/drugs/byname/{name}
		
	//	System.out.println(drugs.size());
		
		
		String json= restTemplate.getForObject(SERVER_URI+"/rest/g/drugs/byname/ADVIL", String.class);
		
		System.out.println("json->"+json+"<-");
//		for(LinkedHashMap map : drugs){
//			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
//		}
	}*/
	
	
	private static void testGetDrug() {
		RestTemplate restTemplate = new RestTemplate();
		DrugTest dr = restTemplate.getForObject(SERVER_URI+"/rest/drug/1", DrugTest.class);
		printDrugData(dr);
	}
	
	
	private static void testGetAllGDrug() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_ALL_G_DR, List.class);
		System.out.println(drugs.size());
//		for(LinkedHashMap map : drugs){
//			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
//		}
	}

	private static void testGetAllDrug() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> drugs = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_ALL_DR, List.class);
		System.out.println(drugs.size());
		for(LinkedHashMap map : drugs){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateDrug() {
		RestTemplate restTemplate = new RestTemplate();
		DrugTest dr = new DrugTest();
		dr.setId(1);
		dr.setName("Prozack");
		DrugTest response = restTemplate.postForObject(SERVER_URI+DrugRestURIConstants.CREATE_DR, dr, DrugTest.class);
		printDrugData(response);
	}

	

	private static void testGetDummyDrug() {
		RestTemplate restTemplate = new RestTemplate();
		DrugTest dr = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.DUMMY_DR, DrugTest.class);
		printDrugData(dr);
	}
	
	
	private static void testGetDummyDrugJSON() {
		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.DUMMY_DR, String.class);
		//printDrugData(dr);
		
		System.out.println("json->"+json+"<-");
		
	}
	
	
	
	// /rest/g/drugs/resp/{listvars}
	
	
	
	private static void testPutGet() {
		RestTemplate restTemplate = new RestTemplate();
		//String json = restTemplate.getForObject(SERVER_URI+DrugRestURIConstants.GET_resp, String.class);
		///rest/g/drugs/resp/
		
		/// /rest/g/drugs/resp/{age}/{sex}/{fails}
	//	String json = restTemplate.getForObject(SERVER_URI+"/rest/g1/asf/resp/84/1/3", String.class);
		
	//	String json = restTemplate.getForObject(SERVER_URI+"/rest/g2/asf2/resp2/84_1_3", String.class);
		
		String json = restTemplate.getForObject(SERVER_URI+"/rest/g2/asf2/resp2/84/1/3", String.class);
		
		// /rest/g/drugs/resp/{listvars}
		//printDrugData(dr);
		
		System.out.println("json->"+json+"<-");
		
	}
	
	
	
	private static void testGET_LISTBCP() {
		RestTemplate restTemplate = new RestTemplate();
		List<Drug> drugsin= new ArrayList<Drug>();
		
		Drug d1= new Drug();
		
		Codegen cg= new Codegen();
		
		/*	cg.setCode(code); or get from entity
			d1.setCodegen(cg);*/
		
		d1.setCodegen(cg);
		d1.setCreationtransactionid(222);
		d1.setDefaultdurationdays(333);
	//	d1.setDefaultfreetextposologylvid(444);
		//d1.setDefaultinstructionslvid(555);
		
		
Drug d2= new Drug();
		
		d2.setCodegen(cg);
		d2.setCreationtransactionid(2221);
		d2.setDefaultdurationdays(3332);
		//d2.setDefaultfreetextposologylvid(4442);
	//	d2.setDefaultinstructionslvid(5552);
		
		drugsin.add(d1);
		
		drugsin.add(d2);
		
		
		///rest/tripp/getlist/{list}
		//String json = restTemplate.getForObject(SERVER_URI+"/gimi/tripp/getlist/"+drugsin, String.class);
		String json = restTemplate.getForObject(SERVER_URI+"/gimi/tripp/getlist/", String.class);
		// /rest/g/drugs/resp/{listvars}
		//printDrugData(dr);
		
		System.out.println("json->"+json+"<-");
		
	}
	
	
	private static void testGET_LIST() {
		
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		

String user="trrc";
String password="moxxi";
		String json= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

		//	String json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl", String.class);
		//restTemplate.
		JSONObject jobj= new JSONObject(json);
		 logger.info(json);
		
//		System.out.println("json->"+json+"<-");
//		
//		System.out.println("json->"+jobj.getString("value")+"<-");
//		
		 logger.info(jobj.getString("value"));
		 json= restTemplate.getForObject(SERVER_URI+"/rest/tripp/getlist/?access_token="+jobj.getString("value"), String.class);
		 
//		 System.out.println("json->"+json+"<-");
		 
		 logger.info(json);
		 
		List<Drug> drugsin= new ArrayList<Drug>();
		
		Drug d1= new Drug();
		
		
		Codegen cg= new Codegen();
		
		/*	cg.setCode(code); or get from entity
			d1.setCodegen(cg);*/
		
		
		d1.setCodegen(cg);
		d1.setCreationtransactionid(222);
		d1.setDefaultdurationdays(333);
		//d1.setDefaultfreetextposologylvid(444);
	//	d1.setDefaultinstructionslvid(555);
		
		
Drug d2= new Drug();
		
		d2.setCodegen(cg);
		d2.setCreationtransactionid(2221);
		d2.setDefaultdurationdays(3332);
	//	d2.setDefaultfreetextposologylvid(4442);
	//	d2.setDefaultinstructionslvid(5552);
		
		drugsin.add(d1);
		
		drugsin.add(d2);
		
		
		System.out.println("json->"+json+"<-");
		
	}
	
	
	private static void testGetAllRisktrippClassDrugGIMITEST_TC_LIST() {
		RestTemplate restTemplate = new RestTemplate();
	List<Drug> drugsin= new ArrayList<Drug>();
		
		Drug d1= new Drug();
		
		Codegen cg= new Codegen();
		
	/*	cg.setCode(code); or get from entity
		d1.setCodegen(cg);*/
		d1.setCreationtransactionid(222);
		d1.setDefaultdurationdays(333);
		//d1.setDefaultfreetextposologylvid(444);
	//	d1.setDefaultinstructionslvid(555);
		
		
Drug d2= new Drug();
/*	cg.setCode(code); or get from entity
d1.setCodegen(cg);*/
		
		d2.setCodegen(cg);
		d2.setCreationtransactionid(2221);
		d2.setDefaultdurationdays(3332);
		//d2.setDefaultfreetextposologylvid(4442);
		//d2.setDefaultinstructionslvid(5552);
		
		drugsin.add(d1);
		
		drugsin.add(d2);
		
		
		//JSONObject jobj= new JSONObject("{\"businessId\":\"13\"}");
				// "	//http://localhost:8080/risk-rest-web-service-0.1/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=beingjavaguys&password=spring@java
	//	String json= restTemplate.getForObject(SERVER_URI+"/gimi/tripp/getlist/{LocalizedValueTrippRisk: sadsa}", String.class);

		String json= restTemplate.getForObject(SERVER_URI+"/gimi/tripp/getlist", String.class);

		
		//	String json= restTemplate.getForObject(SERVER_URI+"/rest/allriskcl/alltrippdrcl/alltrippbncl", String.class);
		//restTemplate.
	//	JSONObject jobj= new JSONObject(json);
		 logger.info(json);
		


	}
	
	
	private static void testGetAllRisktrippClassDrugGIMIprint_getlisttr() {
		RestTemplate restTemplate = new RestTemplate();
	
		String request ="{\"patient\":{\"patid\":12345,\"fails\":3,\"age\":84,\"sexe\":1},"+
				"\"drugs\":"+
				"["+
				"{\"din\":\"din_0\",\"strength\":\"strength_0\",\"whoDose\":\"whoDose_0\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"},"+
				"{\"din\":\"din_1\",\"strength\":\"strength_1\",\"whoDose\":\"whoDose_1\",\"alternativeDose\":\"alternativeDose_1\",\"alternativeDuration\":\"alternativeDuration_1\"},"+
				"{\"din\":\"din_2\",\"strength\":\"strength_2\",\"whoDose\":\"whoDose_2\",\"alternativeDose\":\"alternativeDose_2\",\"alternativeDuration\":\"alternativeDuration_2\"},"+
				"{\"din\":\"din_1\",\"strength\":\"strength_1\",\"whoDose\":\"whoDose_1\",\"alternativeDose\":\"alternativeDose_1\",\"alternativeDuration\":\"alternativeDuration_1\"}"+
				"]"+
				"}"
				;
	
		String json= restTemplate.postForObject(SERVER_URI+"/gimi/print/getlisttr/", request,  String.class);
		 logger.info(json);
		
	
	}
	
	
	
	private static void testGetAllRisktrippClassDrugGIMIprint_getlisttr_auth() {
		
		RestTemplate restTemplate = new RestTemplate();
		String user="trrc";
		String password="moxxi";
				String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

				JSONObject jobjauth= new JSONObject(jsonA);
				 logger.info(jsonA);
					
				 logger.info(jobjauth.getString("value"));

		String request ="{\"trippProfile\":{\"patid\":12345,\"fails\":3,\"age\":84,\"sexe\":1,\"gb\":1,\"ci\":1},"+
				"\"drugs\":"+
				"["+
				"{\"din\":\"din_0\",\"codegen\":\"codegen_0\",\"quantity\":\"10\",\"duration\":\"10\",\"strength\":\"strength_0\",\"whoDose\":\"whoDose_0\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"},"+
				"{\"din\":\"din_1\",\"codegen\":\"codegen_1\",\"quantity\":\"11\",\"duration\":\"11\",\"strength\":\"strength_1\",\"whoDose\":\"whoDose_1\",\"alternativeDose\":\"alternativeDose_1\",\"alternativeDuration\":\"alternativeDuration_1\"},"+
				"{\"din\":\"din_2\",\"codegen\":\"codegen_2\",\"quantity\":\"12\",\"duration\":\"12\",\"strength\":\"strength_2\",\"whoDose\":\"whoDose_2\",\"alternativeDose\":\"alternativeDose_2\",\"alternativeDuration\":\"alternativeDuration_2\"},"+
				"{\"din\":\"din_1\",\"codegen\":\"codegen_3\",\"quantity\":\"13\",\"duration\":\"13\",\"strength\":\"strength_1\",\"whoDose\":\"whoDose_1\",\"alternativeDose\":\"alternativeDose_1\",\"alternativeDuration\":\"alternativeDuration_1\"}"+
				"]"+
				"}"
				;
		
		String json= restTemplate.postForObject(SERVER_URI+"/rest/print/getlisttr/?access_token="+jobjauth.getString("value"), request,  String.class);
		 logger.info(json);
		
	}
	
	
private static void testGetAllRisktrippClassDrugGIMIprint_getlisttr_authRealDIN() {
		
		RestTemplate restTemplate = new RestTemplate();
		String user="trrc";
		String password="moxxi";
				String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

				JSONObject jobjauth= new JSONObject(jsonA);
				 logger.info(jsonA);
					
				 logger.info(jobjauth.getString("value"));

		/*String request ="{\"patient\":{\"patid\":12345,\"fails\":3,\"age\":84,\"sexe\":1,\"gb\":1,\"ci\":1},"+
				"\"drugs\":"+
				"["+
				"{\"din\":\"din_0\",\"codegen\":\"codegen_0\",\"quantity\":\"10\",\"duration\":\"10\",\"strength\":\"strength_0\",\"whoDose\":\"whoDose_0\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"}"+
					"]"+
				"}"
				;*/
		
	/*	String request ="{\"patient\":{\"patid\":12345,\"fails\":3,\"age\":84,\"sexe\":1,\"gb\":1,\"ci\":1},"+
				"\"drugs\":"+
				"["+
				"{\"din\":\"02247244\",\"codegen\":\"13067969\",\"quantity\":\"60\",\"duration\":\"30\",\"strength\":\"10\",\"whoDose\":\"300\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"}"+
				"]"+
				"}"
				;*/
		
		String request ="{\"trippProfile\":{\"patid\":12345,\"fails\":0,\"age\":\"84.46\",\"sexe\":1,\"gb\":0,\"ci\":0},"+
				
			//	String request ="{\"patient\":{\"patid\":12345,\"fails\":0,\"age\":\"84.46\",\"sexe\":1,\"gb\":0,\"ci\":0},"+
				"\"drugs\":"+
				"["+
				//"{\"din\":\"02247244\",\"codegen\":\"13067969\",\"quantity\":\"60\",\"duration\":\"30\",\"strength\":\"10\",\"whoDose\":\"300\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"},"+
				"{\"din\":\"00029173\",\"codegen\":\"28160807\",\"quantity\":\"30\",\"duration\":\"30\",\"strength\":\"5\",\"whoDose\":\"10\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"}"+
				
				"]"+
				"}"
				;
		
		
		
		
		String json= restTemplate.postForObject(SERVER_URI+"/rest/print/getlisttr/?access_token="+jobjauth.getString("value"), request,  String.class);
		 logger.info(json);
		
	}
	




private static void testPrintSaveAllRisktrippClassDrugGIMIprint_getlisttr_authRealDIN() {
	
	RestTemplate restTemplate = new RestTemplate();
	String user="trrc";
	String password="moxxi";
			String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

			JSONObject jobjauth= new JSONObject(jsonA);
			 logger.info(jsonA);
				
			 logger.info(jobjauth.getString("value"));

	
	String request ="{\"trippProfile\":{\"patid\":12345,\"fails\":25,\"age\":\"84.46\",\"sexe\":1,\"gb\":0,\"ci\":0},"+
			"\"drugs\":"+
			"["+
			"{\"din\":\"02247244\",\"codegen\":\"13067969\",\"quantity\":\"60\",\"duration\":\"30\",\"strength\":\"10\",\"whoDose\":\"300\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"},"+
			"{\"din\":\"00726354\",\"codegen\":\"13067972\",\"quantity\":\"30\",\"duration\":\"30\",\"strength\":\"5\",\"whoDose\":\"10\",\"alternativeDose\":\"alternativeDose_0\",\"alternativeDuration\":\"alternativeDuration_0\"}"+



			
			"]"+
			"}"
			;
	
	
	
	
	String json= restTemplate.postForObject(SERVER_URI+"/rest/printsave/getlisttr/?access_token="+jobjauth.getString("value"), request,  String.class);
	 logger.info(json);
	
}





	
	private static void testGetAllRisktrippDrugTESTAuth() {
		RestTemplate restTemplate = new RestTemplate();
		
		

		String user="trrc";
		String password="moxxi";
				String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

				JSONObject jobjauth= new JSONObject(jsonA);
				 logger.info(jsonA);
				
			
				 logger.info(jobjauth.getString("value"));
				 
		String json= restTemplate.getForObject(SERVER_URI+"/rest/allrisk/alltrippdr/alltrippbn/?access_token="+jobjauth.getString("value"), String.class);
		
		
		
		System.out.println("json->"+json+"<-");

	}
	
	
	private static void testGetAllDrugsByTradeTESTAuth() {
		RestTemplate restTemplate = new RestTemplate();
		
		

		String user="trrc";
		String password="moxxi";
				String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

				JSONObject jobjauth= new JSONObject(jsonA);
				 logger.info(jsonA);
				
			
				 logger.info(jobjauth.getString("value"));
				 
		String json= restTemplate.getForObject(SERVER_URI+"/rest/g1/asf/resp/CLOZAPINE?access_token="+jobjauth.getString("value"), String.class);
		
		
		
		System.out.println("json->"+json+"<-");

	}
	
	
	
	private static void testGetAllDrugsByCodegenTESTAuth() {
		RestTemplate restTemplate = new RestTemplate();
		
		

		String user="trrc";
		String password="moxxi";
				String jsonA= restTemplate.getForObject(SERVER_URI+"/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username="+user+"&password="+password, String.class);

				JSONObject jobjauth= new JSONObject(jsonA);
				 logger.info(jsonA);
				
			
				 logger.info(jobjauth.getString("value"));
				 
		String json= restTemplate.getForObject(SERVER_URI+"/rest/g2/cadegen/resp/CLOZAPINE?access_token="+jobjauth.getString("value"), String.class);
		
		
		
		System.out.println("json->"+json+"<-");

	}
	
	
	
	
	public static void printDrugData(DrugTest dr){
		System.out.println("ID="+dr.getId()+",Name="+dr.getName()+",CreatedDate="+dr.getCreatedDate());
	}
}
