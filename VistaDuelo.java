package Vista;

import Controlador.ControladorTablero;
import Modelo.Posicion;
import Modelo.Tablero;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Controlador.ControladorJugador;

public class VistaDuelo extends javax.swing.JDialog 
{
    
    private ControladorTablero CT;
    private ControladorJugador CJ2;
    public VistaDuelo(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        this.setResizable(false);
        initComponents();
        CT= new ControladorTablero();
        //panel para colocar la imagen
       // Icon icono = new ImageIcon(getClass().getResource("imagenes/Cat-party_2.gif"));
       // jcMousePanel1.setIcon(icono);
        for(int i=0; i<15; i++)
        {
            for(int j=0; j<15; j++)
            {
                this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
            }
        }
        
        this.accionARealizar.removeAllItems();
        this.orientacion.removeAllItems();
        this.formaDeDespliegue.removeAllItems();
        this.accionARealizar.addItem("Invocar");
        this.accionARealizar.addItem("Mover");
        this.accionARealizar.addItem("Atacar");
        this.accionARealizar.addItem("Ocupar magia");
        this.accionARealizar.addItem("Ocupar trampa");
        for (int i=1; i<11; i++)
        {
            this.formaDeDespliegue.addItem(String.valueOf(i));
        }
        for (int j=1; j<5; j++)
        {
            this.orientacion.addItem(String.valueOf(j));
        }
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcMousePanel1 = new jcMousePanel.jcMousePanel();
        Mapa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        accionARealizar = new javax.swing.JComboBox<>();
        formaDeDespliegue = new javax.swing.JComboBox<>();
        subAccion1 = new javax.swing.JLabel();
        subAccion2 = new javax.swing.JLabel();
        orientacion = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        MoverArriba = new javax.swing.JButton();
        MoverIzquierda = new javax.swing.JButton();
        MoverDerecha = new javax.swing.JButton();
        MoverAbajo = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcMousePanel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Wallpapersxl Yugioh Papel De Parede Yu Gi Oh 160903 1366x768.jpg"))); // NOI18N

        javax.swing.GroupLayout MapaLayout = new javax.swing.GroupLayout(Mapa);
        Mapa.setLayout(MapaLayout);
        MapaLayout.setHorizontalGroup(
            MapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        MapaLayout.setVerticalGroup(
            MapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Accion:");

        accionARealizar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        accionARealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionARealizarActionPerformed(evt);
            }
        });

