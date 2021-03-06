package provaalg1909pedro.tela;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import provaalg1909pedro.DAO.DestinoDAO;
import provaalg1909pedro.MenuJDialog;
import provaalg1909pedro.Util.DateUtil;
import provaalg1909pedro.model.Destino;

/**
 *
 * @author Pedro Henrique Martins Stulp
 */
public class DestinoJDialog extends javax.swing.JDialog {

    private DestinoDAO destinoDAO;

    /**
     * Creates new form DestinoJDialog
     */
    public DestinoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        destinoDAO = new DestinoDAO();
        habilitaFiltroCodigo();
        try {
            carregaTable(destinoDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(DestinoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        desabilitaCampos(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDestino = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfDescricao = new javax.swing.JTextField();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        tfDtInicio = new javax.swing.JFormattedTextField();
        tfDtTermino = new javax.swing.JFormattedTextField();
        btCancelar = new javax.swing.JButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbDescricao = new javax.swing.JRadioButton();
        tfCodigoFiltro = new javax.swing.JTextField();
        tfDescricaoFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tbDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Data Início", "Data Término", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDestino);

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        jLabel3.setText("Data Início");

        jLabel4.setText("Data Término");

        tfCodigo.setEnabled(false);

        tfDescricao.setEnabled(false);

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        try {
            tfDtInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtInicio.setEnabled(false);

        try {
            tfDtTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtTermino.setEnabled(false);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCodigo);
        rbCodigo.setText("Código");
        rbCodigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbCodigoItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbDescricao);
        rbDescricao.setText("Descrição");
        rbDescricao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbDescricaoItemStateChanged(evt);
            }
        });

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDescricao)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfDtInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(tfDtTermino))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tfCodigoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tfDescricaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(btFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(rbCodigo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDtTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btRemover)
                    .addComponent(btCancelar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCodigo)
                            .addComponent(tfCodigoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDescricao)
                            .addComponent(tfDescricaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btFiltrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        try {
            tfCodigo.setText(String.valueOf(destinoDAO.getLastId()));
            desabilitaCampos(true);
            btSalvar.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        try {
            if (tfDtInicio.getText().replace("/", " ").trim().length() > 0 &&
                    tfDtTermino.getText().replace("/", " ").trim().length() > 0) {
                java.sql.Date dataSqlInicio = new java.sql.Date((DateUtil.stringToDate(tfDtInicio.getText().trim())).getTime());
                java.sql.Date dataSqlTermino = new java.sql.Date((DateUtil.stringToDate(tfDtTermino.getText().trim())).getTime());
                Destino destino = new Destino();
                destino.setCodigo(Integer.parseInt(tfCodigo.getText().trim()));
                destino.setDescricao(tfDescricao.getText().trim());
                destino.setDtInicio(dataSqlInicio);
                destino.setDtTermino(dataSqlTermino);
                destino.setVlTotal(0);
                destinoDAO.save(destino);
                JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso!!!");
                limparCampos();
                desabilitaCampos(false);
                carregaTable(destinoDAO.getAll());
            } else {
                JOptionPane.showMessageDialog(null, "Campo de Data não pode estar vazio");
            }
        } catch (NumberFormatException pex) {
            JOptionPane.showMessageDialog(null, "Campos estão preenchidos incorretamente");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
        MenuJDialog dialog = new MenuJDialog(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void rbCodigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbCodigoItemStateChanged
        habilitaFiltroCodigo();
    }//GEN-LAST:event_rbCodigoItemStateChanged

    private void rbDescricaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbDescricaoItemStateChanged
        tfCodigoFiltro.setText("");
        tfCodigoFiltro.setEnabled(false);
        tfDescricaoFiltro.setEnabled(true);
    }//GEN-LAST:event_rbDescricaoItemStateChanged

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        try {
            if (destinoDAO.getAll() != null) {
                if (tfCodigoFiltro.getText().trim().length() == 0
                        && tfDescricaoFiltro.getText().trim().length() == 0) {
                    carregaTable(destinoDAO.getAll());
                    return;
                }
                if (rbCodigo.isSelected() && tfCodigoFiltro.getText().trim().length() > 0) {//Codigo está selecionado
                    Destino destino = destinoDAO.getById(Integer.parseInt(tfCodigoFiltro.getText()));
                    List<Destino> destinoList = new ArrayList<>();
                    destinoList.add(destino);
                    carregaTable(destinoList);
                } else if (rbDescricao.isSelected() && tfDescricaoFiltro.getText().trim().length() > 0) {
                    carregaTable(destinoDAO.getByName(tfDescricaoFiltro.getText()));
                } else {
                    JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lista Vazia, Impossível Filtrar");
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Impossível filtrar código com letras");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DestinoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DestinoJDialog dialog = new DestinoJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void carregaTable(List<Destino> destinoList) {
        if (destinoList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbDestino.getModel();
        model.setRowCount(0);
        for (Destino d : destinoList) {
            model.addRow(new Object[]{d.getCodigo(), d.getDescricao(),
                d.getDtInicio(), d.getDtTermino(), d.getVlTotal()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbDescricao;
    private javax.swing.JTable tbDestino;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoFiltro;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfDescricaoFiltro;
    private javax.swing.JFormattedTextField tfDtInicio;
    private javax.swing.JFormattedTextField tfDtTermino;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {
        tfCodigo.setText("");
        tfDescricao.setText("");
        tfDtInicio.setText("");
        tfDtTermino.setText("");
    }

    private void desabilitaCampos(boolean ativo) {
        tfDescricao.setEnabled(ativo);
        tfDtInicio.setEnabled(ativo);
        tfDtTermino.setEnabled(ativo);
        btSalvar.setEnabled(ativo);
    }

    private void remover() {
        int linhaSeleciona = tbDestino.getSelectedRow();
        if (linhaSeleciona == - 1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para Remover");
            return;
        }
        try {
            int codigoRemover = (int) tbDestino.getValueAt(linhaSeleciona, 0);
            if (destinoDAO.getById(codigoRemover).getVlTotal() == 0) {
                try {
                    destinoDAO.delete(codigoRemover);
                    carregaTable(destinoDAO.getAll());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Impossivel remover Destino pois esta ligado a um Custo");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void habilitaFiltroCodigo() {
        tfDescricaoFiltro.setText("");
        tfDescricaoFiltro.setEnabled(false);
        tfCodigoFiltro.setEnabled(true);
    }

}
