import java.rmi.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {

    public Cliente(){

        try {
            int opcionFigura;
            Scanner scanner;
            InterfaceRemota objetoRemoto;
            DecimalFormat df;
            
            scanner = new Scanner(System.in);
            objetoRemoto = (InterfaceRemota)Naming.lookup("//25.72.27.24/ObjetoRemoto");
            df = new DecimalFormat("#.##");
            
            System.out.println("Elige una opcion para calcular su area:");
            System.out.println("1... Calcular área circulo");
            System.out.println("2... Calcular área póligono regular");
            //System.out.print("3... Calcular area Poligono Irregular");

            System.out.print("Elige una opción: ");
            opcionFigura = scanner.nextInt();

            switch (opcionFigura){
                case 1:
                    double radio;
                    
                    System.out.println("\nIngresa el rádio del círculo");
                    radio = scanner.nextDouble();
                    
                    System.out.println("\nLa area del circulo es : "+df.format(objetoRemoto.areaCirculo(radio)));
                    
                    break;
                case 2:
                    double perimetro; 
                    double apotema;
                    
                    System.out.println("\nIngresa el perímetro del polígono regular");
                    perimetro = scanner.nextDouble();
                    System.out.println("Ingresa el apotema del polígono regular");
                    apotema = scanner.nextDouble();
                    
                    System.out.println("\nLa area del poligono regular es : "+df.format(objetoRemoto.areaPoligonoRegular(perimetro, apotema)));
                    
                    break;
                /*
                case 3:
                    System.out.println("\nArea del poligono regular\nIngrese el numero de lados");
                    int numLado = scanner.nextInt();
                    double lados;
                    double distCentro;

                    for(int i = 0; i < numLado; i++){
                        System.out.println("Ingrese la longitud del lado");
                        lados = scanner.nextDouble();
                        System.out.println("Ingrese la distancia entre el centro y el lado");
                        distCentro = scanner.nextDouble();
                        objetoRemoto.areaPoligonoIrregular(lados,distCentro);
                    }

                    System.out.println("Area: " + objetoRemoto.calAreaPoligonoIrr());
                    break;
                */
                default:
                     System.out.printf("Opción inválida");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public static void  main(String[] args){
        new Cliente();
    }
}
    

