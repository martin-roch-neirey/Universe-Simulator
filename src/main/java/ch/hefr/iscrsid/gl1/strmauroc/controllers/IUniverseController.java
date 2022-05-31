package ch.hefr.iscrsid.gl1.strmauroc.controllers;

import ch.heia.isc.gl1.simulife.interface_.ICell;
import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import ch.heia.isc.gl1.simulife.interface_.IElement;

import java.util.ArrayList;

public class IUniverseController {

    /**
     * Call action() method on all elements in the universe
     */
    public static void actionAll(IControllableUniverse universe) {
        ArrayList<IElement> elements = new ArrayList<>();
        for (int i = 0; i < universe.getHeight(); i++) {
            for (int j = 0; j < universe.getWidth(); j++) {
                ICell cell = universe.getICell(i, j);
                for (int k = 0; k < cell.getNumberOfElements(); k++) {
                    elements.add(cell.getElement(k));
                }
            }
        }

        for (IElement element : elements) element.action();

    }

}