        formaDeDespliegue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        formaDeDespliegue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaDeDespliegueActionPerformed(evt);
            }
        });

        subAccion1.setText("Forma de despliegue:");

        subAccion2.setText("Orientacion:");

        orientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("REALIZAR ACCION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cat-party_2.gif"))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VALE POR UN DADO");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("VALE POR UN DADO");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("VALE POR UN DADO");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("VALE POR UN DADO");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jButton2.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        jButton2.setText("Lanzar dados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        MoverArriba.setText("^");
        MoverArriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverArribaActionPerformed(evt);
            }
        });

        MoverIzquierda.setText("<");
        MoverIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverIzquierdaActionPerformed(evt);
            }
        });

        MoverDerecha.setText(">");
        MoverDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverDerechaActionPerformed(evt);
            }
        });

        MoverAbajo.setText("v");
        MoverAbajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverAbajoActionPerformed(evt);
            }
        });

        jButton7.setText("Ver estadísticas criatura");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jugador 1:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jugador 2:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Jugador 3:");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jugador 4:");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Turno Jugador:");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Cantidad de movimientos:");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("puntos de magias:");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("puntos de trampas:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jugador inicial:");

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Turno N°:");

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cantidad de ataques:");

        jButton8.setText("volver");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jcMousePanel1Layout = new javax.swing.GroupLayout(jcMousePanel1);
        jcMousePanel1.setLayout(jcMousePanel1Layout);
        jcMousePanel1Layout.setHorizontalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(Mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(accionARealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                                .addComponent(subAccion1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(formaDeDespliegue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                                .addComponent(subAccion2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(orientacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MoverAbajo)
                                            .addComponent(MoverArriba))))
                                .addGap(18, 18, 18)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                            .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel18)
                                    .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addComponent(MoverIzquierda)
                                .addGap(66, 66, 66)
                                .addComponent(MoverDerecha))
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17))
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel13)))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8)
                        .addContainerGap())))
        );
        jcMousePanel1Layout.setVerticalGroup(
            jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addComponent(Mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jcMousePanel1Layout.createSequentialGroup()
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accionARealizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18))
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)
                                .addGap(15, 15, 15)))
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(subAccion1)
                                .addComponent(formaDeDespliegue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(subAccion2)
                                .addComponent(orientacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(MoverArriba))
                            .addGroup(jcMousePanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jcMousePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MoverIzquierda)
                            .addComponent(MoverDerecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MoverAbajo)
                        .addGap(231, 231, 231))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcMousePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formaDeDespliegueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaDeDespliegueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_formaDeDespliegueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String accion= this.accionARealizar.getSelectedItem().toString();
        switch(accion)
        {
            case "Invocar":
                boolean confirmacionToqueBoton=CT.confirmacionToque();
                if(confirmacionToqueBoton==true)
                {
                    int filaADesplegar=this.CT.getCampoDeBatalla().getFilaBotonTocado();
                    int columnaADesplegar=this.CT.getCampoDeBatalla().getColumnaBotonTocado();
                    
                    int forma=Integer.parseInt(this.formaDeDespliegue.getSelectedItem().toString());
                    int orientacionADesplegar=Integer.parseInt(this.orientacion.getSelectedItem().toString());
                    
                    boolean confirmacionDespliege=CT.comprobacionDespliegue(filaADesplegar, columnaADesplegar, forma, orientacionADesplegar, CT.getCampoDeBatalla().getMatrizTABLERO());
                    
                    if(confirmacionDespliege==true)
                    {
                        CT.getCampoDeBatalla().setMatrizACTUALIZADORA(CT.agregarTerrenos(filaADesplegar, columnaADesplegar, forma, orientacionADesplegar, CT.getCampoDeBatalla().getMatrizTABLERO()));
                        CT.getCampoDeBatalla().setMatrizTABLERO(CT.actualizarUsos(CT.getCampoDeBatalla().getMatrizTABLERO(), CT.getCampoDeBatalla().getMatrizACTUALIZADORA()));
                        
                        for(int i=0; i<15; i++)
                        {
                            for(int j=0; j<15; j++)
                            {
                                this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
                            }
                        }
                        
                        CT.restaurarToque();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "La posicion escogida no es apta para la invocacion, por favor, escoja otra.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Escoga la posicion en la que desea invocar haciendo click sobre el tablero.");
                }
                break;
                
            
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void accionARealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionARealizarActionPerformed
        
    }//GEN-LAST:event_accionARealizarActionPerformed

    private void MoverIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverIzquierdaActionPerformed
       String accion= this.accionARealizar.getSelectedItem().toString();
       
                //DATOS CASILLA INICIAL
                int columnaInicial = CT.getCampoDeBatalla().getColumnaBotonTocado();
                int filaInicial = CT.getCampoDeBatalla().getFilaBotonTocado();
                 int casillaFinal = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial-1,filaInicial);
                  System.out.println(casillaFinal);
                int casillaInicial = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial);
                
               
                String TipoUso=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial).getTipoDeUso();
                boolean existenciaDelacriatura= TipoUso.equals("criatura");
                System.out.println(existenciaDelacriatura+"esta es el boolean de si hay criatura en el boton");
       //int CASILLAFINAL=Integer.parseInt(this.casillasFinales.getSelectedItem().toString());
       if (accion.equals("Mover")&& existenciaDelacriatura)
           
       {
          
          boolean usoCasillaFinal=CT.getCampoDeBatalla().getPosicion(columnaInicial-1,filaInicial).getUso();
         
           if (usoCasillaFinal)
               
           {
               
              CT.getCampoDeBatalla().setMatrizACTUALIZADORA(CT.realizarMovimiento(CT.getCampoDeBatalla().getMatrizTABLERO(),casillaFinal,casillaInicial));
            
              CT.getCampoDeBatalla().setMatrizTABLERO(CT.actualizarUsos(CT.getCampoDeBatalla().getMatrizTABLERO(), CT.getCampoDeBatalla().getMatrizACTUALIZADORA()));  
           for(int i=0; i<15; i++)
                    {
                        for(int j=0; j<15; j++)
                        {
                            this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "la casilla escogida no tiene una criatura a mover, escoja una que tenga criatira a mover");
                }
            /*
           }
           
              
       {
            boolean confirmacionToquecriatura=CT.confirmacionToque();
                if(confirmacionToquecriatura==true)
                {
                    
                }
                
           */
       
           }
    
       


    }//GEN-LAST:event_MoverIzquierdaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        CJ2.cerrarVistaDuelo(this);
        CJ2.llamarVistaPrincipal(CJ2);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void MoverArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverArribaActionPerformed

               String accion= this.accionARealizar.getSelectedItem().toString();
       
                //DATOS CASILLA INICIAL
                int columnaInicial = CT.getCampoDeBatalla().getColumnaBotonTocado();
                int filaInicial = CT.getCampoDeBatalla().getFilaBotonTocado();
                 int casillaFinal = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial-1);
                  System.out.println(casillaFinal);
                int casillaInicial = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial);
                
               
                String TipoUso=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial).getTipoDeUso();
                boolean existenciaDelacriatura= TipoUso.equals("criatura");
                System.out.println(existenciaDelacriatura+"esta es el boolean de si hay criatura en el boton");
       //int CASILLAFINAL=Integer.parseInt(this.casillasFinales.getSelectedItem().toString());
       if (accion.equals("Mover")&& existenciaDelacriatura)
           
       {
          
          boolean usoCasillaFinal=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial-1).getUso();
         
           if (usoCasillaFinal)
               
           {
               
              CT.getCampoDeBatalla().setMatrizACTUALIZADORA(CT.realizarMovimiento(CT.getCampoDeBatalla().getMatrizTABLERO(),casillaFinal,casillaInicial));
            
              CT.getCampoDeBatalla().setMatrizTABLERO(CT.actualizarUsos(CT.getCampoDeBatalla().getMatrizTABLERO(), CT.getCampoDeBatalla().getMatrizACTUALIZADORA()));  
           for(int i=0; i<15; i++)
                    {
                        for(int j=0; j<15; j++)
                        {
                            this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "la casilla escogida no tiene una criatura a mover, escoja una que tenga criatira a mover");
                }

       }

    }//GEN-LAST:event_MoverArribaActionPerformed

    private void MoverDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverDerechaActionPerformed
