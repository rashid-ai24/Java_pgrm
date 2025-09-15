// File: Converter.java
import CurrencyConverter.*;
import DistanceConverter.*;
import TimeConverter.*;
import java.util.*;

public class Converter {

    public static void main(String args[]) {
        System.out.println("1. Currency Converter");
        System.out.println("2. Distance Converter");
        System.out.println("3. Time Converter");

        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        Converter cr = new Converter();

        switch (choice) {
            case 1: cr.Currency(); break;
            case 2: cr.Distance(); break;
            case 3: cr.Time(); break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void Currency() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amt = in.nextDouble();
        CurrencyConverter cc = new CurrencyConverter();

        System.out.println("DOLLAR " + amt + " = INR " + cc.dollortoinr(amt));
        System.out.println("INR " + amt + " = DOLLAR " + cc.inrtodollor(amt));
        System.out.println("EURO " + amt + " = INR " + cc.eurotoinr(amt));
        System.out.println("INR " + amt + " = EURO " + cc.inrtoeuro(amt));
        System.out.println("YEN " + amt + " = INR " + cc.yentoinr(amt));
        System.out.println("INR " + amt + " = YEN " + cc.inrtoyen(amt));
    }

    public void Distance() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter distance: ");
        double dis = in.nextDouble();
        DistanceConverter dd = new DistanceConverter();

        System.out.println("METER " + dis + " = KM " + dd.metertokm(dis));
        System.out.println("KM " + dis + " = METER " + dd.kmtometer(dis));
        System.out.println("MILES " + dis + " = KM " + dd.milestokm(dis));
        System.out.println("KM " + dis + " = MILES " + dd.kmtomiles(dis));
    }

    public void Time() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter time (in hours for example): ");
        double tim = in.nextDouble();
        TimeConverter tt = new TimeConverter();

        System.out.println("HOURS " + tim + " = MINUTES " + tt.hourstominutes(tim));
        System.out.println("MINUTES " + tim + " = HOURS " + tt.minutestohours(tim));
        System.out.println("HOURS " + tim + " = SECONDS " + tt.hourstoseconds(tim));
        System.out.println("SECONDS " + tim + " = HOURS " + tt.secondstohours(tim));
    }
  }
