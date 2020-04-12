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

    public void setIDlbl(int ID) {
        this.ID = ID;
    }

    public String getFirstNamelbl() {
        return firstName;
    }

    public void setFirstNamelbl(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNamelbl() {
        return lastName;
    }

    public void setlastNamelbl(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}