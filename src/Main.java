import java.util.ArrayList;
import java.util.List;

public class Main {

    static Stack<Point> path = new Stack<>();

    static int[][] directions = {
            {1, 0},//up
            {-1, 0},//down
            {0, 1},//right
            {0, -1}//left
    };

    public static void main(String[] args) {
        char[][] maze = selectAmaze(1);
        List<Point> startAndEndCoordinates = findStartAndEndCoordinates(maze);
        List<Point> solution = solve(maze, '|', startAndEndCoordinates.get(0), startAndEndCoordinates.get(1));

        for (Point p : solution) {
            if (maze[p.x][p.y] == ' ') {
                maze[p.x][p.y] = '*';
            }
        }

        for (char[] row : maze) {
            System.out.println(new String(row));
        }

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
        for (int[] dir : directions) {
            Point newCurrent = new Point(current.x + dir[0], current.y + dir[1], maze[current.x + dir[0]][current.y + dir[1]]);
            if (walk(maze, wall, newCurrent, End, seen, path)) {
                return true;
            }
        }
        //Post
        path.pop();
        return false;
    }

    public static List<Point> findStartAndEndCoordinates(char[][] maze) {
        List<Point> SandE = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    SandE.add(0, new Point(i, j, maze[i][j]));
                }
                if (maze[i][j] == 'E') {
                    SandE.add(1, new Point(i, j, maze[i][j]));
                }
            }
        }
        return SandE;
    }

    public static char[][] selectAmaze(int choice) {
        char[][] maze = new char[0][0];

        switch (choice) {
            case 1:
                maze = FileReader.readFile("maze");
                break;
            case 2:
                maze = new char[][]
                        {
                                {'|', '|', '|', '|', '|',},
                                {'|', 'S', '|', '|', '|',}, // s location = myarray [1,1];
                                {'|', ' ', '|', '|', '|',}, // path [2,1][3,1][3,2]
                                {'|', ' ', ' ', 'E', '|',}, // e location = myarray [3,3]
                                {'|', '|', '|', '|', '|',}
                        };
                break;
            case 3:
                maze = new char[][]
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
                break;
        }
        return maze;
    }
}

