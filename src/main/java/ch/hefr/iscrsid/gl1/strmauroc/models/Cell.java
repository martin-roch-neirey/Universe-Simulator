package ch.hefr.iscrsid.gl1.strmauroc.models;


import java.util.ArrayList;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief Cell with elements
 */

public class Cell {

    private final int x;
    private final int y;
    private final ArrayList<Element> elements;

    /**
     * @param x x coord
     * @param y y coord
     * @throws NumberFormatException exception
     * @brief Constructor of Cell with Exception handler
     */
    public Cell(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Illegal Args: x: " + x + " y: " + y);
        }
        this.elements = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    /**
     * @param element element instance
     * @brief Add element in Cell
     */
    public void addElement(Element element) throws ArrayStoreException {
        if (this.elements.contains(element)) {
            throw new ArrayStoreException("Element: " + element + " already exist in array");
        } else {
            this.elements.add(element);
            element.setCell(this);
        }
    }


    /**
     * @param element element instance
     * @throws ArrayStoreException exception
     * @brief remove element
     */
    public void removeElement(Element element) throws ArrayStoreException {
        if (this.elements.contains(element)) {
            this.elements.remove(element);
            element.setCell(null);
        } else {
            throw new ArrayStoreException("Element: " + element + " dont exist in array");
        }


    }

    /**
     * @return x and y
     */
    @Override
    public String toString() {
        return "x:" + x + " y:" + y;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * @return size of elements
     */
    public int size() {
        return this.elements.size();
    }
}
