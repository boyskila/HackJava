import java.io.IOException;
import java.util.List;

public class NearestPoint {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();
        List<Point> allPoints = PointsFunctions.generatePoints();
        PointsFunctions.printPoints(PointsFunctions.getNearestPoint(allPoints));
        System.out.println(System.currentTimeMillis() - start + "milliseconds");
    }
}
