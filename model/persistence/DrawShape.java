package model.persistence;

import Factory.ColorMap;
import Factory.ShapeList;
import Factory.ShapeProperties;
import model.ShapeColor;
import model.interfaces.IDraw;
import model.interfaces.IObserver;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawShape implements IObserver {

    PaintCanvasBase paintCanvas;
    ShapeList shapeList;
    ShapeProperties shapeProperties;
//    private static ColorMap colorMap = new ColorMap();

    public DrawShape(PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    public void update(){

        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(ColorMap.getInstance().getColor(ShapeColor.WHITE));
//        g.setColor(colorMap.getTheColor(ShapeColor.WHITE));
        g.fillRect(0,0,paintCanvas.getWidth(),paintCanvas.getHeight());

        for(IDraw shape : shapeList.getShapeList()){
            shape.draw(g);
            if(shapeList.getSelectedShapeList().contains(shape)){
                shape.outline(g);

            }



        }

    }
}