String accion= this.accionARealizar.getSelectedItem().toString();
       
                //DATOS CASILLA INICIAL
                int columnaInicial = CT.getCampoDeBatalla().getColumnaBotonTocado();
                int filaInicial = CT.getCampoDeBatalla().getFilaBotonTocado();
                 int casillaFinal = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial+1,filaInicial);
                  System.out.println(casillaFinal);
                int casillaInicial = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial);
                
               
                String TipoUso=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial).getTipoDeUso();
                boolean existenciaDelacriatura= TipoUso.equals("criatura");
                System.out.println(existenciaDelacriatura+"esta es el boolean de si hay criatura en el boton");
       //int CASILLAFINAL=Integer.parseInt(this.casillasFinales.getSelectedItem().toString());
       if (accion.equals("Mover")&& existenciaDelacriatura)
           
       {
          
          boolean usoCasillaFinal=CT.getCampoDeBatalla().getPosicion(columnaInicial+1,filaInicial).getUso();
         
           if (usoCasillaFinal)
               
           {
               
              CT.getCampoDeBatalla().setMatrizACTUALIZADORA(CT.realizarMovimiento(CT.getCampoDeBatalla().getMatrizTABLERO(),casillaFinal,casillaInicial));
            
              CT.getCampoDeBatalla().setMatrizTABLERO(CT.actualizarUsos(CT.getCampoDeBatalla().getMatrizTABLERO(), CT.getCampoDeBatalla().getMatrizACTUALIZADORA()));  
           for(int i=0; i<15; i++)
                    {
                        for(int j=0; j<15; j++)
                        {
                            this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "la casilla escogida no tiene una criatura a mover, escoja una que tenga criatira a mover");
                }

       }
    }//GEN-LAST:event_MoverDerechaActionPerformed

    private void MoverAbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverAbajoActionPerformed

        String accion= this.accionARealizar.getSelectedItem().toString();
       
                //DATOS CASILLA INICIAL
                int columnaInicial = CT.getCampoDeBatalla().getColumnaBotonTocado();
                int filaInicial = CT.getCampoDeBatalla().getFilaBotonTocado();
                 int casillaFinal = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial+1);
                  System.out.println(casillaFinal);
                int casillaInicial = CT.getCampoDeBatalla().getNumeroDeCasillaSegunFilaYColumna(columnaInicial,filaInicial);
                
               
                String TipoUso=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial).getTipoDeUso();
                boolean existenciaDelacriatura= TipoUso.equals("criatura");
                System.out.println(existenciaDelacriatura+"esta es el boolean de si hay criatura en el boton");
       //int CASILLAFINAL=Integer.parseInt(this.casillasFinales.getSelectedItem().toString());
       if (accion.equals("Mover")&& existenciaDelacriatura)
           
       {
          
          boolean usoCasillaFinal=CT.getCampoDeBatalla().getPosicion(columnaInicial,filaInicial+1).getUso();
         
           if (usoCasillaFinal)
               
           {
               
              CT.getCampoDeBatalla().setMatrizACTUALIZADORA(CT.realizarMovimiento(CT.getCampoDeBatalla().getMatrizTABLERO(),casillaFinal,casillaInicial));
            
              CT.getCampoDeBatalla().setMatrizTABLERO(CT.actualizarUsos(CT.getCampoDeBatalla().getMatrizTABLERO(), CT.getCampoDeBatalla().getMatrizACTUALIZADORA()));  
           for(int i=0; i<15; i++)
                    {
                        for(int j=0; j<15; j++)
                        {
                            this.Mapa.add(CT.getCampoDeBatalla().getBotonTablero(i,j));
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "la casilla escogida no tiene una criatura a mover, escoja una que tenga criatira a mover");
                }

       }
    }//GEN-LAST:event_MoverAbajoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setCJ2(ControladorJugador CJ2) 
    {
        this.CJ2 = CJ2;
    }
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
            java.util.logging.Logger.getLogger(VistaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaDuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaDuelo dialog = new VistaDuelo(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Mapa;
    private javax.swing.JButton MoverAbajo;
    private javax.swing.JButton MoverArriba;
    private javax.swing.JButton MoverDerecha;
    private javax.swing.JButton MoverIzquierda;
    private javax.swing.JComboBox<String> accionARealizar;
    private javax.swing.JComboBox<String> formaDeDespliegue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private jcMousePanel.jcMousePanel jcMousePanel1;
    private javax.swing.JComboBox<String> orientacion;
    private javax.swing.JLabel subAccion1;
    private javax.swing.JLabel subAccion2;
    // End of variables declaration//GEN-END:variables
}
