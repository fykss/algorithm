package datastruct;

public class ArrayListApp implements IList {
    private final static int DEFAULT_SIZE = 4;
    private int[] data;
    private int position;

    public ArrayListApp() {
        this(DEFAULT_SIZE);
    }

    public ArrayListApp(int capacity) {
        this.data = new int[capacity];
        position = 0;
    }

    private void resize() {
        int newLength = this.data.length << 1 | 1;
        int[] new_data = new int[newLength];
        for (int i = 0; i < this.data.length; i++) {
            new_data[i] = this.data[i];
        }
        this.data = new_data;
    }

    @Override
    public void add(int el) {
        if (position >= this.data.length) {
            resize();
        }
        this.data[position++] = el;
    }

    private void checkValid(int index) {
        if (index < 0 || index >= this.position) {
            throw new IllegalArgumentException("invalid index");
        }
    }

    @Override
    public int get(int index) {
        checkValid(index);
        return this.data[index];
    }

    @Override
    public int size() {
        return this.position;
    }

    @Override
    public void remove(int index) {
        checkValid(index);
        int[] data_new = new int[this.data.length];
        for (int i = 0; i < index; i++) {
            data_new[i] = data[i];
        }
        for (int i = index + 1; i < position; i++) {
            data_new[i - 1] = data[i];
        }
        this.data = data_new;
        this.position--;
    }

    @Override
    public void remove() {
        remove(this.position);
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        for (int i = 0; i < this.position; i++) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(data[i]);
        }
        System.out.println(sb.append("]"));
    }

    public static void main1(String[] args) {
        ArrayListApp list = new ArrayListApp();

        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
    }

    public static void main2(String[] args) {
        ArrayListApp list = new ArrayListApp();

        list.add(5);
        list.print();
        list.add(10);
        list.print();
        list.add(15);
        list.print();

        list.remove(1);
        list.print();
        list.remove(1);
        list.print();
        list.remove(0);
        list.print();
    }

    public static void main(String[] args) {
        ArrayListApp list = new ArrayListApp(0);
        list.add(1);
        list.print();
        list.add(2);
        list.print();
    }
}
