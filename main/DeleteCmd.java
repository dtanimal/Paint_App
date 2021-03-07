package main;

import StaticShapeFactory.ShapeProperties;
import model.interfaces.IApplicationState;
import model.interfaces.IDraw;
import view.interfaces.ISubject;

public class DeleteCmd implements ICommand, IUndoable{
    ISubject selectShapeList;
    ShapeProperties shapeProperties;

    public DeleteCmd(ISubject selectShapeList, ShapeProperties shapeProperties) {

        this.selectShapeList = selectShapeList;
        this.shapeProperties = shapeProperties;

    }

    @Override
    public void run() {

        for(IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.removeShape(s);
            selectShapeList.notifyObserver();

        }
        CommandHistory.add(this);


    }

    @Override
    public void undo() {
        //same as all other undos just reverse the process
        for(IDraw s : selectShapeList.getSelectedShapeList()) {
            selectShapeList.addShape(s);
        }

    }

    @Override
    public void redo() {
        // re-run the run() function to redo what we undid
        run();

    }
}
