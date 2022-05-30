package ch.hefr.iscrsid.gl1.strmauroc;

import ch.hefr.iscrsid.gl1.strmauroc.controllers.IUniverseController;
import ch.hefr.iscrsid.gl1.strmauroc.models.*;
import ch.heia.isc.gl1.simulife.interface_.IControllableUniverse;

import java.util.concurrent.TimeUnit;

/**
 * @author Philipp Streit <philipp.streit@edu.hefr.ch>
 * @author Maumary Quentin <quentin.maumary@edu.hefr.ch>
 * @author Roch-Neirey Martin <martin.roch-neirey@edu.hefr.ch>
 * @version 1.0
 * @date 05.04.2022
 * @brief One demo of the app
 */

public abstract class App {
    public static void main(String[] args) throws InterruptedException {
        Board myBoard = new Board(10,10);
        System.out.println("----------------INIT-----------------");
        System.out.println(myBoard);
        System.out.println();
        System.out.println("-----------------ADD-----------------");
        MobileAntenna antenna1 = new MobileAntenna(myBoard, 4);
        MobileAntenna antenna2 = new MobileAntenna(myBoard, 4);
        MobilePhone phone = new MobilePhone(myBoard, 10);
        MobilePhone phone2 = new MobilePhone(myBoard, 10);
        myBoard.addElement(antenna1, 7, 9);
        myBoard.addElement(phone, 4, 1);
        myBoard.addElement(phone2, 6, 7);
        myBoard.addElement(antenna2, 2, 3);

        System.out.println(myBoard);

        System.out.println("-----------------START-----------------");


        for (int i = 0; i < 2; i++) {
            System.out.println("time unit = " + i);
            IUniverseController.actionAll(myBoard);
            System.out.println(myBoard);
            // System.out.println(phone.getState());
            System.out.println("antenna1= "+antenna1.getState());
            // System.out.println("antenna2= "+antenna2.getState());
            System.out.println("phone= " + phone.getState());
            TimeUnit.SECONDS.sleep(4);
        }

    }
}
