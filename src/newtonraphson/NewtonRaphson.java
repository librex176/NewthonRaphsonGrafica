
package newtonraphson;
import functions.CalcularXn;
import functions.IdentificarTipoMonomio;
import functions.Operaciones;
import functions.SepararEcuacion;
import functions.ValidarEcuacion;
import java.util.ArrayList;
import java.util.Scanner;
public class NewtonRaphson {

    
    public static void main(String[] args) {
        //Entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la ecuacion");
        String ecuacion = scanner.nextLine(); 
        System.out.println("Ingrese el punto de partida");
        String partidaStr = scanner.nextLine(); 
        double partida = Double.parseDouble(partidaStr);
        System.out.println("Ingresa la tolerancia");
        String toleranciaStr = scanner.nextLine(); 
        double tolerancia = Double.parseDouble(toleranciaStr);
        
        //Lista de arreglos que contendra los monomios de la ecuacion y su derivada
        ArrayList<String> terminos = new ArrayList<>();
        ArrayList<String> derivada = new ArrayList<>();
        
        //Separamos la ecuacion para identificar todos sus terminos
        terminos = SepararEcuacion.Separar(ecuacion);
        
        //Validamos la ecuacion
        boolean ecuacionValida = ValidarEcuacion.Validacion(terminos);
        if( ecuacionValida == false){
            System.out.println("La ecuacion ingresada esta mal");
        }
        //Derivamos los terminos
        derivada = IdentificarTipoMonomio.Derivar(terminos);
        
        

//       // Imprimimos los terminos y su derivada
//        for (int i = 0; i < terminos.size(); i++) {
//            String termino = terminos.get(i);
//            
//            System.out.println("f(x):"+termino  );
//            
//        }
//        for (int i = 0; i < derivada.size(); i++) {
//            String derivadaTermino = derivada.get(i);
//            System.out.println("f'(x):"+derivadaTermino);
//        }
        
        double res1,res2;
        res1 = Operaciones.monomioANumero(terminos, partida);
        res2 = Operaciones.monomioANumero(derivada, partida);
        
        System.out.println(res1);
        System.out.println(res2);
        
        double nuevaPartida = 0;
        
        
       
        do{
             nuevaPartida = CalcularXn.xn(res1,res2,nuevaPartida);
            res1 = Operaciones.monomioANumero(terminos, nuevaPartida);
            res2 = Operaciones.monomioANumero(derivada, nuevaPartida);
            
        }while(res1 > tolerancia);
        System.out.println(nuevaPartida);
        
        
         
        
       
        
        
    }
    
    
}
