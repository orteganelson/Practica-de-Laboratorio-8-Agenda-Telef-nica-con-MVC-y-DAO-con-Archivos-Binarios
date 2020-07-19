/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Telefono;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Anahi
 */
public class GestionTelefono extends javax.swing.JInternalFrame {
    
    private ControladorUsuario controladorUsuario;
    private List<String> operadoras;
    /**
     * Creates new form GestionTelefono
     */
    public GestionTelefono(ControladorUsuario controladorUsuario) {
        initComponents();
        this.controladorUsuario = controladorUsuario;
        DatosOperadora();
        botonesInicio();
    }
    public void botonesInicio() {

        btnAgregar.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

    }

    public void botonesEditar() {
        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    public void DatosOperadora() {
        operadoras = new ArrayList<>();

        operadoras.add("Movistar");
        operadoras.add("Claro");
        operadoras.add("CNT");
        operadoras.add("Tuenti");
        operadoras.add("Etapa");

        ComboOperadora();

    }

    public void ComboOperadora() {

        DefaultComboBoxModel modelo = (DefaultComboBoxModel) comboOperadora.getModel();
        for (String opera : operadoras) {
            modelo.addElement(opera);
        }
        comboOperadora.setModel(modelo);
    }

    public void llenarTablaTelefonos() {

        DefaultTableModel modelo = (DefaultTableModel) tablaGTelefono.getModel();

        modelo.setRowCount(0);

        for (Telefono telefono : controladorUsuario.listarTelefonosUsuario()) {
            Object[] rowData = {telefono.getCodigo(), telefono.getNumero().trim(),
                telefono.getOperadora().trim(), telefono.getTipo().trim()};
            modelo.addRow(rowData);
        }
        tablaGTelefono.setModel(modelo);
    }

    public void cargarCodigo() {
        int cod = controladorUsuario.codigoTelefono();
        txtCodigo.setText(String.valueOf(cod));
    }
    public void limpiar() {

        txtCodigo.setText("");
        txtNum.setValue("");
        comboOperadora.setSelectedIndex(0);
        comboTipo.setSelectedIndex(0);
        cargarCodigo();
        tablaGTelefono.clearSelection();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGTelefono = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        comboOperadora = new javax.swing.JComboBox<>();
        txtNum = new javax.swing.JFormattedTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestión Teléfonos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Código:");

        jLabel2.setText("Tipo:");

        jLabel3.setText("Número:");

        jLabel4.setText("Operadora:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tablaGTelefono.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Tipo", "Operadora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGTelefonoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGTelefono);

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        comboOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboOperadora, 0, 171, Short.MAX_VALUE)
                                            .addComponent(comboTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtNum))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 15, Short.MAX_VALUE)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(comboOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
         try {
            String item = (String) comboTipo.getSelectedItem();
            if (item.equals("Casa")) {
                txtNum.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)#-####-###")
                        )
                );

            } else if (item.equals("Celular")) {
                txtNum.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)###-###-###")
                        )
                );

            } else {
                txtNum.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(593)#-####-####")
                        )
                );
            }
        } catch (java.text.ParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato del número del teléfono erroneo");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_comboTipoActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cargarCodigo();
        llenarTablaTelefonos();
        limpiar();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String numero = txtNum.getText();
        String operadora = comboOperadora.getSelectedItem().toString();
        String tipo = comboTipo.getSelectedItem().toString();
        int cod = Integer.parseInt(txtCodigo.getText());
        if (numero.isEmpty() || tipo.equals(comboTipo.getItemAt(0)) || operadora.equals(comboOperadora.getItemAt(0))) {
            JOptionPane.showMessageDialog(this, "Llene el casillero del número del teléfono");
        } else {
            controladorUsuario.agregarTelefono(cod, numero, tipo, operadora);
            JOptionPane.showMessageDialog(this, "Teléfono creado con exito");
            llenarTablaTelefonos();
            limpiar();

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tablaGTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGTelefonoMouseClicked
        int fila = tablaGTelefono.getSelectedRow();
        int cod = (int) tablaGTelefono.getValueAt(fila, 0);
        String num = (String) tablaGTelefono.getValueAt(fila, 1);
        String tipo = (String) tablaGTelefono.getValueAt(fila, 2);
        String opera = (String) tablaGTelefono.getValueAt(fila, 3);

        txtCodigo.setText(String.valueOf(cod));
        txtNum.setValue(num);
        comboTipo.setSelectedItem(tipo);
        comboOperadora.setSelectedItem(opera);

        botonesEditar();

    }//GEN-LAST:event_tablaGTelefonoMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String numero = txtNum.getText();
        String operadora = comboOperadora.getSelectedItem().toString();
        String tipo = comboTipo.getSelectedItem().toString();
        int cod = Integer.parseInt(txtCodigo.getText());

        if (numero.isEmpty()
                || tipo.equals(comboTipo.getItemAt(0)) || operadora.equals(comboOperadora.getItemAt(0))) {
            JOptionPane.showMessageDialog(this, "Llene todos los requerimientos");
        } else {
            controladorUsuario.actualizarTelefono(numero, tipo, operadora, cod);
            JOptionPane.showMessageDialog(this, "Teléfono actualizado con exito");
            llenarTablaTelefonos();
            btnAgregar.setEnabled(true);
            btnCancelar.setEnabled(false);
            btnEditar.setEnabled(false);
            btnEliminar.setEnabled(false);
            limpiar();

        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int eliminar = JOptionPane.showConfirmDialog(this, "¿Seguro quieres eliminar este teléfono?");
        if (eliminar == JOptionPane.YES_OPTION) {
            int cod = Integer.parseInt(txtCodigo.getText());
            controladorUsuario.eliminarTelefono(cod);
            JOptionPane.showMessageDialog(this, "Telefono eliminado con exito");
            llenarTablaTelefonos();
            botonesInicio();
            limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
        botonesInicio();
        tablaGTelefono.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboOperadora;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGTelefono;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
