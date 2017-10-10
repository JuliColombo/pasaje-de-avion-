package main.java.ar.edu.utn.frba.ia.ag.ejemplos.pasajeDeAvion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialAzar;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.BinomialMascaraComplemento;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionTemperaturaAscendente;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

/**
 * Created by julicolombo on 10/7/17.
 */
public class PasajeDeAvion {
    public PasajeDeAvion(){
        this.setPosiones();
        this.setEdades();
        this.setPeinados();
        this.setDestinos();
        this.setLugares();
        this.setProgramas();
    }

    public static final String SIMPSON = "Los Simpson";
    public static final String CORONATION_STREET = "Coronation Street";
    public static final String EASTENDERS = "Eastenders";
    public static final String DESPERATE_HOUSWIVES = "Desperate Houswives";
    public static final String NEIGHBORS = "Neighbors";

    private static ArrayList<Integer> posiciones;
    private static ArrayList<Integer> edades;
    private static ArrayList<String> peinados;
    private static ArrayList<String> destinos;
    private static ArrayList<String> lugares;
    private static ArrayList<String> programas;

    public ArrayList<Integer> getPosiones() {
        return this.posiciones;
    }

    public void setPosiones() {
        this.posiciones = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    }

    public ArrayList<Integer> getEdades() {
        return this.edades;
    }

    public void setEdades() {
        this.edades = new ArrayList<Integer>(Arrays.asList(14, 21, 46, 52, 81));
    }

    public ArrayList<String> getPeinados() {
        return this.peinados;
    }

    public void setPeinados() {
        this.peinados = new ArrayList<String>(Arrays.asList("afro", "largo", "liso", "rizado", "calvo"));
    }

    public ArrayList<String> getDestinos() {
        return this.destinos;
    }

    public void setDestinos() {
        this.destinos = new ArrayList<String>(Arrays.asList("Francia", "Australia", "Inglaterra", "África", "Italia"));
    }

    public ArrayList<String> getLugares() {
        return this.lugares;
    }

    public void setLugares() {
        this.lugares = new ArrayList<String>(Arrays.asList("hotel", "ciudad", "pueblo", "granja", "albergue juvenil"));
    }

    public ArrayList<String> getProgramas() {
        return this.programas;
    }

    public void setProgramas() {
        this.programas = new ArrayList<String>(Arrays.asList(SIMPSON,
                CORONATION_STREET,
                EASTENDERS,
                DESPERATE_HOUSWIVES,
                NEIGHBORS));
    }

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
