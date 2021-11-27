/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller2complejidadcomputacional;

import controlador.MetodosInsercion;


//AUTHOR: Juan Eyzaguirre
public class Main {

    public static void main(String[] args) {
        MetodosInsercion lanzador = new MetodosInsercion();
        lanzador.insertWords();
        lanzador.searchWord();
        lanzador.deleteWord();
        lanzador.order();
    }
}
