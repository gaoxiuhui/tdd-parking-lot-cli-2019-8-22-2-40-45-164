package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private  ParkingLot parkingLot; //定义一个停车场
    private String lastErrorMessage; //返回错误信息   
	private ArrayList<ParkingLot> list;
    public ParkingBoy(ParkingLot parkingLot) { //传入一个对象 停车场
        this.parkingLot = parkingLot;
    }
    public ParkingBoy(ArrayList<ParkingLot> list) { //传入一个对象 停车场        
        list.add(parkingLot);
    	this.list = list;
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
