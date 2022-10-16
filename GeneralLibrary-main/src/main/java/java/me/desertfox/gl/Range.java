package java.me.desertfox.gl;

import java.util.Random;

public class Range {

    private double min;
    private double max;

    public Range(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public Range(double fixed) {
        this.min = fixed;
        this.max = fixed;
    }

    /**
     * @return A random value between min and max
     */
    public double getRandomBetween(){
        if(min == max) return min;
        return min + (max - min) * new Random().nextDouble();
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
