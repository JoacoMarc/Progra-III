
public class Main {
    public static void main(String[] args) {
        BinarySearchTreeAdaptado tree = new BinarySearchTreeAdaptado();

        // Crear un árbol de ejemplo
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);
        root.right.right.right = new TreeNode(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        TreeNode result = tree.searchBST(root, valueToSearch);

        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }

        // Imprimir la altura del árbol
        System.out.println("Altura del árbol: " + tree.getHeight(root));
    }
}