package com.chaitu.solrj;

import org.apache.solr.client.solrj.beans.Field;

public class ATCDao 
{
	public String atcCode;
	public String atcName;
	public Integer length;
	public String getAtcCode() {
		return atcCode;
	}
	@Field("atcCode")
	public void setAtcCode(String atcCode) {
		this.atcCode = atcCode;
	}
	public String getAtcName() {
		return atcName;
	}
	@Field("atcName")
	public void setAtcName(String atcName) {
		this.atcName = atcName;
	}
	public Integer getLength() {
		return length;
	}
	@Field("length")
	public void setLength(Integer length) {
		this.length = length;
	}
	public ATCDao(String atcCode, String atcName, Integer length) {
		super();
		this.atcCode = atcCode;
		this.atcName = atcName;
		this.length = length;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ATC Code : "+this.atcCode+" ATC Name : "+this.atcName+" length : "+this.length;
	}
}
