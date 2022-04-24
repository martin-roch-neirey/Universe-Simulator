package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MobileAntenna implements IElement {

    private Map<String, String> state;

    public MobileAntenna() {
        state = new HashMap<>();
    }

    @Override
    public void action() {

    }

    @Override
    public char getCode() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public String getIconPath() {
        return null;
    }

    public Map<String, String> getState() {
        return this.state;
    }
}
