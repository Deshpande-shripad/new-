package com.TKATasl.Business.Management.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderMan {

	@Id

	int customerid;
	int productid;
	int quantity;

	public OrderMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderMan(int customerid, int productid, int quantity) {
		super();
		this.customerid = customerid;
		this.productid = productid;
		this.quantity = quantity;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderMan [customerid=" + customerid + ", productid=" + productid + ", quantity=" + quantity + "]";
	}

}
