import java.util.Scanner;
public class Interpolacion {

    // Método para realizar la búsqueda por interpolación
    public int buscar(int arr[], int valor) {
        int bajo = 0, alto = arr.length - 1;
        while (bajo <= alto && valor >= arr[bajo] && valor <= arr[alto]) {
            int posicion = bajo + ((valor - arr[bajo]) * (alto - bajo)) / (arr[alto] - arr[bajo]);
            if (arr[posicion] == valor) return posicion;
            if (arr[posicion] < valor) bajo = posicion + 1;
            else alto = posicion - 1;
        }
        return -1;
    }
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {10, 12, 15, 18, 20, 23, 25, 28, 30, 35, 40};
        Scanner scanner = new Scanner(System.in);
        System.err.println("10, 12, 15, 18, 20, 23, 25, 28, 30, 35, 40\n");
        System.out.print("Ingresa el numero a buscar: ");
        int valor = scanner.nextInt(); 
        Interpolacion ob = new Interpolacion();
        int resultado = ob.buscar(arr, valor);
        if (resultado == -1) 
            System.out.println("Valor no encontrado");
        else 
            System.out.println("Elemento encontrado en la posición: " + resultado);
        scanner.close();
    }
}
