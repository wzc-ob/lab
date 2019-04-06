package com.mis.model;

import java.sql.Date;

public class Filefolder {
        private String f_route;

    public String getF_route() {
        return f_route;
    }

    public void setF_route(String f_route) {
        this.f_route = f_route;
    }
	private Date f_date ;
	private long f_size; 
	private String f_name; 
	private String f_type;
	public Date getF_date() {
		return f_date;
	}
	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	public long getF_size() {
		return f_size;
	}
	public void setF_size(long f_size) {
		this.f_size = f_size;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_type() {
		return f_type;
	}
	public void setF_type(String f_type) {
		this.f_type = f_type;
	}
	
}
