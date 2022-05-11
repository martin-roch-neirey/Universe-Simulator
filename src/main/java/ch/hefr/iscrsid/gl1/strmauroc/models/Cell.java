package ch.hefr.iscrsid.gl1.strmauroc.models;


import ch.heia.isc.gl1.simulife.interface_.ICell;
import ch.heia.isc.gl1.simulife.interface_.IElement;
import ch.heia.isc.gl1.simulife.interface_.IUniverse;
import lombok.Getter;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 2.0
 * @date 26.04.2022
 * @brief It's a cell in a universe that can contain elements
 */

public class Cell implements ICell {
    @Getter
    private final int x;

    @Getter
    private final int y;
    private final Stack<IElement> elements;

    private final IUniverse universe;

    /**
     * @param x x coord
     * @param y y coord
     * @throws NumberFormatException exception
     * @brief Constructor of Cell with Exception handler
     */

    public Cell(int x, int y, IUniverse universe) throws IllegalArgumentException {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Illegal Args: x: " + x + " y: " + y);
        }
        this.elements = new Stack<>();
        this.x = x;
        this.y = y;
        this.universe = universe;
    }

    /**
     * @param element element instance
     * @brief Add element in Cell
     */
    public void addElement(IElement element) throws ArrayStoreException {
        if (this.elements.contains(element)) {
            throw new ArrayStoreException("Element: " + element + " already exist in array");
        } else {
            this.elements.push(element);
            ((Element)element).setPosition(this.x, this.y);
        }
    }


    /**
     * @param element element instance
     * @throws ArrayStoreException exception
     * @brief remove element
     */
    public void removeElement(IElement element) throws ArrayStoreException {
        if (this.elements.contains(element)) {
            this.elements.remove(element);
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
     * This function returns the universe that this object is in.
     *
     * @return The universe.
     */
    @Override
    public IUniverse getIUniverse() {
        return this.universe;
    }

    /**
     * Returns the top element of the stack.
     *
     * @return The top element of the stack.
     */
    @Override
    public IElement getTopElement() throws EmptyStackException {
        return this.elements.peek();
    }

    /**
     * Returns the element at the specified index.
     *
     * @param i The index of the element to get.
     * @return The element at the given index.
     */
    @Override
    public IElement getElement(int i) throws ArrayIndexOutOfBoundsException {
        return elements.get(i);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int getNumberOfElements() {
        return this.elements.size();
    }
}
