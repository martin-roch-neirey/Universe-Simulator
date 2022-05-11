package ch.hefr.iscrsid.gl1.strmauroc.models;

import ch.heia.isc.gl1.simulife.interface_.ICell;
import ch.heia.isc.gl1.simulife.interface_.IElement;
import ch.heia.isc.gl1.simulife.interface_.IUniverse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 2.0
 * @date 05.04.2022
 * @brief 2D Array of cells
 */

public class Board implements IUniverse {

    private final Cell[][] cellBoard;
    private final int width;
    private final int height;

    @Getter
    private ArrayList<MobileAntenna> antennas;

    /**
     * @param width width of the board
     * @param height height of the board
     * @throws NumberFormatException exception
     * @brief Constructor of Board with Exception handler
     */
    public Board(int width, int height) throws IllegalArgumentException {

        this.width = width;
        this.height = height;
        this.antennas = new ArrayList<>();

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
     * @param element element to move
     * @param x x destination coord
     * @param y y destination coord
     * @throws NumberFormatException exception
     * @brief Move an Element to specific x and y
     */
    public void moveElement(Element element, int x, int y) throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        if (x >= this.cellBoard.length || x < 0 || y >= this.cellBoard.length || y < 0) {
            throw new ArrayIndexOutOfBoundsException("Illegal Args: x: " + x + " y: " + y);
        }

        element.getCell().removeElement(element);
        this.getICell(x,y).addElement(element);
        element.setCell(this.cellBoard[x][y]);
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
                        s.append(" " + " | ");
                        break;
                    case 1:
                        s.append("X" + " | ");
                        break;
                    default:
                        s.append("M" + " | ");
                        break;
                }

            }

        }
        s.append("\n\n");
        s.append("--------------------------------------------\n");
        s.append("|              Legend:                     |\n");
        s.append("|------------------------------------------|\n");
        s.append("|  \" \", No Element                         |\n");
        s.append("|  \"X\", One Element                        |\n");
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
        return this.width;
    }

    /**
     * Returns height of the board
     *
     * @return The height.
     */
    @Override
    public int getHeight() {
        return this.height;
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


}

