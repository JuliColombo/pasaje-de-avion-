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

    public double aptitud() {

        double valor = 0;
        //-----PISTAS-----
        //2)Kanguela(3) no negoci� con Lacourt.
        if (this.getLacourt().getHallo() != 3){valor += 15;}

        //3)Burke(1) lo vendi� a un conde(2).
        if (((this.getGarcia().getHallo() == 1) && (this.getGarcia().getEntrego() == 2)) ||
                ((this.getGianuzzi().getHallo() == 1) && (this.getGianuzzi().getEntrego() == 2)) ||
                ((this.getLacourt().getHallo() == 1) && (this.getLacourt().getEntrego() == 2)) ||
                ((this.getSiemann().getHallo() == 1) && (this.getSiemann().getEntrego() == 2)) ||
                ((this.getSmith().getHallo() == 1) && (this.getSmith().getEntrego() == 2)))
        {valor += 15;}

        //4)El coleccionista chino Ming-Chu(4) se lo compr� al filipino Garc�a...
	/*	if (((this.getGianuzzi().getHallo() == 4) && (this.getGianuzzi().getAnio() == this.getGarcia().getAnio()-1)) ||
			((this.getLacourt().getHallo() == 4) && (this.getLacourt().getAnio() == this.getGarcia().getAnio()-1)) ||
			((this.getSiemann().getHallo() == 4) && (this.getSiemann().getAnio() == this.getGarcia().getAnio()-1)) ||
			((this.getSmith().getHallo() == 4) && (this.getSmith().getAnio() == this.getGarcia().getAnio()-1)))
		{valor += 15;}*/
        if (this.getGarcia().getHallo() == 4){valor += 15;}

        //4bis)... que lo hab�a robado al banquero(1).
        if(((this.getGianuzzi().getAnio() + 1 == this.getGarcia().getAnio()) && (this.getGianuzzi().getEntrego() == 1)) ||
                ((this.getLacourt().getAnio() + 1 == this.getGarcia().getAnio()) && (this.getLacourt().getEntrego() == 1)) ||
                ((this.getSiemann().getAnio() + 1 == this.getGarcia().getAnio()) && (this.getSiemann().getEntrego() == 1)) ||
                ((this.getSmith().getAnio() + 1 == this.getGarcia().getAnio()) && (this.getSmith().getEntrego() == 1)))
        {valor += 15;}

        //5)El �ltimo en recuperarlo lo entreg� a Interpol(3), para �lavar� sus delitos.
        if (((this.getGarcia().getEntrego() == 3) && (this.getGarcia().getAnio() == 5)) ||
                ((this.getGianuzzi().getEntrego() == 3) && (this.getGianuzzi().getAnio() == 5)) ||
                ((this.getLacourt().getEntrego() == 3) && (this.getLacourt().getAnio() == 5)) ||
                ((this.getSiemann().getEntrego() == 3) && (this.getSiemann().getAnio() == 5)) ||
                ((this.getSmith().getEntrego() == 3) && (this.getSmith().getAnio() == 5)))
        {valor += 15;}

        //6)Zarnev(5) lo entreg� a un joyero(4). Treinta a�os antes, el ladr�n hab�a sido Siemann.
        switch (this.getSiemann().getAnio()){
            case 1: //1798 - entonces lo de Zarnev(5) y el joyero(4) fue en 1828(2)
                if (((this.getGarcia().getEntrego() == 4) && (this.getGarcia().getHallo() == 5) && (this.getGarcia().getAnio() == 2)) ||
                        ((this.getLacourt().getEntrego() == 4) && (this.getLacourt().getHallo() == 5) && (this.getLacourt().getAnio() == 2)) ||
                        ((this.getSiemann().getEntrego() == 4) && (this.getSiemann().getHallo() == 5) && (this.getSiemann().getAnio() == 2)) ||
                        ((this.getSmith().getEntrego() == 4) && (this.getSmith().getHallo() == 5) && (this.getSmith().getAnio() == 2)))
                {valor += 15;}
                break;
            case 2: //1828 - entonces lo de Zarnev(5) y el joyero(4) fue en 1858(3)
                if (((this.getGarcia().getEntrego() == 4) && (this.getGarcia().getHallo() == 5) && (this.getGarcia().getAnio() == 3)) ||
                        ((this.getLacourt().getEntrego() == 4) && (this.getLacourt().getHallo() == 5) && (this.getLacourt().getAnio() == 3)) ||
                        ((this.getSiemann().getEntrego() == 4) && (this.getSiemann().getHallo() == 5) && (this.getSiemann().getAnio() == 3)) ||
                        ((this.getSmith().getEntrego() == 4) && (this.getSmith().getHallo() == 5) && (this.getSmith().getAnio() == 3)))
                {valor += 15;}
                break;
            default: //para 1858, 1918 o 1978 no hay fechas validas
                break;
        }

        //7)La entrega al museo(5) se produjo sesenta a�os despu�s del robo de Gianuzzi.
        switch (this.getGianuzzi().getAnio()){
            case 1: //1798 - entonces lo del Museo(5) fue en 1858(3)
                if (((this.getGarcia().getEntrego() == 5) && (this.getGarcia().getAnio() == 3)) ||
                        ((this.getLacourt().getEntrego() == 5) && (this.getLacourt().getAnio() == 3)) ||
                        ((this.getSiemann().getEntrego() == 5) && (this.getSiemann().getAnio() == 3)) ||
                        ((this.getSmith().getEntrego() == 5) && (this.getSmith().getAnio() == 3)))
                {valor += 15;}
                break;
            case 3: //1858 - entonces lo del Museo(5) fue en 1918(4)
                if (((this.getGarcia().getEntrego() == 5) && (this.getGarcia().getAnio() == 4)) ||
                        ((this.getLacourt().getEntrego() == 5) && (this.getLacourt().getAnio() == 4)) ||
                        ((this.getSiemann().getEntrego() == 5) && (this.getSiemann().getAnio() == 4)) ||
                        ((this.getSmith().getEntrego() == 5) && (this.getSmith().getAnio() == 4)))
                {valor += 15;}
                break;
            case 4: //1918 - entonces lo del Museo(5) fue en 1978(5)
                if (((this.getGarcia().getEntrego() == 5) && (this.getGarcia().getAnio() == 5)) ||
                        ((this.getLacourt().getEntrego() == 5) && (this.getLacourt().getAnio() == 5)) ||
                        ((this.getSiemann().getEntrego() == 5) && (this.getSiemann().getAnio() == 5)) ||
                        ((this.getSmith().getEntrego() == 5) && (this.getSmith().getAnio() == 5)))
                {valor += 15;}
                break;
            default: //para 1828 o 1978 no hay fechas validas
                break;
        }

        //8)Haanen(2) lo hall� en 1858(3).
        if (((this.getGarcia().getHallo() == 2) && (this.getGarcia().getAnio() == 3)) ||
                ((this.getGianuzzi().getHallo() == 2) && (this.getGianuzzi().getAnio() == 3)) ||
                ((this.getLacourt().getHallo() == 2) && (this.getLacourt().getAnio() == 3)) ||
                ((this.getSiemann().getHallo() == 2) && (this.getSiemann().getAnio() == 3)) ||
                ((this.getSmith().getHallo() == 2) && (this.getSmith().getAnio() == 3)))
        {valor += 15;}

        //-----INVALIDA-----
        //No deberia haber dos o mas Personas con algun atributo igual
        if(!esValido(this.getGarcia(), this.getGianuzzi())) {valor -= 50;}
        if(!esValido(this.getGarcia(), this.getLacourt())) {valor -= 50;}
        if(!esValido(this.getGarcia(), this.getSiemann())) {valor -= 50;}
        if(!esValido(this.getGarcia(), this.getSmith())) {valor -= 50;}

        if(!esValido(this.getGianuzzi(), this.getLacourt())) {valor -= 50;}
        if(!esValido(this.getGianuzzi(), this.getSiemann())) {valor -= 50;}
        if(!esValido(this.getGianuzzi(), this.getSmith())) {valor -= 50;}

        if(!esValido(this.getLacourt(), this.getSiemann())) {valor -= 50;}
        if(!esValido(this.getLacourt(), this.getSmith())) {valor -= 50;}

        if(!esValido(this.getSiemann(), this.getSmith())) {valor -= 50;}
        return valor;
    }

    public boolean esValido (Persona ladri1, Persona ladri2){
        boolean res;
        res = ((ladri1.getAnio() != ladri2.getAnio()) &&
                (ladri1.getHallo() != ladri2.getHallo()) &&
                (ladri1.getEntrego() != ladri2.getEntrego()));
        return res;
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
