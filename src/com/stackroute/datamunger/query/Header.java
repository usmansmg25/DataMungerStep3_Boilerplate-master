package com.stackroute.datamunger.query;

public class Header {
	String[] header;
	
	public Header(String[] header) {
		super();
		this.header = header;
	}

	/*
	 * This class should contain a member variable which is a String array, to hold
	 * the headers.
	 */
	
	public String[] getHeader() {
		return header;
	}

	public void setHeader(String[] header) {
		this.header = header;
	}

	public String[] getHeaders() {
		return header;
	}

}
