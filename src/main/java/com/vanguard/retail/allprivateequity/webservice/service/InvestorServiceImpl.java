package com.vanguard.retail.allprivateequity.webservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanguard.retail.allprivateequity.webservice.dao.InvestorRepo;
import com.vanguard.retail.allprivateequity.webservice.exception.MyPrivateEquityException;
import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;
@Service
public class InvestorServiceImpl implements InvestorService {
	public  static final String  CLASS_NAME= InvestorServiceImpl.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorServiceImpl.class);
	private static final String SAVE_METHOD = "saveInvestor            ";
	private static final String EXCEPTION = " Exception occurred while saving Investor";
@Autowired
	private InvestorRepo investorRepo;
	
	
	public Optional<Investor> saveInvestor(InvestorRequest investorRequest) {
		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to save investor  service").toString());
		
		Investor investor	=getInvestor(investorRequest);
		Investor investor2=investorRepo.save(investor);
		log.info(msgBuilder.append("sucessfully  saved investor ").toString());

	Optional<Investor>optional	=Optional.of(investor2);
		return optional;
		}
		catch (Exception e) {
			log.error(EXCEPTION+e);

throw (new MyPrivateEquityException("unprocessable entity"));
		}

	}

	public Optional<Investor> updateInvestor(InvestorRequest investorRequest) {
		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to updated investor  service").toString());
		
		Investor investor	=getInvestor(investorRequest);
		Investor investor2=investorRepo.save(investor);
		log.info(msgBuilder.append("sucessfully  updated investor ").toString());

	Optional<Investor>optional	=Optional.of(investor2);
		return optional;
		}
		catch (Exception e) {
			log.error(EXCEPTION+e);

throw (new MyPrivateEquityException("unprocessable entity"));
		}
	}

	
	public Optional<Investor> getIvestorByID(Integer investorId) {
		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to get investor by id  in service").toString());
		
		Optional<Investor> investor2=investorRepo.findById(investorId);
		log.info(msgBuilder.append("sucessfully  get investor by id ").toString());

		return investor2;
		}
		catch (Exception e) {
			log.error(EXCEPTION+e);

throw (new MyPrivateEquityException(" investor is not avilable"));
		}		
	}

	public List<Investor> getAllInvestor() {

		StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
		try {
			 log.info(msgBuilder.append("Attemping to get all investor in service").toString());
		
		List<Investor> investor2=investorRepo.findAll();
		log.info(msgBuilder.append("sucessfully  get all investor  ").toString());

		return investor2;
		}
		catch (Exception e) {
			log.error(EXCEPTION+e);

throw (new MyPrivateEquityException(" something gone wrong"));
		}		
	}
	
	Investor getInvestor( InvestorRequest investorRequest)
	 {
		 Investor investor= new Investor();
		 investor.setInvestorId(123);
		 investor.setEndDate(LocalDateTime.now());
		 investor.setInvestorLegalName(investorRequest.getInvestorLegalName());
		 investor.setInvestorShortName(investorRequest.getInvestorShortName());
		 investor.setInvestorStatus("Active");
		 investor.setLimitedPartnerId(investorRequest.getLimitedPartnerId());
		 investor.setParentInvestorId(investorRequest.getParentInvestorId());
		 investor.setVersionId("1212");
		 investor.setVbaAccountNumber("1212");
		 investor.setPoid("234");
		 investor.setParentLongName(investorRequest.getParentLongName());
		 return investor;
		 
	 }

}
