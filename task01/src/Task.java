import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.*;

public class Task {
    public static ArrayList<SinglyLinkedList<Point>> FindPath(Map map, Point start, ArrayList<Point> finish) {
        LinkedList<SinglyLinkedList<Point>> paths = new LinkedList();//queue
        paths.addLast(new SinglyLinkedList<Point>(start));

        HashSet<Point> exits = new HashSet(finish);
        HashSet visited = new HashSet<Point>();

        ArrayList<SinglyLinkedList<Point>> resultPaths = new ArrayList<>();
        while (paths.stream().count() != 0) {
            SinglyLinkedList<Point> point = paths.removeFirst();
            if (!map.InBounds(point.Value)
                    || map.Dungeon[point.Value.x][point.Value.y] == MapCell.Wall
                    || visited.contains(point.Value)) continue;
            visited.add(point.Value);

            if (exits.contains(point.Value))
                resultPaths.add(point);

            GetPointAround(point, paths);
        }
        return resultPaths;
    }

    private static LinkedList<SinglyLinkedList<Point>> GetPointAround(SinglyLinkedList<Point> point,
                                                                      LinkedList<SinglyLinkedList<Point>> paths) {
        for (int y = -1; y <= 1; y++)
            for (int x = -1; x <= 1; x++) {
                if (x == 0 || y == 0) {
                    Point nextPoint = new Point(point.Value.x + x, point.Value.y + y);
                    paths.addLast(new SinglyLinkedList<Point>(nextPoint, point));
                }
            }
        return paths;
    }
}
