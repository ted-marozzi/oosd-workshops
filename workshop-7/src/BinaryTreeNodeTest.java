import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This testing class WILL be filled with errors until you make the BinaryTreeNode class generic
 *
 * You should not need to modify this class at all.
 */
class BinaryTreeNodeTest {

    /**
     * << HELPER METHOD>> - you do not need to worry about this method!
     * Converts a binary tree to a comma-separated string representation in level order
     * @param node Root node
     * @return Level order representation of the tree separated by commas
     */
    private <T> String levelOrderRepresentation(BinaryTreeNode<T> node) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        // Perform a level order traversal and append each node value to the resulting list
        List<String> levelOrderValues = new ArrayList<>();
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> temp = queue.poll();
            if (temp == null) {
                continue;
            }
            levelOrderValues.add(temp.getValue().toString());
            queue.add(temp.getLeft());
            queue.add(temp.getRight());
        }
        // Join with commas
        return levelOrderValues.stream()
            .map(Object::toString)
            .collect(Collectors.joining(","));
    }

    @Test
    public void stringBinaryTree() {
        String expectedOutput = "root node,left of root,right of root,right of left of root,left of right of root";
        BinaryTreeNode<String> stringBinaryTree = new BinaryTreeNode<>("root node");
        stringBinaryTree.setLeft(new BinaryTreeNode<>("left of root"));
        stringBinaryTree.setRight(new BinaryTreeNode<>("right of root"));
        stringBinaryTree.getLeft().setRight(new BinaryTreeNode<>("right of left of root"));
        stringBinaryTree.getRight().setLeft(new BinaryTreeNode<>("left of right of root"));
        Assertions.assertEquals(expectedOutput, levelOrderRepresentation(stringBinaryTree));
    }

    @Test
    public void intBinaryTree() {
        String expectedOutput = "10,9,8,7,6,5,4";
        BinaryTreeNode<Integer> integerBinaryTree = new BinaryTreeNode<>(10);
        integerBinaryTree.setLeft(new BinaryTreeNode<>(9));
        integerBinaryTree.setRight(new BinaryTreeNode<>(8));
        integerBinaryTree.getLeft().setLeft(new BinaryTreeNode<>(7));
        integerBinaryTree.getLeft().setRight(new BinaryTreeNode<>(6));
        integerBinaryTree.getRight().setLeft(new BinaryTreeNode<>(5));
        integerBinaryTree.getRight().setRight(new BinaryTreeNode<>(4));
        Assertions.assertEquals(expectedOutput, levelOrderRepresentation(integerBinaryTree));


    }
}