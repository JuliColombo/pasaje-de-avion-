package main.java.ar.edu.utn.frba.ia.ag.ejemplos.pasajeDeAvion;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaAscendente;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

/**
 * Created by julicolombo on 10/7/17.
 */
public class PasajeDeAvion {
    public static void main(String[] args) {

        ConfiguracionDefault config = new ConfiguracionDefault();
        config.setCriterioDeParo(new CantidadDeCiclos((long)1000));
        config.setPoblacionInicial(500);
        config.setMetodoDeSeleccion(new Torneo());
        config.setCruzamiento(new BinomialMascaraComplemento("XYYXYX"));
        config.setMutacion(new MutacionTemperaturaAscendente());

        AlgoritmoGenetico solucion = new AlgoritmoGenetico(config, Personas.class);

        Individuo personas = solucion.ejecutar();

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Conjunto final: " + personas.toString());
    }
}
