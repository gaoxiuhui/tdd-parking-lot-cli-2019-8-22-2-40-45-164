package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity; //容量
     //票和车相对应 一张票对应一辆车
    private Map<ParkingTicket, Car> cars = new HashMap<>();
     //构造器 ，定义容量
    public ParkingLot() {
        this(10);
    }
    
    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }
    // cars.size() 得到的有效的停车位置
    public int getAvailableParkingPosition() {
        return capacity -cars.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<ParkingTicket, Car> getCars() {
        return cars;
    }

    public void setCars(Map<ParkingTicket, Car> cars) {
        this.cars = cars;
    }
    
    public ParkingTicket park(Car car) {
    	ParkingTicket  ticket =new ParkingTicket();
    	cars.put(ticket,car);
    	return ticket;
    }
   
    public ParkingTicket fetch(Car car) {
    	ParkingTicket  ticket =new ParkingTicket();
    	cars.put(ticket,car);
    	return ticket;
    }
}
