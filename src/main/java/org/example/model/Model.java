package org.example.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;

public class Model extends Observable {
    private MyShape currentShape;
    private List<MyShape> shapeList = new ArrayList<>();

    public List<MyShape> getShapeList() {
        return shapeList;
    }

    public void createCurrentShape(MyShape shape){
        currentShape = shape;
        shapeList.add(shape);
    }
    public void addCurrentShape(MyShape sampleShape){
        shapeList.add(sampleShape);
    }
    public MyShape getLastShape() {
        int size = shapeList.size();
        return shapeList.isEmpty() ? null : shapeList.get(size - 1);
    }

    public void  removeLastShape() {
        if(shapeList == null) {
            return;
        } else {
            int size = shapeList.size();
            shapeList.remove(size - 1);
        }

    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D x, Point2D y) {
        currentShape.setFrame(x, y);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }
    public void update()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
