package tp2;

import tp2.arboles.Tree;

public class Main {
    public static void main(String[] args) {
        Tree arbolito = new Tree();
        arbolito.add(10);
//        arbolito.add(5);
//        arbolito.add(2);
//        arbolito.add(8);
//        arbolito.add(15);
//        arbolito.add(12);
//        arbolito.add(18);
//        arbolito.add(16);
        arbolito.printPreOrder();
        System.out.println(arbolito.getHeight());
    }
}
