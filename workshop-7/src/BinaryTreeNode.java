/**
 * Represents a node in a binary tree
 */
class BinaryTreeNode<T> {

    // Child node references
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    // Value of the node
    private final T value;

    /**
     * Creates a new node with a specified value
     *
     * @param value The value of the node
     */
    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

}
