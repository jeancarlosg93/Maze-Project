import java.util.*;


public class Main {
    public static void main(String[] args) {



        char[][] myarray = {
                {'|','|','|','|','|',},
                {'|','S','|','|','|',}, // s location = myarray [1,1];
                {'|',' ','|','|','|',},
                {'|',' ',' ','E','|',}, // e location = myarray [3,3]
                {'|','|','|','|','|',}
        };

        int[] sLocation;
        int[] eLocation;
        List<List<Integer>> connectingNodes;


        connectingNodes =adjacencyList(myarray);
        for (List<Integer> connectingNode : connectingNodes) {
            System.out.println(connectingNode);
        }
        sLocation = findS(myarray);
        System.out.println(sLocation[0] + " " + sLocation[1]);
        eLocation = findE(myarray);
        System.out.println(eLocation[0] + " " + eLocation[1]);


    }

    public static List<List<Integer>> adjacencyList(char[][] myarray) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < myarray.length; i++) {
                 adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < myarray[0].length; i++) {
            for (int j = 0; j < myarray.length; j++) {
                if (myarray[i][j] == '|') {
                    adjacencyList.get(i).add(j);
                }
            }
        }
            return adjacencyList;
    }

    public static int[] findS(char[][] maze){
        int[] s = {0,0};
        for (int i = 0; i < maze.length; i++) {
             for (int j = 0; j < maze[i].length; j++) {
                 if (maze[i][j] == 'S') {
                     s = new int[]{i, j};

                 }
             }
         }
        return s;
    }

    public static int[] findE(char[][] maze){
        int[] e = {0,0};
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'E') {
                    e = new int[]{i, j};
                }
            }
        }
        return e;
    }


}