package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Embeddable
public class Location {
	@Column(name="LONGITUD") 
	private long longitud;
	@Column(name="LATITUDE")
	private long latitude;
	
	public Location (long longi, long lati){
		this.longitud=longi;
		this.latitude=lati;
	}
	
	public long getLongitud() {
		return longitud;
	}

	public void setLongitud(long longitud) {
		this.longitud = longitud;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
}
