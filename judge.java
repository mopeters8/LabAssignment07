import java.util.ArrayList;

public class judge {

    public class Graph
    {
        private boolean [][] adjacencyMatrix;

        public Graph (Integer vertices) {
         adjacencyMatrix = new boolean[vertices][vertices];
        }

        public boolean[][] getMatrix() {
            return adjacencyMatrix;
        }

        public void addEdge(int[][] newArray) {
            int x = 0;
            int y = 0;
            for (int i = 0; i < newArray.length; i++) {
                for (int j = 0; j < newArray[i].length; j++) {
                    if(j == 0) {
                        x = newArray[i][j]-1;
                    }
                    else {
                        y = newArray[i][j]-1;
                    }
                }
                //System.out.println("X: "+x+" Y: "+y);  //testing to see X and Y
                adjacencyMatrix[x][y] = true;
            }
        }
    }

    public int findJudge (int N, int [][] trust)
    {
        Graph giraphy = new Graph(N);
        giraphy.addEdge(trust);
        boolean[][] ourMatrix = giraphy.getMatrix();
        printGraph(ourMatrix); //testing


        for (int i = 0; i < ourMatrix.length; i++) {
            int isempty = 0;
            for (int j = 0; j < ourMatrix[i].length; j++) {
                if (ourMatrix[i][j] == true) {
                    isempty++;
                }
            }
            if (isempty == 0) {
                System.out.print("The Judge was found! It is: ");
                return i+1;
            }
        }
        System.out.print("No Judge was found: ");
        return -1;
    }

    public void printGraph(boolean[][] printArray) {
        System.out.print("\n\nAdjacency Matrix: \n-----------------\n   ");

        for (int k = 0; k < printArray.length; k++) {
            System.out.print(" "+(k+1));
        }
        System.out.println();
        for(int i=0; i<printArray.length; i++) {
            System.out.print((i+1)+" | ");
            for(int j=0; j<printArray[i].length; j++) {
                if (printArray[i][j] == true) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println(" ");
        }
    }

    public int getN(int [][] countarray) {
        int highcount = 0;

        for(int i=0; i<countarray.length; i++) {
            for(int j=0; j<countarray[i].length; j++) {
                if (countarray[i][j] > highcount) {
                    highcount = countarray[i][j];
                }
            }
        }

        return highcount;
    }   //Added this to make it look nicer. Simply finds the highest number in array for N

    public static void main(String args[]) {
        judge judgy = new judge();
//
//        EXAMPLE 1
//
        int[][] example1 = {{1,2}};
        int nCount = judgy.getN(example1);
        System.out.println(judgy.findJudge(nCount, example1));

//
//        EXAMPLE 2
//
        int[][] example2 = {{1,3},{2,3}};
        nCount = judgy.getN(example2);
        System.out.println(judgy.findJudge(nCount, example2));


//
//        EXAMPLE 3
//
        int[][] example3 = {{1,3},{2,3},{3,1}};
        nCount = judgy.getN(example3);
        System.out.println(judgy.findJudge(nCount, example3));

//
//        EXAMPLE 4
//
        int[][] example4 = {{1,2},{2,3}};
        nCount = judgy.getN(example4);
        System.out.println(judgy.findJudge(nCount, example4));

//
//        EXAMPLE 5
//
        int[][] example5 = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        nCount = judgy.getN(example5);
        System.out.println(judgy.findJudge(nCount, example5));

//
//        EXAMPLE CUSTOM
//
        int[][] example6 = {{3,4},{2,1},{5,3},{4,1},{2,5}};
        nCount = judgy.getN(example6);
        System.out.println(judgy.findJudge(nCount, example6));
    }
}
