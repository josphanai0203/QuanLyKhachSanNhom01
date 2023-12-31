package view.customerView;

import dao.CustomerDAO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class DefaultCustomerView extends javax.swing.JPanel {

    private static Customer customerSelect;
    private ArrayList<Customer> list;

    public DefaultCustomerView(int num) {

    }

    public DefaultCustomerView() {
        initComponents();
        CustomerDAO cd = new CustomerDAO();
        list = cd.selectAll();
        setTableCustomer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cusTable = new javax.swing.JTable();

        cusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(cusTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents
 private void setTableCustomer() {
        DefaultTableModel dtm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        cusTable.setModel(dtm);
        ListSelectionModel lsm = cusTable.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                crearteCustomer();
            }
        });
        setColumnName(dtm);
        setColumnWidths(cusTable, 50, 400, 100, 100, 400, 200, 200, 200, 100);
        setRow(dtm);
    }

    private void setColumnName(DefaultTableModel dtm) {
        dtm.addColumn("ID");
        dtm.addColumn("Tên Khách Hàng");
        dtm.addColumn("Năm Sinh");
        dtm.addColumn("Giới Tính");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Quốc Tịch");
        dtm.addColumn("Số CMND");
        dtm.addColumn("Số Điện Thoại");
        dtm.addColumn("Phòng");
    }

    public void setColumnWidths(JTable table, int... widths) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < widths.length; i++) {
            if (i < columnModel.getColumnCount()) {
                columnModel.getColumn(i).setMaxWidth(widths[i]);
            } else {
                break;
            }
        }
    }

    public void setRow(DefaultTableModel dfm) {
        Vector v = null;
        for (Customer c : list) {
            v = new Vector();
            v.removeAllElements();
            v.add(c.getMaKhachHang());
            v.add(c.getTenKhachHang());
            v.add(c.getNamSinh());
            v.add(c.getGioiTinh());
            v.add(c.getDiaChi());
            v.add(c.getQuocTich());
            v.add(c.getSoCMND());
            v.add(c.getSdt());
            v.add(c.getMaPhong().getName());
            dfm.addRow(v);
        }

    }

    public void crearteCustomer() {
        int row = cusTable.getSelectedRow();
        int maKhachHang = (Integer) cusTable.getValueAt(row, 0);
        customerSelect = new Customer();
        customerSelect.setMaKhachHang(maKhachHang);
    }

    public static Customer getCustomerSelected() {
        return customerSelect;
    }

    public static void setNullSelect() {
        customerSelect = null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cusTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
