package fantasia.artefactos;

public class Armadura extends Artefacto {
    private int nivelProteccion;

    public Armadura(String nombre, int poderMagico, int nivelProteccion) {
        super(nombre, poderMagico);
        this.nivelProteccion = nivelProteccion;
    }

    @Override
    public void usar() {
        System.out.println("¡Mejorando defensa con la armadura de nombre " + this.getNombre() +"!");
    }
}