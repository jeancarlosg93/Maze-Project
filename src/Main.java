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
        ;






    }

    public static int[] findNextNode(int[]checkAround, char[][]maze) {

        int y = checkAround[0];
        int x = checkAround[1];

        if (maze[y][x+1] == ' '){
            return new int[]{y, x+1};
        }

        if (maze[y][x-1] == ' '){
            return new int[]{y, x-1};
        }
        if (maze[y+1][x] == ' '){
            return new int[]{y+1, x};
        }
        if (maze[y-1][x] == ' '){
            return new int[]{y-1, x};
        }
          return null;
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