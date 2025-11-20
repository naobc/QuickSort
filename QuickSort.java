import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class QuickSort {

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pi = particion(arr, inicio, fin);
            quickSort(arr, inicio, pi - 1);
            quickSort(arr, pi + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("numeros.txt"));
            String linea = br.readLine();
            br.close();

            String[] partes = linea.split("\\s+");
            int[] arr = new int[partes.length];

            for (int i = 0; i < partes.length; i++) {
                arr[i] = Integer.parseInt(partes[i]);
            }

            quickSort(arr, 0, arr.length - 1);

            PrintWriter pw = new PrintWriter("resultado.txt");
            pw.println("Resultado QuickSort:");
            for (int n : arr) pw.print(n + " ");
            pw.close();

            System.out.println("QuickSort generado en resultado.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
