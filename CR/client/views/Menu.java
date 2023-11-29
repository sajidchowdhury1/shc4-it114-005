package CR.client.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import CR.client.Card;
import CR.client.ICardControls;

public class Menu extends JMenuBar {
    public Menu(ICardControls controls) {
        JMenu roomsMenu = new JMenu("Rooms");
        JMenuItem roomsSearch = new JMenuItem("Search");
        roomsSearch.addActionListener((event) -> {
            controls.show(Card.ROOMS.name());
        });
        roomsMenu.add(roomsSearch);
        // shc4 11/27/23 it114-005
        // this is for the export button
        JMenuItem export = new JMenuItem("Export");
        export.addActionListener((event) -> {
            controls.export();
        });
        roomsMenu.add(export);
        this.add(roomsMenu);
    }
}