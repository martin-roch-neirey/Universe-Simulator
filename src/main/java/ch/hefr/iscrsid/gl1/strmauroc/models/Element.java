package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;

import java.awt.*;
import java.util.Map;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief Elements in a cell
 */


public class Element implements IElement {

    private Cell cell;

    /**
     * @brief constructor with only type
     */
    public Element() {
    }

    /**
     * @param cell cell instance
     * @brief set cell to element
     */
    void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * @return Cell
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * @return element info
     */
    @Override
    public String toString() {
        return "type:" + " cell:" + " " + cell;
    }

    @Override
    public String getIconPath() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public char getCode() {
        return 0;
    }

    @Override
    public Map<String, String> getState() {
        return null;
    }

    @Override
    public void action() {

    }
}
