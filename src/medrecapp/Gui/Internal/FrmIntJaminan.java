/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medrecapp.Gui.Internal;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import medrecapp.Dao.JaminanDao;
import medrecapp.Entity.Jaminan;
import medrecapp.Services.JaminanService;
import medrecapp.TabelModel.TabelModelJaminan;

/**
 *
 * @author Hady
 */
public class FrmIntJaminan extends javax.swing.JInternalFrame {

    JaminanService js = new JaminanService();
    TabelModelJaminan tabelModelJaminan = new TabelModelJaminan();
    Connection connection;

    /**
     * Creates new form FrmIntJaminan
     */
    public FrmIntJaminan() {
        initComponents();
        tabelJaminan.setModel(tabelModelJaminan);
        tabelModelJaminan.setData(js.serviceGetAllJaminan());
        if (!JaminanDao.hasilGetAll.equals("ok")) {
            JOptionPane.showMessageDialog(null, JaminanDao.hasilGetAll, "Get All Jaminan Gagal", JOptionPane.ERROR_MESSAGE);
        }
        sesuaikan();

        tabelJaminan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelJaminan.getSelectedRow();
                if (row != -1) {
                    String idJaminan = tabelJaminan.getValueAt(row, 0).toString();
                    String nmJaminan = tabelJaminan.getValueAt(row, 1).toString();
                    String keterangan = tabelJaminan.getValueAt(row, 2).toString();
                    txtIdJaminan.setText(idJaminan);
                    txtNamaJaminan.setText(nmJaminan);
                    txtKeterangan.setText(keterangan);

                    btnInsert.setEnabled(false);
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                }
            }
        });

        txtKeterangan.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    txtKeterangan.transferFocus();
                    e.consume();
                }
            }
        });
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtIdJaminan.setText("");
        txtNamaJaminan.setText("");
        txtKeterangan.setText("");
        txtCari.setText("");
        txtIdJaminan.requestFocus();
    }

    public final void sesuaikan() {
        TableColumnModel tcm = tabelJaminan.getColumnModel();
        for (int kolom = 0; kolom < tcm.getColumnCount(); kolom++) {
            int lebarKolomMax = 0;
            for (int baris = 0; baris < tabelJaminan.getRowCount(); baris++) {
                TableCellRenderer tcr = tabelJaminan.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelJaminan.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelJaminan, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }
    }

    public void clear() {
        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        txtIdJaminan.setText("");
        txtNamaJaminan.setText("");
        txtKeterangan.setText("");
        txtCari.setText("");
        tabelModelJaminan.setData(js.serviceGetAllJaminan());
        txtIdJaminan.requestFocus();
        sesuaikan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaJaminan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdJaminan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelJaminan = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Jaminan"));

        jLabel2.setText("Nama Jaminan");

        txtNamaJaminan.setName("txtNamaJaminan"); // NOI18N

        jLabel3.setText("Keterangan");

        txtKeterangan.setColumns(20);
        txtKeterangan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtKeterangan.setLineWrap(true);
        txtKeterangan.setRows(5);
        txtKeterangan.setName("txtKeterangan"); // NOI18N
        jScrollPane1.setViewportView(txtKeterangan);

        jLabel4.setText(":");

        jLabel5.setText(":");

        jLabel1.setText("ID Jaminan");

        jLabel6.setText(":");

        txtIdJaminan.setName("txtIDJaminan"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(txtNamaJaminan))))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtIdJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelJaminan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelJaminan.setName("tabelJaminan"); // NOI18N
        jScrollPane2.setViewportView(tabelJaminan);

        btnRefresh.setText("Refresh");
        btnRefresh.setName("btnRefresh"); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnInsert.setText("Insert");
        btnInsert.setName("btnInsert"); // NOI18N
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel9.setText("Masukkan ID / Nama Jaminan:");

        txtCari.setName("txtCari"); // NOI18N
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(468, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        Jaminan j = new Jaminan();
        j.setIdJaminan(txtIdJaminan.getText());
        j.setNmJaminan(txtNamaJaminan.getText());
        j.setKetJaminan(txtKeterangan.getText());
        js.serviceInsertJaminan(j);
        if (JaminanDao.hasilInsert.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Data jaminan berhasil ditambah!", "Insert Jaminan", JOptionPane.INFORMATION_MESSAGE);
            clear();
        } else {
            JOptionPane.showMessageDialog(null, JaminanDao.hasilInsert, "Insert Jaminan Gagal!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Jaminan j = new Jaminan();
        j.setNmJaminan(txtNamaJaminan.getText());
        j.setKetJaminan(txtKeterangan.getText());

        int row = tabelJaminan.getSelectedRow();
        if (row != -1) {
            js.serviceUpdateJaminan(j, tabelJaminan.getValueAt(row, 0).toString());
            if (JaminanDao.hasilUpdate.equals("ok")) {
                JOptionPane.showMessageDialog(null, "Data jaminan berhasil diubah", "Update Jaminan", JOptionPane.INFORMATION_MESSAGE);
                clear();
            } else {
                JOptionPane.showMessageDialog(null, JaminanDao.hasilUpdate, "Update Jaminan Gagal", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tabelJaminan.getSelectedRow();
        if (row == -1) {
            return;
        }
        js.serviceDeleteJaminan(tabelJaminan.getValueAt(row, 0).toString());
        if (JaminanDao.hasilDelete.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Data jaminan berhasil dihapus", "Delete jaminan", JOptionPane.INFORMATION_MESSAGE);
            clear();
        }else{
            JOptionPane.showMessageDialog(null, JaminanDao.hasilDelete,"Hapus jaminan gagal!",JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        tabelModelJaminan.setData(js.serviceGetAllJaminanById(txtCari.getText()));
        if (tabelModelJaminan.getRowCount() == 0) {
            tabelModelJaminan.setData(js.serviceGetAllJaminanByNm(txtCari.getText()));
        }
        txtIdJaminan.setText("");
        txtNamaJaminan.setText("");
        txtKeterangan.setText("");

        btnInsert.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_txtCariKeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelJaminan;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdJaminan;
    private javax.swing.JTextArea txtKeterangan;
    private javax.swing.JTextField txtNamaJaminan;
    // End of variables declaration//GEN-END:variables
}
