
public class Ej7_25 {

	public static void main(String[] args) {

		String cadena = "Hola mundo";
		
		String palabras [] = cadena.split(" ");
		
		System.out.println("La cadena tiene " + palabras.length + " palabras");
		
		int sumaCaracteres = 0;
		for(int i=0;i<palabras.length; i++) {
			
			sumaCaracteres=sumaCaracteres+palabras[i].length();
			
		}
		
		System.out.println("La cadena tiene " + sumaCaracteres + " caracteres");
		
	}

}
