package fantasia.artefactos;

public class Armadura extends Artefacto {
    private int nivelProteccion;

    public Armadura(String nombre, int poderMagico, int nivelProteccion) {
        super(nombre, poderMagico);
        this.nivelProteccion = nivelProteccion;
    }

    @Override
    public void usar() {
        System.out.println("La armadura " + nombre + " refuerza la defensa del personaje.");
    }

    public int getNivelProteccion() {
        return nivelProteccion;
    }
}
