import java.util.Scanner;

public class Plate6Problem7 {

    public static void main(String[] args) {
        int i, j, vertices, edges;
        Scanner in = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("# of vertices: ");
        vertices = in.nextInt();
        vertices += 1;

        // Get the number of edges
        System.out.print("# of edges: ");
        edges = in.nextInt();
        edges += 1;

        char[][] matrix = new char[vertices][edges]; // initialize incidence matrix in 2d array

        matrix[0][0] = '\\';// 1st element in matrix as '\'

        // Assign numbers as edges to first row of matrix
        int index = 0;
        for (j=1; j < edges; j++) {
            matrix[0][j] = (char) (49+index);
            index += 1;
        }
        
        // Assign letters as vertices to first column of matrix
        index = 0;
        for (i=1; i < vertices; i++) {
            matrix[i][0] = (char) (65+index);
            index += 1;
        }

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices followed by the number of times each edge appears, e.g. 'A B 1': ");
        index = edges;
        while (index > 1) {
            
            for ( j = 1; j < edges; j++) {
                char u = in.next().charAt(0);
                char v = in.next().charAt(0);
                char count = in.next().charAt(0);
    
                for ( i = 1; i < vertices; i++) {
                    if ((u == matrix [i][0]) || (v == matrix [i][0])) {
                        matrix[i][j] = count;
                    } else {
                        matrix[i][j] = '0';
                    }
                }
                index -= Character.getNumericValue(count);
            }
            
        }

        in.close();

        // Print the incidence matrix
        System.out.println("Incidence matrix:");
        for ( i = 0; i < vertices; i++) {
            for ( j = 0; j < edges; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        } // end of for loop

    } // end of main

}
