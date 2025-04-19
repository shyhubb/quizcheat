package quizcheat.backend.service.interfaces;

import java.util.List;

import quizcheat.backend.entity.Point;

public interface PointSerivce {
    public boolean typePoint(String email, Point point);

    List<Point> findallPoints();
}
