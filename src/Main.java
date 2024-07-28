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
        sLocation = findS(myarray);
        System.out.println(myarray[sLocation[0]][sLocation[1]+1]);
        System.out.println(myarray[sLocation[0]][sLocation[1]-1]);
        System.out.println(myarray[sLocation[0]+1][sLocation[1]]);
        System.out.println(myarray[sLocation[0]-1][sLocation[1]+1]);




    }

//    public static List<List<Integer>> solve(int[]sLocation, char[][] maze) {
//
//
//    }


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