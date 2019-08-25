package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (car != null && this.parkingLot.getCars().size() < this.parkingLot.getCapacity()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            this.parkingLot.getCars().put(parkingTicket, car);
            this.lastErrorMessage = null;
            return parkingTicket;
        } else if (this.parkingLot.getCars().size() >= this.parkingLot.getCapacity()) {
            this.lastErrorMessage = "The parking lot is full.";
            return null;
        } else {
            return null;
        }
    }

    public Car fetch(ParkingTicket ticket) {
        if (ticket != null && this.parkingLot.getCars().get(ticket) != null) {
            Car car = this.parkingLot.getCars().get(ticket);
            this.parkingLot.getCars().remove(ticket);
            this.lastErrorMessage = null;
            return car;
        } else if (ticket == null) {
            this.lastErrorMessage = "Please provide your parking ticket.";
            return null;
        } else {
            this.lastErrorMessage = "Unrecognized parking ticket.";
            return null;
        }
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
