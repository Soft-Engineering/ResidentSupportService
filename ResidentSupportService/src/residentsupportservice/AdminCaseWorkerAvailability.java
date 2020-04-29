/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kyler
 */
public class AdminCaseWorkerAvailability {
    public static void main(String args[]){
    ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]);
        DatabaseFunctions dbFunctions = new DatabaseFunctions();
        
        

//Frame generation
        JFrame frame = new JFrame("Case worker availability");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JComboBox cwNames = new JComboBox();
        ArrayList<String> caseWorkerNames = dbFunctions.getAllCaseWorkers();
        for(int i = 0; i<caseWorkerNames.size();i++){
            cwNames.addItem(caseWorkerNames.get(i));
        }
        
        JButton seeAvailability = new JButton("See availability");
        JComboBox dateBox = new JComboBox();
        JButton remove = new JButton("Remove date");
        remove.setEnabled(false);
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
        
        cwNames.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               dateBox.removeAllItems();
               remove.setEnabled(false);
            }
        });

        seeAvailability.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dateBox.setEnabled(true);
                remove.setEnabled(true);
                int id = dbFunctions.findCaseWorker(cwNames.getSelectedItem().toString());
                ArrayList<String> dates = dbFunctions.seeAvailability(id);
                for(int i = 0; i<dates.size();i++){
                    dateBox.addItem(dates.get(i));
                }
            }
        });

        remove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            boolean querySuccess = dbFunctions.removeAvailability(dateBox.getSelectedItem().toString());
            if(querySuccess){
                JOptionPane.showMessageDialog(frame, "Date removed.");
            }
            else{
                JOptionPane.showMessageDialog(frame, "Failed to remove");
            }
            dateBox.removeAllItems();
            remove.setEnabled(false);
        }
    });
        
	logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                LoginGUI loginScreen = new LoginGUI();
                String[] arguments = new String[] {"123"};
                loginScreen.main(arguments);
            } 
        });

        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                AdminGUI newgui = new AdminGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            } 
        });
        
        
        //combo box contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(cwNames, gbc);
        
        //combo box contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(seeAvailability, gbc);


        //combo box contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(remove, gbc);

        //combo box contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 31;
        gbc.ipadx = 150;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(dateBox, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //setting the frame
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        p = ip.getPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}
