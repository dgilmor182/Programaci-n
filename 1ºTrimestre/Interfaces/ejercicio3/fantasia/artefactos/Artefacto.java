// Paquete fantasia.artefactos
package fantasia.artefactos;

import fantasia.interfaces.Usable;

public abstract class Artefacto implements Usable {
    protected String nombre;
    protected int poderMagico;

    public Artefacto(String nombre, int poderMagico) {
        this.nombre = nombre;
        this.poderMagico = poderMagico;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoderMagico() {
        return poderMagico;
    }
}




