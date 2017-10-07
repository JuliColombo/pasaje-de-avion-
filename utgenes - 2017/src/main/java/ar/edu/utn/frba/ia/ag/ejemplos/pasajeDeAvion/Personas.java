package main.java.ar.edu.utn.frba.ia.ag.ejemplos.pasajeDeAvion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

/**
 * Created by julicolombo on 10/7/17.
 */
public class Personas extends Individuo{
    public Personas(){
        this.setRandom(new Random());
        this.setearRandom();
        this.setPosiones();
        this.setEdades();
        this.setPeinados();
        this.setDestinos();
        this.setLugares();
        this.setProgramas();
    }

    private static ArrayList<Integer> posiciones;
    private static ArrayList<Integer> edades;
    private static ArrayList<String> peinados;
    private static ArrayList<String> destinos;
    private static ArrayList<String> lugares;
    private static ArrayList<String> programas;

    private Persona bob;
    private Persona keeley;
    private Persona rachael;
    private Persona eilish;
    private Persona amy;

    private Random random;


    public Random getRandom() {
        return random;
    }

    public void setRandom(Random unRandom) {
        this.random = unRandom;
    }

    public Persona getBob() {
        return bob;
    }

    public void setBob(Persona bob) {
        this.bob = bob;
    }

    public Persona getKeeley() {
        return keeley;
    }

    public void setKeeley(Persona keeley) {
        this.keeley = keeley;
    }

    public Persona getRachael() {
        return rachael;
    }

    public void setRachael(Persona rachael) {
        this.rachael = rachael;
    }

    public Persona getEilish() {
        return eilish;
    }

    public void setEilish(Persona eilish) {
        this.eilish = eilish;
    }

    public Persona getAmy() {
        return amy;
    }

    public void setAmy(Persona amy) {
        this.amy = amy;
    }

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
        return this.destinoss;
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
        this.programas = new ArrayList<String>(Arrays.asList("Los Simpson",
                                                             "Coronation Street",
                                                             "Eastenders",
                                                             "Desperate Houswives",
                                                             "Neigbors"));
    }

    public double sumarAptitud(double valor) {
        return valor + 10;
    }

    public double aptitud() {

        double valor = 0;
//        1. La persona que está en el medio mira Desperate Housewives
//        2. Bob es el primero en la cola
            if(getBob().getPosicion() == 1){
                sumarAptitud(valor);
            }
//        3. La persona que ve a los Simpson está al lado de la persona que vive en un albergue juvenil
//        4. La persona que va a África está detrás de Rachael
//        5. La persona que vive en un pueblo tiene 52 años
//        6. La persona que va a Australia tiene el pelo liso
//        7. La persona que viaja a África mira Desperate Housewives
//        8. El jugador de 14 años está al final de la cola
//        9. Amy mira a Eastenders
            if(getAmy().getPrograma() == "Eastenders"){
                sumarAptitud(valor);
            }
//        10. La persona que va a Italia tiene el pelo largo
//        11. Keeley vive en un pueblo
//        12. El joven de 46 años es calvo
//        13. El cuarto en la cola va a Inglaterra
//        14. Las personas que ven Desperate Housewives y Neighbors están uno atras del otro
//        15. La persona que mira Coronation Street está al lado de la persona con un afro
//        16. La persona que le sigue a en la fila Rachael tiene un afro
//        17. El joven de 21 años vive en un albergue juvenil
//        18. La persona que mira Corrie tiene el pelo largo
//        19. El de 81 años vive en una granja
//        20. La persona que viaja a Francia vive en una ciudad
//        21. Eilish no está al lado de la persona con el pelo liso

        return valor;
    }


    @Override
    public boolean esMasAptoQue(Individuo individuo) {
        return this.aptitud() > individuo.aptitud();
    }

    @Override
    public Individuo generarRandom() {

        Personas nuevo = new Personas();

        nuevo.setearRandom();

        //Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Personas generados: " + nuevo.toString());

        return nuevo;
    }

    public void setearRandom(){
        ArrayList<Integer> listaPosiciones = listaRandom(getPosiones());
        ArrayList<Integer> listaEdades = listaRandom(getEdades());
        ArrayList<String> listaPeinados = listaRandom(getPeinados());
        ArrayList<String> listaDestinos = listaRandom(getDestinos());
        ArrayList<String> listaLugares = listaRandom(getLugares());
        ArrayList<String> listaProgramas = listaRandom(getProgramas());

        setBob(new Persona(listaPosiciones.get(0),
                           listaEdades.get(0),
                           listaPeinados.get(0),
                           listaDestinos.get(0),
                           listaLugares.get(0),
                           listaProgramas.get(0)));
        setKeeley(new Persona(listaPosiciones.get(1),
                              listaEdades.get(1),
                              listaPeinados.get(1),
                              listaDestinos.get(1),
                              listaLugares.get(1),
                              listaProgramas.get(1)));
        setRachael(new Persona(listaPosiciones.get(2),
                               listaEdades.get(2),
                               listaPeinados.get(2),
                               listaDestinos.get(2),
                               listaLugares.get(2),
                               listaProgramas.get(2)));
        setEilish(new Persona(listaPosiciones.get(3),
                              listaEdades.get(3),
                              listaPeinados.get(3),
                              listaDestinos.get(3),
                              listaLugares.get(03),
                              listaProgramas.get(3)));
        setAmy(new Persona(listaPosiciones.get(4),
                           listaEdades.get(4),
                           listaPeinados.get(4),
                           listaDestinos.get(4),
                           listaLugares.get(4),
                           listaProgramas.get(4)));

		/* SOLUCI�N DEL PROBLEMA
		setGarcia(new Persona(4,4,5));
		setGianuzzi(new Persona(3,2,1));
		setLacourt(new Persona(2,5,4));
		setSiemann(new Persona(1,1,2));
		setSmith(new Persona(5,3,3));
		*/
    }

    public ArrayList listaRandom(ArrayList array){
        ArrayList copy = new ArrayList(array);
        Collections.shuffle(copy);
        return copy;
    }

    @Override
    public String toString() {

        return "-AÑO.HALLO.ENTREGO-\n" +
                "GARCIA: " + this.getGarcia().getAnio() + "." + this.getGarcia().getHallo() + "." + this.getGarcia().getEntrego() + "\n" +
                "GIANUZZI: " + this.getGianuzzi().getAnio() + "." + this.getGianuzzi().getHallo() + "." + this.getGianuzzi().getEntrego() + "\n" +
                "LACOURT: " + this.getLacourt().getAnio() + "." + this.getLacourt().getHallo() + "." + this.getLacourt().getEntrego() + "\n" +
                "SIEMANN: " + this.getSiemann().getAnio() + "." + this.getSiemann().getHallo() + "." + this.getSiemann().getEntrego() + "\n" +
                "SMITH: " + this.getSmith().getAnio() + "." + this.getSmith().getHallo() + "." + this.getSmith().getEntrego() + "\n" +
                "<<APTO>>: " + this.aptitud();
    }
}
