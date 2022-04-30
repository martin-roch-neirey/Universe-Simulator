package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

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
    private Map<String, String> state;

    public MobilePhone(int energy) {
        this.energy = energy;
        state = new HashMap<>();
        state.put("xLocation", String.valueOf(this.getCell().getX()));
        state.put("yLocation", String.valueOf(this.getCell().getY()));
        state.put("energy", String.valueOf(this.getEnergy()));
    }

    @Override
    public void action() {
        this.setEnergy(this.getEnergy() - 1);
        if (energy <= 0) {
            // TODO delete mobilePhone because it has no more energy
            System.out.println("Phone delete");
        }

        Board board = (Board) this.getCell().getIUniverse();
        double distance = Double.parseDouble(this.getState().getOrDefault("nearestAntenna", "99999999999"));

        int xPhone = Integer.parseInt(this.getState().get("xLocation"));
        int yPhone = Integer.parseInt(this.getState().get("yLocation"));

        for (MobileAntenna antenna : board.getAntennas()) {

                int xAntenna = Integer.parseInt(antenna.getState().get("xLocation"));
                int yAntenna = Integer.parseInt(antenna.getState().get("yLocation"));

                double newDistance = Math.sqrt((yAntenna - yPhone)^2 + (xAntenna - xPhone)^2);

                if (newDistance < distance) {
                    distance = newDistance;
                    System.out.println("Discovered a new nearest Antenna");
                }
        }

        this.getState().put("nearestAntenna", String.valueOf(distance));

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

    public void setEnergy(int energy) {
        this.energy = energy;
        this.state.put("energy", String.valueOf(energy));
    }

}
