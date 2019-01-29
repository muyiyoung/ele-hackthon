package me.ele.hackathon.example.ghost.map.parse.path;

import me.ele.hackathon.pacman.ds.Coordinate;

/**
 * @author: Jimu Yang
 * @date: 2019/1/28 3:17 PM
 * @descricption: want more.
 * 线段 无方向
 */
public class Segment {

    private Coordinate coord1;

    private Coordinate coord2;

    private int length;

    private Coordinate[] coords;

    private boolean vertical;

    public Segment(Coordinate coord1, Coordinate coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
        this.coords = new Coordinate[]{coord1, coord2};

        if (coord1.equals(coord2)) {
            throw new RuntimeException("invalid path: length = 0");
        }

        if (coord1.getX() == coord2.getX()) {
            this.length = Math.abs(coord1.getY() - coord2.getY());
            this.vertical = true;
        } else {
            this.length = Math.abs(coord1.getX() - coord2.getX());
            this.vertical = false;
        }
    }

    public boolean have(Coordinate coord) {
        return coord1.equals(coord) || coord2.equals(coord);
    }

    public Coordinate another(Coordinate coord) {
        if (coord1.equals(coord)) {
            return coord2;
        } else if (coord2.equals(coord)) {
            return coord1;
        }
        return null;
    }

    public boolean on(Coordinate coord) {
        if (this.vertical) {
            if (coord.getX() != coord1.getX()) {
                return false;
            }
            if (coord1.getY() > coord2.getY()) {
                return coord.getY() >= coord2.getY() && coord.getY() <= coord1.getY();
            } else {
                return coord.getY() >= coord1.getY() && coord.getY() <= coord2.getY();
            }
        } else {
            if (coord.getY() != coord1.getY()) {
                return false;
            }
            if (coord1.getX() > coord2.getX()) {
                return coord.getX() >= coord2.getX() && coord.getX() <= coord1.getX();
            } else {
                return coord.getX() >= coord1.getX() && coord.getX() <= coord2.getX();
            }
        }
    }


    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return coord1.toString() + "---" + coord2.toString();
    }

}
