/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
//AUTHOR: Juan Eyzaguirre
class Node {
    //SE REEMPLAZO LAS VARIABLES INT DE LOS NODOS POR LA CLASE PALABRA DEBIDO A QUE ES CON LA QUE 
    //TIENE INTERES DE TRABAJAR EN LA CLASE TREE.
    public Palabra palabra;        //Nodo.
    public Node leftChild;         // this node's left child
    public Node rightChild;        // this node's right child

    
    //Getter y Setter que se ocuparan en la clase Tree.
    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    
}  // end class Node
