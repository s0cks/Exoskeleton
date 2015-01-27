package exoskeleton.api.utils;

public class StringUtils{
    public static String capitalize(String str){
        return str.toUpperCase().charAt(0) + str.substring(1);
    }
}