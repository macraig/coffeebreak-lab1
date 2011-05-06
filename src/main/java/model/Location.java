package model;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
@Embeddable
public class Location {
	@Column(name="LONGITUD") 
	private long longitud;
	@Column(name="LATITUDE")
	private long latitude;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Location (long longi, long lati){
		this.longitud=longi;
		this.latitude=lati;
	}

    public Location() {
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
