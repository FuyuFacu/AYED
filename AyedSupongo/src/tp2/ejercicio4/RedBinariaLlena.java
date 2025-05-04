package tp2.ejercicio4;
import tp2.ejercicio1Y2.BinaryTree;

public class RedBinariaLlena {

    private BinaryTree<Integer> ab;

    public RedBinariaLlena(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    private int retardoEnvio(BinaryTree<Integer> red) {
        if (red == null || red.getData() == null) return 0;

        int retardoHI = red.hasLeftChild() ? retardoEnvio(red.getLeftChild()) : 0;
        int retardoHD = red.hasRightChild() ? retardoEnvio(red.getRightChild()) : 0;

        return red.getData() + Math.max(retardoHI, retardoHD);
    }

    public int retardoEnvio() {
        return retardoEnvio(this.ab);
    }

    public static void main(String[] args) {
        System.out.println("Test mayor retardo");
        BinaryTree<Integer> ab = new BinaryTree<>(10);
        ab.addLeftChild(new BinaryTree<>(3));
        ab.addRightChild(new BinaryTree<>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(9));
        ab.getLeftChild().addRightChild(new BinaryTree<>(6));
        ab.getRightChild().addLeftChild(new BinaryTree<>(8));
        ab.getRightChild().addRightChild(new BinaryTree<>(7));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<>(12)); // más profundidad

        RedBinariaLlena red = new RedBinariaLlena(ab);
        System.out.println("El mayor retardo posible es de: " + red.retardoEnvio() + " segundos");
    }
}
