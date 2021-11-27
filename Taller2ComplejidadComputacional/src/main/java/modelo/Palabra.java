/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//AUTHOR: Juan Eyzaguirre.

//CLASE PALABRA SEGUN LA ESTRUCTURA DEFINIDA EN LAS INSTRUCCIONES DEL TALLER.
public class Palabra {

    private String nombre;
    private String significado;
    private String clasificacion;

    public Palabra(String nombre, String significado, String clasificacion) {
        this.nombre = nombre;
        this.significado = significado;
        this.clasificacion = clasificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Palabra: " + nombre + "|| significado: " + significado + "|| clasificacion: " + clasificacion;
    }
}
