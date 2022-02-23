package com.vanguard.retail.allprivateequity.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vanguard.retail.allprivateequity.webservice.models.Investor;
@Repository
public interface InvestorRepo extends JpaRepository<Investor, Integer> {

}
