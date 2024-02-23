// Paquete fantasia.principal
package fantasia.principal;

import fantasia.artefactos.Armadura;
import fantasia.artefactos.Espada;
import fantasia.personajes.Guerrero;
import fantasia.personajes.Mago;

public class MundoFantasia {
    public static void main(String[] args) {
        Espada espadaDelDestino = new Espada("Espada del Destino", 100, 1.5);
        Armadura armaduraMistica = new Armadura("Armadura Mística", 80, 50);

        Guerrero guerrero = new Guerrero("Aragorn", 100, espadaDelDestino);
        Mago mago = new Mago("Gandalf", 120, armaduraMistica);

        System.out.println("El guerrero entra en acción:");
        guerrero.accion();
        guerrero.usarArtefacto();

        System.out.println("\nEl mago entra en acción:");
        mago.accion();
        mago.usarArtefacto();

        guerrero.recuperarEnergia(20);
        mago.consumirEnergia(30);
    }
}
