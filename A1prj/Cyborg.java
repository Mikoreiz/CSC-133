package com.mycompany.A1prj;

public class Cyborg extends MoveableObject implements ISteerable {

    private int steeringDirection;
    private int maxSpeed;
    private int energyLevel;
    private int energyConsumptionRate;
    private int damageLevel;
    private int lastBaseReached;
    private int maxDamage = 20;

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
        return this.maxDamage;
    }

    public int getDmgLvl() {
        return damageLevel;
    }

    public void setDmgLvl(int damage) {
        if (damage < maxDamage) {
            damageLevel += damage;
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

    public void energyLoss() {
        energyLevel -= energyConsumptionRate;
        if (energyLevel <= 0) {
            setSpeed(0);
        }
    }

    public void right() {
        if (steeringDirection <= 40) {
            this.setSteeringDirection(steeringDirection + 5);
        }
    }

    public void left() {
        if (steeringDirection >= -40) {
            this.setSteeringDirection(steeringDirection - 5);
        }
    }

    public void droneCollision() {
        this.setDmgLvl(damageLevel + 2);
        this.setSpeed(getSpeed() - 5);
        this.setMaxSpeed((int) (40 * (1 - (damageLevel / maxDamage))));
        this.setRGB(0, 0, 10 * (20 - damageLevel));
    }

    public void baseCollision(int baseNum) {
        if (baseNum - lastBaseReached == 1) {
            lastBaseReached = baseNum;
        }
    }

    public void energyCollision(int energy) {
        if (energy + energyLevel >= 20) {
            this.setEnergyLevel(20);
        } else {
            this.setEnergyLevel(energyLevel + energy);
        }
    }

    public boolean isDead() {
        return damageLevel == maxDamage && energyLevel <= 0;
    }

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

    @Override
    public void steer(int amt) {
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