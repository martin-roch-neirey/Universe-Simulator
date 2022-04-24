package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MobilePhone implements IElement {

    private int energy;
    private Map<String, String> state;

    public MobilePhone(int energy) {
        this.energy = energy;
        state = new HashMap<>();
    }

    @Override
    public void action() {




        if (energy <= 0) {
            // TODO delete mobilePhone because it has no more energy
        }
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

    public int getEnergy() {
        return energy;
    }
}
