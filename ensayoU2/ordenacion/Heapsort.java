public class Heapsort {
    public void sort(int arr[]) {
        int n = arr.length; // Definir el tamaño del arreglo
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i); // Asegurar que el subárbol cumpla la propiedad de heap
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }
    // Método para mantener  un heap máximo en un subárbol
    void heapify(int arr[], int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Llamada  a heapify
            heapify(arr, n, largest);
        }
    }
    // Función auxiliar para imprimir el arreglo
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    // main
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7}; //  arreglo desordenado
        
        Heapsort ob = new Heapsort();
        ob.sort(arr); 

        System.err.println("12, 11, 13, 5, 6, 7\n");

        System.out.println("El arreglo ordenado es:");
        printArray(arr); 
    }
}
