package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import ch.heia.isc.gl1.simulife.interface_.IPositionnableElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief Elements in a cell
 */


public abstract class Element implements IPositionnableElement {

    protected Map<String, String> state;

    @Getter
    protected int xLoc;

    @Getter
    protected int yLoc;

    protected char code;

    @Getter
    @Setter
    protected IControllableUniverse universe;

    /**
     * @brief constructor with only type
     */
    public Element(IControllableUniverse universe, char code) {
        this.universe = universe;
        this.code = code;
        state = new HashMap<>();
    }

    /**
     * @return element info
     */
    @Override
    public String toString() {
        return "type:" + " position:" + " " + xLoc + ":" + yLoc;
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
        return this.code;
    }

    /**
     * Returns a map of the state of the object.
     * This map is a copy of the state map, so if we modify values on the real map, the copy
     * won't be changed.
     *
     * This method is possibly override in children class.
     *
     * @values :
     * - xLoc : x location
     * - yLox : y location
     *
     * @return A copy of the map.
     */
    @Override
    public Map<String, String> getState() {
        Map<String, String> map = new HashMap<>(state);
        map.put("xLoc", String.valueOf(xLoc));
        map.put("yLoc", String.valueOf(yLoc));
        return map;
    }

    /**
     * Sets the x and y coordinates of the object.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    @Override
    public void setPosition(int x, int y) {
        this.xLoc = x;
        this.yLoc = y;
    }
}
