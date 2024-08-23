
public class BinarySearchTreeAdaptado {

    // Método para buscar un valor en el BST
    public TreeNode searchBST(TreeNode root, int x) {
        if (root == null || root.value == x) {
            return root;
        }

        if (x < root.value) {
            return searchBST(root.left, x);
        }

        return searchBST(root.right, x);
    }

    // Método para calcular la altura del árbol
    public int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

}
