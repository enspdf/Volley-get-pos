package com.example.sebastianhiguita.postvolley;

/**
 * Created by sebastian.higuita on 23/09/2016.
 */
public class ParqueaderoDTO {
    int idParqueadero;
    String nombreParqueadero;

    public ParqueaderoDTO() {
    }

    public ParqueaderoDTO(int idParqueadero, String nombreParqueadero) {
        this.idParqueadero = idParqueadero;
        this.nombreParqueadero = nombreParqueadero;
    }

    public int getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(int idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getNombreParqueadero() {
        return nombreParqueadero;
    }

    public void setNombreParqueadero(String nombreParqueadero) {
        this.nombreParqueadero = nombreParqueadero;
    }
}
