package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.controllers.BoardController;
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
        Board myBoard = new Board(10,10);
        System.out.println("----------------Init-----------------");
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------ADD-----------------");
        MobileAntenna antenna1 = new MobileAntenna(4);
        MobileAntenna antenna2 = new MobileAntenna(4);
        MobilePhone phone = new MobilePhone(10);
        myBoard.getICell(0,0).addElement(antenna2);
        myBoard.getICell(1,1).addElement(antenna1);
        myBoard.getICell(1,2).addElement(phone);

        System.out.println(myBoard);
        BoardController.actionAll(myBoard, true);
        System.out.println(phone.getState().get("nearestAntenna"));

    }
}


// TODO LIST
// Diag séquence MobileAntenna et MobilePhone
// UC diag
// Desc files