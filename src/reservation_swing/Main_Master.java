/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation_swing;

import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableRowSorter;


public class Main_Master extends javax.swing.JFrame {
    
    public void getData(String fname,String lname){
        
        display_name.setText(fname + " " +lname);
    }
    
  
    
    
    public double calculateTotal(String rsize,String days,String amenities){
        double total = 0.0;
        double size = 0.0;
        double d = 0.0;
        double am = 0.0;
        
        if(rsize.equals("Small")){
            size = 250;
        }else if (rsize.equals("Medium")){
            size = 300;
        }else if (rsize.equals("Large")){
            size = 350;
        }else if (rsize.equals("Extra Large")){
            size = 400;
        }
        
        // MULTIPLIER
        if(days.equals("1 Day")){
            d = 1;
        }else if (days.equals("2 Day")){
            d = 2;
        }else if (days.equals("3 Day")){
            d = 3;
        }else if (days.equals("4 Day")){
            d = 4;
        }else if (days.equals("5 Day")){
            d = 5;
        }else if (days.equals("7 Day")){
            d = 7;
        }else if (days.equals("10 Day")){
            d = 10;
        }else if (days.equals("20 Day")){
            d = 20;
        }else if (days.equals("30 Day")){
            d = 30;
        }
        
        
        if(amenities.equals("No Package")){
            am = 0;
        }else if (amenities.equals("Package 1")){
            am = 300;
        }else if (amenities.equals("Package 2")){
            am = 400;
        }else if (amenities.equals("Package 3")){
            am = 500;
        }else if (amenities.equals("Package 4")){
            am = 700;
        }
        
         total = d * (size + am);       
        
         return total;
        
    }
    
    public ArrayList<Reserve> reservation()
    {
        
        ArrayList<Reserve> reservation = new ArrayList<>();
        try{
         Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection(""
                        + "jdbc:mysql://localhost:3306/reservation","root","");  
            PreparedStatement query =  
          conn.prepareStatement("SELECT * FROM room_reserve");   
            ResultSet set = query.executeQuery();
            Reserve re;
                while (set.next()){
                    re = new Reserve(set.getString(1),set.getString(2),set.getString(3)
                    ,set.getString(4),set.getString(5),set.getString(6),set.getString(7),
                    set.getString(8));
                    
                    reservation.add(re);
                    
                }
                
        }catch(Exception e){
            e.printStackTrace();
        }
        return reservation;
    }
    
