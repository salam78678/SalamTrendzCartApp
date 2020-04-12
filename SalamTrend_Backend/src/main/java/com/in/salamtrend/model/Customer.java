package com.in.salamtrend.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CUSTOMER")
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid" )

	private Integer id;
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String customer_mail;
	@OneToMany( targetEntity = Items.class ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "c_id")
	private List<Items> items;
	

	public Customer(Integer id, String customer_mail, List<Items> items) {
		super();
		this.id = id;
		this.customer_mail = customer_mail;
		this.items = items;
	}


	public Customer() {
	this.items=new ArrayList<>();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCustomer_mail() {
		return customer_mail;
	}


	public void setCustomer_mail(String customer_mail) {
		this.customer_mail = customer_mail;
	}


	public List<Items> getItems() {
		return items;
	}


	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	

	
}
