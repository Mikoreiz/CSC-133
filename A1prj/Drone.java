package com.mycompany.A1prj;

import java.util.Random;

public class Drone extends MoveableObject {

    // Will use random for heading change
    public Random rangeInit = new Random();

    // Constructor
    public Drone() {
        this.setSize(rangeInit.nextInt(40) + 10);
        this.setHeading(rangeInit.nextInt(360));
        this.setSpeed(rangeInit.nextInt(5) + 5);
        this.setRGB(0, 0, 0);
        this.setLocation(rangeInit.nextInt(1000), rangeInit.nextInt(1000));
    }

    // Changes heading. Uses array of size 2 to randomly choose between 5 and -5.
    public void changeHeading() {
        int[] headings = new int[2];
        headings[0] = -5;
        headings[1] = 5;

        // If drone touches the end of the map, it will make a 180 turn
        if (getLocation().getX() > 1000 || getLocation().getX() < 0 || getLocation().getY() > 1000
                || getLocation().getY() < 0) {
            setHeading(getHeading() + 180);
        } else {
            setHeading(getHeading() + headings[rangeInit.nextInt(2)]);
        }
    }

    public String toString() {
        String parentObj = super.toString();
        String obj = ", Heading = " + getHeading() + ", Speed = " + getSpeed() + ", Size = " + getSize();
        return "Drone: " + parentObj + obj;
    }

}