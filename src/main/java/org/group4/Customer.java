package org.group4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Address address;
    private double funds;
    private int credits;
    private int missedReservations;
    private final List<Reservation> reservations = new ArrayList<>();

    public Customer(String uniqueId, String firstName, String lastName, Address address, double funds) {
        this.id = (uniqueId == null) ? UUID.randomUUID().toString() : uniqueId;
        this.firstName = firstName;
        // NOTE: We must consider the case when this is optional, like with Beyonce
        this.lastName = lastName;
        this.address = address;
        this.funds = funds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMissedReservations() {
        return missedReservations;
    }

    public void setMissedReservations(int missedReservations) {
        this.missedReservations = missedReservations;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public boolean checkRes(Reservation reservation) {
        for (Reservation r : reservations) {
            if (Duration.between(r.getDateTime(), reservation.getDateTime()).abs().compareTo(Duration.ofHours(2)) > 0) {
                return false;
            }
        }
        return true;
    }

    public void addRes(Reservation reservation) {
        reservations.add(reservation);
    }
}
