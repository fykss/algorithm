package graphs;

import java.util.*;

// vertices 1...N

public class Graph {
    private final Map<Integer, Set<Integer>> data = new HashMap<>();
    private final Set<Integer> visited = new TreeSet<>();
    private final Scanner in = new Scanner(System.in);

    public void addVertice(int v) {
        if (!data.containsKey(v)) {
            data.put(v, new TreeSet<>());
        }
    }

    public void addLink(int v1, int v2) {
        addVertice(v1);
        addVertice(v2);
        data.get(v1).add(v2);
    }

    public void removeLink(int v1, int v2) {
        if (data.containsKey(v1)) {
            data.get(v1).remove(v2);
        }
    }

    public Set<Integer> getOutgoing(int v1) {
        if (!data.containsKey(v1)) {
            throw new IllegalArgumentException(
                    String.format("There is no vertex with requested %d", v1));
        }
        return data.get(v1);
    }

    public Set<Integer> getIncoming(int v1) {
        if (!data.containsKey(v1)) {
            throw new IllegalArgumentException(
                    String.format("There is no vertex with requested %d", v1));
        }
        TreeSet<Integer> t = new TreeSet<>();

        for (Map.Entry<Integer, Set<Integer>> item : data.entrySet()) {
            if (item.getValue().contains(v1)) {
                t.add(item.getKey());
            }
        }

        return t;
    }

    private boolean isConnectedV1(int from, int to) {
        if (from == to) {
            return true;
        }
        Set<Integer> childs = getOutgoing(from);
        for (int el : childs) {
            if (isConnectedV1(el, to)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfs_doesntwork(int from, int to) {
        if (visited.contains(from)) {
            return false;
        }

        Set<Integer> children = getOutgoing(from);
        for (int el : children) {
            if (el == to) {
                return true;
            }
        }
        visited.add(from);

        for (int el : children) {
            return bfs_doesntwork(el, to);
        }
        return false;
    }

    public boolean isConnected(int from, int to) {
        if (!data.containsKey(from) || !data.containsKey(to)) {
            return false;
        }
        visited.clear();
        return bfs_doesntwork(from, to);
    }

    public static void main_out(String[] args) {
        Graph graph = new Graph();

        graph.addLink(1, 37);
        graph.addLink(37, 41);
        graph.addLink(1, 38);
        graph.addLink(1, 39);

        Set<Integer> out = graph.getOutgoing(1);
        System.out.println(Arrays.toString(out.toArray()));
    }

    public static void main_incoming(String[] args) {
        Graph graph = new Graph();

        graph.addLink(6, 31);
        graph.addLink(115, 31);
        graph.addLink(112, 31);

        Set<Integer> incoming = graph.getIncoming(31);
        System.out.println(Arrays.toString(incoming.toArray()));
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addLink(1, 2);
        graph.addLink(1, 3);
        graph.addLink(1, 4);

        graph.addLink(2, 10);
        graph.addLink(2, 11);
        graph.addLink(2, 12);

        graph.addLink(3, 20);
        graph.addLink(3, 21);
        graph.addLink(3, 22);

        graph.addLink(11, 101);
        graph.addLink(11, 102);
        graph.addLink(11, 103);

        System.out.println(graph.isConnected(1, 200));
        System.out.println(graph.isConnected(200, 300));
        System.out.println(graph.isConnected(300, 2));

        System.out.println(graph.isConnected(1, 11));
        System.out.println(graph.isConnected(1, 103));
    }

    public static void main2(String[] args) {
        Graph graph = new Graph();

        graph.addLink(1, 2);
        graph.addLink(2, 3);
        graph.addLink(3, 4);
        graph.addLink(4, 1);

        graph.addLink(5, 3);

        System.out.println(graph.isConnected(1, 5));
    }
}
