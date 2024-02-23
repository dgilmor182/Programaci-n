package fantasia.personajes;

import fantasia.artefactos.Artefacto;

public class Guerrero extends Personaje {
    private Artefacto espada;

    public Guerrero(String nombre, int nivelEnergia, Artefacto espada) {
        super(nombre, nivelEnergia);
        this.espada = espada;
    }

    @Override
    public void usarArtefacto() {
        espada.usar();
    }

    @Override
    public void accion() {
        System.out.println("El guerrero ataca con su espada!");
    }
}
