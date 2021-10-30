package de.hsw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Starter {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        Point p3 = new Point(1,2);

        List<Point> pointList = new ArrayList<>();
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        System.out.println(pointList);

        Set<Point> pointSet = new HashSet<>();
        pointSet.add(p1);
        pointSet.add(p2);
        pointSet.add(p3);
        System.out.println(pointSet);

        Map<String, Point> stringPointMap = new HashMap<>();
        stringPointMap.put("Point 1", p1);
        stringPointMap.put("Point 2", p2);
        stringPointMap.put("Point 3", p3);
        System.out.println(stringPointMap);

        Map<Point, String> pointStringMap = new HashMap<>();
        pointStringMap.put(p1, "Point 1");
        pointStringMap.put(p2, "Point 2");
        pointStringMap.put(p3, "Point 3");
        System.out.println(pointStringMap);
    }
}
