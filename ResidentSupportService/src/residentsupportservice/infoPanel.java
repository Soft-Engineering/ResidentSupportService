package residentsupportservice;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class infoPanel extends JPanel {
    public int ID;
    public JLabel lblID;
    public String firstName;
    public JLabel lblFirstName;
    public String lastName;
    public JLabel lblLastName;

    public infoPanel() {

    setVisible(true);
    setBounds(new Rectangle(200, 200, 600, 400));
    
    JPanel addPanel = new JPanel();
        addPanel.setBackground (Color.red);
        addPanel.setPreferredSize(new Dimension(200,200));
        if(firstName != null) {
            JLabel lblID = new JLabel("error true");
            JLabel lblFirstName = new JLabel("error true");
            JLabel lblLastName = new JLabel("error true");
            lblID.setText(getIDlbl());
            lblFirstName.setText(getFirstNamelbl());
            lblLastName.setText(getLastNamelbl());

        } else if {
            JLabel lblID = new JLabel("error");
            JLabel lblFirstName = new JLabel("error");
            JLabel lblLastName = new JLabel("error");
        }
    }

    public int getIDlbl() {
        return ID;
    }

    public int setIDlbl(String ID) {
        this.ID = ID;
    }

    public int getFirstNamelbl() {
        return firstName;
    }

    public int setFirstNamelbl(String firstName) {
        this.firstName = firstName;
    }

    public int getLastNamelbl() {
        return lastName;
    }

    public int setlastNamelbl(String lastName) {
        this.firstName = lastName;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}