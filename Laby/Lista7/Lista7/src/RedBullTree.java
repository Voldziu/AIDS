import java.util.Comparator;
import java.util.GregorianCalendar;

public class RedBullTree<T> extends BST<T>{


    public RedBullTree(Comparator<T> comp) {
        super(comp);
        _root=null;

    }

    private RBNode _root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;



    private class RBNode  extends Node{

        RBNode left;

        RBNode right;
        boolean color;
        RBNode parent;

        RBNode(T obj) {
            super(obj);

            color = RED;
        }

        RBNode(T obj, RBNode leftNode, RBNode rightNode,RBNode parent) {
            super(obj);
            value=obj;
            left = leftNode;
            right=rightNode;
            parent =parent;

            color = RED;
        }
    }




    @Override
    public void insert(T elem) {
        RBNode node = _root;
        RBNode parent = null;
        while (node !=null) {
            parent = node;
            int cmp = _comparator.compare(elem, node.value);
            if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;

            }
        }
            RBNode newNode= new RBNode(elem);
            newNode.color=RED;

            if(parent==null){
                _root=newNode;
            } else {
                int cmp = _comparator.compare(elem,parent.value);

                if(cmp<0){
                    parent.left=newNode;
                }
                else if(cmp>0){
                    parent.right=newNode;

                }

            }

