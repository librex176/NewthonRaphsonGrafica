
package functions;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentificarTipoMonomio {
    
    public static ArrayList<String> Derivar(ArrayList<String> ecuacion){
        String patron1 = "[+-]?\\d*x\\^\\d+"; //  "(+/-)ax^b"
        String patron2 = "[+-]?\\d*x"; //  "(+/-)ax"
        String patron3 = "[+-]?\\d+"; //  "(+/-)a"

        // Compilar los patrones en objetos Pattern
        Pattern pattern1 = Pattern.compile(patron1);
        Pattern pattern2 = Pattern.compile(patron2);
        Pattern pattern3 = Pattern.compile(patron3);
        
        ArrayList<String> ecuacionDerivada = new ArrayList<>();
        
        for (String termino : ecuacion) {
            Matcher matcher1 = pattern1.matcher(termino);
            Matcher matcher2 = pattern2.matcher(termino);
            Matcher matcher3 = pattern3.matcher(termino);

            if (matcher1.matches()) {
                String derivada = Derivar.DerivarMonomiosTipo1(termino);
                ecuacionDerivada.add(derivada); // Agregar la cadena derivada al ArrayList
            }
            if (matcher2.matches()) {
                String derivada = Derivar.DerivarMonomiosTipo2(termino);
                ecuacionDerivada.add(derivada); // Agregar la cadena derivada al ArrayList
            }
            
            
        }
        
        return ecuacionDerivada;
    }
}
