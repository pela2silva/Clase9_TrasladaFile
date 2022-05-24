package org.proydesa.clases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class testFileAle {

    /* Clase 9: Ejercicio File
    Generar un txt con 5 nombres
    Generar un programa que reciba un SI o un NO
    Con salida mínima de interfaz Grafica del JOPtionPane
    En caso de que la persona ingrese de manera incorrecta 3 veces el no 
    Se cierra el programa 
    En caso de que la entrada sea un SI 
    Preguntamos un nombre para el archivo a trasladar 
    Trasladamos el archivo con el nombre que le pasemos(rutaRelativa)
    */
    public static void main(String[] args) {

        String direccionInicial = "C:\\Users\\CC16744644\\Desktop\\JAVA\\Intermedio\\Clase 9\\Ejercicio Carga Nombres.txt";
        //String direccionFinal= "Traslado Ejercicio Carga Nombres .txt";

        List<Integer> nom = recuperador (direccionInicial);
       
        List<String> nombre = new ArrayList<>();
        pregunta(nombre);
        trasladar ((nombre + ".txt"), nom);
        
    }// Fin de la main

    public static void pregunta(List<String> lista) {

        int contador = 0;
        String opcion = JOptionPane.showInputDialog("Ingrese un (SI) para indicar Archivo a Trasladar (NO -> Exit): ");

        while (true) {

            if (verificadorSi(opcion)) {
                lista.add(JOptionPane.showInputDialog("Ingrese Direccion a trasladar: "));
                System.out.println("TRASLADO COMPLETO !");
                break;
            }
            if (verificadorNo(opcion)) {
                contador++;
                JOptionPane.showInputDialog("Ingrese un (SI) para indicar Archivo a Trasladar (NO -> Exit): ");
                if (contador == 2) {
                    System.out.println("## EXIT !! ##");
                    break;
                }
            }
        }
    } // Fin de pregunta

    public static boolean verificadorSi(String texto) {

        return texto.matches("^[s|S]{1}+[i|I]{1}$");

    }

    public static boolean verificadorNo(String texto) {

        return texto.matches("^[n|N]{1}+[o|O]{1}$");

    }

    public static List<Integer> recuperador(String origen) {

        List<Integer> retornar = new ArrayList<>();
        int c;

        try {
            FileInputStream archivo = new FileInputStream(origen);

            c = archivo.read();
            while (c != -1) {
                retornar.add(c);
                c = archivo.read();
            }

            archivo.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
        return retornar;
    } // Fin de recuperador

    public static void trasladar(String direccion, List<Integer> lista) {

        try {
            FileOutputStream fo = new FileOutputStream(direccion);

            for (Integer e : lista) {

                fo.write(e);
            }

            fo.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }
    } // Fin de trasladar

} // Fin clase
