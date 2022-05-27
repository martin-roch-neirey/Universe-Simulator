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
 * @brief MobileAntenna object
 */

public class MobileAntenna extends Element implements IElement {

    @Setter
    @Getter
    private int coverageRadius;

    public MobileAntenna(int coverageRadius) {
        super();
        this.coverageRadius = coverageRadius;
    }

    @Override
    public void action() {
        // moves optionnally
        // go away from other antennas
        // or go near covered mobile phones
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

    private void getNearestAntenna() {
        // TODO
        // state.put("xNearestAntenna", );
        // state.put("yNearestAntenna", );
    }

    private int getPhoneCovered() {
        // TODO
        return 0;
    }
}
