package RBTree;

public class RedBlackTree {
    private Node root;
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node();
        TNULL.setRed(false);
        TNULL.setLeft(null);
        TNULL.setRight(null);
        root = TNULL;
    }

    public void insert(int key){
        Node node = new Node();
        node.setParent(null);
        node.setData(key);
        node.setLeft(TNULL);
        node.setRight(TNULL);
        node.setRed(true);

        Node y = null;
        Node x = this.root;

        while(x != TNULL){
            y=x;
            if(node.getData() < x.getData()){
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }

        node.setParent(y);
        if(y == null){
            root = node;
        }
        else if (node.getData() < y.getData()){
            y.setLeft(node);
        }
        else{
            y.setRight(node);
        }

        if(node.getParent() == null){
            node.setRed(false);
            return;
        }
        if(node.getGrandParent() == null){
            return;
        }

        fixInsert(node);
    }

    private void fixInsert(Node k){
        String whichCase = whichCase(k);

        switch (whichCase) {
            case "1":
//                System.out.println(k.getData() + ": Case 1");
                break;
            case "2":
//                System.out.println(k.getData() + ": Case 2");
                k.getParent().setRed(false);
                k.getUncle().setRed(false);
                if (root == k.getGrandParent()){
                    k.getGrandParent().setRed(false);
                }else{
                    k.getGrandParent().setRed(true);
                    fixInsert(k.getGrandParent());
                }
                break;
            case "3LL":
//                System.out.println(k.getData() + ": Case 3LL");
                k.setRed(true);
                k.getGrandParent().setRed(true);
                k.getParent().setRed(false);
                rightRotate(k.getGrandParent());
                break;
            case "3RR":
//                System.out.println(k.getData() + ": Case 3RR");
                k.setRed(true);
                k.getGrandParent().setRed(true);
                k.getParent().setRed(false);
                leftRotate(k.getGrandParent());
                break;
            case "4RL":
//                System.out.println(k.getData() + ": Case 4RL");
                k.setRed(false);
                k.getParent().setRed(true);
                k.getGrandParent().setRed(true);
                leftRotate(k.getParent());
                rightRotate(k.getParent());
                break;
            case "4LR":
//                System.out.println(k.getData() + ": Case 4LR");
                k.getParent().setRed(true);
                k.setRed(false);
                k.getGrandParent().setRed(true);
                rightRotate(k.getParent());
                leftRotate(k.getParent());
                break;

            default:
                System.out.println("Error: Non the cases has been detected!");
                break;
        }
    }

    private void leftRotate(Node x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != TNULL) {
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x.isLeftChild()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    private void rightRotate(Node x) {
        Node y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != TNULL) {
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            this.root = y;
        } else if (x.isRightChild()) {
            x.getParent().setRight(y);
        } else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    private String whichCase(Node k) {

        boolean res = k.checkCase1();
        if(res)return "1";
        res = k.checkCase2();
        if(res)return "2";
        res = k.checkCase3LL();
        if(res)return "3LL";
        res = k.checkCase3RR();
        if(res)return "3RR";
        res = k.checkCase4RL();
        if(res)return "4RL";
        res = k.checkCase4LR();
        if(res)return "4LR";

        System.out.println(" Attention: Non of the cases has been detected! ");
        return "ERROR";
    }

    public Node searchTree(int k) {
        return searchTreeHelper(this.root, k);
    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == TNULL || key == node.getData()) {
            return node;
        }

        if (key < node.getData()) {
            return searchTreeHelper(node.getLeft(), key);
        }
        return searchTreeHelper(node.getRight(), key);
    }

    public void inorder() {
        inOrderHelper(this.root);
    }

    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderHelper(node.getRight());
        }
    }

    public void prettyPrint() {
        printHelper(this.root, "", true);
    }

    private void printHelper(Node root, String indent, boolean last) {
        // print the tree structure on the screen
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = root.isRed()?"RED":"BLACK";
            System.out.println(root.getData() + "(" + sColor + ")");
            printHelper(root.getLeft(), indent, false);
            printHelper(root.getRight(), indent, true);
        }
    }

    public Node getRoot(){
        return this.root;
    }

}

