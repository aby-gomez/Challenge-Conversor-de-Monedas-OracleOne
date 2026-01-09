
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        ConversorService conversorService = new ConversorService();
        HashMap<Integer, String> listaConversiones = new HashMap<>();
        listaConversiones.put(1,"USD ARS");
        listaConversiones.put(2,"ARS USD");
        listaConversiones.put(3,"USD BRL");
        listaConversiones.put(4,"BRL USD");
        listaConversiones.put(5,"USD COP");
        listaConversiones.put(6,"COP USD");


        System.out.println("Bienvenid@ al Conversor de Moneda!");
        while(true) {
            String opciones = """
                    1) Dólar => Peso Argentino
                    2) Peso Argentino => Dólar
                    3) Dólar => Real Brasileño
                    4) Real Brasileño => Dólar
                    5) Dólar => Peso Colombiano
                    6) Peso Colombiano => Dólar
                    7) Salir
                    
                    """;
            System.out.println(opciones);
            System.out.println("Elija una opción válida");
            int elegido = ingreso.nextInt();

            if(elegido == 7){
                break;
            }

            if(listaConversiones.containsKey(elegido)){
                System.out.println("Ingrese el valor que desea convertir");
                double amount = ingreso.nextDouble();
                ingreso.nextLine();
                String[] currency = (listaConversiones.get(elegido)).split(" ");
                String base = currency[0].trim();
                String target = currency[1].trim();
                Exchange conversion = conversorService.conversionPar(base,target,amount);
                System.out.println("El valor "+amount+" "+base+" corresponde al valor final de "+conversion.conversion_result()+" "+target);


            }else{
                System.out.println("Opcion inválida, intente nuevamente");
            }
            System.out.println();
        }

            }
        }







