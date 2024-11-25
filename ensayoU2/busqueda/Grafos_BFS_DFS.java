import java.util.Scanner;
public class Grafos_BFS_DFS {
    public static int[][] buscar(int[][] mapa, int inicioX, int inicioY, int objetivoX, int objetivoY) {
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        int filas = mapa.length, columnas = mapa[0].length;
        int[][] cola = new int[filas * columnas][2]; // Cola para BFS
        boolean[][] visitado = new boolean[filas][columnas];
        int[][] padres = new int[filas][columnas];
        int cabeza = 0, colaFinal = 0;
        cola[colaFinal++] = new int[]{inicioX, inicioY};
        visitado[inicioX][inicioY] = true;
        while (cabeza < colaFinal) {
            int[] celda = cola[cabeza++];
            int x = celda[0], y = celda[1];
            if (x == objetivoX && y == objetivoY) {
                int[][] camino = new int[filas * columnas][2];
                int caminoSize = 0;
                while (x != inicioX || y != inicioY) {
                    camino[caminoSize++] = new int[]{x, y};
                    int tmp = padres[x][y];
                    x = tmp / columnas;
                    y = tmp % columnas;
                }
                camino[caminoSize++] = new int[]{inicioX, inicioY};
                int[][] resultado = new int[caminoSize][2];
                System.arraycopy(camino, 0, resultado, 0, caminoSize);
                return resultado;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < filas && ny >= 0 && ny < columnas && mapa[nx][ny] == 0 && !visitado[nx][ny]) {
                    cola[colaFinal++] = new int[]{nx, ny};
                    visitado[nx][ny] = true;
                    padres[nx][ny] = x * columnas + y;
                }
            }
        }
        return new int[0][0]; // Si no hay camino
    }
    public static void main(String[] args) {
        int[][] mapa = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa las coordenadas X de inicio (0-4): ");
        int inicioX = scanner.nextInt();
        System.out.print("Ingresa las coordenadas Y de inicio (0-4): ");
        int inicioY = scanner.nextInt();
        System.out.print("Ingresa las coordenadas X de objetivo (0-4): ");
        int objetivoX = scanner.nextInt();
        System.out.print("Ingresa las coordenadas Y de objetivo (0-4): ");
        int objetivoY = scanner.nextInt();

        int[][] camino = buscar(mapa, inicioX, inicioY, objetivoX, objetivoY);
        if (camino.length == 0) System.out.println("No hay camino.");
        else {
            for (int[] paso : camino) {
                System.out.println("[" + paso[0] + "," + paso[1] + "]");
            }
        }
        
        scanner.close(); // Cerrar el escáner después de usarlo
    }
}
