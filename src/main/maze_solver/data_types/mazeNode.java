package maze_solver.data_types;

import java.awt.*;

/**
 * Created by jphamlett on 6/16/17.
 */
public class mazeNode {
    private Point point;
    private int dist;
    private mazeNode preultimate;

    public mazeNode getPreultimate() {
        return preultimate;
    }

    public void setPreultimate(mazeNode preultimate) {
        this.preultimate = preultimate;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public mazeNode(Point point, int dist, mazeNode preultimate){
        setPoint(point);
        setDist(dist);
        setPreultimate(preultimate);
    }

    @Override
    public String toString() {
        return "mazeNode{" +
                "point=" + point +
                ", dist=" + dist +
                ", preultimate=" + preultimate +
                '}';
    }
}
