// Paquete fantasia.personajes
package fantasia.personajes;

import fantasia.artefactos.Artefacto;

public abstract class Personaje {
    protected String nombre;
    protected int nivelEnergia;

    public Personaje(String nombre, int nivelEnergia) {
        this.nombre = nombre;
        this.nivelEnergia = nivelEnergia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public void consumirEnergia(int cantidad) {
        this.nivelEnergia -= cantidad;
    }

    public void recuperarEnergia(int cantidad) {
        this.nivelEnergia += cantidad;
    }

    public abstract void usarArtefacto();
    public abstract void accion();
}


