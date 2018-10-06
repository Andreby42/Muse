package com.muse.model;

import java.util.List;

public class SongDLModel {
	    private List<Data> data;
	    private int code;
	    public void setData(List<Data> data) {
	         this.data = data;
	     }
	     public List<Data> getData() {
	         return data;
	     }

	    public void setCode(int code) {
	         this.code = code;
	     }
	     public int getCode() {
	         return code;
	     }
}