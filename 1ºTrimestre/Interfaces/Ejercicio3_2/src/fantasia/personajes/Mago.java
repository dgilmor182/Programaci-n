package fantasia.personajes;

import fantasia.artefactos.Armadura;

public class Mago extends Personaje {
    private Armadura armadura;

    public Mago(String nombre, int nivelEnergia, String nombreArmadura, int poderMagicoArmadura, int nivelProteccion) {
        super(nombre, nivelEnergia);
        this.armadura = new Armadura(nombreArmadura, poderMagicoArmadura, nivelProteccion);
    }

    @Override
    public void usarArtefacto() {
        armadura.usar();
    }

    @Override
    public void accion() {
        System.out.println(nombre + " potencia su armadura con magia.");
    }
}
