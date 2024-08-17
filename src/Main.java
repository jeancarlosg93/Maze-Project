import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        char[][] maze3 = FileReader.readFile("maze");
        List<Point> mazetolist = new ArrayList<>();

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

        for (int i = 0; i < maze1.length; i++) {
            for (int j = 0; j < maze1[i].length; j++) {
                mazetolist.add(new Point(i, j, maze1[i][j]));
            }
        }

        for (Point p : mazetolist) {
            System.out.println(p);
        }


        Point S = findS(maze1);
        Point E = findE(maze1);
        List<Point> solution = solve(maze1, '|', S, E);

        for (Point p : solution) {
            if (maze1[p.x][p.y] == ' ') {
                maze1[p.x][p.y] = '*';
            }
        }

        for (char[] row : maze1) {
            System.out.println(new String(row));
        }

    }

    static int[][] dir = {
            {1, 0},//up
            {-1, 0},//down
            {0, 1},//right
            {0, -1}//left
    };

    static Stack<Point> path = new Stack<>();

    public static boolean walk(char[][] maze, char wall, Point current, Point End, boolean[][] seen,
                               Stack<Point> path) {
        //Base Cases
        //1. Off the map
        if (current.x < 0 || current.x >= maze.length ||
                current.y < 0 || current.y >= maze[0].length) {
            return false;
        }
        //2. It is a wall
        if (current.value == wall) {
            return false;
        }
        //3. It is the end
        if (current.x == End.x && current.y == End.y) {
            path.push(current);
            return true;
        }
        //4. If already seen
        if (seen[current.x][current.y]) {
            return false;
        }

        //Pre
        seen[current.x][current.y] = true;
        path.push(current);

        //Recurse
        for (int[] dir : dir) {
            Point newCurrent = new Point(current.x + dir[0], current.y + dir[1], maze[current.x + dir[0]][current.y + dir[1]]);
            if (walk(maze, wall, newCurrent, End, seen, path)) {
                return true;
            }
        }
        //Post
        path.pop();
        return false;
    }

    public static List<Point> solve(char[][] maze, char wall, Point Start, Point End) {

        boolean[][] seen = new boolean[maze.length][maze[0].length];

        List<Point> solution = new ArrayList<>();

        if (walk(maze, wall, Start, End, seen, path)) {
            // Convert from Stack to List
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
                    return new Point(i, j, maze[i][j]);
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
                    return new Point(i, j, maze[i][j]);

                }
            }
        }
        return null;
    }


}