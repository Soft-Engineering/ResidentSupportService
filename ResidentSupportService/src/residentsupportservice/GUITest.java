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
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Admin home");
        JButton openNewCase = new JButton("Open New Case");
        JButton closeCase = new JButton("Close Case");
        JButton viewCases = new JButton("View All Cases");
        JButton outstandingAppointments = new JButton("Outstanding Appointments");
        JButton back = new JButton("Back");
        JButton cwAvailability = new JButton("Case Worker Availability");
        JButton logOut = new JButton ("Log out");
        
        //Setting panel layout
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        // set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 750));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        //setting action listeners for buttons
//        logOut.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                LoginGUI loginScreen = new LoginGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                loginScreen.main(arguments);
//                frame.dispose();
//            } 
//        });
//        back.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                LoginGUI newgui = new LoginGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                newgui.main(arguments);
//            } 
//        });
//        openNewCase.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                OpenNewCaseGUI newgui = new OpenNewCaseGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                newgui.main(arguments);
//            } 
//        });
//        closeCase.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                CloseCaseGUI newgui = new CloseCaseGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                newgui.main(arguments);
//            } 
//        });
//        viewCases.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                ViewAllCasesGUI newgui = new ViewAllCasesGUI();
//                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
//                newgui.main(arguments);
//            } 
//        });
//        outstandingAppointments.addActionListener(new ActionListener() { 
//            public void actionPerformed(ActionEvent e) { 
//                frame.dispose();
//                OutstandingAppointments newgui = new OutstandingAppointments();
//                newgui.createFrame(localArguments.get(0), localArguments.get(1), localArguments.get(2));
//            } 
//        });
        
        
        //adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //open case constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(25,0,0,0);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(openNewCase, gbc);
        
        //close case constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;      
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(closeCase, gbc);
        
        //view cases constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(viewCases, gbc);
        
        //outstanding appointments contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(outstandingAppointments, gbc);
        
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
        panel.add(cwAvailability, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //setting the frame
        JPanel p = new JPanel();
        //infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        //p = ip.getPanel();

        //frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
    
}
