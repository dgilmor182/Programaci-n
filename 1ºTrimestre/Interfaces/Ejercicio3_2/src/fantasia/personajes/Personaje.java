package fantasia.personajes;

import fantasia.artefactos.Artefacto;
import fantasia.interfaces.Usable;

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

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public abstract void usarArtefacto();

    public abstract void accion();

    public void consumirEnergia(int cantidad) {
        nivelEnergia -= cantidad;
    }

    public void recuperarEnergia(int cantidad) {
        nivelEnergia += cantidad;
    }
}
