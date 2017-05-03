package com.journaldev.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.controller.DrugRestURIConstants;
import com.journaldev.spring.model.DrugTest;



public class TestSpringRestExample {
	public static final String HOST = "localhost";
	

	public static final String SERVER_URI = "http://"+ HOST+":8080/risk-rest-web-service-0.1";
	
	
	
	public static void main(String args[]){
		/*Diferent test cases to keep and chack what to trabsfer to Junit test to check with Hicham
		*/
		
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
	
		 testGetAllRisktrippClassDrugTEST();
		
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
	
	// links to test
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
	
	public static void printDrugData(DrugTest dr){
		System.out.println("ID="+dr.getId()+",Name="+dr.getName()+",CreatedDate="+dr.getCreatedDate());
	}
}
