package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import ch.heia.isc.gl1.simulife.interface_.IElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief MobilePhone object
 */

public class MobilePhone extends Element implements IElement {

    @Getter
    private int energy;

    @Getter
    @Setter
    private IControllableUniverse board;

    public MobilePhone(IControllableUniverse board, int energy) {
        super();
        this.energy = energy;
        state.put("xLocation", String.valueOf(xLoc));
        state.put("yLocation", String.valueOf(yLoc));
        state.put("energy", String.valueOf(this.getEnergy()));

        this.board = board;
    }

    @Override
    public void action() {
        this.setEnergy(this.energy - 1);
        if (this.energy <= 0) {
            this.getBoard().removeElement(this);
            // System.out.println("Phone delete");
        }

        double distance = Double.parseDouble(this.getState().getOrDefault("nearestAntenna", String.valueOf(Integer.MAX_VALUE)));


        /* Code disabled to allow execution
        for (MobileAntenna antenna : this.getAntennas()) {

            int xAntenna = this.getxLoc();
            int yAntenna = this.getyLoc();

            double newDistance = Math.sqrt((yAntenna - yLoc) ^ 2 + (xAntenna - xLoc) ^ 2);

            if (newDistance < distance) {
                distance = newDistance;
                System.out.println("Discovered a new nearest Antenna");
            }
        }

        this.getState().put("nearestAntenna", String.valueOf(distance));*/

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

    @Override
    public Map<String, String> getState() {
        Map<String, String> map = super.getState();
        map.put("energy", String.valueOf(this.energy));
        return map;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
        this.state.put("energy", String.valueOf(energy));
    }

    private ArrayList<MobileAntenna> getAntennas() {
        ArrayList<MobileAntenna> list = new ArrayList<>();
        Board.forEachElementOfUniverse(this.board, e -> {
            if (e instanceof MobileAntenna) list.add((MobileAntenna) e);
        });
        return list;
    }

}
