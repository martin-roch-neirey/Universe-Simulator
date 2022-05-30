package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief MobileAntenna object
 */

public class MobileAntenna extends Element {

    @Setter
    @Getter
    private int coverageRadius;

    /**
     * @brief mobile antenna constructor
     */
    public MobileAntenna(IControllableUniverse universe, int coverageRadius) {
        super(universe, 'A', Color.PINK);
        this.coverageRadius = coverageRadius;
    }

    /**
     * Action method called on a mobile antenna to reproduce behavior specified in project requirements
     */
    @Override
    public void action() {

        // looking for a new nearest antenna
        double distance = Integer.MAX_VALUE;

        for (MobileAntenna antenna : this.getAntennas()) {

            if (antenna == this) continue;

            int xAntenna = antenna.getXLoc();
            int yAntenna = antenna.getYLoc();

            double newDistance = Point2D.distance(xAntenna, yAntenna, this.getXLoc(), this.getYLoc());

            if (newDistance < distance) { // found a new nearest Antenna
                distance = newDistance;
                this.nearestAntenna = antenna;
            }
        }

        this.state.put("nearestAntenna", String.valueOf(distance));

        // move away from nearest Antenna :
        if (this.nearestAntenna != null) {

            int xNearest = nearestAntenna.getXLoc();
            int yNearest = nearestAntenna.getYLoc();

            boolean xRight = true;
            boolean yDown = true;

            if (xNearest > this.getXLoc()) xRight = false;
            if (yNearest > this.getYLoc()) yDown = false;

            // x management
            if (xRight && this.getXLoc() < this.getUniverse().getWidth() - 1) {
                this.getUniverse().moveElement(this, this.getXLoc() + 1, this.getYLoc());
            } else if (this.getXLoc() > 0 && !xRight) {
                this.getUniverse().moveElement(this, this.getXLoc() - 1, this.getYLoc());
            }

            // y management
            if (yDown && this.getYLoc() < this.getUniverse().getHeight() - 1) {
                this.getUniverse().moveElement(this, this.getXLoc(), this.getYLoc() + 1);
            } else if (this.getYLoc() > 0 && !yDown) {
                this.getUniverse().moveElement(this, this.getXLoc(), this.getYLoc() - 1);
            }

        }


    }

    private int getPhoneCovered() {
        // TODO
        return 0;
    }
}
