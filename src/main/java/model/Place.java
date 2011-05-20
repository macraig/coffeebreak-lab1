package model;

import javax.persistence.*;

@Entity
@Table(name="PLACE")

public class Place {
	
	@Column(name="PLACE_NAME", nullable=false)
	private String name;
	@Embedded @OneToOne(targetEntity = model.Location.class)
	private Location location;
	@Column(name="ADDRESS", nullable = false)
	private String address;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long placeId;

    public Place() {
    }

    public Place(String name, String address){
		this.name=name;
		this.address=address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	
	public void setLocation(Location location) {
		this.location = location;
	}
	public Location getLocation() {
		return location;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}

	public void setId(long id) {
		this.placeId = id;
	}

	public long getId() {
		return placeId;
	}
	
	
	

}
