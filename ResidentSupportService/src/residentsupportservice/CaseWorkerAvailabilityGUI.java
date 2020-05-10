package residentsupportservice;




/**
 * Graphical interface for case workers to specify their availability.
 *
 * @author Dean Rimmer
 * @version 1.4
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class CaseWorkerAvailabilityGUI
{   
    public static void main(String args[]){
        //Casts local arguments from args[] to local ArrayList for ease of use.
        DatabaseFunctions dbFunctions = new DatabaseFunctions();
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]);
        
        //Get the ID of the logged in user.
        int ID = Integer.parseInt(localArguments.get(0));
        
        //Frame generation
        JFrame frame = new JFrame("My availability");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JComboBox dateBox = new JComboBox();
        //Populate combobox with date values.
        ArrayList<String> dates = dbFunctions.seeAvailability(ID);
        for(int i = 0; i < dates.size(); i++ ){
            dateBox.addItem(dates.get(i));
        }
        JButton remove = new JButton("Remove date");
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

        //Set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //Setting action listeners for buttons
        remove.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean querySuccess = dbFunctions.removeAvailability(dateBox.getSelectedItem().toString());
                if(querySuccess){
                    JOptionPane.showMessageDialog(frame, "Date removed.");
                }else{
                    JOptionPane.showMessageDialog(frame, "Failed to remove");
                }
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
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(remove, gbc);

        //combo box contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 31;
        gbc.ipadx = 150;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(dateBox, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(logOut, gbc);
        
        //Creating the personalised information frame for the user at the bottom of the page.
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        p = ip.getPanel();
        
        //Add both panels to the frame, one for main gui of the frame and the other for the personalised user information panel at the bottom of the page.
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}