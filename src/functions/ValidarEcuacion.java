

        
        package functions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEcuacion {
    public static boolean Validacion(ArrayList<String> terminos) {
        // Patrones de las cadenas a validar
        String patron1 = "[+-]?\\d*x\\^\\d+"; //  "(+/-)ax^b"
        String patron2 = "[+-]?\\d*x"; //  "(+/-)ax"
        String patron3 = "[+-]?\\d+"; // "(+/-)a"

        // Compilar los patrones en objetos Pattern
        Pattern pattern1 = Pattern.compile(patron1);
        Pattern pattern2 = Pattern.compile(patron2);
        Pattern pattern3 = Pattern.compile(patron3);

        // Comprobamos cada termino
        for (String termino : terminos) {
            //Objetos tipo matcher
            Matcher matcher1 = pattern1.matcher(termino);
            Matcher matcher2 = pattern2.matcher(termino);
            Matcher matcher3 = pattern3.matcher(termino);

            
            if (!(matcher1.matches() || matcher2.matches() || matcher3.matches())) {
                
                return false;
            }
        }

        
        return true;
    }
}

    

