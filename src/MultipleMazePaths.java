import java.util.ArrayList;
import java.util.List;

public class MultipleMazePaths {
    static int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static List<List<Point>> findAllPaths(char[][] maze, char wall, Point start, Point end) {
        List<List<Point>> allPaths = new ArrayList<>();
        boolean[][] seen = new boolean[maze.length][maze[0].length];
        List<Point> currentPath = new ArrayList<>();

        walkAndFindAllPaths(maze, wall, start, end, seen, currentPath, allPaths);

        return allPaths;
    }

    private static void walkAndFindAllPaths(char[][] maze,
                                            char wall,
                                            Point current,
                                            Point end,
                                            boolean[][] seen,
                                            List<Point> currentPath,
                                            List<List<Point>> allPaths) {
        // Base cases
        if (current.x < 0 || current.x >= maze.length ||
                current.y < 0 || current.y >= maze[0].length ||
                maze[current.x][current.y] == wall ||
                seen[current.x][current.y]) {
            return;
        }

        currentPath.add(current);
        seen[current.x][current.y] = true;

        if (current.x == end.x && current.y == end.y) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int[] d : dir) {
                Point next = new Point(current.x + d[0], current.y + d[1]);
                walkAndFindAllPaths(maze, wall, next, end, seen, currentPath, allPaths);
            }
        }
        // Backtrack
        currentPath.remove(currentPath.size() - 1);
        seen[current.x][current.y] = false;
    }

    public static void displayPaths(char[][] maze, List<List<Point>> paths) {

        for (int i = 0; i < paths.size(); i++) {
            char[][] mazeCopy = new char[maze.length][maze[0].length];
            for (int j = 0; j < maze.length; j++) {
                mazeCopy[j] = maze[j].clone();
            }

            for (Point p : paths.get(i)) {
                if (mazeCopy[p.x][p.y] != 'S' && mazeCopy[p.x][p.y] != 'E') {
                    mazeCopy[p.x][p.y] = '*';
                }
            }

            System.out.println("Path " + (i + 1) + ":");
            for (char[] row : mazeCopy) {
                System.out.println(new String(row));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
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
        char wall = '|';
        Point start = new Point(2, 1);
        Point end = new Point(4, 3);

        List<List<Point>> allPaths = findAllPaths(maze, wall, start, end);
        displayPaths(maze, allPaths);
        System.out.println("Total paths found: " + allPaths.size());
    }
}