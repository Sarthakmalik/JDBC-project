package com.ibm.customer_management_project.dto;

import java.util.Objects;

public class Product {
	private int pid;
	private String pname;
	private double pprice;
	private String avaliable;
	private int cid;
	/**
	 * 
	 */
	public Product() {
		super();
	}
	
	
	/**
	 * @param pid
	 * @param pname
	 * @param pprice
	 * @param avaliable
	 */
	public Product(int pid, String pname, double pprice, String avaliable) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.avaliable = avaliable;
	}


	/**
	 * @param pid
	 * @param pname
	 * @param pprice
	 * @param avaliable
	 * @param cid
	 */
	public Product(int pid, String pname, double pprice, String avaliable, int cid) {
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.avaliable = avaliable;
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	public String getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(String avaliable) {
		this.avaliable = avaliable;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", avaliable=" + avaliable + ", cid="
				+ cid + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(avaliable, cid, pid, pname, pprice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(avaliable, other.avaliable) && cid == other.cid && pid == other.pid
				&& Objects.equals(pname, other.pname)
				&& Double.doubleToLongBits(pprice) == Double.doubleToLongBits(other.pprice);
	}
	
	
	
	
}
