package tp2.arboles;

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

}
