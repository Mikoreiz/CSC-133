package com.mycompany.A1prj;

import java.util.Random;

public class EnergyStation extends FixedObject {

    // Energy capacity for station
    private int capacity;
    // Will use random to determin size and location
    public Random rangeInit = new Random();

    // Constructor
    public EnergyStation() {
        this.setLocation((double) rangeInit.nextInt(1000), (double) rangeInit.nextInt(1000));
        this.setSize(rangeInit.nextInt(40) + 10);
        this.capacity = getSize() / 2;
        this.setRGB(0, 255, 0);

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) {
        this.capacity = cap;
    }

    // Once energy is taken, it will set values again, along with a new location
    public void replace() {
        this.setLocation((double) rangeInit.nextInt(1000), (double) rangeInit.nextInt(1000));
        this.setSize(rangeInit.nextInt(40) + 10);
        this.capacity = getSize() / 2;
    }

    public String toString() {
        String parentObj = super.toString();
        String obj = ", Size = " + getSize() + ", Capacity = " + getCapacity();
        return "Energy Station: " + parentObj + obj;
    }
}