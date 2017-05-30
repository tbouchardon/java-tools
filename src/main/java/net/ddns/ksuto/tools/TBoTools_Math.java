package net.ddns.ksuto.tools;

/**
 * Created by thomas.bouchardon on 24/10/2016!
 */
public class TBoTools_Math {
    
    public static double sygmoid(double x) {
        
        //               1
        // S(y) = --------------
        //          1 + e ^ -x
        
        double y;
        
        y = 1 / (1 + Math.pow(Math.E, x));
        
        return y;
    }
    
    public static double sygmoidPrime(double x) {
        
        //
        // S'(y) = S(x) * (1 - S(x))
        //
        
        double y;
        
        y = sygmoid(x) * (1 - sygmoid(x));
        
        return y;
    }
}
