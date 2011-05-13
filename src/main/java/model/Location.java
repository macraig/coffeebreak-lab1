package model;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
@Embeddable
public class Location {
	@Column(name="LONGITUDE")
	private long longitude;
	@Column(name="LATITUDE")
	private long latitude;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Location (long lati, long longi){
		this.longitude=longi;
		this.latitude=lati;
	}

    public Location() {
    }

    public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	
}
