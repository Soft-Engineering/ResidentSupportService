package residentsupportservice;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.*;


/**
 * Creates a panel which takes information about a user who is logged in and adds it to a panel which is to be passed to by GUI classes.
 * @author Dean
 * @version 1.2
 */
public class infoPanel extends JPanel {
    private JLabel lblID;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    public static JPanel infopanel;

    /**
     * Constryctor for the infoPanel Class
     * @param id
     * @param firstName
     * @param lastName 
     */
    public infoPanel(String id, String firstName, String lastName) {
        //Sets panel constants
        User user = DatabaseFunctions.loggedInUser;
        JPanel addPanel = new JPanel();
        addPanel.setBackground (Color.gray);
        addPanel.setPreferredSize(new Dimension(25,25));
        //Dynamicallt sets the value of JLabels.
        if(firstName != null) {
            lblID = new JLabel("error true");
            lblFirstName = new JLabel("error true");
            lblLastName = new JLabel("error true");
            lblID.setText(id);
            lblFirstName.setText(firstName);
            lblLastName.setText(lastName);
        } else {
            JLabel lblID = new JLabel("error");
            JLabel lblFirstName = new JLabel("error");
            JLabel lblLastName = new JLabel("error");
        }
        //Sets the panel
        addPanel.setSize(100, 50);
        addPanel.add(lblID, BorderLayout.PAGE_END);
        addPanel.add(lblFirstName, BorderLayout.PAGE_END);
        addPanel.add(lblLastName, BorderLayout.PAGE_END);
        infopanel = new JPanel();
        infopanel = addPanel;
    }
    
    /**
     * Returns the panel set by the constructor.
     * @return 
     */
    public JPanel getPanel(){
        return infopanel;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}