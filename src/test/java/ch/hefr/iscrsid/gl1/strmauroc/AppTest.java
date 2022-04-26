package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.models.Board;
import ch.hefr.iscrsid.gl1.strmauroc.models.Cell;
import ch.hefr.iscrsid.gl1.strmauroc.models.Element;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
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
        first = new Board(10,10);
        Board second = new Board(10,10);
        assertNotEquals(second, first);
    }


    @Test
    public void boardInstanceNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(-1,-1));
    }

    @Test
    public void boardInstanceWidthNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(-1,1));
    }

    @Test
    public void boardInstanceHeightNegativeTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(1,-1));
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
        Board test = new Board(10,10);
        Element element = new Element("S");
        test.getICell(2,4).addElement(element);
        assertEquals(test.getICell(2,4).getNumberOfElements(), 1);
        assertEquals(test.getICell(4,2).getNumberOfElements(), 0);
    }

    @Test
    public void boardWidthHeightSeparateTest() {
        Board test = new Board(10,20);
        assertNotEquals(test.getWidth(), test.getHeight());
    }

    @Test
    public void boardInstanceHeightMinTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Board(1, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellMaxTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void boardGetCellMinTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellXTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(Integer.MIN_VALUE, 9));
    }

    @Test
    public void boardGetCellXMaxTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(Integer.MAX_VALUE, 9));
    }

    @Test
    public void boardGetCellYTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(9, Integer.MAX_VALUE));
    }

    @Test
    public void boardGetCellYMinTest() {
        Board test = new Board(10,10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                test.getCell(9, Integer.MIN_VALUE));
    }

    @Test
    public void boardGetCellTest() {
        Board test = new Board(10,10);
        assertNotNull(test.getCell(9, 9));
    }

    @Test
    public void boardAddElementTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertEquals(myBoard.getCell(0, 0).size(), 1);
    }

    @Test
    public void boardAddElementTest2() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        Element element2 = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        myBoard.getCell(0,0).addElement(element2);
        assertEquals(myBoard.getCell(0, 0).size(), 2);
    }

    @Test
    public void boardAddElementTest3() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayStoreException.class, () ->
                myBoard.getCell(0,0).addElement(element));
    }

    @Test
    public void boardPrintTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        Element element2 = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        System.out.println(myBoard);
        myBoard.getCell(0,0).addElement(element2);
        System.out.println(myBoard);
        assertEquals(myBoard.getCell(0, 0).size(), 2);
    }

    @Test
    public void boardMoveElementTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertEquals(myBoard.getCell(0, 0).size(), 1);
        assertEquals(myBoard.getCell(2, 2).size(), 0);
        myBoard.moveElement(element, 2, 2);
        assertEquals(myBoard.getCell(0, 0).size(), 0);
        assertEquals(myBoard.getCell(2, 2).size(), 1);
    }

    @Test
    public void boardMoveElementMinTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void boardMoveElementMaxTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void boardMoveElementMaxXTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, 2));
    }

    @Test
    public void boardMoveElementMaxYTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, 2, Integer.MAX_VALUE));
    }

    @Test
    public void boardMoveElementMinYTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, 2, Integer.MIN_VALUE));
    }

    @Test
    public void boardMoveElementMinXTest() {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                myBoard.moveElement(element, Integer.MAX_VALUE, 2));
    }

    @Test
    public void boardRemoveElementTest() throws ArrayIndexOutOfBoundsException, ArrayStoreException {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertEquals(myBoard.getCell(0, 0).size(), 1);
        myBoard.getCell(0,0).removeElement(element);
        assertEquals(myBoard.getCell(0, 0).size(), 0);
    }

    @Test
    public void boardRemoveElementTest2() throws ArrayIndexOutOfBoundsException, ArrayStoreException, NullPointerException {
        Board myBoard = new Board(10,10);
        Element element = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        assertThrows(ArrayStoreException.class, () -> {
            myBoard.getCell(0,0).removeElement(element);
            myBoard.getCell(0,0).removeElement(element);
        });
    }

    @Test
    public void boardTest() {
        Board myBoard = new Board(10,10);
        assertNotNull(myBoard);
    }

    @Test
    public void cellTest() {
        Cell newCell = new Cell(0, 0);
        assertNotNull(newCell);
    }

    @Test
    public void cellArrayStoreExceptionTest() {
        Cell cell = new Cell(0, 0);
        Element element = new Element("S");
        assertThrows(ArrayStoreException.class, () -> {
            cell.addElement(element);
            cell.addElement(element);
        });
    }

    @Test
    public void cellInstanceMAXTest() {
        Cell cell = new Cell(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMINTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Cell(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void cellInstanceMAXYTest() {
        Cell cell = new Cell(2, Integer.MAX_VALUE);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMAXXTest() {
        Cell cell = new Cell(Integer.MAX_VALUE, 2);
        assertNotNull(cell);
    }

    @Test
    public void cellInstanceMINYTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Cell(2, Integer.MIN_VALUE));
    }

    @Test
    public void cellInstanceMINXTest() {
        assertThrows(IllegalArgumentException.class, () ->
                new Cell(Integer.MIN_VALUE, 2));
    }

    @Test
    public void cellGetX() {
        Cell cell = new Cell(2, 2);
        assertTrue(cell.getX() >= 0);
    }

    @Test
    public void cellGetY() {
        Cell cell = new Cell(2, 2);
        assertTrue(cell.getY() >= 0);
    }

    @Test
    public void elementTest() {
        Element element = new Element("S");
        assertNotNull(element);
    }

    @Test
    public void elementGetCellTest() {
        Cell cell = new Cell(2, 1);
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
