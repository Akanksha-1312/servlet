
package com.samples.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productinfo")
public class ProductInfo {

	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;	

    
	@Column(name="cost")
	private long cost;

 ProductInfo(){}

@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}


public ProductInfo(int id,  String name,long cost) {
	
	this.id = id;
	this.name = name;
	this.cost = cost;
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public long getCost() {
	return cost;
}


public void setCost(long cost) {
	this.cost = cost;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


}