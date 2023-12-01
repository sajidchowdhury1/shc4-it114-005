package CR.client.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import CR.client.ClientUtils;
import CR.client.ICardControls;

// shc4 11/30/23 it114-005
// imports for a list
import java.util.List;
import java.util.ArrayList;

public class UserListPanel extends JPanel {
    JPanel userListArea;
    private static Logger logger = Logger.getLogger(UserListPanel.class.getName());

    // shc4 11/30/23 it114-005
    private List<String> userListofPeople = new ArrayList<String>();

    public UserListPanel(ICardControls controls) {
        super(new BorderLayout(10, 10));
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        // wraps a viewport to provide scroll capabilities
        JScrollPane scroll = new JScrollPane(content);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        // scroll.setBorder(BorderFactory.createEmptyBorder());
        // no need to add content specifically because scroll wraps it

        userListArea = content;

        wrapper.add(scroll);
        this.add(wrapper, BorderLayout.CENTER);

        userListArea.addContainerListener(new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (userListArea.isVisible()) {
                    userListArea.revalidate();
                    userListArea.repaint();
                }
            }

        });
    }

    protected void addUserListItem(long clientId, String clientName) {
        // shc4 11/30/23 it114-005
        // this is to add in list of connected people
        collectingData(clientId, clientName);
        logger.log(Level.INFO, "Adding user to list: " + clientName);
        JPanel content = userListArea;
        logger.log(Level.INFO, "Userlist: " + content.getSize());
        // shc4 11/29/23 it114-005
        // this formats usernames when they have html tags
        // shc4 11/30/23 it114-005
        // had support from Danny
        boolean mute = checkMute(clientName);
        if(mute){
            clientName = clientName.substring(1);
            clientName = "<b><font color=#808080>" + clientName + "</font></b>";
        }
        JEditorPane textContainer = new JEditorPane("text/html", clientName);
        textContainer.setName(clientId + "");
        // sizes the panel to attempt to take up the width of the container
        // and expand in height based on word wrapping
        textContainer.setLayout(null);
        textContainer.setPreferredSize(
                new Dimension(content.getWidth(), ClientUtils.calcHeightForText(this, clientName, content.getWidth())));
        textContainer.setMaximumSize(textContainer.getPreferredSize());
        textContainer.setEditable(false);
        // remove background and border (comment these out to see what it looks like
        // otherwise)
        ClientUtils.clearBackground(textContainer);
        // add to container
        content.add(textContainer);
    }

    protected void removeUserListItem(long clientId) {
        logger.log(Level.INFO, "removing user list item for id " + clientId);
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            if (c.getName().equals(clientId + "")) {
                userListArea.remove(c);
                break;
            }
        }
    }

    protected void clearUserList() {
        Component[] cs = userListArea.getComponents();
        for (Component c : cs) {
            userListArea.remove(c);
        }
    }

    // shc4 
    // this method is used to add those users into the list above
    private void collectingData(Long id,String name){
        String arrayFormat = name + ":" + id;
        if(!userListofPeople.contains(arrayFormat)){
            userListofPeople.add(arrayFormat);
        }
    }
    // removes from list if someone disconnects or goes to another room
    protected void removeFromList(Long id){
        for(String i: userListofPeople){
            if(i.contains(("" + id).trim())){
                userListofPeople.remove(i);
            }
        }
    }

    // shc4 11/30/23 it114-005
    // new method to check the contents of the component which is the clients
    protected void updateUserList(List<String> muteList){
        clearUserList();
        for(String i: userListofPeople){
            String clientName = i.split(":")[0].trim();
            Long clientId = Long.parseLong(i.split(":")[1]);
            for(String x: muteList){
                if(x.equalsIgnoreCase(clientName)){
                    clientName = "~" + clientName;
                }
            }
            addUserListItem(clientId, clientName);
        }
    }

    // had support from Danny
    private boolean checkMute(String name){
        if(name.contains("~")){
            return true;
        }
        return false;
    }

}