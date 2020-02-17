package com.mycompany.A1prj;

public class Cyborg extends MoveableObject implements ISteerable {

    // Variables uniquely for Cyborg
    private int steeringDirection;
    private int maxSpeed;
    private int energyLevel;
    private int energyConsumptionRate;
    private int damageLevel;
    private int lastBaseReached;
    private int maxDamage = 20;

    // Constructor
    public Cyborg(float x, float y) {
        this.steeringDirection = 0;
        this.maxSpeed = 40;
        this.energyLevel = 20;
        this.energyConsumptionRate = 1;
        this.damageLevel = 0;
        this.lastBaseReached = 1;
        this.setSize(40);
        this.setSpeed(5);
        this.setHeading(0);
        this.setRGB(0, 0, 255);
        this.setLocation(x, y);
    }

    public int getSteeringDirection() {
        return steeringDirection;
    }

    public void setSteeringDirection(int std) {
        this.steeringDirection = std;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int mxSpd) {
        this.maxSpeed = mxSpd;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int eLvl) {
        this.energyLevel = eLvl;
    }

    public int getEConsumpRte() {
        return energyConsumptionRate;
    }

    public void setEConsumpRte(int eCR) {
        this.energyConsumptionRate = eCR;
    }

    public int getMaxDmg() {
        return maxDamage;
    }

    public int getDmgLvl() {
        return damageLevel;
    }

    // Sets damage for Cyborg when hit
    public void setDmgLvl(int damage) {
        if (damage < maxDamage) {
            damageLevel = damage;
        } else {
            damageLevel = maxDamage;
        }
    }

    public int getLastBase() {
        return lastBaseReached;
    }

    public void setLastBase(int base) {
        this.lastBaseReached = base;
    }

    // Reduces energy after each tick
    public void energyLoss() {
        energyLevel -= energyConsumptionRate;
        if (energyLevel <= 0) {
            setSpeed(0);
        }
    }

    // Changes steering direction to the right
    public void right() {
        if (getSteeringDirection() + 5 <= 40) {
            this.setSteeringDirection(steeringDirection + 5);
        } else {
            this.setSteeringDirection(40);
        }
    }

    // Changes steering direction to the left
    public void left() {
        if (getSteeringDirection() - 5 >= -40) {
            this.setSteeringDirection(steeringDirection - 5);
        } else {
            this.setSteeringDirection(-40);
        }
    }

    // Method for when Cyborg collides with a Drone 'g' or Cyborg 'c'
    public void collision(char c) {
        if (c == 'g') {
            this.setDmgLvl(damageLevel + 2);
        } else if (c == 'c') {
            this.setDmgLvl(damageLevel + 1);
        }
        ;
        double newMax =  (40 * (1 - ((double) damageLevel / (double) maxDamage)));
        this.setMaxSpeed((int) newMax);
        this.setRGB(0, 0, 10 * (20 - damageLevel));
        if (getSpeed() - 4 >= 0) {
            this.setSpeed(getSpeed() - 4);
        } else {
            this.setSpeed(0);
        }

    }

    // Changes lastbasereached depending on sequence number of base
    public void baseCollision(int baseNum) {
        if (baseNum - lastBaseReached == 1) {
            lastBaseReached = baseNum;
        }
    }

    // Cyborg get energy when it collides with an energy station
    public void energyCollision(int energy) {
        if (energy + energyLevel >= 20) {
            this.setEnergyLevel(20);
        } else {
            this.setEnergyLevel(energyLevel + energy);
        }
    }

    // Method to check is Cyborg is dead
    public boolean isDead() {
        return damageLevel >= maxDamage || energyLevel <= 0;
    }

    // If Cyborg is dead, and still has a life, it will reset its values and start
    // over
    public void newLife(float x, float y) {
        this.setSteeringDirection(0);
        this.setEnergyLevel(20);
        this.setDmgLvl(0);
        this.setLastBase(1);
        this.setSpeed(0);
        this.setMaxSpeed(40);
        this.setHeading(0);
        this.setRGB(0, 0, 255);
        this.setLocation(x, y);
    }

    // Changes heading of Cyborg
    public void steer() {
        this.setHeading(steeringDirection);
    }

    public String toString() {
        String parentObj = super.toString();
        String obj = ", Heading = " + getHeading() + ", Speed = " + getSpeed() + ", Size = " + getSize()
                + ", Maximum Speed = " + getMaxSpeed() + ", Steering Direction = " + getSteeringDirection()
                + ", Energy Level = " + getEnergyLevel() + ", Damage Level = " + getDmgLvl();
        return "Cyborg: " + parentObj + obj;
    }

}