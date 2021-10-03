package RBTree;

public class Node {
    private int data; // holds the key
    private Node parent; // pointer to the parent
    private Node left; // pointer to left child
    private Node right; // pointer to right child
    private boolean isRed; // Default true

    public Node(int data, Node parent, Node left, Node right, boolean isRed) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.isRed = isRed;
    }

    public Node() {
        this.data = -1;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.isRed = true;
    }

    public boolean isLeftChild() {
        return parent.getLeft() == this;
    }

    public boolean isRightChild() {
        return parent.getRight() == this;
    }

    public boolean isLeftChildOfLeftChild() {
        return this.isLeftChild() && this.getParent().isLeftChild();
    }

    public boolean isRightChildOfRightChild() {
        return this.isRightChild() && this.getParent().isRightChild();
    }

    public boolean isLeftChildOfRightChild() {
        return this.isLeftChild() && this.getParent().isRightChild();
    }

    public boolean isRightChildOfLeftChild() {
        return this.isRightChild() && this.getParent().isLeftChild();
    }

    public boolean checkCase1() {
        return this.isRed() && !this.getParent().isRed();
    }

    public boolean checkCase2() {
        return this.isRed() && this.getParent().isRed() && this.getUncle().isRed();
    }

    public boolean checkCase3LL() {
        return this.isRed() && this.getParent().isRed() && !this.getUncle().isRed() && this.isLeftChildOfLeftChild();
    }

    public boolean checkCase3RR() {
        return this.isRed() && this.getParent().isRed() && !this.getUncle().isRed() && this.isRightChildOfRightChild();
    }

    public boolean checkCase4RL() {
        return this.isRed() && this.getParent().isRed() && !this.getUncle().isRed() && this.isRightChildOfLeftChild();
    }

    public boolean checkCase4LR() {
        return this.isRed() && this.getParent().isRed() && !this.getUncle().isRed() && this.isLeftChildOfRightChild();
    }

    public Node getUncle() {
        Node grandParent = this.getGrandParent();
        if (grandParent.getLeft() == this.getParent()) {
            return grandParent.getRight();
        }
        return grandParent.getLeft();
    }

    public Node getGrandParent() {
        return parent.getParent();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
