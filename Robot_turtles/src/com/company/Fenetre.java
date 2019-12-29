package com.company;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

public class Fenetre extends JFrame implements ActionListener {
    public static int numberOfPlayers;
    public   JFrame window= new JFrame("Robot Turtles");
    private JButton buttons2p = new JButton("2 Joueurs");
    private JButton buttons3p = new JButton("3 Joueurs");
    private JButton buttons4p = new JButton("4 Joueurs");
    public static Panneau scene;
    private ImageIcon logo= new ImageIcon(getClass().getResource("/images/logo.png"));
    public boolean endGame =false;
    private JPanel bannerPanel;
    private JLabel bannerLabel;
    public Fenetre() {

        window.setSize(1420, 800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        bannerLabel = new JLabel();
        bannerLabel.setIcon(new ImageIcon(getClass().getResource("/images/logo.png")));
        bannerPanel = new JPanel();
        bannerPanel.add(bannerLabel);
        bannerPanel.setPreferredSize(new Dimension(400, 250));
        bannerPanel.setBackground(Color.LIGHT_GRAY);
        buttons2p.addActionListener(this);
        buttons3p.addActionListener(this);
        buttons4p.addActionListener(this);


        JPanel twopPanel = new JPanel(new GridLayout(1, 1));
        twopPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 25));
        twopPanel.add(buttons2p);

         JPanel threepPanel = new JPanel(new GridLayout(1, 1));
        threepPanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 50));
        threepPanel.add(buttons3p);

       JPanel fourpPanel = new JPanel(new GridLayout(1, 1));
        fourpPanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 50));
        fourpPanel.add(buttons4p);



        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));
        buttonsPanel.setPreferredSize(new Dimension(40, 400));
        buttonsPanel.add(twopPanel);
        buttonsPanel.add(threepPanel);
        buttonsPanel.add(fourpPanel);
        window.add(bannerPanel, BorderLayout.NORTH);
        window.add(buttonsPanel, BorderLayout.SOUTH);



    window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals("2 Joueurs")) {
           numberOfPlayers=2;
           scene = new Panneau(numberOfPlayers);
           window.setContentPane(scene);

           window.setVisible(true);}


       else if(e.getActionCommand().equals("3 Joueurs")){
           numberOfPlayers=3;
           scene = new Panneau(numberOfPlayers);
           window.setContentPane(scene);
            window.setVisible(true);
       }
       else if(e.getActionCommand().equals("4 Joueurs")){
           numberOfPlayers=4;
           scene = new Panneau(numberOfPlayers);
           window.setContentPane(scene);
            window.setVisible(true);
       }
       }



}



