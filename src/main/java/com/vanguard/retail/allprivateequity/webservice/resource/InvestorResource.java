package com.vanguard.retail.allprivateequity.webservice.resource;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanguard.retail.allprivateequity.webservice.exception.MyPrivateEquityException;
import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;
import com.vanguard.retail.allprivateequity.webservice.service.InvestorService;

@RestController
public class InvestorResource {
	public  static final String  CLASS_NAME= InvestorResource.class.getName()  ; 
	private static final Logger log = LoggerFactory.getLogger(InvestorResource.class);
	private static final String SAVE_METHOD = "createInvestor";
	private static final String EXCEPTION = " Exception occurred while saving Investor";

@Autowired
	 private InvestorService investorService;
@PostMapping("/investors")
	public ResponseEntity<String >createInvestor(@Valid @RequestBody InvestorRequest investorRequest)
	 {
	StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to save investor  resource").toString());
	
		 investorService.saveInvestor(investorRequest);
			log.info(msgBuilder.append("sucessfully  saved investor ").toString());

		 return ResponseEntity.ok("investor has created");
	}
		 catch (Exception e) {
				log.error(EXCEPTION+e);

	throw new MyPrivateEquityException("unprocessable entity");
			} 
		 
	 }

@PutMapping("/investors")
public ResponseEntity<String > updateInvestor(InvestorRequest investorRequest) {
	StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to updated investor  service").toString());
	
	
		 investorService.saveInvestor(investorRequest);
	log.info(msgBuilder.append("sucessfully  updated investor ").toString());
	 return ResponseEntity.ok("investor has created");

	}
	catch (Exception e) {
		log.error(EXCEPTION+e);

throw (new MyPrivateEquityException("unprocessable entity"));
	}
}

@GetMapping("/investors/{investorId}")
public ResponseEntity<String > getIvestorByID(  @PathVariable Integer investorId) {
	StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to get investor by id in  service layer").toString());
	
	Optional<Investor> optional=investorService.getIvestorByID(investorId);
	log.info(msgBuilder.append("sucessfully  get investor by id ").toString());
if (optional.isEmpty()) {
	throw (new MyPrivateEquityException(" investor is not avilable"));

}
return ResponseEntity.ok("investor has updated");

	}
	catch (Exception e) {
		log.error(EXCEPTION+e);

throw (new MyPrivateEquityException(" investor is not avilable"));
	}		
}
@GetMapping("/investors")
public ResponseEntity<List<Investor> > getAllInvestor() {

	StringBuilder msgBuilder= new StringBuilder(CLASS_NAME).append("::"+SAVE_METHOD);
	try {
		 log.info(msgBuilder.append("Attemping to get all investor  service").toString());
	
	List<Investor> investor2=investorService.getAllInvestor();
	log.info(msgBuilder.append("sucessfully  get all investor  ").toString());

	return ResponseEntity.ok(investor2);
	}
	catch (Exception e) {
		log.error(EXCEPTION+e);

throw (new MyPrivateEquityException(" something gone wrong"));
	}		
}
	}



