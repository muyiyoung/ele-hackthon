package me.ele.hackathon.example.ghost.path;

import me.ele.hackathon.example.ghost.map.Direction;
import me.ele.hackathon.pacman.ds.Coordinate;

/**
 * @author: Jimu Yang
 * @date: 2019/1/28 3:25 PM
 * @descricption: want more.
 */
public class Path {

    private Coordinate start;

    private Coordinate end;

    private int length;

    private Direction goDir;

    private Direction arriveDir;

    private PathNode head;

    private PathNode tail;


    public Path() {

    }

    /**
     * 简单的path
     *
     * @param start
     * @param end
     */
    public Path(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
        this.length = end.mhdDistance(start);
        this.goDir = Direction.get(start, end);
        this.arriveDir = Direction.get(end, start);
        this.head = new PathNode(start);
        this.tail = new PathNode(end);
        this.head.setNext(this.tail);
        this.tail.setFrom(this.head);

    }


    public Coordinate getStart() {
        return start;
    }

    public void setStart(Coordinate start) {
        this.start = start;
    }

    public Coordinate getEnd() {
        return end;
    }

    public void setEnd(Coordinate end) {
        this.end = end;
    }

    public Direction getGoDir() {
        return goDir;
    }

    public void setGoDir(Direction goDir) {
        this.goDir = goDir;
    }

    public Direction getArriveDir() {
        return arriveDir;
    }

    public void setArriveDir(Direction arriveDir) {
        this.arriveDir = arriveDir;
    }

    public PathNode getHead() {
        return head;
    }

    public void setHead(PathNode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public PathNode getTail() {
        return tail;
    }

    public void setTail(PathNode tail) {
        this.tail = tail;
    }
}
