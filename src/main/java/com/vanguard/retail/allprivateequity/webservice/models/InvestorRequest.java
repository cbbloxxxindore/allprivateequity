package com.vanguard.retail.allprivateequity.webservice.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Setter
@Getter
@ToString
public class InvestorRequest {

public static final String REQUIRED_FIELD="value cant be null or empty";
@NotNull(message =REQUIRED_FIELD )
private int investorId;

	@NotBlank(message =REQUIRED_FIELD )
 private String  limitedPartnerId;
	@NotBlank(message =REQUIRED_FIELD )
 private String investorLegalName;
	@NotBlank(message =REQUIRED_FIELD )
 private String investorShortName;
	@NotBlank(message =REQUIRED_FIELD )
 private String parentLongName;
	@NotBlank(message =REQUIRED_FIELD )
 private String parentInvestorId;
	

}
