package com.muse.model;

/**
 * 下載實體與详情实体
 * 
 * @author andreby
 *
 */
public class ConvergenceDetailAndDLModel {
	private Songs songs;
	
	private Data data;
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Songs getSongs() {
		return songs;
	}

	public void setSongs(Songs songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "ConvergenceDetailAndDLModel [Data=" + data + ", songs=" + songs + "]";
	}

}
