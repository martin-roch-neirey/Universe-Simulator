package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.models.Board;
import ch.hefr.iscrsid.gl1.strmauroc.models.Cell;
import ch.hefr.iscrsid.gl1.strmauroc.models.Element;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 2.0
 * @date 26.04.2022
 */

public class AppTest {

    /**
     * This test should always pass
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void boardInstanceTest() {
        Board first;
        first = new Board(10, 10);
        Board second = new Board(10, 10);
        assertNotEquals(second, first);
    }


    @Test
    public void boardInstanceNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(-1, -1));
    }

    @Test
    public void boardInstanceWidthNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(-1, 1));
    }

    @Test
    public void boardInstanceHeightNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(1, -1));
    }

    @Test
    public void boardInstanceMinTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void boardInstanceWidthMinTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(Integer.MIN_VALUE, 1));
    }

    @Test
    public void boardWidthHeightNotInvertedTest() {
        Board test = new Board(10, 10);
        Element element = new Element("S");
        test.getICell(2, 4).addElement(element);
        assertEquals(test.getICell(2, 4).getNumberOfElements(), 1);
        assertEquals(test.getICell(4, 2).getNumberOfElements(), 0);
    }

    @Test
    public void boardWidthHeightSeparateTest() {
        Board test = new Board(10, 20);
        assertNotEquals(test.getWidth(), test.getHeight());
    }

    @Test
    public void boardInstanceHeightMinTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(1, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellMaxTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void boardGetCellMinTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellXTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(Integer.MIN_VALUE, 9));
    }

    @Test
    public void boardGetCellXMaxTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(Integer.MAX_VALUE, 9));
    }

    @Test
    public void boardGetCellYTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(9, Integer.MAX_VALUE));
    }

    @Test
    public void boardGetCellYMinTest() {
        Board test = new Board(10, 10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getICell(9, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellTest() {
        Board test = new Board(10, 10);
        assertNotNull(test.getICell(9, 9));
    }

    @Test
    public void boardAddElementTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 1);
    }

    @Test
    public void boardAddElementTest2() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        Element element2 = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        myBoard.getICell(0, 0).addElement(element2);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 2);
    }

    @Test
    public void boardAddElementTest3() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayStoreException.class, () ->
                myBoard.getICell(0, 0).addElement(element));
    }

    @Test
    public void boardPrintTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        Element element2 = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        System.out.println(myBoard);
        myBoard.getICell(0, 0).addElement(element2);
        System.out.println(myBoard);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 2);
    }

    @Test
    public void boardMoveElementTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 1);
        assertEquals(myBoard.getICell(2, 2).getNumberOfElements(), 0);
        myBoard.moveElement(element, 2, 2);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 0);
        assertEquals(myBoard.getICell(2, 2).getNumberOfElements(), 1);
    }

    @Test
    public void boardMoveElementMinTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void boardMoveElementMaxTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void boardMoveElementMaxXTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, 2));
    }

    @Test
    public void boardMoveElementMaxYTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, 2, Integer.MAX_VALUE));
    }

    @Test
    public void boardMoveElementMinYTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, 2, Integer.MIN_VALUE));
    }

    @Test
    public void boardMoveElementMinXTest() {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, 2));
    }

    @Test
    public void boardRemoveElementTest() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 1);
        myBoard.getICell(0, 0).removeElement(element);
        assertEquals(myBoard.getICell(0, 0).getNumberOfElements(), 0);
    }

    @Test
    public void boardRemoveElementTest2() throws
            ArrayIndexOutOfBoundsException, ArrayStoreException, NullPointerException {
        Board myBoard = new Board(10, 10);
        Element element = new Element("S");
        myBoard.getICell(0, 0).addElement(element);
        assertThrows(ArrayStoreException.class, () -> {
            myBoard.getICell(0, 0).removeElement(element);
            myBoard.getICell(0, 0).removeElement(element);
        });
    }

    @Test
    public void boardTest() {
        Board myBoard = new Board(10, 10);
        assertNotNull(myBoard);
    }

    @Test
    public void cellTest() {
        Board board = new Board(2, 2);
        Cell newCell = new Cell(0, 0, board);
        assertNotNull(newCell);
    }

    @Test
    public void cellGetIUniverse() {
        Board board = new Board(2, 2);
        Cell newCell = new Cell(0, 0, board);
        assertEquals(newCell.getIUniverse(), board);
    }

    @Test
    public void cellGetTopElement() {
        Board board = new Board(2, 2);
        Cell newCell = new Cell(0, 0, board);
        assertThrows(EmptyStackException.class, newCell::getTopElement);
        Element element = new Element("S");
        newCell.addElement(element);
        assertEquals(newCell.getTopElement(), element);

        Element element2 = new Element("T");
        newCell.addElement(element2);
        assertEquals(newCell.getTopElement(), element2);

        newCell.removeElement(element2);
        assertEquals(newCell.getTopElement(), element);

        newCell.removeElement(element);
        assertThrows(EmptyStackException.class, newCell::getTopElement);
    }

    @Test
    public void cellGetElementWithIndex() {
        Board board = new Board(2, 2);
        Cell newCell = new Cell(0, 0, board);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            newCell.getElement(0);
        });

        Element element = new Element("S");
        newCell.addElement(element);
        assertEquals(newCell.getElement(0), element);

        Element element2 = new Element("T");
        newCell.addElement(element2);
        assertEquals(newCell.getElement(0), element);
        assertEquals(newCell.getElement(1), element2);

        newCell.removeElement(element);
        assertEquals(newCell.getElement(0), element2);
    }

    @Test
    public void cellArrayStoreExceptionTest() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(0, 0, board);
        Element element = new Element("S");
        assertThrows(ArrayStoreException.class, () -> {
            cell.addElement(element);
            cell.addElement(element);
        });
    }

    @Test
    public void cellInstanceMAXTest() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(Integer.MAX_VALUE, Integer.MAX_VALUE, board);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMINTest() {
        Board board = new Board(2, 2);
        assertThrows(IllegalArgumentException.class, () ->

                new Cell(Integer.MIN_VALUE, Integer.MIN_VALUE, board));
    }

    @Test
    public void cellInstanceMAXYTest() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(2, Integer.MAX_VALUE, board);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMAXXTest() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(Integer.MAX_VALUE, 2, board);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMINYTest() {
        Board board = new Board(2, 2);
        assertThrows(IllegalArgumentException.class, () ->
                new Cell(2, Integer.MIN_VALUE, board));
    }

    @Test
    public void cellInstanceMINXTest() {
        Board board = new Board(2, 2);
        assertThrows(IllegalArgumentException.class, () ->
                new Cell(Integer.MIN_VALUE, 2, board));
    }

    @Test
    public void cellGetX() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(2, 2, board);
        assertTrue(cell.getX() >= 0);
    }

    @Test
    public void cellGetY() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(2, 2, board);
        assertTrue(cell.getY() >= 0);
    }

    @Test
    public void elementTest() {
        Element element = new Element("S");
        assertNotNull(element);
    }

    @Test
    public void elementGetCellTest() {
        Board board = new Board(2, 2);
        Cell cell = new Cell(2, 1, board);
        Element element = new Element("t");
        assertNull(element.getCell());
        cell.addElement(element);
        assertEquals(element.getCell(), cell);
    }

    @Test
    public void appTest() {
        // no parameter needed
        App.main(null);
        try {
            Class<App> clazz = App.class;
            int mod = clazz.getModifiers();
            assertTrue(Modifier.isAbstract(mod) && !Modifier.isInterface(mod));
        } catch (Exception ex) {
            fail();
        }


    }


}
