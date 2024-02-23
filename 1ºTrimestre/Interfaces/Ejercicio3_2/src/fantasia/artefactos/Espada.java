package fantasia.artefactos;

public class Espada extends Artefacto {
    private double longitud;

    public Espada(String nombre, int poderMagico, double longitud) {
        super(nombre, poderMagico);
        this.longitud = longitud;
    }

    @Override
    public void usar() {
        System.out.println("La espada " + nombre + " desata su poder en combate.");
    }

    public double getLongitud() {
        return longitud;
    }
}
