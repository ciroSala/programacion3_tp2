package tp2;

import tp2.arboles.Tree;

public class Main {
    public static void main(String[] args) {
        Tree arbolito = new Tree();
        arbolito.add(6);
        arbolito.add(2);
        arbolito.add(10);
        arbolito.add(1);
        arbolito.add(4);
        arbolito.add(8);
        arbolito.add(11);
        arbolito.add(7);
        arbolito.add(9);
        arbolito.add(13);
        arbolito.printPreOrder();
        System.out.println(arbolito.delete(8));
        arbolito.printPreOrder();
    }
}
