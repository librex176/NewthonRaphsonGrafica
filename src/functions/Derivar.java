
package functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Derivar {
    // Monomio tipo 1: (+/-)ax^b
    public static String DerivarMonomiosTipo1(String monomio) {
    // Verifica si el monomio tiene un numero antes de la x
    Pattern patronNumero = Pattern.compile("[-+]?\\d*");
    Matcher matcherNumero = patronNumero.matcher(monomio);

    int coeficiente = 1; // SI no hay un nnumero ponemos el 1
    if (matcherNumero.find()) {
        // Si hay un numero guardamos su valor
        String coeficienteStr = matcherNumero.group();
        if (!coeficienteStr.isEmpty()) {
            coeficiente = Integer.parseInt(coeficienteStr);
        }
    }

    // Verifica si el monomio tiene un exponente
    Pattern patronExponente = Pattern.compile("\\^\\d+");
    Matcher matcherExponente = patronExponente.matcher(monomio);
    
    int exponente = 1; 
    if (matcherExponente.find()) {
        exponente = Integer.parseInt(matcherExponente.group().substring(1));
    }

    // Derivar el monomio
    int nuevoCoeficiente = coeficiente * exponente;
    int nuevoExponente = exponente - 1;

    // Construir la nueva cadena del monomio derivado
    StringBuilder resultado = new StringBuilder();
    if (nuevoCoeficiente != 0) {
        resultado.append(nuevoCoeficiente);
    }

    if (nuevoExponente != 0) {
        if (nuevoExponente == 1) {
            resultado.append("x"); 
        } else {
            resultado.append("x^").append(nuevoExponente); 
        }
    }

    return resultado.toString();
}


    public static String DerivarMonomiosTipo2(String monomio) {
    // Verifica si el monomio es solo "x"
    if ("x".equals(monomio)) {
        return "1";
    }

    
    Pattern patronNumero = Pattern.compile("[+-]?\\d+");
    Matcher matcherNumero = patronNumero.matcher(monomio);

    if (matcherNumero.find()) {
        int num = Integer.parseInt(matcherNumero.group());
        return Integer.toString(num);
    }

    
    return "1";
}


}
