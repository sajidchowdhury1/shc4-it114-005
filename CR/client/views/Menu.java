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
        // shc4 12/6/23 it114-005
        // to do flip
        JMenu command = new JMenu("Command");
        JMenuItem commandFlip = new JMenuItem("Flip");
        commandFlip.addActionListener((event) -> {
            controls.flip();
        });
        command.add(commandFlip);

        // to do roll 2d6
        JMenuItem commandRollD = new JMenuItem("Roll 2d6");
        commandRollD.addActionListener((event) -> {
            controls.rollD();
        });
        command.add(commandRollD);

        // to do roll 6
        JMenuItem commandRoll = new JMenuItem("Roll 6");
        commandRoll.addActionListener((event) -> {
            controls.roll();
        });
        command.add(commandRoll);
        this.add(command);

        // shc4 12/6/23 it114-005
        /*JMenu Tools = new JMenu("Instruction");
        JMenuItem info = new JMenuItem("INFO");
        info.addActionListener((event) -> {
            controls.infoUser();
        });
        Tools.add(info);
        this.add(Tools);*/
    }
}