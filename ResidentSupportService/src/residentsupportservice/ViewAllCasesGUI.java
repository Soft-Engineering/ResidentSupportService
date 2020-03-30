package residentsupportservice;




/**
 * Graphical interface for view of all cases will be shared between case worker and administrator.
 *
 * @author Dean Rimmer
 * @version 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewAllCasesGUI
{   
    public static void main(String args[]){
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - View Cases");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("View Cases");
        JButton back = new JButton("Back");
        JButton logOut = new JButton("Log Out");
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //setting action listeners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                AdminGUI newgui = new AdminGUI();
                String[] arguments = new String[] {"123"};
                newgui.main(arguments);
            } 
        });
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //setting the frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}