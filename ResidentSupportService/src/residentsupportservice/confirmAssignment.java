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
import java.util.ArrayList;
public class confirmAssignment
{   
    public static void main(String args[]){
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]); 
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - View Cases");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600,600);
        
        //Component Generation
        JLabel title = new JLabel("Assign Case Worker");
        JButton cancel = new JButton("Cancel");
        JButton confirm = new JButton("Confirm");
        JLabel id = new JLabel(args[3]);
        JLabel fname = new JLabel(args[4]);
        JLabel lname = new JLabel(args[5]);
        JLabel date = new JLabel(args[6]);
        
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
        frame.setPreferredSize(new Dimension(500, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //setting action listeners for buttons
        confirm.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                ConfirmAssignmentExecute cf = new ConfirmAssignmentExecute(args[3], args[4], args[5], args[6]);
            } 
        });
        cancel.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                frame.dispose();
            } 
        });
        
        //title button constraints
        gbc.gridx = 0;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;      
        gbc.ipady = 10;
        gbc.ipadx = 10;
        gbc.gridwidth = 1;
        panel.add(id, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;      
        gbc.ipady = 10;
        gbc.ipadx = 10;
        gbc.gridwidth = 1;
        panel.add(fname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;      
        gbc.ipady = 10;
        gbc.ipadx = 10;
        gbc.gridwidth = 1;
        panel.add(lname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;      
        gbc.ipady = 10;
        gbc.ipadx = 10;
        gbc.gridwidth = 1;
        panel.add(date, gbc);
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(cancel, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,5,0,0);
        panel.add(confirm, gbc);
        
        //setting the frame
        JPanel p = new JPanel();
        infoPanel ip = new infoPanel(args[0], args[1], args[2]);
        p = ip.getPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, p);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}