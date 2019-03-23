package datastruct;

public class LinkedListApp implements IList{

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        boolean hasNext() {
            return next != null;
        }
    }

    private Node head = null;

    public LinkedListApp() {
    }

    private Node findLastNode() {
        Node curr = head;
        while (curr.hasNext()) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public void add(int el) {
        Node current = new Node(el);
        if (this.head == null) {
            this.head = current;
        } else {
            Node last = findLastNode();
            last.next = current;
        }
    }

    @Override
    public int get(int index) {
        throw new IllegalArgumentException("not implemented yet...");
    }

    @Override
    public int size() {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    @Override
    public void remove(int index) {
        throw new IllegalArgumentException("not implemented yet...");
    }

    @Override
    public void remove() {
        throw new IllegalArgumentException("not implemented yet...");
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        Node curr = head;
        if (curr != null) {
            while (curr.hasNext()) {
                sb.append(curr.value);
                sb.append(",");
                curr = curr.next;
            }
            sb.append(curr.value);
        }
        System.out.println(sb.append("]"));
    }

    public boolean contains(int el) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == el) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private Node findByValue(int val) {
        Node curr = head;
        while (curr != null) {
            if (curr.value == val) {
                return curr;
            }
            curr = curr.next;
        }
        throw new IllegalArgumentException(String.format("element '%d' not found", val));
    }

    public void insertBefore(int val, int newVal) {

    }

    public void insertAfter(int val, int newVal) {
        Node newNode = new Node(newVal);
        Node curr = findByValue(val);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void removeByValue(int val) {
        Node curr = head;
        while (curr.hasNext()) {
            if (curr.next.value == val) {
                Node nextNode = curr.next;
                curr.next = nextNode.next;
                return;
            }
            curr = curr.next;
        }
        throw new IllegalArgumentException(String.format("Element '%d' not found", val));
    }

    public static void main1(String[] args) {
        LinkedListApp list = new LinkedListApp();
        list.print();
        System.out.println(list.size());
        list.add(11);
        list.print();
        System.out.println(list.size());
        list.add(22);
        list.print();
        System.out.println(list.size());
    }

    public static void main2(String[] args) {
        LinkedListApp list = new LinkedListApp();
        list.add(11);
        list.add(22);
        list.add(33);

        System.out.println(list.contains(11));
        System.out.println(list.contains(44));
    }

    public static void main3(String[] args) {
        LinkedListApp linkedListApp = new LinkedListApp();
        linkedListApp.add(11);
        linkedListApp.add(22);
        linkedListApp.add(22);
        linkedListApp.add(33);
        linkedListApp.print();
        linkedListApp.insertAfter(22, 30);
        linkedListApp.print();
//        linkedListApp.insertAfter(23, 30);
    }

    public static void main(String[] args) {
        LinkedListApp linkedListApp = new LinkedListApp();
        linkedListApp.add(11);
        linkedListApp.add(22);
        linkedListApp.add(33);
        linkedListApp.add(44);
        linkedListApp.add(55);
        linkedListApp.print();
        linkedListApp.removeByValue(33);
        linkedListApp.print();
        linkedListApp.removeByValue(55);
        linkedListApp.print();
    }
}
