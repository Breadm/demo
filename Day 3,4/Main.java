package Practice;

public class Main {
    public static void main(String[] args){
        LList l = new LList();
        System.out.println(l.size());
        l.add("test 1");
        l.add("test 2");
        l.add("test 3");
        l.add("test 0.5",0);
        l.add("test 1.5",2);
        l.add("test 4",5);
        System.out.println(l.size());
        for (int i = -1; i < l.size()+1; i++) {
            try {
                String s = (String) l.get(i);
                System.out.println(s);
            } catch (IndexException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

class Node {
    Object data;
    Node next;
}

class LList {
    private Node root;
    private int size;

    public void add(Object obj){
        if (obj == null)
            return;
        Node last = new Node();
        last = findLast(root);
        if (last == null) {
            root = new Node();
            root.data = obj;
            size = 1;
        } else {
            last.next = new Node();
            last = last.next;
            last.data = obj;
            size++;
        }
    }

    public void add(Object obj, int num){
        if (obj == null)
            return;
        if (num < 0 || num > size)
            throw new IndexException("Неверный индекс");
        if (num == size){
            add(obj);
            return;
        }
        if (num == 0) {
            Node newRoot = new Node();
            newRoot.data = obj;
            newRoot.next = root;
            root = newRoot;
            size++;
            return;
        }
        Node current = find(num-1);
        Node newNode = new Node();
        newNode.data = obj;
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public int size(){
        return size;
    }

    public Object get(int num){
        if (num < 0 || num >= size)
            throw new IndexException("Неверный индекс");
        Node node = find(num);
        if (node != null)
            return node.data;
        else
            return null;
    }

    private Node findLast(Node current){
        if (current == null)
            return null;
        Node last = current;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    private Node find(int num){
        if (num < 0 || num >= size)
            return null;
        Node current = root;
        for (int i = 0; i < size; i++) {
            if (i == num)
                return current;
            current = current.next;
        }
        return null;
    }

}
