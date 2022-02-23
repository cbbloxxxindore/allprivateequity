package com.vanguard.retail.allprivateequity.webservice.service;

import java.util.List;
import java.util.Optional;

import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;

public interface InvestorService {
	Optional<Investor> saveInvestor(InvestorRequest investorRequest);
    Optional<Investor> updateInvestor(InvestorRequest investorRequest);
    Optional<Investor> getIvestorByID(Integer investorId);
    List<Investor> getAllInvestor();

}
