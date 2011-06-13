package model;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
@Embeddable
public class Location {
	@Column(name="LONGITUDE")
	private double longitude;
	@Column(name="LATITUDE")
	private double latitude;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long locationId;
	
	public Location (double lat, double lng){
		this.longitude=lng;
		this.latitude=lat;
	}

    public Location() {
    }

    public double getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

     public long getLocationId() {
        return locationId;
    }


    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

}
