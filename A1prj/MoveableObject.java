package com.mycompany.A1prj;

public abstract class MoveableObject extends GameObject {
    private int heading;
    private int speed;

    public void move() {
        double deltaX = Math.round(Math.cos(Math.toRadians(90 - heading)) * speed);
        double deltaY = Math.round(Math.sin(Math.toRadians(90 - heading)) * speed);

        setLocation((float) getLocation().getX() + deltaX, (float) getLocation().getY() + deltaY);
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int h) {
        heading = h;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int spd) {
    	speed = spd;
    }

    public String toString() {
        String parentObj = super.toString();

        return parentObj;
    }
}