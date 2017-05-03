package service;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mcgill.risk.spring.configuration.AppConfig;
import org.mcgill.risk.spring.model.TrippProfile;
import org.mcgill.risk.spring.model.TrippProfileRisk;
import org.mcgill.risk.spring.model.TrippProfileRiskDrug;
import org.mcgill.risk.spring.service.TrippDrugService;
import org.mcgill.risk.spring.service.TrippProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/*To check with Hicham
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TrippProfileTest {
	
	@Autowired
	TrippProfileService trippProfileService;
	@Autowired
	TrippDrugService trippDrugService;
	
	
	@Test
	public void testGetAllGProfile() {

		
		assertTrue(true);
	}
	
	
	
	/**
	 * Testing  all tripp profile list from database
	 */
//	@Test
	public void testGetAllProfile() {

		List<TrippProfile> trippProfileList = trippProfileService.getAllTrippProfiles();

		assertTrue("List is not empty", !trippProfileList.isEmpty());
	}
	
	
	/**
	 * Testing  all tripp risk profile list from database
	 */
/*	@Test
	public void testGetAllTrippRiskProfiles()  {

		List<TrippProfileRisk> trippRiskProfileList = trippProfileService.getAllTrippRiskProfiles() ;

		assertTrue("List is not empty", !trippRiskProfileList.isEmpty());
	}
	*/
	
	
	
//	@Test
	public void addTrippAllProfile() {
		
		
		//Create trip profile
		
		// @Table(name="TRIPP_PROFILE")
		
		TrippProfile trippProfile =new TrippProfile();
		
		
		
		
		trippProfile.setPatientId(new BigDecimal(300));
		trippProfile.setSessionID("sessionAgimdgdgdg20220");
		trippProfile.setCreationDate(new Date());
		trippProfile.setAge(new BigDecimal(20));
		trippProfile.setFemale(true);
		trippProfile.setConditionGB(false);
		trippProfile.setConditionCI(false);
		trippProfile.setFallCount(50);
		trippProfile.setRiskNonMod(new BigDecimal(6));
		trippProfile.setHazardNonMod(new BigDecimal(5));
		
		TrippProfile persistedTrippProfile=(TrippProfile) trippProfileService.addTrippProfile(trippProfile);
		
		// create tripp profiles risk
		//1
	//	@Table(name="TRIPP_PROFILE_RISK")
		
		TrippProfileRisk trippProfileRisk1= new TrippProfileRisk();
	
		trippProfileRisk1.setTrippProfile(persistedTrippProfile);
		trippProfileRisk1.setRiskTotal(new BigDecimal(1));
		trippProfileRisk1.setHazardTotal(new BigDecimal(0));
		trippProfileRisk1.setHazardMod(new BigDecimal(0));
		trippProfileRisk1.setClass_2(new BigDecimal(0));
		trippProfileRisk1.setClass_4(new BigDecimal(0));
		trippProfileRisk1.setClass_5(new BigDecimal(0));
		trippProfileRisk1.setClass_9(new BigDecimal(0));
		trippProfileRisk1.setClass_16(new BigDecimal(0));
		trippProfileRisk1.setClass_17(new BigDecimal(0));
		trippProfileRisk1.setClass_18(new BigDecimal(0));
		trippProfileRisk1.setClass_7(new BigDecimal(0));
		trippProfileRisk1.setClass_13(new BigDecimal(0));
		
		TrippProfileRisk persistedTrippProfileRisk1=trippProfileService.addTrippProfileRisk(trippProfileRisk1);
		
		//@Table(name="TRIPP_PROFILE_RISK")
		
		//2
		TrippProfileRisk trippProfileRisk2= new TrippProfileRisk();
		trippProfileRisk2.setTrippProfile(persistedTrippProfile);
		trippProfileRisk2.setRiskTotal(new BigDecimal(1));
		trippProfileRisk2.setHazardTotal(new BigDecimal(0));
		trippProfileRisk2.setHazardMod(new BigDecimal(0));
		trippProfileRisk2.setClass_2(new BigDecimal(0));
		trippProfileRisk2.setClass_4(new BigDecimal(0));
		trippProfileRisk2.setClass_5(new BigDecimal(0));
		trippProfileRisk2.setClass_9(new BigDecimal(0));
		trippProfileRisk2.setClass_16(new BigDecimal(0));
		trippProfileRisk2.setClass_17(new BigDecimal(0));
		trippProfileRisk2.setClass_18(new BigDecimal(0));
		trippProfileRisk2.setClass_7(new BigDecimal(0));
		trippProfileRisk2.setClass_13(new BigDecimal(0));
		TrippProfileRisk persistedTrippProfileRisk2=trippProfileService.addTrippProfileRisk(trippProfileRisk2);
		
		
		// create trip risk drugs 
		//for 1
		
		List<Long> listDrugIdRsik1=new ArrayList<Long>();
		listDrugIdRsik1.add(13072762L);
		listDrugIdRsik1.add(13072763L);
		
		for (Long drugId:listDrugIdRsik1){
		//@Table(name="TRIPP_PROFILE_RISK_DRUG")
			TrippProfileRiskDrug  trippProfileRiskDrug=new TrippProfileRiskDrug();
			trippProfileRiskDrug.setDrugId(drugId);
			trippProfileRiskDrug.setTrippProfileRisk(persistedTrippProfileRisk1);
			trippProfileRiskDrug.setQuantity(new BigDecimal(1));
			trippProfileRiskDrug.setDurationDays(1);
			trippProfileRiskDrug.setStatus("statuts 1");
			trippProfileRiskDrug.setDrugType("type1");
			trippProfileService.addTrippProfileRiskDrug(trippProfileRiskDrug);
			
		}
		
		
		//for 2
		List<Long> listDrugIdRsik2=new ArrayList<Long>();
		listDrugIdRsik2.add(13072764L);
		listDrugIdRsik2.add(13072765L);
		for (Long drugId:listDrugIdRsik2){
		//@Table(name="TRIPP_PROFILE_RISK_DRUG")
			TrippProfileRiskDrug  trippProfileRiskDrug=new TrippProfileRiskDrug();
			trippProfileRiskDrug.setDrugId(drugId);
			trippProfileRiskDrug.setTrippProfileRisk(persistedTrippProfileRisk2);
			trippProfileRiskDrug.setQuantity(new BigDecimal(2));
			trippProfileRiskDrug.setDurationDays(2);
			trippProfileRiskDrug.setStatus("statuts 2");
			trippProfileRiskDrug.setDrugType("type2");
			trippProfileService.addTrippProfileRiskDrug(trippProfileRiskDrug);
			
		}
		
		
	
		
	}

	@Test
	public void testIsTrippDrug(){
		
		boolean res= trippDrugService.isTrippDrug("13073305");
		assertTrue("The drug is a tripp drug", res);
		
	}

	

}
