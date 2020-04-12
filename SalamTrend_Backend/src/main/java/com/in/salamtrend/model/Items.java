package com.in.salamtrend.model;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="TBL_ITEMS")

public class Items implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "I_id", unique = true, nullable = false)
	private Integer item_id;
	private double item_price;
	private Date item_expiry;
	
	public Items() {
		
	}
	
	public Items(Integer item_id, double item_price, Date item_expiry) {
		super();
		this.item_id = item_id;
		this.item_price = item_price;
		this.item_expiry = item_expiry;
	}

	//@OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public double getItem_price() {
		return item_price;
	}
	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}
	public Date getItem_expiry() {
		return item_expiry;
	}
	public void setItem_expiry(Date item_expiry) {
		this.item_expiry = item_expiry;
	}
	
	

}
