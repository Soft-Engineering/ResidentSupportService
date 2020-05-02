package residentsupportservice;




/**
 * Graphical interface for the follow up appointment for a specific case, only to be used by case workers.
 *
 * @author Dean Rimmer
 * @version 1.1
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateFollowUpGUI implements ActionListener
{   
    public static void main(String args[]) {
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]); 
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - Follow-up Appointment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Follow-up Appointment");
        JLabel caseIDLabel = new JLabel("Case ID:");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel dobLabel = new JLabel("D.O.B:");
        JTextField caseID = new JTextField(20);
        JTextField firstName = new JTextField(20);
        JTextField lastName = new JTextField(20);
        JTextField dob = new JTextField(20);
        JButton submit = new JButton("Submit");
        JLabel or = new JLabel("OR");
        JButton back = new JButton("Back");
        JButton logOut = new JButton("Log Out");
        
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
        
        //Action listsners for buttons
        logOut.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        back.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
                CaseWorkerGUI newgui = new CaseWorkerGUI();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2)};
                newgui.main(arguments);
            } 
        });
        submit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if(firstName.getText().equals("")){
                    
                    DatabaseFunctions db = new DatabaseFunctions();
                    db.createFollowUpWithID(caseID.getText());
                }else
                if(caseID.getText().equals("")){
                    DatabaseFunctions db = new DatabaseFunctions();
                    db.createFollowUpWithoutID(firstName.getText(), lastName.getText(), dob.getText());
                    
                }                
            } 
        });
        
        //adding items to panel
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //case ID constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(caseIDLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(caseID, gbc);
        
        //or constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(or, gbc);
        
        //first name constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(firstNameLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(firstName, gbc);
        
        //last name constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(lastNameLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(lastName, gbc);
        
        //dob contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(dobLabel, gbc);
        gbc.insets = new Insets(35,20,0,20);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(dob, gbc);
        
        //submit button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,0,20);
        panel.add(submit, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.ipady = 20;
        gbc.ipadx = 20;
        gbc.insets = new Insets(35,20,20,20);
        panel.add(logOut, gbc);
        
        //setting the frame
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        p = ip.getPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}