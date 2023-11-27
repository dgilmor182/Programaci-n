
public class Ej7_21 {

	public static void main(String[] args) {

		String cadena = "Esta semana se acaba.";

		int contadorA = 0;

		for (int i = 0; i < cadena.length(); i++) {

			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'A') {
				contadorA++;
			}

		}

		System.out.println("El número de A es: " + contadorA);

	}

}