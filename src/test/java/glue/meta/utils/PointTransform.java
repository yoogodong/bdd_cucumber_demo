package glue.meta.utils;

import cucumber.api.Transformer;

import java.awt.*;

public class PointTransform extends Transformer<Point> {
    @Override
    public Point transform(String s) {
        final String[] xy = s.split("/");
        final int x = Integer.parseInt(xy[0]);
        final int y = Integer.parseInt(xy[1]);
        return new Point(x,y);
    }
}
