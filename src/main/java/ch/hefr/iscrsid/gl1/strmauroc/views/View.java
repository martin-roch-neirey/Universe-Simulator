package ch.hefr.iscrsid.gl1.strmauroc.views;

import ch.hefr.iscrsid.gl1.strmauroc.models.Board;
import ch.heia.isc.gl1.simulife.interface_.AbstractView;

public class View extends AbstractView {

    private Board board;
    private boolean visible;

    @Override
    public void refresh() {
        this.board.actionAll();
    }

    @Override
    public void setVisible(boolean b) {
        this.visible = b;
    }
}
