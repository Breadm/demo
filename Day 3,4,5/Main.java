package Practice;

public class Main {
    public static void main(String[] args){
        LList<Number> l = new LList<>();
        System.out.println(l.size());
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(0.5,0);
        l.add(1.5,2);
        l.add(4,5);
        System.out.println(l.size());
        for (int i = -1; i < l.size()+1; i++) {
            try {
                System.out.println(l.get(i));
            } catch (IndexException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

class Node<E> {
    E data;
    Node next;
}

class LList<E> {
    private Node<E> root;
    private int size;

    public void add(E element){
        if (element == null)
            return;
        Node last = new Node();
        last = findLast(root);
        if (last == null) {
            root = new Node();
            root.data = element;
            size = 1;
        } else {
            last.next = new Node();
            last = last.next;
            last.data = element;
            size++;
        }
    }

    public void add(E element, int num){
        if (element == null)
            return;
        if (num < 0 || num > size)
            throw new IndexException("Неверный индекс");
        if (num == size){
            add(element);
            return;
        }
        if (num == 0) {
            Node<E> newRoot = new Node<>();
            newRoot.data = element;
            newRoot.next = root;
            root = newRoot;
            size++;
            return;
        }
        Node<E> current = find(num-1);
        Node<E> newNode = new Node<>();
        newNode.data = element;
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public int size(){
        return size;
    }

    public E get(int num){
        if (num < 0 || num >= size)
            throw new IndexException("Неверный индекс");
        Node<E> node = find(num);
        if (node != null)
            return node.data;
        else
            return null;
    }

    private Node findLast(Node current){
        if (current == null)
            return null;
        Node<E> last = current;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    private Node<E> find(int num){
        if (num < 0 || num >= size)
            return null;
        Node<E> current = root;
        for (int i = 0; i < size; i++) {
            if (i == num)
                return current;
            current = current.next;
        }
        return null;
    }

}
