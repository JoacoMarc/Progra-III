package clase2;

public class BinarySearchTree {

    // Método para buscar un valor en el BST
    public TreeNode2 searchBST(TreeNode2 root, int x) {
        // Caso base: si el nodo es nulo o si el valor del nodo es el que estamos buscando
        if (root == null || root.value == x) {
            return root;
        }

        // Si el valor a buscar es menor que el valor del nodo actual, buscar en el subárbol izquierdo
        if (x < root.value) {
            return searchBST(root.left, x);
        }

        // Si el valor a buscar es mayor que el valor del nodo actual, buscar en el subárbol derecho
        return searchBST(root.right, x);
    }

    private static int altura(TreeNode2 root) {
        if(root==null) { 
            return -1;
        } else {
            return 1+ Math.max(altura(root.left),
            altura(root.right));
        }    
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Crear un árbol de ejemplo
        TreeNode2 root = new TreeNode2(10);
        root.left = new TreeNode2(5);
        root.right = new TreeNode2(20);
        root.left.left = new TreeNode2(3);
        root.left.right = new TreeNode2(7);
        root.right.left = new TreeNode2(15);
        root.right.right = new TreeNode2(25);
        root.right.right.right = new TreeNode2(30);

        // Buscar el valor 7 en el árbol
        int valueToSearch = 7;
        TreeNode2 result = tree.searchBST(root, valueToSearch);
        
        if (result != null) {
            System.out.println("Valor " + result.value + " encontrado en el árbol.");
        } else {
            System.out.println("Valor no encontrado en el árbol.");
        }
        System.out.println("Altura del arbole " + altura(root));

    }
}