    public void showTable(){
       
        
        ArrayList<Reserve> list = reservation();
        DefaultTableModel model = (DefaultTableModel) main_table.getModel();
        Object[] row = new  Object[8];
        
        for (int i = 0; i < list.size();i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getDate();
            row[2] = list.get(i).getDay();
            row[3] = list.get(i).getVisitor();
            row[4] = list.get(i).getRoomNumber();
            row[5] = list.get(i).getRoomSize();
            row[6] = list.get(i).getAmenities();
            row[7] = list.get(i).getTotal();
            
            model.addRow(row);
            
        }
    }
    
     
    public void getDataToUpdate(String id, String date, String day, 
      String visitor, String room_num, String room_size,String amen ){
        
        display_date.setText(date);
        
        display_room.setText(room_num);
        display_id.setText(id);
        display_visitors.setText(visitor);
        // COMBOBOX
        display_rsize.setSelectedItem(room_size);
        display_days.setSelectedItem(day);
        diplay_amenities.setSelectedItem(amen);
      
    }
  
    
    public void searchItem(String query){
        
        DefaultTableModel model = (DefaultTableModel) main_table.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        main_table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
        
        
    }

    
    
    
    public Main_Master() {
        
        
       
        initComponents();
        this.setLocationRelativeTo(null);
        jScrollPane2.getViewport().setBackground(Color.white);
        this.setDefaultCloseOperation(Main_Master.EXIT_ON_CLOSE);
        this.setTitle("PACO HOTEL SYSTEM");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        for_add_reservation.setLocationRelativeTo(null);
        for_add_reservation.setSize(550,650);
        
        for_update.setLocationRelativeTo(null);
        for_update.setSize(694, 497);
        
     
        for_payment.setSize(415, 620);
        
        
        showTable();
        
    }
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        for_add_reservation = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        add = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cancel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        generated_id = new javax.swing.JTextField();
        room_number = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        room_size = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        xtra_amenities = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        visitors = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        days = new javax.swing.JComboBox<>();
        generated_date = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        for_update = new javax.swing.JDialog();
        display_date = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        display_room = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        display_visitors = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        display_rsize = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        back = new javax.swing.JButton();
        display_id = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        diplay_amenities = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        display_days = new javax.swing.JComboBox<>();
        for_payment = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        display_id_payment = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        bill = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        get_total_payment = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        get_bill_payment = new javax.swing.JLabel();
        display_change = new javax.swing.JLabel();
        compute = new javax.swing.JButton();
        payment_cancel = new javax.swing.JButton();
        process = new javax.swing.JButton();
        top_layer = new javax.swing.JPanel();
        panel_left = new javax.swing.JPanel();
        add_reservation = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        delete_reservation = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        update_reservation = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        payments = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        logo_image = new javax.swing.JLabel();
        sales = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panel_top = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        display_name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        main_table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        change_username = new javax.swing.JButton();
        change_password = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        for_add_reservation.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        for_add_reservation.setTitle("Adding Reservation");
        for_add_reservation.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        for_add_reservation.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        for_add_reservation.setSize(new java.awt.Dimension(539, 540));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(570, 520));
        jPanel3.setPreferredSize(new java.awt.Dimension(530, 500));

        jPanel4.setBackground(new java.awt.Color(22, 160, 133));

        add.setBackground(new java.awt.Color(0, 121, 107));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Add");

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
        });

        jLabel16.setText("Cancel");

        javax.swing.GroupLayout cancelLayout = new javax.swing.GroupLayout(cancel);
        cancel.setLayout(cancelLayout);
        cancelLayout.setHorizontalGroup(
            cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel16)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        cancelLayout.setVerticalGroup(
            cancelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        generated_id.setEnabled(false);

        jLabel17.setText("Generated ID");

        jLabel19.setText("Date   (MMM--DDD--YYY)");

        jLabel20.setText("Days");

        jLabel21.setText("Room Number");

        room_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large", "Extra Large" }));

        jLabel22.setText("Room Size");

        xtra_amenities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Package 1", "Package 2", "Package 3", "Package 4" }));

        jLabel23.setText("Extra Amenities");

        jLabel24.setText("Number of Visitors");

        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Day", "2 Day", "3 Day", "4 Day", "5 Day", "7 Day", "10 Day", "20 Day", "30 Day" }));

        generated_date.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)
                        .addGap(195, 195, 195)
                        .addComponent(jLabel19))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(generated_id, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(generated_date, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21)
                        .addGap(187, 187, 187)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(room_number, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(visitors, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(xtra_amenities, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(236, 236, 236)
                                .addComponent(jLabel22))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(room_size, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generated_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generated_date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel21))
                    .addComponent(jLabel24))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(room_number, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(visitors, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel20))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(room_size, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xtra_amenities, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Adding Client for Reservation");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout for_add_reservationLayout = new javax.swing.GroupLayout(for_add_reservation.getContentPane());
        for_add_reservation.getContentPane().setLayout(for_add_reservationLayout);
        for_add_reservationLayout.setHorizontalGroup(
            for_add_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        for_add_reservationLayout.setVerticalGroup(
            for_add_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(for_add_reservationLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        for_update.setTitle("Payments");

        jLabel11.setText("Existing Date");

        jLabel12.setText("Existing Room Number");

        jLabel18.setText("Existing # of Visitors");

        display_rsize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Small", "Medium", "Large" }));

        jLabel25.setText("Existing Room Size");

        jLabel26.setText("Existing Extra Amenities");

        jPanel6.setBackground(new java.awt.Color(22, 160, 133));

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Updating the Reservation Record");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(22, 160, 133));

        update.setBackground(new java.awt.Color(0, 255, 0));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(back)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        display_id.setEditable(false);

        jLabel28.setText("ID");

        diplay_amenities.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Package 1", "Package 2", "Package 3", "Package 4" }));

        jLabel29.setText("Days");

        display_days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Day", "2 Day", "3 Day", "4 Day", "5 Day", "7 Day", "10 Day", "20 Day", "30 Day" }));

        javax.swing.GroupLayout for_updateLayout = new javax.swing.GroupLayout(for_update.getContentPane());
        for_update.getContentPane().setLayout(for_updateLayout);
        for_updateLayout.setHorizontalGroup(
            for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, for_updateLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(display_date, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel29)
                    .addComponent(display_days, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(for_updateLayout.createSequentialGroup()
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(display_id, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel26)
                            .addComponent(diplay_amenities, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25)
                            .addComponent(display_room)
                            .addComponent(jLabel12)
                            .addComponent(display_rsize, 0, 180, Short.MAX_VALUE)))
                    .addComponent(display_visitors, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        for_updateLayout.setVerticalGroup(
            for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(for_updateLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(for_updateLayout.createSequentialGroup()
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(display_room, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(display_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addGap(8, 8, 8)
                        .addGroup(for_updateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(display_rsize, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diplay_amenities, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(for_updateLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(display_date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(display_days, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(display_visitors, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        for_payment.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        for_payment.setTitle("PAYMENT");
        for_payment.setLocation(new java.awt.Point(0, 0));
        for_payment.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        for_payment.setPreferredSize(new java.awt.Dimension(415, 620));
        for_payment.setResizable(false);
        for_payment.setLocationRelativeTo(null);

        jPanel8.setBackground(new java.awt.Color(22, 160, 133));

        jLabel30.setFont(new java.awt.Font("DejaVu Serif", 0, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Payment");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel31.setText("Selected Customer ID: ");

        display_id_payment.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        display_id_payment.setText("xxxxxxxxx");

        jPanel9.setBackground(new java.awt.Color(0, 204, 153));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Computation"));

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel33.setText("Customer Bill");

        bill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                billKeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel34.setText("Total Payment");

        get_total_payment.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        get_total_payment.setForeground(new java.awt.Color(0, 153, 0));
        get_total_payment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        get_total_payment.setText("0.0");

        jLabel36.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel36.setText("PHP");

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel37.setText("Change");

        jLabel38.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("-");

        get_bill_payment.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        get_bill_payment.setForeground(new java.awt.Color(255, 0, 0));
        get_bill_payment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        get_bill_payment.setText("0.0");

        display_change.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        display_change.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        display_change.setText("0.0");

        compute.setBackground(new java.awt.Color(153, 255, 153));
        compute.setText("Compute");
        compute.setBorderPainted(false);
        compute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        compute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(114, 114, 114)
                                .addComponent(display_change, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(28, 28, 28)
                                .addComponent(get_bill_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(get_total_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(compute, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bill, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(get_total_payment)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(get_bill_payment)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(display_change))
                .addGap(18, 18, 18)
                .addComponent(compute, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        payment_cancel.setBackground(new java.awt.Color(153, 255, 153));
        payment_cancel.setText("Cancel");
        payment_cancel.setBorderPainted(false);
        payment_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payment_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_cancelActionPerformed(evt);
            }
        });

        process.setBackground(new java.awt.Color(153, 255, 153));
        process.setText("Process");
        process.setBorderPainted(false);
        process.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout for_paymentLayout = new javax.swing.GroupLayout(for_payment.getContentPane());
        for_payment.getContentPane().setLayout(for_paymentLayout);
        for_paymentLayout.setHorizontalGroup(
            for_paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(for_paymentLayout.createSequentialGroup()
                .addGroup(for_paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(for_paymentLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(display_id_payment, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(for_paymentLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(for_paymentLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(for_paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        for_paymentLayout.setVerticalGroup(
            for_paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(for_paymentLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(for_paymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(display_id_payment))
                .addGap(26, 26, 26)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payment_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UPDATE");
        setName("main"); // NOI18N

        top_layer.setBackground(new java.awt.Color(255, 255, 255));

        panel_left.setBackground(new java.awt.Color(22, 160, 133));
        panel_left.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_left.setFocusCycleRoot(true);
        panel_left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add_reservation.setBackground(new java.awt.Color(0, 121, 107));
        add_reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_reservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_reservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_reservationMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Reservation");

        javax.swing.GroupLayout add_reservationLayout = new javax.swing.GroupLayout(add_reservation);
        add_reservation.setLayout(add_reservationLayout);
        add_reservationLayout.setHorizontalGroup(
            add_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_reservationLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        add_reservationLayout.setVerticalGroup(
            add_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, add_reservationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_left.add(add_reservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 208, 248, -1));

        delete_reservation.setBackground(new java.awt.Color(0, 121, 107));
        delete_reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_reservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_reservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete_reservationMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Delete Reservation");

        javax.swing.GroupLayout delete_reservationLayout = new javax.swing.GroupLayout(delete_reservation);
        delete_reservation.setLayout(delete_reservationLayout);
        delete_reservationLayout.setHorizontalGroup(
            delete_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delete_reservationLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        delete_reservationLayout.setVerticalGroup(
            delete_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, delete_reservationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_left.add(delete_reservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 248, -1));

        update_reservation.setBackground(new java.awt.Color(0, 121, 107));
        update_reservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_reservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                update_reservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                update_reservationMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Update Reservation");

        javax.swing.GroupLayout update_reservationLayout = new javax.swing.GroupLayout(update_reservation);
        update_reservation.setLayout(update_reservationLayout);
        update_reservationLayout.setHorizontalGroup(
            update_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_reservationLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel6)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        update_reservationLayout.setVerticalGroup(
            update_reservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(update_reservationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_left.add(update_reservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 322, -1, -1));

        payments.setBackground(new java.awt.Color(0, 121, 107));
        payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentsMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Payments");

        javax.swing.GroupLayout paymentsLayout = new javax.swing.GroupLayout(payments);
        payments.setLayout(paymentsLayout);
        paymentsLayout.setHorizontalGroup(
            paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paymentsLayout.setVerticalGroup(
            paymentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_left.add(payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 379, 248, -1));

        logout.setBackground(new java.awt.Color(0, 121, 107));
        logout.setFocusCycleRoot(true);
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Log Out");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_left.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 248, -1));
        panel_left.add(logo_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 25, -1, 151));

        sales.setBackground(new java.awt.Color(0, 121, 107));
        sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Reports");

        javax.swing.GroupLayout salesLayout = new javax.swing.GroupLayout(sales);
        sales.setLayout(salesLayout);
        salesLayout.setHorizontalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        salesLayout.setVerticalGroup(
            salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_left.add(sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 436, 248, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon("C:\\Users\\T-Brother\\Desktop\\Reservation-System\\src\\images\\images(0).jpeg")); // NOI18N
        panel_left.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 150));

        panel_top.setBackground(new java.awt.Color(26, 188, 156));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Paco Hotel Reservation System");

        display_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        display_name.setForeground(new java.awt.Color(255, 255, 255));
        display_name.setText("Username ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Welcome, ");

        javax.swing.GroupLayout panel_topLayout = new javax.swing.GroupLayout(panel_top);
        panel_top.setLayout(panel_topLayout);
        panel_topLayout.setHorizontalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(panel_topLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(display_name)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_topLayout.setVerticalGroup(
            panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(display_name)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        main_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Date", "Days", "Visitor", "Room Number", "Room Size", "Amenities", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        main_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(main_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        jButton1.setBackground(new java.awt.Color(0, 121, 107));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reservaton Prices");

        change_username.setBackground(new java.awt.Color(0, 121, 107));
        change_username.setForeground(new java.awt.Color(255, 255, 255));
        change_username.setText("Change Username");

        change_password.setBackground(new java.awt.Color(0, 121, 107));
        change_password.setForeground(new java.awt.Color(255, 255, 255));
        change_password.setText("Change Password");

        jLabel10.setText("** The Table Below is where you to Select, Update and Delete");

        javax.swing.GroupLayout top_layerLayout = new javax.swing.GroupLayout(top_layer);
        top_layer.setLayout(top_layerLayout);
        top_layerLayout.setHorizontalGroup(
            top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top_layerLayout.createSequentialGroup()
                .addComponent(panel_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top_layerLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(change_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(change_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(panel_top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(top_layerLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        top_layerLayout.setVerticalGroup(
            top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_left, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addGroup(top_layerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(change_username, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change_password, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(panel_top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top_layerLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10))
                    .addGroup(top_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 475, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_layer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_layer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_reservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_reservationMouseEntered
       add_reservation.setBackground(new Color(0,150,136));
       add_reservation.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
       
       
    }//GEN-LAST:event_add_reservationMouseEntered

    private void add_reservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_reservationMouseExited
        add_reservation.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_add_reservationMouseExited

    private void delete_reservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_reservationMouseEntered
        delete_reservation.setBackground(new Color(0,150,136));
        delete_reservation.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_delete_reservationMouseEntered

    private void delete_reservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_reservationMouseExited
        delete_reservation.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_delete_reservationMouseExited

    private void add_reservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_reservationMouseClicked

        Random rand = new Random();
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         int year  = localDate.getYear();
         int month = localDate.getMonthValue();
         int day   = localDate.getDayOfMonth();
       
         
         generated_id.setText(String.valueOf(rand.nextInt(100000) + 1));
         generated_date.setText(month + "/" + day + "/" + year);
       
          for_add_reservation.setVisible(true);

    }//GEN-LAST:event_add_reservationMouseClicked

    private void delete_reservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_reservationMouseClicked
        
        
        
        int selected = main_table.getSelectedRowCount();
        
         if(selected != 0){
             
            DefaultTableModel model = (DefaultTableModel) main_table.getModel();
            int column = 0;


            int row = main_table.getSelectedRow();  

            String get_id =
            main_table.getModel().getValueAt(row, column).toString();
        
       
        try{
            
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = (Connection) DriverManager.getConnection(""
           + "jdbc:mysql://localhost:3306/reservation","root","");  
           
           PreparedStatement query =  
          conn.prepareStatement("DELETE FROM room_reserve WHERE ID = " + "'" + get_id +"'"); 
           query.execute();
           model.removeRow(row);
            JOptionPane.showMessageDialog(null, "Deleted Successfully","DELETE",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select in the Table to Delete","DELETE",JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
        
        System.out.print(get_id);
             
        }else{
             JOptionPane.showMessageDialog(null, "Select in the Table to Delete","DELETE",JOptionPane.INFORMATION_MESSAGE);
        }
        /**
         The User must click in the Table to delete the data that has been click
         * The Deletion can deleted a multiple lines in the table(optional)
         * Error Catching for not being able to click in the table
         * Make a Confirmation Button(Dialog Box) in order to proceed 
         * 
         * LINK: 
         **/
        
       
        
        
    }//GEN-LAST:event_delete_reservationMouseClicked

    private void update_reservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_reservationMouseClicked
        // TODO add your handling code here:
        // UPDATE
        
        int selectrow = main_table.getSelectedRowCount();
        
        if (selectrow != 0){
            
            int row = main_table.getSelectedRow();  

            String id =
            main_table.getModel().getValueAt(row, 0).toString();
            String date =
            main_table.getModel().getValueAt(row, 1).toString();
            String day =
            main_table.getModel().getValueAt(row, 2).toString();
            String visitor =
            main_table.getModel().getValueAt(row, 3).toString();
            String rnum =
            main_table.getModel().getValueAt(row, 4).toString();
            String rsize =
            main_table.getModel().getValueAt(row, 5).toString();
            String am =
            main_table.getModel().getValueAt(row, 6).toString();
            
            

           getDataToUpdate(id,date,day,visitor,rnum,rsize,am);
         for_update.setVisible(true);
          for_update.setLocationRelativeTo(null);  
          for_update.setTitle("UPDATE");
        }else{
           JOptionPane.showMessageDialog(null, "Select in the Table to Delete","DELETE",JOptionPane.INFORMATION_MESSAGE);  
        }

    }//GEN-LAST:event_update_reservationMouseClicked

    private void update_reservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_reservationMouseEntered
        update_reservation.setBackground(new Color(0,150,136));
        update_reservation.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_update_reservationMouseEntered

    private void update_reservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_reservationMouseExited
        update_reservation.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_update_reservationMouseExited

    private void paymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsMouseClicked
        // TODO add your handling code here:
        // PAYMENT
        
        int row = main_table.getSelectedRowCount();
        int srow = main_table.getSelectedRow();
        
         
        if (row != 0){
             String get_id =
        main_table.getModel().getValueAt(srow, 0).toString();
         String get_total =  main_table.getModel().getValueAt(srow, 7).toString();
            for_payment.setVisible(true);
            display_id_payment.setText(get_id);
           get_total_payment.setText(get_total);
           for_payment.setLocationRelativeTo(null);
           bill.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Select in the Table"
         + " to Start the Payment Process","Payment",JOptionPane.INFORMATION_MESSAGE);  
        }
        
        
 
    }//GEN-LAST:event_paymentsMouseClicked

    private void paymentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsMouseEntered
        payments.setBackground(new Color(0,150,136));
        payments.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_paymentsMouseEntered

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
           this.dispose();
           Main obj = new Main();
           obj.setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(new Color(0,150,136));
        logout.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
       logout.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_logoutMouseExited

    private void paymentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsMouseExited
         payments.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_paymentsMouseExited

    private void salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseClicked
        // TODO add your handling code here:
        
        Reports obj = new Reports();
        obj.setVisible(true);
        
    }//GEN-LAST:event_salesMouseClicked

    private void salesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseExited
       sales.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_salesMouseExited

    private void salesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseEntered
        sales.setBackground(new Color(0,150,136));
        sales.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_salesMouseEntered

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // Add into database and display it in the table
        double total = 0.0;
        
        String day_selected = (String) days.getSelectedItem();
        String room_selected = (String) room_size.getSelectedItem();
        String amenities_selected = (String) xtra_amenities.getSelectedItem();
        String get_id = generated_id.getText();
        String get_date = generated_date.getText();
        String get_room_number = room_number.getText();
        String get_visitors = visitors.getText();
        int choice = 0;
        
        total = calculateTotal(room_selected, day_selected, amenities_selected);
        
        if(get_room_number.equals("") && get_visitors.equals("")){
            JOptionPane.showMessageDialog(for_add_reservation, "Please Input the Missing Fields","FIELDS",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            choice = JOptionPane.showConfirmDialog(for_add_reservation, "Total Payment: " + total,
                "TOTAL PAYMENT" 
                , JOptionPane.OK_CANCEL_OPTION );

        if(choice == 0){
            // OK
            // ADDING IT TO THE TABLE
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection(""
                        + "jdbc:mysql://localhost:3306/reservation","root","");
                 PreparedStatement query =  conn.prepareStatement(""
                         + "INSERT INTO room_reserve (ID,date,days,visitors,room_number,room_size,amenities,total)"
                      + " VALUES (" + "'" +get_id + "'" + ","+"'" + get_date + "'"+","+ "'"+day_selected+"'"+","+
                             "'"+ get_visitors+"'"+","+"'"+get_room_number+"'" +"," +
                                     "'" + room_selected + "'" + "," + "'" + amenities_selected +"'"+ "," + 
                                            "'" + total + "'"+")");
                 
                 query.execute();
                 JOptionPane.showMessageDialog(for_add_reservation, "Added Successfully","Add",
                         JOptionPane.INFORMATION_MESSAGE);
                 
                 // REFRESH JTABLE
                 DefaultTableModel model = (DefaultTableModel) main_table.getModel();
                 model.setRowCount(0);
                 showTable();
            }catch(ClassNotFoundException | SQLException e){
               e.printStackTrace();
            }
            

            for_add_reservation.dispose();
        }else{
            // CANCEL
        }
        
        }
 
    }//GEN-LAST:event_addMouseClicked

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(new Color(0,121,107));
    }//GEN-LAST:event_addMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(new Color(0,150,136));
        add.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_addMouseEntered

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        for_add_reservation.dispose();
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered

        cancel.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));
    }//GEN-LAST:event_cancelMouseEntered

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        /**
        *  NOT FIX: NOT REFRESHING THE JTABLE
        */
        String id = display_id.getText();
        String date = display_date.getText();
        String day = (String) display_days.getSelectedItem();
        String visitor = display_visitors.getText();
        String rnum = display_room.getText();
        String rsize =  (String) display_rsize.getSelectedItem();
        String am = (String) diplay_amenities.getSelectedItem();

        double total = calculateTotal(rsize,day,am);

        if(id.equals("") && date.equals("") && visitor.equals("")
            && rnum.equals("")){

            JOptionPane.showMessageDialog(null, "Please Input the Missing Fields","FIELDS",
                JOptionPane.INFORMATION_MESSAGE);
        }else{

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/reservation","root","");
                PreparedStatement query =  conn.prepareStatement(
                    "UPDATE room_reserve SET ID = " + "'" + id + "'" + "," + "date = " +
                    "'" + date + "'" + "," + "days = " + "'" + day + "'" + "," +
                    "visitors = " + "'" + visitor +"'" + "," + "room_number = " +
                    "'" + rnum +"'" + "," + "room_size = " + "'" + rsize+ "'" + "," +
                    "amenities = " + "'" + am + "'" + "," + "total = " + "'" + total + "'"+
                    "WHERE ID = " + "'" + id + "'" );
                    
                query.execute();
                
                JOptionPane.showMessageDialog(null, "Successfully Updated","UPDATED",
                    JOptionPane.INFORMATION_MESSAGE);
                
                  DefaultTableModel model = (DefaultTableModel) main_table.getModel();
                  
                 model.setRowCount(0);
                 showTable();
               
            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        for_update.dispose();

    }//GEN-LAST:event_backActionPerformed

    private void computeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeActionPerformed
        double get_bill = Double.valueOf(get_bill_payment.getText());
        double get_total = Double.valueOf(get_total_payment.getText());
        double total_change = 0.0;
        
        if(get_total < get_bill ){
            total_change = get_bill - get_total;
            display_change.setText(String.valueOf(total_change));
        }else{
             JOptionPane.showMessageDialog(null, "Not enough Funds..","Compute",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        display_change.setText(String.valueOf(total_change));
    }//GEN-LAST:event_computeActionPerformed

    private void payment_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_cancelActionPerformed
        for_payment.dispose();
    }//GEN-LAST:event_payment_cancelActionPerformed

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        
        String get_change = display_change.getText();
        int row = main_table.getSelectedRow();
           String get_id =
            main_table.getModel().getValueAt(row, 0).toString();
             String get_date =
            main_table.getModel().getValueAt(row, 1).toString();
               String total = get_total_payment.getText();
         
        if ("0.0".equals(get_change)){
            JOptionPane.showMessageDialog(null, "Please Check the Change First","Check",JOptionPane.INFORMATION_MESSAGE);
        }else{
            
           try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection) DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/reservation","root","");
                PreparedStatement query =  conn.prepareStatement("INSERT INTO reports (ID,date,total_balance)"
                      + " VALUES (" + "'" +get_id + "'" + ","+"'" + get_date + "'"+","+ "'"+total+"'"+ ")");
                
                query.execute();
                JOptionPane.showMessageDialog(null, "Payment Complete","Success",JOptionPane.INFORMATION_MESSAGE);
                for_payment.dispose();
           }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR: Something went wrong","ERROR",JOptionPane.ERROR_MESSAGE);
           }
            
        }
        
        
        
    }//GEN-LAST:event_processActionPerformed

    private void billKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billKeyReleased
        String get = bill.getText();
        get_bill_payment.setText(get);
    }//GEN-LAST:event_billKeyReleased

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String q =  search.getText();
        searchItem(q);
    }//GEN-LAST:event_searchKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Master.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Master().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JPanel add_reservation;
    private javax.swing.JButton back;
    private javax.swing.JTextField bill;
    private javax.swing.JPanel cancel;
    private javax.swing.JButton change_password;
    private javax.swing.JButton change_username;
    private javax.swing.JButton compute;
    private javax.swing.JComboBox<String> days;
    private javax.swing.JPanel delete_reservation;
    private javax.swing.JComboBox<String> diplay_amenities;
    private javax.swing.JLabel display_change;
    private javax.swing.JTextField display_date;
    private javax.swing.JComboBox<String> display_days;
    private javax.swing.JTextField display_id;
    private javax.swing.JLabel display_id_payment;
    private javax.swing.JLabel display_name;
    private javax.swing.JTextField display_room;
    private javax.swing.JComboBox<String> display_rsize;
    private javax.swing.JTextField display_visitors;
    private javax.swing.JDialog for_add_reservation;
    private javax.swing.JDialog for_payment;
    private javax.swing.JDialog for_update;
    private javax.swing.JTextField generated_date;
    private javax.swing.JTextField generated_id;
    private javax.swing.JLabel get_bill_payment;
    private javax.swing.JLabel get_total_payment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logo_image;
    private javax.swing.JPanel logout;
    private javax.swing.JTable main_table;
    private javax.swing.JPanel panel_left;
    private javax.swing.JPanel panel_top;
    private javax.swing.JButton payment_cancel;
    private javax.swing.JPanel payments;
    private javax.swing.JButton process;
    private javax.swing.JTextField room_number;
    private javax.swing.JComboBox<String> room_size;
    private javax.swing.JPanel sales;
    private javax.swing.JTextField search;
    private javax.swing.JPanel top_layer;
    private javax.swing.JButton update;
    private javax.swing.JPanel update_reservation;
    private javax.swing.JTextField visitors;
    private javax.swing.JComboBox<String> xtra_amenities;
    // End of variables declaration//GEN-END:variables
}
