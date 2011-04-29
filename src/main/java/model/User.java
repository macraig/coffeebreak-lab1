package model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="USER")

public class User {
	
	@Column(name= "USER_NICKNAME", nullable = false, unique=true)
	private String nickName;
	@Column(name= "USER_PASS", nullable = false)
	private String password;
	@Embedded @OneToOne
	private Location lastLocation;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	//@ManyToMany(targetEntity=model.User.class, fetch = FetchType.EAGER)
	//private List<User> friends;
	
	public User(String name, String pass){
		this.nickName=name;
		this.password=pass;
	}
	
	public String getNickName(){
		return nickName;
	}

	public void setNickName(String userName) {
		this.nickName = userName;
	}


	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	
	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}
	

	

	
}

