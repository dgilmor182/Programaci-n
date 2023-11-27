
public class Ej7_27 {

	public static void main(String[] args) {

		String cadena = "Hola mundo";
		boolean empiezaConHola = false;

		empiezaConHola = cadena.startsWith("Hola") || cadena.startsWith("hola");

		if (empiezaConHola) {
			System.out.println("Empieza con Hola o hola");
		} else {
			System.out.println("No empieza con Hola o hola");
		}

	}

}