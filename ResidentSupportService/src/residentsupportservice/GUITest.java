/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author kyler
 */
public class GUITest {
    public static void main(String args[]){
//        ArrayList<String> localArguments = new ArrayList<String>();
//        localArguments.add(args[0]);
//        localArguments.add(args[1]);
//        localArguments.add(args[2]); 
        //Frame generation
        JFrame frame = new JFrame("My availability");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JComboBox availability = new JComboBox();
        JButton logOut = new JButton("Log out");
        JButton back = new JButton ("Back");
        
        
        
        //Setting panel layout
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //Setting panel layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        // set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //setting action listeners for buttons
//        logOut.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//            } 
//        });
//        back.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                AdminGUI newgui = new AdminGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                newgui.main(arguments);
//            } 
//        });
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 20;
        gbc.ipadx = 150;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(availability, gbc);

        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //setting the frame
        JPanel p = new JPanel();
        //infoPanel ip = new infoPanel(args[0], args[1], args[2]);
       // p = ip.getPanel();
        //frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