            newNode.parent=parent;
            fixInsert(newNode);
        }






    private RBNode getUncle(RBNode parent) {
        RBNode grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else  {
            return grandparent.left;
        }
    }



    private void fixInsert(RBNode node) {
        RBNode parent = node.parent;


        if (parent == null) {


             node.color = BLACK;
            return;
        }



        if (parent.color == BLACK) {
            return;
        }


        RBNode grandparent = parent.parent;


        if (grandparent == null) {


            parent.color = BLACK;
            return;
        }



        RBNode uncle = getUncle(parent);


        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;


            fixInsert(grandparent);
        }


        else if (parent == grandparent.left) {

            if (node == parent.right) {
                rotateLeft(parent);


                parent = node;
            }


            rotateRight(grandparent);


            parent.color = BLACK;
            grandparent.color = RED;
        }


        else {


            if (node == parent.left) {
                rotateRight(parent);


                parent = node;
            }

            rotateLeft(grandparent);

            parent.color = BLACK;
            grandparent.color = RED;
        }

    }

    public void delete(T elem) {
        RBNode node = _root;


        while (node != null && _comparator.compare(elem,node.value)!=0) {
            int cmp =_comparator.compare(elem,node.value);

            if (cmp<0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }


        if (node == null) {
            return;
        }


        RBNode movedUpNode;
        boolean deletedNodeColor;

        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }


        else {

            RBNode inOrderSuccessor = findMinimum(node.right);


            node.value = inOrderSuccessor.value;


            movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);


            if (movedUpNode.getClass() == NilNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }
    }

    private RBNode deleteNodeWithZeroOrOneChild(RBNode node) {

        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left);
            return node.left;
        }



        else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right);
            return node.right; // moved-up node
        }


        else {
            RBNode newChild = node.color == BLACK ? new NilNode() : null;
            replaceParentsChild(node.parent, node, newChild);
            return newChild;
        }
    }

    private RBNode findMinimum(RBNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    private void fixRedBlackPropertiesAfterDelete(RBNode node) {

        if (node == _root) {

             node.color = BLACK;
            return;
        }

        RBNode sibling = getSibling(node);



        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = getSibling(node);
        }


        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = RED;


            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }


            else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }


        else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    private void handleRedSibling(RBNode node, RBNode sibling) {

        sibling.color = BLACK;
        node.parent.color = RED;



        if (node == node.parent.left) {
            rotateLeft(node.parent);
        } else {
            rotateRight(node.parent);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(RBNode node, RBNode sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        if (nodeIsLeftChild && isBlack(sibling.right)) {
            sibling.left.color = BLACK;
            sibling.color = RED;
            rotateRight(sibling);
            sibling = node.parent.right;
        } else if (!nodeIsLeftChild && isBlack(sibling.left)) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            rotateLeft(sibling);
            sibling = node.parent.left;
        }


        sibling.color = node.parent.color;
        node.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        } else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    private RBNode getSibling(RBNode node) {
        RBNode parent = node.parent;
        if (node == parent.left) {
            return parent.right;
        } else   {
            return parent.left;
        }
    }

    private boolean isBlack(RBNode node) {
        return node == null || node.color == BLACK;
    }

    private  class NilNode extends RBNode {
        private NilNode() {
            super(null);
            this.color = BLACK;
        }
    }


//    @Override
//    protected void deleteNode(RBNode node) {
//        RBNode successor = node;
//        RBNode fixNode;
//        boolean originalColor = successor.color;
//
//        if (node.left == null) {
//            fixNode =  node.right;
//            transplant(node, node.right);
//        } else if (node.right == null) {
//            fixNode = node.left;
//            transplant(node, node.left);
//        } else {
//            successor = (Node) minimum(node.right);
//            originalColor = successor.color;
//            fixNode = (Node) successor.right;
//
//            if (successor.parent == node) {
//                fixNode.parent = successor;
//            } else {
//                transplant(successor, successor.right);
//                successor.right = node.right;
//                successor.right.parent = successor;
//            }
//
//            transplant(node, successor);
//            successor.left = node.left;
//            successor.left.parent = successor;
//            successor.color = node.color;
//        }
//
//        if (originalColor == BLACK) {
//            fixDelete(fixNode);
//        }
//    }

    protected RBNode delete(T elem, RBNode node) {

        int cmp=_comparator.compare(elem,node.value);
        if(cmp<0)
            node.left=delete(elem,node.left);
        else if(cmp>0)
            node.right=delete(elem,node.right);
        else if(node.left!=null &&node.right!=null)
            node.right=detachMin(node,node.right);
        else node = (node.left != null) ? node.left : node.right;

        return node; }
    private RBNode detachMin(RBNode del, RBNode node)
    { if(node.left!=null)
        node.left=detachMin(del, node.left);
    else {
        del.value=node.value;
        node=node.right;
    }
        return node; }

    private void fixDelete(RBNode node) {
        while (node != _root && node.color == BLACK) {
            if (node == node.parent.left) {
                RBNode sibling =  node.parent.right;

                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateLeft(node.parent);
                    sibling = node.parent.right;
                }

                if (sibling.left.color == BLACK && sibling.right.color == BLACK) {
                    sibling.color = RED;
                    node =  node.parent;
                } else {
                    if (sibling.right.color == BLACK) {
                        sibling.left.color = BLACK;
                        sibling.color = RED;
                        rotateRight(sibling);
                        sibling =  node.parent.right;
                    }

                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.right.color = BLACK;
                    rotateLeft(node.parent);
                    node = _root;
                }
            } else {
                RBNode sibling = node.parent.left;

                if (sibling.color == RED) {
                    sibling.color = BLACK;
                    node.parent.color = RED;
                    rotateRight(node.parent);
                    sibling =  node.parent.left;
                }

                if (sibling.right.color == BLACK && sibling.left.color == BLACK) {
                    sibling.color = RED;
                    node =  node.parent;
                } else {
                    if (sibling.left.color == BLACK) {
                        sibling.right.color = BLACK;
                        sibling.color = RED;
                        rotateLeft(sibling);
                        sibling =  node.parent.left;
                    }

                    sibling.color = node.parent.color;
                    node.parent.color = BLACK;
                    sibling.left.color = BLACK;
                    rotateRight(node.parent);
                    node =  _root;
                }
            }
        }
        node.color = BLACK;
    }

    private void rotateLeft(RBNode node) {
        RBNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            _root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(RBNode node) {
        RBNode leftChild =  node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            _root = leftChild;
        } else if (node == node.parent.left) {
            node.parent.left = leftChild;
        } else {
            node.parent.right = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }
    public void replaceParentsChild(RBNode parent, RBNode oldChild, RBNode newChild) {
        if (parent == null) {
            _root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }
    public void printTree() {
        printTreeRec(_root, 0);
    }

    private void printTreeRec(RBNode root, int level) {
        if (root == null)
            return;

        // Wydrukowanie prawego poddrzewa
        printTreeRec(root.right, level + 1);

        // Wydrukowanie węzła
        for (int i = 0; i < level; i++) {
            System.out.print("          "); // Odstęp dla czytelności
        }
        String color;
        if(root.color==RED){
            color = "R";
        } else{
            color ="B";
        }

        System.out.println(root.value+" "+color);

        // Wydrukowanie lewego poddrzewa
        printTreeRec(root.left, level + 1);
    }
    public T find(T elem){
        RBNode node=search(elem);
        return node==null?null:node.value;
    }
    private RBNode search(T elem) {
        RBNode node=_root;
        int cmp=0;
        while(node!=null && (cmp=_comparator.compare(elem, node.value))!=0)
            node=cmp<0? node.left:node.right;
        return node;
    }


}
