package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.models.*;


/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief One demo of the app
 */

public abstract class App {
    public static void main(String[] args) {
        Board myBoard = new Board(10);
        System.out.println("----------------Init-----------------");
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------ADD-----------------");
        Element element = new Element("S");
        Element element2 = new Element("S");
        myBoard.getCell(0,0).addElement(element);
        myBoard.getCell(5,5).addElement(element2);
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------MOVE----------------");
        myBoard.moveElement(element, 6,6);
        myBoard.moveElement(element2, 4,4);
        System.out.println(myBoard);



    }
}
