/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Scanner;
import modelo.Tree;
//AUTHOR: Juan Eyzaguirre
public class MetodosInsercion {

    //CLASE DONDE SE HACE USO DE LOS METODOS PROPIOS CREADOS EN LA CLASE TREE PARA UNA ESTRUCTURA MAS ORDENADA.
    
    Tree palabra = new Tree();
    public Scanner s = new Scanner(System.in);

    public void insertWords() {
        palabra.insert("Desahuciado", "Sin esperanza o desesperado", "Adjetivo");
        palabra.insert("Estrella", "Astro o cuerpo celeste que brilla con luz propia en el firmamento", "Sustantivo");
        palabra.insert("Nombre", "Palabra o conjunto de palabras con las que designan y se distinguen los seres vivos y los objetos fisicos o abstractos", "Sustantivo");
        palabra.insert("Bebestible", "Bebible", "Adjetivo");
        palabra.insert("Licor", "Bebida alcoholica de alta graduación que se obtiene por destilación", "Sustantivo");
        palabra.insert("Bebida", "Sustancia líquida que se bebe, en especial la elaborada o la compuesta de varios ingrediente", "Sustantivo");
    }

    public void searchWord() {
        System.out.println("Por favor ingrese la palabra que desea buscar");
        String palabraInsertada = s.nextLine();
        System.out.println("Palabra ingresada en la consola: " + palabraInsertada);
        palabra.find(palabraInsertada).toString();
    }

    public void deleteWord() {
        System.out.println("Por favor ingrese la palabra que desea eliminar");
        String palabraInsertada = s.nextLine();
        System.out.println("Palabra ingresada en la consola: " + palabraInsertada);
        palabra.delete(palabraInsertada);
    }
    public void order(){
        palabra.traverse(2);
    }
}
