import java.awt.*;
import java.util.ArrayList;


public class Map {
    public final MapCell[][] Dungeon;
    public final Point InitialPosition;
    public final ArrayList<Point> Exits;

    private Map(MapCell[][] dungeon, java.awt.Point initialPosition, ArrayList<Point> exits)
    {
        Dungeon = dungeon;
        InitialPosition = initialPosition;
        Exits = exits;
    }

    public static Map FromText(String text)
    {
        String[] lines = text.split("\n");
        return FromLines(lines);
    }

    public static Map FromLines(String[] lines)
    {
        MapCell[][] dungeon = new MapCell[lines[0].length()][lines.length];
        Point initialPosition = new Point(0,0);
        ArrayList<Point> exits = new ArrayList();
        for (int y = 0; y < lines.length; y++)
        {
            for (int x = 0; x < lines[0].length(); x++)
            {
                switch (lines[y].charAt(x))
                {
                    case '#':
                        dungeon[x][y] = MapCell.Wall;
                        break;
                    case 's':
                        dungeon[x][y] = MapCell.Start;
                        initialPosition = new Point(x, y);
                        break;
                    case 'f':
                        dungeon[x][y] = MapCell.Finish;
                        exits.add(new Point(x, y));
                        break;
                    case '.':
                    default:
                        dungeon[x][y] = MapCell.Empty;
                        break;
                }
            }
        }
        return new Map(dungeon, initialPosition, exits);
    }

    public boolean InBounds(Point point)
    {
        Rectangle bounds = new Rectangle(0, 0, Dungeon[0].length, Dungeon.length);
        return bounds.contains(point);
    }
}
