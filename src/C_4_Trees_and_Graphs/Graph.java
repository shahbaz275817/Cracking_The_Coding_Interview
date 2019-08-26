package C_4_Trees_and_Graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Shahbaz on 10-Jul-19.
 */
public class Graph {
    private int size;
    private LinkedList<Integer> adjacentList[];

    public LinkedList<Integer>[] getAdjacentList() {
        return adjacentList;
    }

    public Graph(int size){
        this.size = size;
        adjacentList = new LinkedList[size];

        for(int i = 0;i<size;i++)
            adjacentList[i] = new LinkedList<>();
    }

    void addEdge(int source,int destination){
        adjacentList[source].add(destination);
    }

    void printGraph(Graph graph){
        for(int v=0;v < graph.size;v++){
            System.out.println("Adjacent List of vertex " + v);
            System.out.print("Head");
            for(int node : graph.adjacentList[v]){
                System.out.print("->" + node);
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    String findPath(int source, int destination){
        boolean visited[] = new boolean[this.size];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);


        while(queue.size()!=0){
            source =queue.poll();
            if(source==destination)
                return "Path exists";
            Iterator<Integer> itr = adjacentList[source].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(n==destination)
                    return "Path exists";
                if(visited[n]==false){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return "Path does not exists";
    }
}
