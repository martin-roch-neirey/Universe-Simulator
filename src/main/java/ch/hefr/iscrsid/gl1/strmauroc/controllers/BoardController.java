package ch.hefr.iscrsid.gl1.strmauroc.controllers;

import ch.hefr.iscrsid.gl1.strmauroc.models.Board;
import ch.hefr.iscrsid.gl1.strmauroc.models.MobilePhone;
import ch.heia.isc.gl1.simulife.interface_.IElement;

public class BoardController {


    /**
     * Call action() method on all elements in the board
     */
    public static void actionAll(Board board, boolean printAfter) {
        for (IElement element : board.getAllElements()) {
            element.action();

            if (element instanceof MobilePhone) {
                if (((MobilePhone) element).getEnergy() <= 0) {
                    ((MobilePhone) element).getCell().removeElement((MobilePhone) element);
                }
            }
        }
        if (printAfter) board.toString();
    }

}
