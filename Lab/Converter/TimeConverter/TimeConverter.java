// File: TimeConverter.java
package TimeConverter;

public class TimeConverter {

    public double hourstominutes(double x) {
        return x * 60;
    }
    public double minutestohours(double x) {
        return x / 60;
    }
    public double hourstoseconds(double x) {
        return x * 3600;
    }
    public double secondstohours(double x) {
        return x / 3600;
    }
}
