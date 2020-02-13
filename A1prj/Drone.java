package com.mycompany.A1prj;

import java.util.Random;

public class Drone extends MoveableObject {

    public Random rangeInit = new Random();

    public Drone() {
        this.setSize(rangeInit.nextInt(40) + 10);
        this.setHeading(rangeInit.nextInt(360));
        this.setSpeed(rangeInit.nextInt(5) + 5);
        this.setRGB(0, 0, 0);
        this.setLocation(rangeInit.nextInt(1000), rangeInit.nextInt(1000));
    }

    public void changeHeading() {
        int[] headings = new int[2];
        headings[0] = -5;
        headings[1] = 5;

        if (getLocation().getX() > 1000 || getLocation().getX() < 0 || getLocation().getY() > 1000
                || getLocation().getY() < 0) {
            setHeading(getHeading() + 180);
        } else {
            setHeading(headings[rangeInit.nextInt(1)]);
        }
    }

    public String toString() {
        String parentObj = super.toString();
        String obj = ", Heading = " + getHeading() + ", Speed = " + getSpeed() + ", Size = " + getSize();
        return "Drone: " + parentObj + obj;
    }

}