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
    }


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


    public double sumarAptitud(double valor) {
        return valor + 10;
    }

    public double sumarAptitudSiCumple(double valor, boolean condicion) {
        if(condicion){
            return sumarAptitud(valor);
        }
        return valor;
    }

    public boolean estaAdelante(int posicion1, int posicion2) {
        return posicion1 == posicion2 - 1;
    }

    public boolean estaAtras(int posicion1, int posicion2) {
        return posicion1 == posicion2 + 1;
    }

    public boolean estaAlLado(int posicion1, int posicion2) {
        return estaAdelante(posicion1, posicion2) || estaAtras(posicion1, posicion2);
    }

    public double aptitud() {

        String DESPERATE_HOUSWIVES = PasajeDeAvion.DESPERATE_HOUSWIVES;
        String SIMPSON = PasajeDeAvion.DESPERATE_HOUSWIVES;
        String CORONATION_STREET = PasajeDeAvion.CORONATION_STREET;
        String EASTENDERS = PasajeDeAvion.EASTENDERS;
        String NEIGHBORS = PasajeDeAvion.NEIGHBORS;

        double valor = 0;
        boolean condicion;
        boolean condicionBob;
        boolean condicionKeeley;
        boolean condicionRachael;
        boolean condicionAmy;
        boolean condicionEilish;

        int posicionBob = getBob().getPosicion();
        int posicionKeeley = getKeeley().getPosicion();
        int posicionRachael = getRachael().getPosicion();
        int posicionAmy = getAmy().getPosicion();
        int posicionEilish = getEilish().getPosicion();

        int edadBob = getBob().getEdad();
        int edadKeeley = getKeeley().getEdad();
        int edadRachael = getRachael().getEdad();
        int edadAmy = getAmy().getEdad();
        int edadEilish = getEilish().getEdad();

        String peinadoBob = getBob().getPeinado();
        String peinadoKeeley = getKeeley().getPeinado();
        String peinadoRachael = getRachael().getPeinado();
        String peinadoAmy = getAmy().getPeinado();
        String peinadoEilish = getEilish().getPeinado();

        String destinoBob = getBob().getDestino();
        String destinoKeeley = getKeeley().getDestino();
        String destinoRachael = getRachael().getDestino();
        String destinoAmy = getAmy().getDestino();
        String destinoEilish = getEilish().getDestino();

        String lugarBob = getBob().getLugar();
        String lugarKeeley = getKeeley().getLugar();
        String lugarRachael = getRachael().getLugar();
        String lugarAmy = getAmy().getLugar();
        String lugarEilish = getEilish().getLugar();

        String programaBob = getBob().getPrograma();
        String programaKeeley = getKeeley().getPrograma();
        String programaRachael = getRachael().getPrograma();
        String programaAmy = getAmy().getPrograma();
        String programaEilish = getEilish().getPrograma();

//        1. La persona que está en el medio mira Desperate Housewives
            condicionBob = posicionBob == 3 && programaBob.equals(DESPERATE_HOUSWIVES);
            condicionKeeley = posicionKeeley == 3 && programaKeeley.equals(DESPERATE_HOUSWIVES);
            condicionRachael = posicionRachael == 3 && programaRachael.equals(DESPERATE_HOUSWIVES);
            condicionAmy = posicionAmy == 3 && programaAmy.equals(DESPERATE_HOUSWIVES);
            condicionEilish = posicionEilish == 3 && programaEilish.equals(DESPERATE_HOUSWIVES);

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        2. Bob es el primero en la cola
            valor = sumarAptitudSiCumple(valor, posicionBob == 1);

//        3. La persona que ve a los Simpson está al lado de la persona que vive en un albergue juvenil
            condicionBob = programaBob.equals(SIMPSON) && (estaAlLado(posicionBob, posicionKeeley) &&
                           lugarKeeley.equals("albergue juvenil") ||
                           estaAlLado(posicionBob, posicionRachael) && lugarRachael.equals("albergue juvenil") ||
                           estaAlLado(posicionBob, posicionAmy) && lugarAmy.equals("albergue juvenil") ||
                           estaAlLado(posicionBob, posicionEilish) && lugarEilish.equals("albergue juvenil"));
            condicionKeeley = programaKeeley.equals(SIMPSON) && (estaAlLado(posicionKeeley, posicionBob) &&
                              lugarBob.equals("albergue juvenil") ||
                              estaAlLado(posicionKeeley, posicionRachael) && lugarRachael.equals("albergue juvenil") ||
                              estaAlLado(posicionKeeley, posicionAmy) && lugarAmy.equals("albergue juvenil") ||
                              estaAlLado(posicionKeeley, posicionEilish) && lugarEilish.equals("albergue juvenil"));
            condicionRachael = programaRachael.equals(SIMPSON) && (estaAlLado(posicionRachael, posicionBob) &&
                               lugarBob.equals("albergue juvenil") ||
                               estaAlLado(posicionRachael, posicionKeeley) && lugarKeeley.equals("albergue juvenil") ||
                               estaAlLado(posicionRachael, posicionAmy) && lugarAmy.equals("albergue juvenil") ||
                               estaAlLado(posicionEilish, posicionEilish) && lugarEilish.equals("albergue juvenil"));
            condicionAmy = programaAmy.equals(SIMPSON) && (estaAlLado(posicionAmy, posicionBob) &&
                           lugarBob.equals("albergue juvenil") ||
                           estaAlLado(posicionAmy, posicionKeeley) && lugarKeeley.equals("albergue juvenil") ||
                           estaAlLado(posicionAmy, posicionRachael) && lugarRachael.equals("albergue juvenil") ||
                           estaAlLado(posicionAmy, posicionEilish) && lugarEilish.equals("albergue juvenil"));
            condicionEilish = programaEilish.equals(SIMPSON) && (estaAlLado(posicionEilish, posicionBob) &&
                              lugarBob.equals("albergue juvenil") ||
                              estaAlLado(posicionEilish, posicionKeeley) && lugarKeeley.equals("albergue juvenil") ||
                              estaAlLado(posicionEilish, posicionRachael) && lugarRachael.equals("albergue juvenil") ||
                              estaAlLado(posicionEilish, posicionAmy) && lugarAmy.equals("albergue juvenil"));

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        4. La persona que va a África está detrás de Rachael
            condicionBob = destinoBob.equals("África") && estaAtras(posicionBob, posicionRachael);
            condicionKeeley = destinoKeeley.equals("África") && estaAtras(posicionKeeley, posicionRachael);
            condicionAmy = destinoAmy.equals("África") && estaAtras(posicionAmy, posicionRachael);
            condicionEilish = destinoEilish.equals("África") && estaAtras(posicionEilish, posicionRachael);

            condicion = condicionBob || condicionKeeley || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        5. La persona que vive en un pueblo tiene 52 años
            condicionBob = lugarBob.equals("pueblo") && edadBob == 52;
            condicionKeeley = lugarKeeley.equals("pueblo") && edadKeeley == 52;
            condicionRachael = lugarRachael.equals("pueblo") && edadRachael == 52;
            condicionAmy = lugarAmy.equals("pueblo") && edadAmy == 52;
            condicionEilish = lugarEilish.equals("pueblo") && edadEilish == 52;

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        6. La persona que va a Australia tiene el pelo liso
            condicionBob = destinoBob.equals("Australia") && peinadoBob.equals("liso");
            condicionKeeley = destinoKeeley.equals("Australia") && peinadoKeeley.equals("liso");
            condicionRachael = destinoRachael.equals("Australia") && peinadoRachael.equals("liso");
            condicionAmy = destinoAmy.equals("Australia") && peinadoAmy.equals("liso");
            condicionEilish = destinoEilish.equals("Australia") && peinadoEilish.equals("liso");

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        7. La persona que viaja a África mira Desperate Housewives
            condicionBob = destinoBob.equals("África") && programaBob.equals(DESPERATE_HOUSWIVES);
            condicionKeeley = destinoKeeley.equals("África") && programaKeeley.equals(DESPERATE_HOUSWIVES);
            condicionRachael = destinoRachael.equals("África") && programaRachael.equals(DESPERATE_HOUSWIVES);
            condicionAmy = destinoAmy.equals("África") && programaAmy.equals(DESPERATE_HOUSWIVES);
            condicionEilish = destinoEilish.equals("África") && programaEilish.equals(DESPERATE_HOUSWIVES);

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        8. El jugador de 14 años está al final de la cola
            condicionBob = posicionBob == 5 && edadBob == 14;
            condicionKeeley = posicionKeeley == 5 && edadKeeley == 14;
            condicionRachael = posicionRachael == 5 && edadRachael == 14;
            condicionAmy = posicionAmy == 5 && edadAmy == 14;
            condicionEilish = posicionEilish == 5 && edadEilish == 14;

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        9. Amy mira a Eastenders
            valor = sumarAptitudSiCumple(valor, programaAmy.equals(EASTENDERS));

//        10. La persona que va a Italia tiene el pelo largo
            condicionBob = destinoBob.equals("Italia") && peinadoBob.equals("largo");
            condicionKeeley = destinoKeeley.equals("Italia") && peinadoKeeley.equals("largo");
            condicionRachael = destinoRachael.equals("Italia") && peinadoRachael.equals("largo");
            condicionAmy = destinoAmy.equals("Italia") && peinadoAmy.equals("largo");
            condicionEilish = destinoEilish.equals("Italia") && peinadoEilish.equals("largo");

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        11. Keeley vive en un pueblo
            valor = sumarAptitudSiCumple(valor, lugarKeeley.equals("pueblo"));

//        12. El joven de 46 años es calvo
            condicionBob = edadBob == 46 && peinadoBob.equals("calvo");
            condicionKeeley = edadKeeley == 46 && peinadoKeeley.equals("calvo");
            condicionRachael = edadRachael == 46 && peinadoRachael.equals("calvo");
            condicionAmy = edadAmy == 46 && peinadoAmy.equals("calvo");
            condicionEilish = edadEilish == 46 && peinadoEilish.equals("calvo");

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        13. El cuarto en la cola va a Inglaterra
            condicionBob = posicionBob == 4 && destinoBob.equals("Inglaterra");
            condicionKeeley = posicionKeeley == 4 && destinoKeeley.equals("Inglaterra");
            condicionRachael = posicionRachael == 4 && destinoRachael.equals("Inglaterra");
            condicionAmy = posicionAmy == 4 && destinoAmy.equals("Inglaterra");
            condicionEilish = posicionEilish == 4 && destinoEilish.equals("Inglaterra");

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        14. Las personas que ven Desperate Housewives y Neighbors están uno atras del otro
            condicionBob = programaBob.equals(DESPERATE_HOUSWIVES) && (estaAtras(posicionBob, posicionKeeley) &&
                           programaKeeley.equals(NEIGHBORS) ||
                           estaAtras(posicionBob, posicionRachael) && programaRachael.equals(NEIGHBORS) ||
                           estaAtras(posicionBob, posicionAmy) && programaAmy.equals(NEIGHBORS) ||
                           estaAtras(posicionBob, posicionEilish) && programaEilish.equals(NEIGHBORS));
            condicionKeeley = programaKeeley.equals(DESPERATE_HOUSWIVES) && (estaAtras(posicionKeeley, posicionBob) &&
                              programaBob.equals(NEIGHBORS) ||
                              estaAtras(posicionKeeley, posicionRachael) && programaRachael.equals(NEIGHBORS) ||
                              estaAtras(posicionKeeley, posicionAmy) && programaAmy.equals(NEIGHBORS) ||
                              estaAtras(posicionKeeley, posicionEilish) && programaEilish.equals(NEIGHBORS));
            condicionRachael = programaRachael.equals(DESPERATE_HOUSWIVES) && (estaAtras(posicionRachael, posicionBob) &&
                               programaBob.equals(NEIGHBORS) ||
                               estaAtras(posicionRachael, posicionKeeley) && programaKeeley.equals(NEIGHBORS) ||
                               estaAtras(posicionRachael, posicionAmy) && programaAmy.equals(NEIGHBORS) ||
                               estaAtras(posicionRachael, posicionEilish) && programaEilish.equals(NEIGHBORS));
            condicionAmy = programaAmy.equals(DESPERATE_HOUSWIVES) && (estaAtras(posicionAmy, posicionBob) &&
                           programaBob.equals(NEIGHBORS) ||
                           estaAtras(posicionAmy, posicionKeeley) && programaKeeley.equals(NEIGHBORS) ||
                           estaAtras(posicionAmy, posicionRachael) && programaRachael.equals(NEIGHBORS) ||
                           estaAtras(posicionAmy, posicionEilish) && programaEilish.equals(NEIGHBORS));
            condicionEilish = programaEilish.equals(DESPERATE_HOUSWIVES) && (estaAtras(posicionEilish, posicionBob) &&
                              programaEilish.equals(NEIGHBORS) ||
                              estaAtras(posicionEilish, posicionKeeley) && programaKeeley.equals(NEIGHBORS) ||
                              estaAtras(posicionEilish, posicionRachael) && programaRachael.equals(NEIGHBORS) ||
                              estaAtras(posicionEilish, posicionAmy) && programaAmy.equals(NEIGHBORS));

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        15. La persona que mira Coronation Street está al lado de la persona con un afro
            condicionBob = programaBob.equals(CORONATION_STREET) && (estaAlLado(posicionBob, posicionKeeley) &&
                           peinadoKeeley.equals("afro") ||
                           estaAlLado(posicionBob, posicionRachael) && peinadoRachael.equals("afro") ||
                           estaAlLado(posicionBob, posicionAmy) && peinadoAmy.equals("afro") ||
                           estaAlLado(posicionBob, posicionEilish) && peinadoEilish.equals("afro"));
            condicionKeeley = programaKeeley.equals(CORONATION_STREET) && (estaAlLado(posicionKeeley, posicionBob) &&
                              peinadoBob.equals("afro") ||
                              estaAlLado(posicionKeeley, posicionRachael) && peinadoRachael.equals("afro") ||
                              estaAlLado(posicionKeeley, posicionAmy) && peinadoAmy.equals("afro") ||
                              estaAlLado(posicionKeeley, posicionEilish) && peinadoEilish.equals("afro"));
            condicionRachael = programaRachael.equals(CORONATION_STREET) && (estaAlLado(posicionRachael, posicionBob) &&
                               peinadoBob.equals("afro") ||
                               estaAlLado(posicionRachael, posicionKeeley) && peinadoKeeley.equals("afro") ||
                               estaAlLado(posicionRachael, posicionAmy) && peinadoAmy.equals("afro") ||
                               estaAlLado(posicionRachael, posicionEilish) && peinadoEilish.equals("afro"));
            condicionAmy = programaAmy.equals(CORONATION_STREET) && (estaAlLado(posicionAmy, posicionBob) &&
                           peinadoBob.equals("afro") ||
                           estaAlLado(posicionAmy, posicionKeeley) && peinadoKeeley.equals("afro") ||
                           estaAlLado(posicionAmy, posicionRachael) && peinadoRachael.equals("afro") ||
                           estaAlLado(posicionAmy, posicionEilish) && peinadoEilish.equals("afro"));
            condicionEilish = programaEilish.equals(CORONATION_STREET) && (estaAlLado(posicionEilish, posicionBob) &&
                              peinadoBob.equals("afro") ||
                              estaAlLado(posicionEilish, posicionKeeley) && peinadoKeeley.equals("afro") ||
                              estaAlLado(posicionEilish, posicionRachael) && peinadoRachael.equals("afro") ||
                              estaAlLado(posicionEilish, posicionAmy) && peinadoAmy.equals("afro"));


            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        16. La persona que le sigue a en la fila Rachael tiene un afro
            condicionBob = peinadoBob.equals("afro") && estaAtras(posicionBob, posicionRachael);
            condicionKeeley = peinadoKeeley.equals("afro") && estaAtras(posicionKeeley, posicionRachael);
            condicionAmy = peinadoAmy.equals("afro") && estaAtras(posicionAmy, posicionRachael);
            condicionEilish = peinadoEilish.equals("afro") && estaAtras(posicionEilish, posicionRachael);

            condicion = condicionBob || condicionKeeley || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        17. El joven de 21 años vive en un albergue juvenil
            condicionBob = lugarBob.equals("albergue juvenil") && edadBob == 21;
            condicionKeeley = lugarKeeley.equals("albergue juvenil") && edadKeeley == 21;
            condicionRachael = lugarRachael.equals("albergue juvenil") && edadRachael == 21;
            condicionAmy = lugarAmy.equals("albergue juvenil") && edadAmy == 21;
            condicionEilish = lugarEilish.equals("albergue juvenil") && edadEilish == 21;

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        18. La persona que mira Corrie tiene el pelo largo
            condicionBob = peinadoBob.equals("largo") && programaBob.equals(CORONATION_STREET);
            condicionKeeley = peinadoKeeley.equals("largo") && programaKeeley.equals(CORONATION_STREET);
            condicionRachael = peinadoRachael.equals("largo") && programaRachael.equals(CORONATION_STREET);
            condicionAmy = peinadoAmy.equals("largo") && programaAmy.equals(CORONATION_STREET);
            condicionEilish = peinadoEilish.equals("largo") && programaEilish.equals(CORONATION_STREET);

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        19. El de 81 años vive en una granja
            condicionBob = lugarBob.equals("granja") && edadBob == 81;
            condicionKeeley = lugarKeeley.equals("granja") && edadKeeley == 81;
            condicionRachael = lugarRachael.equals("granja") && edadRachael == 81;
            condicionAmy = lugarAmy.equals("granja") && edadAmy == 81;
            condicionEilish = lugarEilish.equals("granja") && edadEilish == 81;

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        20. La persona que viaja a Francia vive en una ciudad
            condicionBob = destinoBob.equals("Francia") && lugarBob.equals("ciudad");
            condicionKeeley = destinoKeeley.equals("Francia") && lugarKeeley.equals("ciudad");
            condicionRachael = destinoRachael.equals("Francia") && lugarRachael.equals("ciudad");
            condicionAmy = destinoAmy.equals("Francia") && lugarAmy.equals("ciudad");
            condicionEilish = destinoEilish.equals("Francia") && lugarEilish.equals("ciudad");

            condicion = condicionBob || condicionKeeley || condicionRachael || condicionAmy || condicionEilish;
            valor = sumarAptitudSiCumple(valor, condicion);

//        21. Eilish no está al lado de la persona con el pelo liso
            condicionEilish = !estaAlLado(posicionEilish, posicionBob) && peinadoBob.equals("liso") ||
                              !estaAlLado(posicionEilish, posicionKeeley) && peinadoKeeley.equals("liso") ||
                              !estaAlLado(posicionEilish, posicionRachael) && peinadoRachael.equals("liso") ||
                              !estaAlLado(posicionEilish, posicionAmy) && peinadoAmy.equals("liso");
            valor = sumarAptitudSiCumple(valor, condicionEilish);

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
        PasajeDeAvion pasajeDeAvion = new PasajeDeAvion();

        ArrayList<Integer> listaPosiciones = listaRandom(pasajeDeAvion.getPosiones());
        ArrayList<Integer> listaEdades = listaRandom(pasajeDeAvion.getEdades());
        ArrayList<String> listaPeinados = listaRandom(pasajeDeAvion.getPeinados());
        ArrayList<String> listaDestinos = listaRandom(pasajeDeAvion.getDestinos());
        ArrayList<String> listaLugares = listaRandom(pasajeDeAvion.getLugares());
        ArrayList<String> listaProgramas = listaRandom(pasajeDeAvion.getProgramas());

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
                              listaLugares.get(3),
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

        return  "-POSICION.EDAD.PEINADO.DESTINO.LUGAR.PROGRAMA-\n" +
                "Bob: " + this.getBob().getPosicion() + "." +
                            this.getBob().getEdad() + "." +
                            this.getBob().getPeinado() +
                            this.getBob().getDestino() + "." +
                            this.getBob().getLugar() + "." +
                            this.getBob().getPrograma() + "\n" +
                "Keeley: " + this.getKeeley().getPosicion() + "." +
                            this.getKeeley().getEdad() + "." +
                            this.getKeeley().getPeinado() +
                            this.getKeeley().getDestino() + "." +
                            this.getKeeley().getLugar() + "." +
                            this.getKeeley().getPrograma() + "\n" +
                "Rachael: " + this.getRachael().getPosicion() + "." +
                                this.getRachael().getEdad() + "." +
                                this.getRachael().getPeinado() +
                                this.getRachael().getDestino() + "." +
                                this.getRachael().getLugar() + "." +
                                this.getRachael().getPrograma() + "\n" +
                "Amy: " + this.getAmy().getPosicion() + "." +
                            this.getAmy().getEdad() + "." +
                            this.getAmy().getPeinado() +
                            this.getAmy().getDestino() + "." +
                            this.getAmy().getLugar() + "." +
                            this.getAmy().getPrograma() + "\n" +
                "Eilish: " + this.getEilish().getPosicion() + "." +
                            this.getEilish().getEdad() + "." +
                            this.getEilish().getPeinado() +
                            this.getEilish().getDestino() + "." +
                            this.getEilish().getLugar() + "." +
                            this.getEilish().getPrograma() + "\n" +
                "<<APTO>>: " + this.aptitud();
    }
}
