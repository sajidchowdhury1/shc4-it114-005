package CR.client;

import javax.swing.JPanel;

public interface ICardControls {
    void next();

    void previous();

    void show(String cardName);

    void addPanel(String name, JPanel panel);

    void connect();

    // shc4 11/27/23 it114-005
    void export();
}
