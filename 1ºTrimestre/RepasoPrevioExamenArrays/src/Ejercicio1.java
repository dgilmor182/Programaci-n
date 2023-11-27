
public class Ejercicio1 {

	public static void main(String[] args) {

		int[] numero = new int[20];
		int[] cuadrado = new int[20];
		int[] cubo = new int[20];

		/*
		 * Completamos el array numeros con enteros aleatorios entre 0 y 100
		 */

		for (int i = 0; i < numero.length; i++) {

			int numeroAleatorio = (int) (Math.random() * 100);

			if(numeroAleatorio == 0) {
				numeroAleatorio += 1;
			} else if(numeroAleatorio == 100){
				numeroAleatorio -= 1;
			}
			//Asignamos un numero entre 1 y 99 incluidos
			numero[i] = numeroAleatorio;
			cuadrado[i] = (int) Math.pow((double)numeroAleatorio,2.0);
			cubo[i] = (int) Math.pow(numeroAleatorio,3.0);
		}

		imprimirArray(numero);
		imprimirArray(cuadrado);
		imprimirArray(cubo);
		
	}

	public static void imprimirArray(int []arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(" " + arr[i] + " ");
		}
	}
	
}
