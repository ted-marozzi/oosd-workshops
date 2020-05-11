/**
 * Represents a node in a binary tree
 */
class BinaryTreeNode {

    // Child node references
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    // Value of the node
    private final int value;

    /**
     * Creates a new node with a specified value
     *
     * @param value The value of the node
     */
    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

}
