import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DFS {

    private static void dfs(int currentNode, Map<Integer, ArrayList<Integer>> adjList, int[] visited) {
        visited[currentNode] = 1;
        System.out.print(currentNode + " ");
        for(int neighbour: adjList.get(currentNode)) {
            if(visited[neighbour] == 0) {
                dfs(neighbour, adjList, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nodes : ");
        int n = sc.nextInt();

        System.out.print("Edges: ");
        int m = sc.nextInt();

        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            System.out.println("<startNode> <destinationNode> for edge " + (i+1));
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            adjList.get(startNode).add(endNode);
            adjList.get(endNode).add(startNode);
        }

        System.out.println();

        for(int node: adjList.keySet()) {
            System.out.print(node + " -> ");
            for(int neighbour: adjList.get(node)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }

        int[] visited = new int[n];

        System.out.print("DFS : ");
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                dfs(i, adjList, visited);
            }
        }

    }
}
