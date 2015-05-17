import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class PointsFunctions {
    public static List<Point> generatePoints() {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < 100_000; i++) {
            int x = (int) (ThreadLocalRandom.current().nextInt(10000));
            int y = (int) (ThreadLocalRandom.current().nextInt(10000));
            Point point = new Point(x, y);
            points.add(point);
        }
        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point x1, Point x2) {
                int result = Double.compare(x1.getX(), x2.getX());
                if (result == 0) {
                    result = Double.compare(x1.getY(), x2.getY());
                }
                return result;
            }
        });
        return points;
    }

    public static synchronized void printPoints(Map<Point, Point> map) {
        Set<Point> keys = map.keySet();
        for (Point key : keys)
            System.out.println("Nearest to " + key + " is: " + map.get(key));
    }

    public static double calcDistance(Point checkedPoint, Point nearestPoint) {
        int x = Math.abs(nearestPoint.getX() - checkedPoint.getX());
        int y = Math.abs(nearestPoint.getY() - checkedPoint.getY());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static Map<Point, Point> getNearestPoint(List<Point> points) throws InterruptedException {
        Map<Point, Point> result = new HashMap<Point, Point>();
        int middle = points.size() / 2;
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                doCalculations(points, 0, middle, result);
            }
        }, "From0to50_000");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                doCalculations(points, middle + 1, points.size() - 1, result);
            }
        }, "From50_000To100_000");
        A.start();
        B.start();
        A.join();
        B.join();
        return result;
    }

    public static void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap) {
        for (int i = indexFrom; i < indexTo; i++) {
            int nearestPoint = Integer.MAX_VALUE;
            int index = 0;
            int pointBefore = i;
            int pointsAfter = i;
            for (int j = 1; j < 11; j++) {
                if (i < indexFrom + 5) {
                    int dis = pointBefore > 0 ? (int) calcDistance(inPoints.get(i), inPoints.get(--pointBefore))
                            : (int) calcDistance(inPoints.get(i), inPoints.get(++pointsAfter));
                    if (dis < nearestPoint) {
                        nearestPoint = dis;
                        index = pointBefore < i ? pointBefore : i + j;
                    }
                } else if (inPoints.size() - i > 10 && i > indexFrom + 2) {
                    if (j < 5) {
                        int dis = (int) calcDistance(inPoints.get(i), inPoints.get(--pointBefore));
                        if (dis < nearestPoint) {
                            nearestPoint = dis;
                            index = i - j;
                        }
                    } else {
                        int dis = (int) calcDistance(inPoints.get(i), inPoints.get(pointsAfter++));
                        if (dis < nearestPoint) {
                            nearestPoint = dis;
                            index = i + j;
                        }
                    }
                }
            }
            outMap.put(inPoints.get(i), inPoints.get(index));
        }
    }
}
