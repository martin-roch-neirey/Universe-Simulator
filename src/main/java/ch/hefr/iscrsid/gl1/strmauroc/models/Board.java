package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 2.0
 * @date 05.04.2022
 * @brief 2D Array of cells
 */

public class Board implements IControllableUniverse {

    private final Cell[][] cellBoard;

    /**
     * @param width width of the board
     * @param height height of the board
     * @throws NumberFormatException exception
     * @brief Constructor of Board with Exception handler
     */
    public Board(int width, int height) throws IllegalArgumentException {

        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative size. Width was: " + width + " Height was: " + height);
        }
        this.cellBoard = new Cell[width][height];

        for (int y = 0; y < (height); y++) {
            for (int x = 0; x < (width); x++) {
                Cell newCell = new Cell(x, y, this);
                this.cellBoard[x][y] = newCell;
            }
        }

    }

    /**
     * @param element element in the cell
     * @return ICell of the specified element. Result can be null
     */
    private Cell getCellOfIElement(IElement element) {
        for (int i = 0 ; i < this.cellBoard.length ; i++) {
            for (int j = 0 ; j < this.cellBoard[0].length ; j++) {
                for (int k = 0 ; k < this.cellBoard[i][j].getNumberOfElements() ; k++) {
                    if (this.cellBoard[i][j].getElement(k) == element) {
                        return this.getICell(i, j);
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param element element to move
     * @param x x destination coord
     * @param y y destination coord
     * @throws NumberFormatException exception
     * @brief Move an Element to specific x and y
     */
    public void moveElement(IPositionnableElement element, int x, int y) throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        if (x >= this.cellBoard.length || x < 0 || y >= this.cellBoard.length || y < 0) {
            throw new ArrayIndexOutOfBoundsException("Illegal Args: x: " + x + " y: " + y);
        }

        if (this.getAllElements().contains(element)) {
            this.removeElement(element);
            this.addElement(element, x, y);
        }

    }

    /**
     * Override toString() for formatting board
     * " ", No Element
     * "X", One Element
     * "M", Multiple Elements
     *
     * @return Formatted String. Displayed board may defer on different computer screens
     * @throws NullPointerException exception
     */
    @Override
    public String toString() throws NullPointerException {
        StringBuilder s = new StringBuilder();
        for (int y = 0; y < getHeight(); y++) {
            s.append("\n| ");
            for (int x = 0; x < getWidth(); x++) {
                switch (getICell(x, y).getNumberOfElements()) {
                    case 0:
                        s.append("  | ");
                        break;
                    case 1:
                        s.append(getICell(x, y).getTopElement().getCode()).append(" | ");
                        break;
                    default:
                        s.append("M | ");
                        break;
                }

            }

        }
        s.append("\n\n");
        s.append("--------------------------------------------\n");
        s.append("|              Legend:                     |\n");
        s.append("|------------------------------------------|\n");
        s.append("|  \" \", No Element                         |\n");
        s.append("|  \"A\", One Mobile Antenna                 |\n");
        s.append("|  \"T\", One Mobile Phone                   |\n");
        s.append("|  \"M\", Multiple Elements                  |\n");
        s.append("--------------------------------------------\n");
        return s.toString();
    }

    /**
     * Returns width of the board
     *
     * @return The width.
     */
    @Override
    public int getWidth() {
        return this.cellBoard.length;
    }

    /**
     * Returns height of the board
     *
     * @return The height.
     */
    @Override
    public int getHeight() {
        return this.cellBoard[0].length;
    }

    /**
     * @param width width coord
     * @param height height coord
     * @return Cell if existing
     * @throws NumberFormatException exception
     * @brief Return Cell in specific x and y
     */
    @Override
    public Cell getICell(int width, int height) throws ArrayIndexOutOfBoundsException {
        return this.cellBoard[width][height];
    }

    /**
     * Helper method
     * Returns an ArrayList of all the cells in the board
     *
     * @return An ArrayList of all the cells.
     */
    private ArrayList<Cell> getAllCells() {
        ArrayList<Cell> arrayList = new ArrayList<>();
        for (Cell[] cells : this.cellBoard) {
            arrayList.addAll(Arrays.asList(cells));
        }
        return arrayList;
    }


    /**
     * Helper method
     * Returns an ArrayList of all the elements in each cell, so all elements in the board
     *
     * @return An ArrayList of all the elements.
     */
    public ArrayList<IElement> getAllElements() {
        ArrayList<IElement> arrayList = new ArrayList<>();
        for (Cell cell : this.getAllCells()) {
            for (int i = 0; i < cell.getNumberOfElements(); i++) {
                arrayList.add(cell.getElement(i));
            }
        }
        return arrayList;
    }


    /**
     * @param iElement element to add
     * @param i x coordinate
     * @param i1 y coordinate
     * @brief add a positionnable element on the board to specified coordinates
     */
    @Override
    public void addElement(IPositionnableElement iElement, int i, int i1) throws ArrayIndexOutOfBoundsException {
        this.getICell(i, i1).addElement(iElement);
    }

    /**
     * @param iElement element to remove
     * @brief remove a positionnable element from the board
     */
    @Override
    public void removeElement(IPositionnableElement iElement) throws IllegalArgumentException {
        this.getCellOfIElement(iElement).removeElement(iElement);
    }

    /**
     * Enumerates the IElements contained in the universe given as parameter
     * and calls the consumer function with each enumerated element as parameter.
     * @param universe the universe
     * @param action the action
     */
    static void forEachElementOfUniverse(IUniverse universe, Consumer<IElement> action) {
        for (int i = 0 ; i < universe.getWidth() ; i++) {
            for (int j = 0 ; j < universe.getHeight() ; j++) {
                for (int k = 0 ; k < universe.getICell(i,j).getNumberOfElements() ; k++) {
                    action.accept(universe.getICell(i,j).getElement(k));
                }
            }
        }
    }
}

