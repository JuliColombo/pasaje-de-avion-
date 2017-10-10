package main.java.ar.edu.utn.frba.ia.ag.ejemplos.pasajeDeAvion;

/**
 * Created by julicolombo on 10/7/17.
 */
public class Persona {
    public Persona(Integer unaPosicion, Integer unaEdad, String unPeinado, String unDestino, String unLugar, String unPrograma){
        setPosicion(unaPosicion);
        setEdad(unaEdad);
        setPeinado(unPeinado);
        setDestino(unDestino);
        setLugar(unLugar);
        setPrograma(unPrograma);
    }

    private Integer posicion;
    /*1 - 1
     *2 - 2
     *3 - 3
     *4 - 4
     *5 - 5*/
    private Integer edad;
    /*1 - 14
     *2 - 21
     *3 - 46
     *4 - 52
     *5 - 81*/
    private String peinado;
    /*1 - afro
     *2 - largo
     *3 - liso
     *4 - rizado
     *5 - calvo*/
    private String destino ;
	/*1 - Francia
	 *2 - Australia
	 *3 - Inglaterra
	 *4 - África
	 *5 - Italia*/
    private String lugar ;
	/*1 - hotel
	 *2 - ciudad
	 *3 - pueblo
	 *4 - granja
	 *5 - albergue juvenil*/
    private String programa ;
	/*1 - Los Simpson
	 *2 - Coronation Street
	 *3 - Eastenders
	 *4 - Desperate Houswifes
	 *5 - Neighbors*/

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPeinado() {
        return peinado;
    }

    public void setPeinado(String peinado) {
        this.peinado = peinado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /*@Override*/
    public String toString() {

        return "Posicion: " + this.getPosicion()
                + ", edad: " + this.getEdad()
                + ", peinado: " + this.getPeinado()
                + ", destino: " + this.getDestino()
                + ", lugar: " + this.getLugar()
                + " y programa:" + this.getPrograma();
    }
}
