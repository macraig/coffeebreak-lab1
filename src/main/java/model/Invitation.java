package model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Pablo
 * Date: 6/24/11
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="INVITATION")
public class Invitation {
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @OneToOne
    @Embedded
    Place place;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<User> users;
    @Column
    String date;
    	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long placeId;

    public Invitation (){

    }
    public Invitation (Place place, Set<User> users, String date){
        this.place=place;
        this.users=users;
        this.date=date;
    }




}
