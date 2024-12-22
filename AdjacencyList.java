import java.awt.*;
import java.util.*;

public class AdjacencyList {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes : ");
        int nodes = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            adjList.put(i, new ArrayList<>());
        }

        System.out.println("Enter start and destination nodes for the edges : ");

        for (int i = 0; i < edges; i++) {

            System.out.print("Enter starting node for edge " + (i + 1) + " : ");
            int startNode = sc.nextInt();

            System.out.print("Enter destination node for edge " + (i + 1) + " : ");
            int endNode = sc.nextInt();

            adjList.get(startNode).add(endNode);
            adjList.get(endNode).add(startNode);

        }

        System.out.println("Adjacency List is as follows : ");

        //can use a for each loop, but wanted to try out with iterators
        Iterator<Map.Entry<Integer, ArrayList<Integer>>> iterator = adjList.entrySet().iterator();

        while(iterator.hasNext()) {

            Map.Entry<Integer, ArrayList<Integer>> mapEntry = iterator.next();

            int node = mapEntry.getKey();

            ArrayList<Integer> neighbours = mapEntry.getValue();

            System.out.print("Node : " + node + " Neighbours : ");

            for(int neighbour: neighbours) {
                System.out.print(neighbour + " ");
            }

            System.out.println();

        }

    }
}
