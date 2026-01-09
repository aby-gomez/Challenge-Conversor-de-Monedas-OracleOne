import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner ingreso = new Scanner(System.in);
        ConversorService conversorService = new ConversorService();


        System.out.println("Bienvenid@ al Conversor de Moneda!");
        String opciones = """
                1) USD => ARS (Dólar => Peso Argentino)
                2) ARS => USD (Peso Argentino => Dólar)
                3) USD => BRL (Dólar => Real Brasileño)
                4) BRL => USD (Real Brasileño => Dólar)
                5) USD => COP (Dólar => Peso Colombiano)
                6) COP => USD (Peso Colombiano => Dólar)
                7) Salir
                
                """;
        System.out.println(opciones);
        System.out.println("Elija una opción válida");
        String elegido = ingreso.nextLine();
        System.out.println("Ingrese el valor que desea convertir");
        double monto = ingreso.nextDouble();
        ingreso.nextLine();

        String[] oraciones = opciones.split("\n");

        for(int i = 0; i<oraciones.length; i++){
            String[] linea = oraciones[i].split(" ");
            if (linea[0].charAt(0) == elegido.charAt(0)){
                String base = linea[1].trim();
                String target = linea[3].trim();
                Exchange conversion = conversorService.conversionPar(base,target,monto);
                System.out.println("El valor "+monto+" "+base+" corresponde al valor final de "+conversion.conversion_result()+" "+target);
                break;
            }
            }
        }






    }
