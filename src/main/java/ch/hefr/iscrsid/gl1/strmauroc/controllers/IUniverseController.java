package ch.hefr.iscrsid.gl1.strmauroc.controllers;

import ch.heia.isc.gl1.simulife.interface_.ICell;
import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import ch.heia.isc.gl1.simulife.interface_.IUniverse;

public class IUniverseController {


    /**
     * Call action() method on all elements in the board
     */
    public static void actionAll(IControllableUniverse universe) {
        for (int i = 0; i < universe.getHeight(); i++) {
            for (int j = 0; j < universe.getWidth(); j++) {
                ICell cell = universe.getICell(i, j);
                for (int k = 0; k < cell.getNumberOfElements(); k++) {
                    cell.getElement(k).action();
                }
            }
        }

        //TODO remove phone IN MobilePhone class

        /*if (element instanceof MobilePhone) {
            if (((MobilePhone) element).getEnergy() <= 0) {
                ((MobilePhone) element).getCell().removeElement((MobilePhone) element);
            }
        }*/
    }

}
