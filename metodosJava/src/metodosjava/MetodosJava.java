package metodosjava;

import javax.swing.JOptionPane;

public class MetodosJava {

    static void imprimirOla() {

        JOptionPane.showMessageDialog(null, "Hello World!!!");
    }

    public static void imprimir() {

        System.out.println("Aprendendo linguagem java");
    }

    public static void imprimirTexto(String texto) {

        System.out.println(texto);
    }

    public static void somar(int a, int b) {

        System.out.println("somar: " + (a + b));
    }

    public static void quadrado(int a) {

        System.out.println(Math.pow(a, 2));
    }

    public static void maior(int a, int b, int c) {

        System.out.println(Math.max(a, Math.max(b, c)));
    }

    public static void sexo(char c) {
        c = Character.toUpperCase(c);
        switch (c) {
            case 'F':
                System.out.println("Feminino");
                break;

            case 'M':
                System.out.println("Masculino");
                break;
            default:
                System.out.println("Desconhecido");
        }
    }

}
