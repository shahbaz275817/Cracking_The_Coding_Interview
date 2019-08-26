package C_4_Trees_and_Graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Shahbaz on 11-Jun-19.
 */
public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,6);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,7);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(4,6);

        System.out.println(graph.findPath(3,6));
    }
}

