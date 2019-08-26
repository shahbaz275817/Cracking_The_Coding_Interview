package C_4_Trees_and_Graphs;


import java.util.*;
/**
 * Created by Shahbaz on 10-Jul-19.
 */
public class BuildOrder {
    public static void main(String[] args) {
        int[] projects = {0,1,2,3,4,5,6,7,8,9};
        int[][] dependencies = {
                {0,1},
                {1,2},
                {0,2},
                {1,3},
                {3,4},
                {4,5},
                {0,5},
                {7,8},
                {7,9},
                {8,9},
                {6,9}};
        Graph graph = new Graph(projects.length);
        for(int[] dependency : dependencies){
            graph.addEdge(dependency[0],dependency[1]);
        }
        Stack<Integer> stack = order(graph,projects);
        System.out.println("Build order:- ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }

    public static Stack<Integer> order(Graph graph,int[] projects){
        Stack<Integer> stack = new Stack<Integer>();
        LinkedList<Integer>[] dependecylist = graph.getAdjacentList();
        boolean visited[] = new boolean[graph.getSize()];
        for(int project : projects){
            orderUtil(project,dependecylist,stack,visited);
        }
        return stack;
    }

    static Stack orderUtil(int project, LinkedList<Integer>[] dependecylist, Stack<Integer> stack,boolean[] visited){
        if(visited[project])
            return stack;
        LinkedList<Integer> list = dependecylist[project];
        visited[project] = true;
        if(!list.isEmpty()){
            Iterator<Integer> itr = list.listIterator();
            while(itr.hasNext()){
                int next = itr.next();
                if(!visited[next])
                    orderUtil(next,dependecylist,stack,visited);
            }
        }
        stack.add(project);
        return stack;
    }
}
