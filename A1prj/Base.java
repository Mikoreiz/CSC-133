package com.mycompany.A1prj;

public class Base extends FixedObject {
    private int seqNum;

    public Base(float x, float y, int seq) {
        this.setLocation(x, y);
        this.seqNum = seq;
        this.setSize(10);
        this.setRGB(255, 0, 0);
    }

    public int getSeq() {
        return seqNum;
    }

    public String toString() {
        String parentObj = super.toString();
        String obj = ", Size = " + getSize() + ", Sequence Number = " + getSeq();
        return "Base: " + parentObj + obj;
    }
}