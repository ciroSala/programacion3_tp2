package tp2.arboles;

import java.util.ArrayList;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public Integer getRoot(){
        if(this.root!=null){
            return this.root.getValue();
        }else{
            return -1;
        }
    }

    public boolean isEmpty(){
        return this.root==null;
    }

    public void printPreOrder() {
        if(this.root!=null) {
            this.printPreOrder(this.root);
        }
    }
    private void printPreOrder(TreeNode nodo){
        if(nodo!=null){
            System.out.println(nodo.getValue());
            printPreOrder(nodo.getLeft());
            printPreOrder(nodo.getRight());
        }else{
            System.out.println('-');
        }
    }

    public void printInOrder() {
        if(this.root!=null) {
            this.printInOrder(this.root);
        }
    }
    private void printInOrder(TreeNode nodo){
        if(nodo!=null){
            printInOrder(nodo.getLeft());
            System.out.println(nodo.getValue());
            printInOrder(nodo.getRight());
        }
    }

    public void printPostOrder() {
        if(this.root!=null) {
            this.printPostOrder(this.root);
        }
    }
    private void printPostOrder(TreeNode nodo){
        if(nodo!=null){
            printPostOrder(nodo.getLeft());
            printPostOrder(nodo.getRight());
            System.out.println(nodo.getValue());
        }
    }

    public Integer getHeight(){
        if(this.root!=null){
            return getHeight(this.root);
        }else{
            return 0;
        }
    }
    private Integer getHeight(TreeNode nodo){
        Integer height1;
        Integer height2;
        if(nodo!=null){
            height1 = this.getHeight(nodo.getLeft());
            height2 = this.getHeight(nodo.getRight());
            //me quedo con la mayor altura y la devuelvo +1
            if (height1>height2){
                return height1+1;
            } else if (height2>height1) {
                return height2+1;
            }else{
                return height1+1;
            }
        }else{
            return 0;
        }
    }

    public boolean hasElem(Integer value){
        if(this.root!=null){
            return this.hasElem(this.root, value);
        }else{
            return false;
        }
    }

    private boolean hasElem(TreeNode nodo, Integer value){
        if(nodo.getValue()>value){
            if(nodo.getLeft()!=null){
                return this.hasElem(nodo.getLeft(),value);
            }else{
                return false;
            }
        } else if (nodo.getValue()<value) {
            if(nodo.getRight()!=null){
                return this.hasElem(nodo.getRight(),value);
            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public ArrayList<Integer> getLongestBranch(){
        if(this.root!=null) {
            return getLongestBranch(this.root);
        }else {
            ArrayList<Integer> arreglo = new ArrayList<>();
            return arreglo;
        }
    }



    private ArrayList<Integer> getLongestBranch(TreeNode nodo){
        if(nodo!=null) {
            ArrayList<Integer> arr1 = getLongestBranch(nodo.getLeft());
            ArrayList<Integer> arr2 = getLongestBranch(nodo.getRight());
            if(arr1.size() > arr2.size()) {
                arr1.add(nodo.getValue());
                return arr1;
            }else if(arr1.size() < arr2.size()){
                arr2.add(nodo.getValue());
                return arr2;
            }else {
                arr1.add(nodo.getValue());
                return arr1;
            }
        }else {
            return new ArrayList<Integer>();
        }
    }


    public ArrayList<Integer> getFrontera(){
        if(this.root == null) {
            return new ArrayList<>();
        }
        return this.getFrontera(this.root);
    }

    private ArrayList<Integer> getFrontera(TreeNode nodo) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (nodo != null) {
            // Si es una hoja, añadir su valor
            if (nodo.isLeaf()) {
                arr.add(nodo.getValue());
            } else {
                // Si no es una hoja, recorrer sus hijos
                if (nodo.getLeft() != null) {
                    ArrayList<Integer> arr1 = this.getFrontera(nodo.getLeft());
                    arr.addAll(arr1);
                }
                if (nodo.getRight() != null) {
                    ArrayList<Integer> arr2 = this.getFrontera(nodo.getRight());
                    arr.addAll(arr2);
                }
            }
        }
        return arr;
    }

    public Integer getMaxElem(){
        if(this.root!=null){
            return getMaxElem(this.root);
        }
        return -1;
    }

    private Integer getMaxElem(TreeNode nodo){
        if(nodo.getRight()!=null){
            return this.getMaxElem(nodo.getRight());
        }
        return nodo.getValue();
    }

    public ArrayList<Integer> getElemAtLevel(int levelB){
        if(this.root!=null){
            return this.getElemAtLevel(this.root, 0,levelB);
        }else{
            return new ArrayList<Integer>();
        }
    }

    private ArrayList<Integer> getElemAtLevel(TreeNode nodo, int level, int levelB){
        ArrayList<Integer> arr = new ArrayList<>();
        level++;
        if(nodo!=null){
            // Si el nivel que busco es el mio me agrego a la lista y me retorno
            if(level==levelB){
                arr.add(nodo.getValue());
            }else{ // Si no soy el nivel buscado, busco elementos de ese nivel en mis subarboles
                // Verifico que mis subarboles no sean nulos
                if(nodo.getLeft()!=null){
                    arr.addAll(getElemAtLevel(nodo.getLeft(),level,levelB));
                }
                if(nodo.getRight()!=null){
                    arr.addAll(getElemAtLevel(nodo.getRight(),level,levelB));
                }
            }
            return arr;
        }else{
            return new ArrayList<>();
        }
    }

    public boolean delete(int key){
        boolean elimino = this.hasElem(key);
        if(this.root!=null){
            this.root = delete(this.root,key);
        }else{
            return false;
        }
        return elimino;
    }

    private TreeNode delete(TreeNode nodo,int key){
            if(key < nodo.getValue()){
                if(nodo.getLeft()!=null) {
                    nodo.setLeft(delete(nodo.getLeft(), key));
                    return nodo;
                }else{
                    return nodo;
                }
            } else if (key > nodo.getValue()) {
                if(nodo.getRight()!=null) {
                    nodo.setRight(delete(nodo.getRight(), key));
                    return nodo;
                }else{
                    return nodo;
                }
            } else {
            /*
                Si el valor a borrar no es mayor ni menor al mio, entonces es mi valor,
                verifico si soy una hoja, tengo un hijo, o si tengo dos hijos
             */
                if (nodo.isLeaf()) {  // Si soy una hoja, retorno nulo, asi mi padre apunta a la nada y listo
                    return null;
                } else if (nodo.getLeft() == null || nodo.getRight() == null) { // Si tengo un hijo
                    // Ver cual es mi nodo hijo para retornarlo y que mi padre apunte directamente a el
                    if (nodo.getLeft() != null) {
                        return nodo.getLeft();
                    } else {
                        return nodo.getRight();
                    }
                } else {  //Si tengo dos hijo, desde donde estoy busco el mas a la izquierda de mi derecha NMID
                    TreeNode nodoNuevo = this.getNMID(nodo.getRight());
                    // Yo me reemplazo por el NMID (Osea devuelvo el nodoNuevo) pero antes tengo que borrar
                    // el nodo duplicado osea el NMID, llamo a delete desde mi nodo para borrar el NMID
                    // (la key del nodoNuevo que sino estaria duplicado)
                    this.delete(nodo,nodoNuevo.getValue());
                    nodo.setValue(nodoNuevo.getValue());
                    return nodo;
                }
            }
    }

    private TreeNode getNMID(TreeNode nodo){
        if(nodo.getLeft()!=null){
            return this.getNMID(nodo.getLeft());
        }else{
            return nodo;
        }
    }
}


