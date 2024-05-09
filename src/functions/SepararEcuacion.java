package functions;

import java.util.ArrayList;
import java.util.Collections;

public class SepararEcuacion {
    public static ArrayList<String> Separar(String ecuacion) {
        ArrayList<String> terminos = new ArrayList<>();

        
        String[] partes = ecuacion.split("\\s*(?=\\+|\\-)\\s*");

        
        Collections.addAll(terminos, partes);

        return terminos;
    }
}
