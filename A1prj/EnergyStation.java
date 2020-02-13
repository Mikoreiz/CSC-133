package com.mycompany.A1prj;

import java.util.Random;

public class EnergyStation extends FixedObject {
    private int capacity;
    public Random rangeInit = new Random();

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