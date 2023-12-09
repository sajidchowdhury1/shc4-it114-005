package CR.client;

import javax.swing.JPanel;

public interface ICardControls {
    void next();

    void previous();

    void show(String cardName);

    void addPanel(String name, JPanel panel);

    void connect();

    // shc4 11/27/23 it114-005
    // for export chat history
    void export();

    // shc4 12/6/23 it114-005
    // for flip commend
    void flip();

    // shc4 12/6/23 it114-005
    // for roll 2d6
    void rollD();

    // shc4 12/6/23 it114-005
    // for roll 2d6
    void roll();

    //void infoUser();
}
