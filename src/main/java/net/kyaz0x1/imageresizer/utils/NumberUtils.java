package net.kyaz0x1.imageresizer.utils;

public class NumberUtils {

    private NumberUtils(){}

    public static boolean isNumber(String value){
        try {
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

}