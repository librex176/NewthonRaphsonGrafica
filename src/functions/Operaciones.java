package functions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operaciones {
    public static double monomioANumero(ArrayList<String> terminos, double x) {
        double sumaTotal = 0; // Inicializar la suma total

        // Definir los patrones de expresión regular para cada tipo de término
        String patronAxExponente = "([+-]?\\d+)x\\^(\\d+)"; // Formato: ax^b
        String patronAx = "([+-]?\\d+)x"; // Formato: ax
        String patronA = "([+-]?\\d+)"; // Formato: a

        // Compilar los patrones en objetos Pattern
        Pattern patternAxExponente = Pattern.compile(patronAxExponente);
        Pattern patternAx = Pattern.compile(patronAx);
        Pattern patternA = Pattern.compile(patronA);

        // Iterar sobre cada término en la lista
        for (String termino : terminos) {
            // Intentar hacer coincidir el término con cada patrón
            Matcher matcherAxExponente = patternAxExponente.matcher(termino);
            Matcher matcherAx = patternAx.matcher(termino);
            Matcher matcherA = patternA.matcher(termino);

            // Verificar el tipo de término y procesarlo adecuadamente
            if (matcherAxExponente.matches()) {
                // Es del tipo ax^b
                double coeficiente = Double.parseDouble(matcherAxExponente.group(1));
                double exponente = Double.parseDouble(matcherAxExponente.group(2));
                double valorTermino = coeficiente * Math.pow(x, exponente);
                sumaTotal += valorTermino;
            } else if (matcherAx.matches()) {
                // Es del tipo ax
                double coeficiente = Double.parseDouble(matcherAx.group(1));
                double valorTermino = coeficiente * x;
                sumaTotal += valorTermino;
            } else if (matcherA.matches()) {
                // Es del tipo a
                double coeficiente = Double.parseDouble(matcherA.group(1));
                sumaTotal += coeficiente;
            } else {
                System.out.println("Error: El término '" + termino + "' no tiene un formato válido.");
            }
        }

        return sumaTotal; // Devolver la suma total
    }
}

