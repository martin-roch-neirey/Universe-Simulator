package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.IElement;
import lombok.Getter;

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

    @Getter
    private Map<String, String> state;

    public MobileAntenna() {
        state = new HashMap<>();

        Board board = (Board) this.getCell().getIUniverse();
        board.getAntennas().add(this);
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

    @Override
    void setCell(Cell cell) {
        super.setCell(cell);
        state.put("xLocation", String.valueOf(this.getCell().getX()));
        state.put("yLocation", String.valueOf(this.getCell().getY()));
    }
}
