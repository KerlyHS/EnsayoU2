public class Counting_Sort {
    public void sort(int arr[]) {  // Método principal para ordenar el arreglo con Counting Sort
        int n = arr.length;
        int max = getMax(arr);
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Función para obtener el valor máximo en el arreglo
    private int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    static void printArray(int arr[]) {    // Función para imprimir el arreglo
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        Counting_Sort ob = new Counting_Sort();
        ob.sort(arr); 
        System.err.println("4, 2, 2, 8, 3, 3, 1\n");
        System.out.println("El arreglo ordenado es:");
        printArray(arr); // Imprimir el arreglo ordenado
    }
}
