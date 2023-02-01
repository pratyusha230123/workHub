package com.example.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PASSENGER")
public class Passenger {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="TRIP_ID")
    private Trip trip;

    @OneToMany(mappedBy="passenger")
    private List<Ticket> ticketList = new ArrayList<Ticket>();

    public Passenger() {

    }

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addTicket(Ticket ticket){
        ticketList.add(ticket);
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
