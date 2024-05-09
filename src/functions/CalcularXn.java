
package functions;


public class CalcularXn {
    
    public static double xn (double fx, double fdx, double x){
        
        double xn = x - (fx/fdx);
        
        return xn;
    }
}
