import java.util.Arrays;

public class Ejercicio3DanielGilMorales {

	public static void main(String[] args) {
		// Crea un array bidimensional de 5x5
		int[][] arrayBidimensional = new int[5][5];
		// Inicializa el array con números aleatorios entre 1 y 25
		inicializar(arrayBidimensional);

		System.out.println("Array principal:");
		// Imprime el array bidimensional
		imprimirArrayBidimensional(arrayBidimensional);

		// Obtiene la diagonal principal del array
		int[] diagonalPrincipal = obtenerDiagonal(arrayBidimensional, true);
		// Obtiene la diagonal secundaria del array
		int[] diagonalSecundaria = obtenerDiagonal(arrayBidimensional, false);

		System.out.println();
		System.out.println("Diagonal principal:");
		// Imprime la diagonal principal
		imprimirArrayUnidimensional(diagonalPrincipal);

		System.out.println();
		System.out.println("Diagonal principal invertida:");
		// Imprime la diagonal principal invertida
		imprimirArrayUnidimensional(invertirArray(diagonalPrincipal));

		System.out.println();
		System.out.println("Diagonal secundaria:");
		// Imprime la diagonal secundaria
		imprimirArrayUnidimensional(diagonalSecundaria);

		System.out.println();
		System.out.println("Diagonal secundaria invertida:");
		// Imprime la diagonal secundaria invertida
		imprimirArrayUnidimensional(invertirArray(diagonalSecundaria));
	}

	// Inicializa un array bidimensional con números aleatorios entre 1 y 25
	public static void inicializar(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 25) + 1;
			}
		}
	}

	// Imprime un array bidimensional
	public static void imprimirArrayBidimensional(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	// Imprime un array unidimensional
	public static void imprimirArrayUnidimensional(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	// Obtiene la diagonal de un array bidimensional, principal o secundaria
	public static int[] obtenerDiagonal(int[][] array, boolean principal) {
		int[] diagonal = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			// Se asigna el valor de la diagonal principal o secundaria al array unidimensional
			diagonal[i] = principal ? array[i][i] : array[i][array.length - 1 - i];
		}
		return diagonal;
	}

	// Invierte el array unidimensional
	public static int[] invertirArray(int[] array) {
		int[] arrayInvertido = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			arrayInvertido[i] = array[array.length - 1 - i];
		}
		return arrayInvertido;
	}
}
