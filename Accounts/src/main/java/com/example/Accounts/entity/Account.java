package com.example.Accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @ToString
public class Account extends BaseEntity{
	
	 @Column(name="customer_id")
	    private Long customerId;

	    @Column(name="account_number")
	    @Id
	    private Long accountNumber;

	    @Column(name="account_type")
	    private String accountType;

	    @Column(name="branch_address")
	    private String branchAddress;

}
