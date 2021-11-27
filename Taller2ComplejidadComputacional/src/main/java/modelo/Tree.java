/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*;               // for Stack class

//IMPORTANTE LEER.
////////////////////////////////////////////////////////////////
//LOS CODIGOS DE ESTA CLASE FUERON CREADOS A PARTIR DE LA REFERENCIA DEL CANAL DE YOUTUBE NICOSIORED
//QUIEN ENSEÑA METODOS DE ORDENAMIENTO, INSERCION ADEMÁS DE FUNCIONES COMPLEMENTARIAS EN ARBOLES BINARIOS.
////////////////////////////////////////////////////////////////

//AUTHOR: Juan Eyzaguirre.
 public class Tree {

    private Node root;             // first node of tree

// -------------------------------------------------------------
    public Tree() // constructor
    {
        root = null;
    }            // no nodes in tree yet
// -------------------------------------------------------------

    public boolean goToLeft(String receivedName, String newName) {

        boolean goToLeft = false;
        short initialLong = 0;
        short finalLong = 0;

        char[] alphabet = alphabet();

        if (newName.length() > receivedName.length()) {
            finalLong = (short) receivedName.length();
        } else if (receivedName.length() > newName.length()) {
            finalLong = (short) newName.length();
        } else {
            finalLong = (short) newName.length();
        }

        while (initialLong < finalLong) {
            int charAtNN = newName.charAt(initialLong);
            int charAtRN = receivedName.charAt(initialLong);
            if (charAtNN!=charAtRN) {
                int auxInitial=0,auxActual=0;
                char charAtRNV = receivedName.charAt(initialLong);
                char charAtNNV = newName.charAt(initialLong);
                for (int i = 0; i < alphabet.length; i++) {
                    if(charAtRNV==alphabet[i]){
                        auxActual= i;
                    }else if(charAtNNV == alphabet[i]){
                        auxInitial = i;
                    }
                }
                if(auxActual>auxInitial){
                    goToLeft=true;
                    break;
                }else if(auxInitial>auxActual){
                    goToLeft=false;
                    break;
                }
            }else if(charAtNN==charAtRN){
                if(initialLong == finalLong -1 && newName.length()> receivedName.length()){
                    goToLeft=false;
                    break;
                }else if(initialLong == finalLong -1 && receivedName.length() > newName.length()){
                    goToLeft=true;
                    break;
                }
            }
        }
        return goToLeft;
    }

    public char[] alphabet() {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z'};
        return alphabet;
    }

    public Palabra find(String key) // find node with given key
    {                           // (assumes non-empty tree)
        Node current = root;               // start at root
        while (!current.palabra.getNombre().equalsIgnoreCase(key)) // while no match,
        {
            if (goToLeft(key.toUpperCase(), current.palabra.getNombre().toUpperCase())) // go left?
            {
                current = current.leftChild;
            } else // or go right?
            {
                current = current.rightChild;
            }
            if (current == null) // if no child,
            {
                return null;                 // didn't find it
            }
        }
        return current.palabra;                    // found it
    }  // end find()
// -------------------------------------------------------------

    public void insert(String nombre, String significado, String clasificacion) {
        Node newNode = new Node();    // make new node
            newNode.palabra = new Palabra(nombre, significado, clasificacion); // insert data
        

        if (root == null) // no node in root
        {
            root = newNode;
        } else // root occupied
        {
            Node current = root;       // start at root
            Node parent;
            while (true) // (exits internally)
            {
                parent = current;
                if (goToLeft(nombre.toUpperCase(), current.palabra.getNombre().toUpperCase())) // go left?
                {
                    current = current.leftChild;
                    if (current == null) // if end of the line,
                    {                 // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                } // end if go left
                else // or go right?
                {
                    current = current.rightChild;
                    if (current == null) // if end of the line
                    {                 // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                }  // end else go right
            }  // end while
        }  // end else not root
    }  // end insert()
// -------------------------------------------------------------

    public boolean delete(String key) // delete node with given key
    {                           // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (!current.palabra.getNombre().equalsIgnoreCase(key)) // search for node
        {
            parent = current;
            if (goToLeft(key.toUpperCase(), current.palabra.getNombre().toUpperCase())) // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) // end of the line,
            {
                return false;                // didn't find it
            }
        }  // end while
        // found node to delete

        // if no children, simply delete it
        if (current.leftChild == null
                && current.rightChild == null) {
            if (current == root) // if root,
            {
                root = null;                 // tree is empty
            } else if (isLeftChild) {
                parent.leftChild = null;     // disconnect
            } else // from parent
            {
                parent.rightChild = null;
            }
        } // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);

            // connect parent of current to successor instead
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }

            // connect successor to current's left child
            successor.leftChild = current.leftChild;
        }  // end else two children
        // (successor cannot have a left child)
        return true;                                // success
    }  // end delete()
// -------------------------------------------------------------
    // returns node with next-highest value after delNode
    // goes to right child, then right child's left descendents

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;   // go to right child
        while (current != null) // until no more
        {                                 // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild;      // go to left child
        }
        // if successor not
        if (successor != delNode.rightChild) // right child,
        {                                 // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
// -------------------------------------------------------------

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
// -------------------------------------------------------------

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.palabra.toString() + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }
// -------------------------------------------------------------

    private void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            localRoot.getPalabra().toString();
            inOrder(localRoot.rightChild);
        }
    }
// -------------------------------------------------------------

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.palabra.toString() + " ");
        }
    }
// -------------------------------------------------------------

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.palabra.toString());
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()
// -------------------------------------------------------------
}  // end class Tree
////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////

