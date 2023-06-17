import java.util.Comparator;

public class BST<T> {
    protected class Node {
        T value; // element

        Node left;
        Node right;


        Node(T obj) {
            value = obj;
        }

        Node(T obj, Node leftNode, Node rightNode) {
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    protected final Comparator<T> _comparator;
    private Node _root;

    public BST(Comparator<T> comp) {
        _comparator = comp;
        _root = null;
    }
    public T find(T elem){
        Node node=search(elem);
        return node==null?null:node.value;
    }
    private Node search(T elem) {
        Node node=_root;
        int cmp=0;
        while(node!=null && (cmp=_comparator.compare(elem, node.value))!=0)
            node=cmp<0? node.left:node.right;
        return node;
    }

    public void insert(T elem){
        _root=insert(_root,elem);}
    protected Node insert(Node node, T elem) {
        if(node==null)
        node=new Node(elem);
        else{
        int cmp=_comparator.compare(elem, node.value);
        if(cmp<0)
            node.left=insert(node.left,elem);
        else if(cmp>0)
            node.right=insert(node.right,elem);

    }
        return node; }

    public void delete(T elem){
        _root=delete(elem,_root);
    }

    protected Node delete(T elem, Node node) {

        int cmp=_comparator.compare(elem,node.value);
        if(cmp<0)
            node.left=delete(elem,node.left);
        else if(cmp>0)
            node.right=delete(elem,node.right);
        else if(node.left!=null &&node.right!=null)
            node.right=detachMin(node,node.right);
        else node = (node.left != null) ? node.left : node.right;

        return node; }
    private Node detachMin(Node del, Node node)
    { if(node.left!=null)
        node.left=detachMin(del, node.left);
        else {
        del.value=node.value;
        node=node.right;
    }
        return node; }
    public void printTree() {
        printTreeRec(_root, 0);
    }

    private void printTreeRec(Node root, int level) {
        if (root == null)
            return;


        //inorder ale na poczatku prawa strona.

        // Wydrukowanie prawego poddrzewa,
        printTreeRec(root.right, level + 1);

        // Wydrukowanie wezla
        for (int i = 0; i < level; i++) {
            System.out.print("          "); //
        }

        System.out.println(root.value);

        // Wydrukowanie lewego poddrzewa
        printTreeRec(root.left, level + 1);
    }



    public int getDepth() {
        return getDepthRec(_root)-1; // -1 bo to sie roznie oznacza chyba idk.
    }

    private int getDepthRec(Node root) {
        if (root == null)
            return 0;

        int leftDepth = getDepthRec(root.left);
        int rightDepth = getDepthRec(root.right);

        return Math.max(leftDepth, rightDepth)+1;
    }


}