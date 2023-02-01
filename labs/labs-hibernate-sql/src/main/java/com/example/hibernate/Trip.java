package com.example.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TRIP")
public class Trip {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="route")
    private String route;

    @OneToMany(mappedBy="trip")
    private List<Passenger> passengerList = new ArrayList<Passenger>();

    public Trip() {
    }

    public Trip(int id, String route) {
        this.id = id;
        this.route= route;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

}
