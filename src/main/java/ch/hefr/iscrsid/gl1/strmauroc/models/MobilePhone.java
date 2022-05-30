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

    @Getter
    private MobileAntenna nearestAntenna;

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
        System.out.println("energy="+energy );

        // has the phone enough energy to live ?
        if (this.energy <= 0) {
            this.getUniverse().removeElement(this);
            this.universe = null;
            System.out.println("phone deleted");
            return;
        }

        // looking for a new nearest antenna
        double distance = Integer.MAX_VALUE;

        for (MobileAntenna antenna : this.getAntennas()) {

            int xAntenna = antenna.getXLoc();
            int yAntenna = antenna.getYLoc();

            double newDistance = Math.sqrt((yAntenna - yLoc) ^ 2 + (xAntenna - xLoc) ^ 2);

            if (newDistance < distance) { // found a new nearest Antenna
                distance = newDistance;
                this.nearestAntenna = antenna;
                this.state.put("nearestAntenna", String.valueOf(distance));
            }
        }

        this.getState().put("nearestAntenna", String.valueOf(distance));

        // move to nearest Antenna :
        if (this.nearestAntenna != null) {

            int xDest = nearestAntenna.getXLoc();
            int yDest = nearestAntenna.getYLoc();

            // if phone is on same cell as nearest antenna, don't move
            if (nearestAntenna.getUniverse().getICell(nearestAntenna.getXLoc(), nearestAntenna.getYLoc()) ==
                    this.getUniverse().getICell(this.getXLoc(), this.getYLoc())) return;

            boolean xRight = false;
            boolean yDown = false;

            if (xDest > this.getXLoc()) xRight = true;
            if (yDest > this.getYLoc()) yDown = true;

            // x management
            if (xRight && this.getXLoc() < this.getUniverse().getWidth()) {
                this.getUniverse().moveElement(this, this.getXLoc() + 1, this.getYLoc());
            } else if (!(xDest == this.getXLoc())){
                this.getUniverse().moveElement(this, this.getXLoc() - 1, this.getYLoc());
            }

            // y management
            if (yDown && this.getYLoc() < this.getUniverse().getHeight()) {
                this.getUniverse().moveElement(this, this.getXLoc(), this.getYLoc() + 1);
            } else if (!(yDest == this.getYLoc())){
                this.getUniverse().moveElement(this, this.getXLoc(), this.getYLoc() - 1);
            }

        }


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
            if (e instanceof MobileAntenna) {
                list.add((MobileAntenna) e);
            }
        });
        return list;
    }

}
