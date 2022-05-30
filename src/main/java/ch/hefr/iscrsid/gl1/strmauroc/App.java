package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.controllers.IUniverseController;
import ch.hefr.iscrsid.gl1.strmauroc.models.*;
import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;


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
        System.out.println("----------------INIT-----------------");
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------ADD-----------------");
        MobileAntenna antenna1 = new MobileAntenna(myBoard, 4);
        MobileAntenna antenna2 = new MobileAntenna(myBoard, 4);
        IControllableUniverse icUni = myBoard;
        MobilePhone phone = new MobilePhone(icUni, 10);
        icUni.addElement(phone, 1, 4);
        icUni.addElement(antenna2, 0, 0);
        icUni.addElement(antenna1, 1, 1);

        System.out.println(myBoard);

        System.out.println("----------------MOVE-----------------");

        System.out.println(myBoard);
        IUniverseController.actionAll(myBoard);

        System.out.println("----------------DELETE-----------------");
        icUni.removeElement(phone);
        System.out.println(phone.getXLoc() + " " + phone.getYLoc());

        System.out.println(myBoard);

    }
}


// TODO LIST
// Diag séquence MobileAntenna et MobilePhone
// UC diag
// Desc files