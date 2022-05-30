package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief MobilePhone object
 */

public class MobilePhone extends Element {

    @Getter
    private int energy;

    /**
     * @brief mobile phone constructor
     */
    public MobilePhone(IControllableUniverse universe, int energy) {
        super(universe, 'T', Color.CYAN);
        this.energy = energy;
    }


    /**
     * Action method called on a mobile phone to reproduce behavior specified in project requirements
     */
    @Override
    public void action() {
        this.setEnergy(this.energy - 1);
        if (this.energy <= 0) {
            this.getUniverse().removeElement(this);
            this.universe = null;
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

    /**
     * @values :
     *    - energy : energy of the mobile phone
     *
     * @return the map given by the super method with the energy of the mobile phone.
     */
    @Override
    public Map<String, String> getState() {
        Map<String, String> map = super.getState();
        map.put("energy", String.valueOf(this.energy));
        return map;
    }

    /**
     * @param energy The amount of energy the mobile phone has.
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return A list of all the MobileAntenna objects in the universe of the mobile phone.
     */
    private ArrayList<MobileAntenna> getAntennas() {
        ArrayList<MobileAntenna> list = new ArrayList<>();
        Board.forEachElementOfUniverse(this.universe, e -> {
            if (e instanceof MobileAntenna) list.add((MobileAntenna) e);
        });
        return list;
    }

}
