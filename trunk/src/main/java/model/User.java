package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="USER")

public class User {
	
	@Column(name= "USER_NICKNAME", nullable = false, unique=true)
	private String nickName;
	@Column(name= "USER_PASS", nullable = false)
	private String password;
    @Column(nullable = false,unique=true)
    private String email;
    @Column(nullable = false)
    private boolean isAdmin;
	@Embedded @OneToOne
	private Location lastLocation;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userId;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<User> friends;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Place> favouritePlaces;


	public User(String name, String pass, String mail){
		this.nickName=name;
		this.password=pass;
        this.email=mail;
        setAdmin(false);
        friends = new HashSet<User>();
        favouritePlaces = new HashSet<Place>();


	}

     public User() {
    }

    public void addFriend(User friend){
       friends.add(friend);
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
		return userId;
	}
	
	public void setId(long id){
		this.userId=id;
	}
	
	
	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location lastLocation) {
		this.lastLocation = lastLocation;
	}

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public void setFavouritePlaces(Set<Place> favouritePlaces) {
        this.favouritePlaces = favouritePlaces;
    }

    public Set<Place> getFavouritePlaces() {

        return favouritePlaces;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
      public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
