package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;
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


public abstract class Element implements IElement {

    protected Map<String, String> state;

    @Setter
    @Getter
    protected int xLoc;

    @Setter
    @Getter
    protected int yLoc;

    /**
     * @brief constructor with only type
     */
    public Element() {
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
        return 0;
    }

    @Override
    public Map<String, String> getState() {
        return new HashMap<>(state);
    }

    @Override
    public void action() {

    }

    public void setPosition(int x, int y) {
        this.xLoc = x;
        this.yLoc = y;
    }
}
