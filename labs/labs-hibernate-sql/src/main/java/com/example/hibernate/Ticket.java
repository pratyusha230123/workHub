package com.example.hibernate;

import javax.persistence.*;

@Entity
@Table(name="TICKET")
public class Ticket {

    @Id
    @Column(name="ID")
    private int id;

    @Column(name="SEAT_NUMBER")
    private String seatNum;

    @ManyToOne
    @JoinColumn(name="PASSENGER_ID")
    private Passenger passenger;

    public Ticket() {

    }

    public Ticket(int id, String seatNum) {
        this.id = id;
        this.seatNum = seatNum;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
