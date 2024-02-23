package fantasia.personajes;

import fantasia.artefactos.Artefacto;

public class Mago extends Personaje {
    private Artefacto armadura;

    public Mago(String nombre, int nivelEnergia, Artefacto armadura) {
        super(nombre, nivelEnergia);
        this.armadura = armadura;
    }

    @Override
    public void usarArtefacto() {
        armadura.usar();
    }

    @Override
    public void accion() {
        System.out.println("El mago fortalece su armadura con magia!");
    }
}
