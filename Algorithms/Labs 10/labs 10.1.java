/*
Your task is to create an unoriented unweighted graph by using an adjacency list, 
where each vertex information is аn integer. You create the graph according to the received commands. 
You will be given an array of commands that can be one of the following:

CREATE - you should create a new graph.

ADDEDGE [number1] [number2] - you should create an edge between the vertices with ordinal number number1 and ordinal number number2. 

DELETEEDGE [number1] [number2] - you should remove the edge between the vertices with ordinal number number1 and ordinal number number2.

ADЈACENT [number1] [number2] - you should print true if the vertices with ordinal number number1 
and ordinal number number2 are adjacent, otherwise print false.

PRINTGRAPH - you should print the adjacency list. 

The number of commands is given in the first input line.
*/

import java.util.*;

class Graph {
    private Map<Integer, Set<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int vertex1, int vertex2) {
                adjacencyList.computeIfAbsent(vertex2, k -> new HashSet<>()).add(vertex1);
        adjacencyList.computeIfAbsent(vertex1, k -> new HashSet<>()).add(vertex2);
    }

    public void deleteEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }

    public boolean isAdjacent(int vertex1, int vertex2) {
        return adjacencyList.getOrDefault(vertex1, Collections.emptySet()).contains(vertex2);
    }

    public void printGraph() {
        List<Integer> sortedVertices = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(sortedVertices);

        for (int vertex : sortedVertices) {
            System.out.print(vertex + ": ");
            List<Integer> neighbors = new ArrayList<>(adjacencyList.get(vertex));
            Collections.sort(neighbors);
            System.out.println(neighbors);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCommands = Integer.parseInt(scanner.nextLine());
        Graph graph = null;

        for (int i = 0; i < numCommands; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "CREATE":
                    graph = new Graph();
                    break;
                case "ADDEDGE":
                    graph.addEdge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "DELETEEDGE":
                    graph.deleteEdge(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                case "ADJACENT":
                    System.out.println(graph.isAdjacent(Integer.parseInt(command[1]), Integer.parseInt(command[2])));
                    break;
                case "PRINTGRAPH":
                    graph.printGraph();
                    System.out.println();
                    break;
            }
        }
    }
}
