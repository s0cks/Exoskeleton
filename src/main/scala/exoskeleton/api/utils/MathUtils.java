package exoskeleton.api.utils;

public class MathUtils{
    public static double clip(double value, double min, double max){
        if(value > max)
            value = max;
        if(value < min)
            value = min;
        return value;
    }
}