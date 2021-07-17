package com.epam;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Triangle> list = new ArrayList<>();

        list.add(new Triangle(4046, 2722, 3700));
        list.add(new Triangle(3778, 2340, 3700));
        list.add(new Triangle(2960, 2920, 2340));
        list.add(new Triangle(3600, 2600, 3090));
        list.add(new Triangle(3521, 2553, 3178));
        list.add(new Triangle(3468, 1708, 2951));
        list.add(new Triangle(2740, 1677, 2947));
        list.add(new Triangle(2087, 1669, 1836));
        list.add(new Triangle(2900, 2800, 2084));
        list.add(new Triangle(3312, 2084, 3083));
        list.add(new Triangle(4046, 3312, 2770));
        list.add(new Triangle(7, 2, 8));

        for (int i = 0; i < list.size() - 1; i++) {


            makeMinus100(list.get(i), i);
        }
    }

    private static void makeMinus100(Triangle tri, int i) {
        tri.init();
        double delta1 = 100 / tri.sinA + 100 * tri.getCtgA() + 100 / tri.sinB + 100 * tri.getCtgB();
        double c1 = tri.c - delta1;
        double k = c1 / tri.c;
        double b1 = k * tri.b;
        double a1 = k * tri.a;

        Triangle tnew1 = new Triangle(a1, b1, c1);
        System.out.println("Сторона с уменьшилась на = " + delta1 + ", k = " + k + ", triangle N " + i + " : " + tnew1);
    }
}

class Triangle {
    double a;
    double b;
    double c;

    double cosA;
    double cosB;
    double sinA;
    double sinB;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void init() {
        cosA = (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c);
        cosB = (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c);
        double s = 1 - Math.pow(cosA, 2);
        sinA = Math.sqrt(s);
        double v = 1 - Math.pow(cosB, 2);
        sinB = Math.sqrt(v);
    }

    public double getCtgA() {
        System.out.println("Угол A = " + Math.toDegrees(Math.acos(cosA)) + ", sin A = " + sinA);
        return Math.sqrt((1 / Math.pow(sinA, 2)) - 1);
    }

    public double getCtgB() {
        System.out.println("Угол Б = " + Math.toDegrees(Math.acos(cosB)) + ", sin B = " + sinB);

        return Math.sqrt((1 / Math.pow(sinB, 2)) - 1);
    }


    @Override
    public String toString() {
        return "= {" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}