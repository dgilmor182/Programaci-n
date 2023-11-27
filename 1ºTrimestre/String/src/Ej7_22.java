
public class Ej7_22 {

	public static void main(String[] args) {

		String cadenaNormal = "Cadena de prueba";
		char arrayCadena[] = new char[cadenaNormal.length()];
		char arrayAlReves[] = new char[cadenaNormal.length()];

		for (int i = 0; i < cadenaNormal.length(); i++) {

			arrayCadena[i] = cadenaNormal.charAt(i);

		}

		int j = 0;
		for (int i = cadenaNormal.length(); i >= 0; i--) {

			arrayAlReves[i] = arrayCadena[j];
			j++;

		}

		
		System.out.println("Array normal: ");
		for(int i=0; i<arrayCadena.length; i++) {
			System.out.print("");
		}
		
	}

}