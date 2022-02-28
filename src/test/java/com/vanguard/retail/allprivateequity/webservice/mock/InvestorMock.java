package com.vanguard.retail.allprivateequity.webservice.mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;

public interface InvestorMock {
	public static InvestorRequest  getInvestorRequest( )
	 {
		InvestorRequest investorRequest= new InvestorRequest();
		investorRequest.setInvestorId(12);
		investorRequest.setInvestorLegalName("abhijeet");
		investorRequest.setInvestorShortName("singh");
		 
		 investorRequest.setLimitedPartnerId("12");
		 investorRequest.setParentInvestorId("123");
	
	
		 
		 investorRequest.setParentLongName("abhijeet");
		 return investorRequest;
		 
	 }
	
	public static  Optional<Investor>  getInvestor()
	 {
		 Investor investor= new Investor();
		 investor.setInvestorId(getInvestorRequest().getInvestorId());
		 investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(getInvestorRequest().getInvestorLegalName());
		 investor.setInvestorShortName(getInvestorRequest().getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(getInvestorRequest().getLimitedPartnerId());
		 investor.setParentInvestorId(getInvestorRequest().getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(getInvestorRequest().getParentLongName());
		 Optional<Investor> optional= Optional.of(investor);
		 return optional;
		 
	 }
	public static  List<Investor>  getListOfInvestor()
	 {
		List<Investor>investors=new ArrayList<>();
		 Investor investor= new Investor();
		 investor.setInvestorId(getInvestorRequest().getInvestorId());
		 investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(getInvestorRequest().getInvestorLegalName());
		 investor.setInvestorShortName(getInvestorRequest().getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(getInvestorRequest().getLimitedPartnerId());
		 investor.setParentInvestorId(getInvestorRequest().getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(getInvestorRequest().getParentLongName());
		 investors.add(investor);
		 return investors;
		 
	 }
	public static  Investor  getInvestor1()
	 {
		 Investor investor= new Investor();
		 investor.setInvestorId(getInvestorRequest().getInvestorId());
		 investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(getInvestorRequest().getInvestorLegalName());
		 investor.setInvestorShortName(getInvestorRequest().getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(getInvestorRequest().getLimitedPartnerId());
		 investor.setParentInvestorId(getInvestorRequest().getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(getInvestorRequest().getParentLongName());
		 return investor;
		 
	 }
}
