import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
       char[][] maze3  = FileReader.readFile("maze");

        char[][] maze1 = {
                {'|', '|', '|', '|', '|',},
                {'|', 'S', '|', '|', '|',}, // s location = myarray [1,1];
                {'|', ' ', '|', '|', '|',}, // path [2,1][3,1][3,2]
                {'|', ' ', ' ', 'E', '|',}, // e location = myarray [3,3]
                {'|', '|', '|', '|', '|',}
        };

        char[][] maze =
                {
                        {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|',},
                        {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|',},
                        {'|', 'S', '|', '|', '|', '|', '|', '|', ' ', '|',},
                        {'|', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|',},
                        {'|', ' ', '|', 'E', '|', '|', '|', '|', ' ', '|',},
                        {'|', ' ', '|', ' ', '|', '|', '|', '|', ' ', '|',},
                        {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|',},
                        {'|', '|', '|', '|', '|', '|', '|', '|', '|', '|',}
                };



        Point S = findS(maze);
        Point E = findE(maze);
        List<Point> points = solve(maze,'|', S,E);

        if(!points.isEmpty()) {
            for(Point p : points) {
                System.out.println(maze[p.x][p.y]);
            }
            System.out.println(points);
        }else {
            System.out.println("No solution");
        }

    }

    static int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static Stack<Point> path = new Stack<>();

    public static boolean walk(char[][] maze, char wall, Point current, Point End, boolean[][] seen,
                               Stack<Point> path) {
        //base cases
        //1. off the map

        if (current.x < 0 || current.x >= maze.length ||
                current.y < 0 || current.y >= maze[0].length) {
            return false;
        }
        //2. it's a wall
        if (maze[current.x][current.y] == wall) {
            return false;
        }
        //3. it's the end
        if (current.x == End.x && current.y == End.y) {
            path.push(current);
            return true;
        }
        //4. if already seen
        if (seen[current.x][current.y]) {
            return false;
        }
        //recursion
        //pre
        seen[current.x][current.y] = true;
        path.push(current);

        //recurse
        for (int[] dir : dir) {
            Point newCurrent = new Point(current.x + dir[0], current.y + dir[1]);
            if (walk(maze, wall, newCurrent, End, seen, path)) {
                return true;
            }
        }
        //post
        path.pop();
        return false;
    }

    public static List<Point> solve(char[][] maze, char wall, Point Start, Point End) {

      boolean[][] seen = new boolean[maze.length][maze[0].length];

        List<Point> solution = new ArrayList();

        if (walk(maze, wall, Start, End, seen, path)) {
            // Mark the path
            while (!path.isEmpty()) {
                solution.add(path.pop());
            }
            return solution;
        }
        return solution; // No path found
    }




    public static Point findS(char[][] maze) {
        Point s = null;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public static Point findE(char[][] maze) {
        Point e = null;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'E') {
                    return new Point(i, j);

                }
            }
        }
        return null;
    }


}