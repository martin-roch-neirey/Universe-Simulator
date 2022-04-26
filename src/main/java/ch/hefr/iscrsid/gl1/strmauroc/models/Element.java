package ch.hefr.iscrsid.gl1.strmauroc.models;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief Elements in a cell
 */


@Deprecated
public class Element {

    private final String type;
    private Cell cell;

    /**
     * @param type type of the element
     * @brief constructor with only type
     */
    public Element(String type) {
        this.type = type;
    }

    /**
     * @param cell cell instance
     * @brief set cell to element
     */
    void setCell(Cell cell) {
        this.cell = cell;
    }

    /**
     * @return Cell
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     * @return element info
     */
    @Override
    public String toString() {
        return "type:" + type + " cell:" + " " + cell;
    }
}
