import java.util.Scanner;

public class Plate6Problem2 {
    
    public static void main(String[] args) {
        int iCollarga, jCollarga, verticesCollarga;

        Scanner in = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("# of vertices in the matrix: ");
        verticesCollarga = in.nextInt();
        verticesCollarga += 1; // add 1 so that the matrix dimension will be larger by 1 more for labels

        char[][] matrixCollarga = new char[verticesCollarga][verticesCollarga]; //initialize matrix

        matrixCollarga[0][0] = '\\'; // slash as the first element in the matrix

        // add labels to matrix
        for (jCollarga=1; jCollarga < verticesCollarga; jCollarga++)
        matrixCollarga[0][jCollarga] = (char)(64+jCollarga);

        for (iCollarga=1; iCollarga < verticesCollarga; iCollarga++)
        matrixCollarga[iCollarga][0] = (char)(64+iCollarga);

        //Get the matrix elements
        System.out.println("Enter matrix elements: ");
        for (iCollarga=1; iCollarga < verticesCollarga; iCollarga++)
            for (jCollarga=1; jCollarga < verticesCollarga; jCollarga++)
            matrixCollarga[iCollarga][jCollarga] = (in.next().charAt(0));

        //print out the matrix for visualization
        System.out.println("Adjacency Matrix: ");
        for (iCollarga=0; iCollarga < verticesCollarga; iCollarga++) {
            for (jCollarga=0; jCollarga < verticesCollarga; jCollarga++)
                System.out.print(matrixCollarga[iCollarga][jCollarga] + " ");
            System.out.println(); 
        }

        char[][] edgesCollarga = new char[verticesCollarga*(verticesCollarga-1)/2][2]; 
        int[] countsCollarga = new int[verticesCollarga*(verticesCollarga-1)/2];
        int indexCollarga = 0;

        //store edges information in separate arrays
        for ( iCollarga = 1; iCollarga < verticesCollarga; iCollarga++) {
            for ( jCollarga = iCollarga+1; jCollarga < verticesCollarga; jCollarga++) { 
                if (matrixCollarga[iCollarga][jCollarga] != '0') { 
                    edgesCollarga[indexCollarga][0] = matrixCollarga[iCollarga][0];
                    edgesCollarga[indexCollarga][1] = matrixCollarga[0][jCollarga];
                    countsCollarga[indexCollarga] = Character.getNumericValue(matrixCollarga[iCollarga][jCollarga]); 
                    indexCollarga++;
                }
            }
        }

        //print results
        for ( iCollarga = 0; iCollarga < indexCollarga; iCollarga++) { 
            System.out.print("Edges:\n");
            System.out.println("{" + edgesCollarga[iCollarga][0] + ", " + edgesCollarga[iCollarga][1] + "} : " + countsCollarga[iCollarga] + " time(s)");
        }

        in.close();

    }

}
