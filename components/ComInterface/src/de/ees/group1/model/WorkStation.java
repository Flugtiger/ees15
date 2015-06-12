package de.ees.group1.model;

public class WorkStation {
	
	public enum Type {
		DRILL,
		LATHE,
	}
	
	/**
	 * Quality delivered by this workstation
	 */
	private int _quality;
	
	/**
	 * status of the workstation 1: ready, 2: work in progress, 3: out of order
	 */
	private int _status;
	
	/**
	 * id of the workstation
	 */
	private int _id;
	
	public void setQuality(int quality){
		if(quality < 1 || quality > 4)
			throw new IllegalArgumentException("The quality must be a number between 0 and 5");
		this._quality=quality;
	}
	
	public int getQuality(){
		return _quality;
	}
	
	public void setStatus(int status){
		if(status < 1 || status > 3)
			throw new IllegalArgumentException("The status must be a number between 0 and 4");
		this._status=status;
	}
	
	public int getStatus(){
		return _status;
	}
	
	public void setId(int id){
		this._id=id;
	}
	
	public int getId(){
		return _id;
	}
	
	

}
