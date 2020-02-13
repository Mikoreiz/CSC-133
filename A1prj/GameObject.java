package com.mycompany.A1prj;

import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
    private int size;
    private Point2D location;
    private int rgb;

    public int getSize() {
        return size;
    }

    public void setSize(int s) {
        size = s;
    }

    public void setLocation(double x, double y) {

        double xCoord = x;
        double yCoord = y;

        location = new Point2D(xCoord, yCoord);
    }

    public Point2D getLocation() {
        return location;
    }

    public int getRGB() {
        return rgb;
    }

    public void setRGB(int r, int g, int b) {
        rgb = ColorUtil.rgb(r, g, b);
    }

    public String toString() {
        String obj = " Location = [" + location.getX() + ", " + location.getY() + "], Color = [" + ColorUtil.red(rgb)
                + ", " + ColorUtil.green(rgb) + ", " + ColorUtil.blue(rgb) + "]";

        return obj;
    }
}