package math;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArraysSort {
    
    public static void main(String[] args) {
        
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe um número: " + (i + 1)));
            
        }
        JOptionPane.showMessageDialog(null, Arrays.toString(numeros));
        Arrays.sort(numeros);
        JOptionPane.showMessageDialog(null, Arrays.toString(numeros));
        
    }
}
