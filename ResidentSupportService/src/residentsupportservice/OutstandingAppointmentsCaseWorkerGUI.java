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
public class OutstandingAppointmentsCaseWorkerGUI
{   
    public static void main(String args[]){
        ArrayList<String> localArguments = new ArrayList<String>();
        localArguments.add(args[0]);
        localArguments.add(args[1]);
        localArguments.add(args[2]); 
        //Frame generation
        JFrame frame = new JFrame("Resident Support Service - View Appointments");
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
        
        //Setting panel layout
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.gray);

        // set the jframe size and location, and make it visible
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        
        //setting action listeners for buttons
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
        
        
        //title button constraints
        gbc.gridx = 1;
        gbc.gridy = 0;      
        gbc.ipady = 50;
        gbc.ipadx = 50;
        gbc.gridwidth = 2;
        title.setFont(new Font("Serif", Font.PLAIN, 40));
        panel.add(title, gbc);
        
        //looping through results and adding labels to the frame
        OutstandingAppointmentsCaseWorker os = new OutstandingAppointmentsCaseWorker();
        os.getAppointments(localArguments.get(0));
        int gy = 1;
        gbc.gridwidth = 1;
        for(int i =0; i<os.labelArray.size();i++){
            JLabel id = new JLabel();
            JLabel fname = new JLabel();
            JLabel lname = new JLabel();
            JLabel date = new JLabel();
            JButton select = new JButton("Select");
            Dimension d = new Dimension(20,5);
            select.setMinimumSize(d);
            JLabel n = os.labelArray.get(i);
            String r = n.getText();
            String[] parts = r.split(" ");
            
            System.out.println(parts[4]);
            
            select.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                viewClientCase cf = new viewClientCase();
                String[] arguments = new String[] {localArguments.get(0), localArguments.get(1), localArguments.get(2), parts[4]};
                cf.main(arguments);
            } 
            });
            
            id.setText(parts[0]);
            fname.setText(parts[1]);
            lname.setText(parts[2]);
            date.setText(parts[3]);
            
            gbc.gridx = 0;
            gbc.gridy = gy;
            panel.add(id, gbc);
            gbc.gridx = 1;
            gbc.gridy = gy;
            panel.add(fname, gbc);
            gbc.gridx = 2;
            gbc.gridy = gy;
            panel.add(lname, gbc);
            gbc.gridx = 3;
            gbc.gridy = gy;
            panel.add(date, gbc);
            gbc.gridx = 4;
            gbc.gridy = gy;
            panel.add(select, gbc);
            gy++;
            if(i>4){
                break;
            }
        }
        
        //back button contraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = gy+1;
        gbc.ipady = 30;
        gbc.ipadx = 40;
        gbc.insets = new Insets(35,0,0,5);
        panel.add(back, gbc);
        
        //log out button constraints
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = gy+1;
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