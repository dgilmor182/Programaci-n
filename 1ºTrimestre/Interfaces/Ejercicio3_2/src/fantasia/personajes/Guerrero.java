package fantasia.personajes;

import fantasia.artefactos.Espada;

public class Guerrero extends Personaje {
    private Espada espada;

    public Guerrero(String nombre, int nivelEnergia, String nombreEspada, int poderMagicoEspada, double longitud) {
        super(nombre, nivelEnergia);
        this.espada = new Espada(nombreEspada, poderMagicoEspada, longitud);
    }

    @Override
    public void usarArtefacto() {
        espada.usar();
    }

    @Override
    public void accion() {
        System.out.println(nombre + " utiliza su espada en combate.");
    }
}
