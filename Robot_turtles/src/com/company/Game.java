package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements ActionListener {

    private static JPanel gamePanel = new JPanel();

    private JButton button1 = new JButton("Executer le programme");
    private JButton button2 = new JButton("Ajouter au programme");
    private JButton button3 = new JButton("Construire un mur");
    private JButton button4 = new JButton("");

    //Définition des coordonnées des murs
    private int xpos;
    private int ypos;


    private ImageIcon icoBackground;
    private Image imgbackground;

    private ImageIcon stoneWall= new ImageIcon(getClass().getResource("/images/tiles/S.png"));
    public  static int numberOfPlayers;
    private static int playersInGame;

    private  ImageIcon imgYellowCard= new ImageIcon(getClass().getResource("/images/cards/y.png"));
    private  ImageIcon  imgPurpleCard= new ImageIcon(getClass().getResource("/images/cards/p.png"));
    private  ImageIcon  imgLaserCard= new ImageIcon(getClass().getResource("/images/cards/l.png"));
    private  ImageIcon  imgBlueCard= new ImageIcon(getClass().getResource("/images/cards/b.png"));
    private  ImageIcon imgBackCard = new ImageIcon(getClass().getResource("/images/cards/backCard.jpeg"));
    private  ImageIcon  imgIceWall= new ImageIcon(getClass().getResource("/images/tiles/I.png"));
    private  ImageIcon  imgStoneWall= new ImageIcon(getClass().getResource("/images/tiles/S.png"));



    //Panel pour les boutons
    private JPanel rightPan = new JPanel();
    //Panel pour afficher les cartes
    private JPanel cards =new JPanel();

    public static char[][] plateau;
    //Liste qui va stocker les joueurs
    public static ArrayList<Player> players = new ArrayList<>();
    //Liste qui va stocker les murs
    public static ArrayList<Wall> walls = new ArrayList<>();
    //Liste qui va stocker les joyaux
    public static ArrayList<Gem> gems = new ArrayList<>();
    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;
    public static Gem gem1;
    public static Gem gem2;
    public static Gem gem3;
    //Pour savoir à qui le tour
    private static int z=0;




    public static Player player;
    public Game(int numberOfPlayers) {


        //Plateau de jeu
        plateau = new char[8][8];

        //Fond
        icoBackground = new ImageIcon(getClass().getResource("/images/background.jpg"));
        this.imgbackground = this.icoBackground.getImage();
        this.numberOfPlayers = numberOfPlayers;

        if (numberOfPlayers == 2) {

            Cards deckP1 = new Cards();
            Cards deckP2 = new Cards();
            player1 = new Player('B', 'S', new int[]{0, 2}, new int[]{0, 2}, deckP1);
            player2 = new Player('P', 'S', new int[]{0, 5}, new int[]{0, 5}, deckP2);
            gem1 = new Gem('b', new int[]{7, 2});
            gem2 = new Gem('p', new int[]{7, 5});
            players.add(player1);
            players.add(player2);
            gems.add(gem1);
            gems.add(gem2);
            initializeBoard();
            updateBoard(player1.getPosition(),player1.getTurtleName());
            updateBoard(player2.getPosition(),player2.getTurtleName());
            updateBoard(gem1.getGemPosition(),gem1.getGemcolor());
            updateBoard(gem2.getGemPosition(),gem2.getGemcolor());

        } else if (numberOfPlayers == 3) {
            Cards deckP1 = new Cards();
            Cards deckP2 = new Cards();
            Cards deckP3 = new Cards();
            player1 = new Player('B', 'S', new int[]{0, 0}, new int[]{0, 0}, deckP1);
            player2 = new Player('P', 'S', new int[]{0, 3}, new int[]{0, 3}, deckP2);
            player3 = new Player('R', 'S', new int[]{0, 6}, new int[]{0, 6}, deckP3);
            gem1 = new Gem('b', new int[]{7, 0});
            gem2 = new Gem('p', new int[]{7, 3});
            gem3 = new Gem('r', new int[]{7, 6});
            initializeBoard();

            players.add(player1);
            players.add(player2);
            players.add(player3);
            gems.add(gem1);
            gems.add(gem2);
            gems.add(gem3);
            updateBoard(player1.getPosition(),player1.getTurtleName());
            updateBoard(player2.getPosition(),player2.getTurtleName());
            updateBoard(player3.getPosition(),player3.getTurtleName());
            updateBoard(gem1.getGemPosition(),gem1.getGemcolor());
            updateBoard(gem2.getGemPosition(),gem2.getGemcolor());
            updateBoard(gem3.getGemPosition(),gem3.getGemcolor());

        } else if (numberOfPlayers == 4) {
            Cards deckP1 = new Cards();
            Cards deckP2 = new Cards();
            Cards deckP3 = new Cards();
            Cards deckP4 = new Cards();
            player1 = new Player('B', 'S', new int[]{0, 0}, new int[]{0, 0}, deckP1);
            player2 = new Player('P', 'S', new int[]{0, 2}, new int[]{0, 2}, deckP2);
            player3 = new Player('R', 'S', new int[]{0, 5}, new int[]{0, 5}, deckP3);
            player4 = new Player('D', 'S', new int[]{0, 7}, new int[]{0, 7}, deckP4);
            gem1 = new Gem('b', new int[]{7, 1});
            gem2 = new Gem('p', new int[]{7, 6});
            initializeBoard();

            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);
            gems.add(gem1);
            gems.add(gem2);
            updateBoard(player1.getPosition(),player1.getTurtleName());
            updateBoard(player2.getPosition(),player2.getTurtleName());
            updateBoard(player3.getPosition(),player3.getTurtleName());
            updateBoard(player4.getPosition(),player4.getTurtleName());
            updateBoard(gem1.getGemPosition(),gem1.getGemcolor());
            updateBoard(gem2.getGemPosition(),gem2.getGemcolor());


        }



        //définition de la taille du panel et de la localisation
        gamePanel.setLocation(900,10);
        gamePanel.setSize(200,200);
        gamePanel.setOpaque(true);
        gamePanel.setBackground(new Color(0,0,0,0));
        rightPan.setLocation(760,250);
        rightPan.setSize(500,200);
        //On rend le fond transparent
        rightPan.setOpaque(true);
        rightPan.setBackground(new Color(0,0,0,0));
        cards.setOpaque(true);
        cards.setBackground(new Color(0,0,0,0));

        //On ajoute au panel principal
        this.add(gamePanel);
        this.add(rightPan);

        //On dit que le bouton pourra subir une action
        button4.addActionListener(this);
        button3.addActionListener(this);
        button2.addActionListener(this);
        button1.addActionListener(this);
        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);



        rightPan.add(cards);

        playersInGame=numberOfPlayers;
        player=turn();
        this.setVisible(true);



    }



    public Game() {

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int CASE_DIM = 85;

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.imgbackground, 0, 0, null);
//Tracage du plateau
        g2.setStroke(new BasicStroke(2));
        g2.setPaint(Color.getHSBColor(38, 44, 71));
        g2.fill(new Rectangle2D.Double(CASE_DIM, CASE_DIM, 8 * CASE_DIM, 8 * CASE_DIM));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g2.setPaint(Color.BLACK);
                g2.setStroke(new BasicStroke(2));
                g2.draw(new Rectangle2D.Double((j + 1) * CASE_DIM, (i + 1) * CASE_DIM, CASE_DIM, CASE_DIM));
            }
        }

        //Initialisation du plateau en fonction du nombre de joueurs
        if(numberOfPlayers>=2) {
            if (!player1.isWin()) {
                (player1.getImgPlayer()).paintIcon(null, g2, (player1.getPosition()[1] + 1) * CASE_DIM, (player1.getPosition()[0] + 1) * CASE_DIM);
            }
            if (!player2.isWin()) {
                (player2.getImgPlayer()).paintIcon(null, g2, (player2.getPosition()[1] + 1) * CASE_DIM, (player2.getPosition()[0] + 1) * CASE_DIM);
            }
            (gem1.getImggem()).paintIcon(null, g2, (gem1.getGemPosition()[1] + 1) * CASE_DIM, (gem1.getGemPosition()[0] + 1) * CASE_DIM);
            (gem2.getImggem()).paintIcon(null, g2, (gem2.getGemPosition()[1] + 1) * CASE_DIM, (gem2.getGemPosition()[0] + 1) * CASE_DIM);
            if (numberOfPlayers == 2 || numberOfPlayers == 3) {
                for (int i = 0; i < 8; i++) {
                    stoneWall.paintIcon(null, g2, 8 * CASE_DIM, (i + 1) * CASE_DIM);
                }
            }
        }
                if(numberOfPlayers>=3) {
                    if (!player3.isWin()) {
                        (player3.getImgPlayer()).paintIcon(null, g2, (player3.getPosition()[1] + 1) * CASE_DIM, (player3.getPosition()[0] + 1) * CASE_DIM);
                    }

                    (gem1.getImggem()).paintIcon(null, g2, (gem1.getGemPosition()[1] + 1) * CASE_DIM, (gem1.getGemPosition()[0] + 1) * CASE_DIM);
                    (gem2.getImggem()).paintIcon(null, g2, (gem2.getGemPosition()[1] + 1) * CASE_DIM, (gem2.getGemPosition()[0] + 1) * CASE_DIM);
                    if(numberOfPlayers==3){
                    (gem3.getImggem()).paintIcon(null, g2, (gem3.getGemPosition()[1] + 1) * CASE_DIM, (gem3.getGemPosition()[0] + 1) * CASE_DIM);}
                }
                if(numberOfPlayers>3){
                    if(!player4.isWin()){
                (player4.getImgPlayer()).paintIcon(null, g2, (player4.getPosition()[1]+1)* CASE_DIM, (player4.getPosition()[0]+1)*CASE_DIM);}

                    }
                //fonction qui trace les murs
        paintPlayersWalls(CASE_DIM,g2);
        Font policeGame= new Font("Arial",Font.BOLD,20);
        g2.setFont(policeGame);
        //fonction affiche le nom de la tortue quand c'est son tour
                if(player.getTurtleName()=='B'){
                    g2.drawString("Au tour de Beep",200,50);
                }
                else if(player.getTurtleName()=='P'){
                    g2.drawString("Au tour de Pangle",200,50);
                }
                else  if(player.getTurtleName()=='D'){
                    g2.drawString("Au tour de Dot",200,50);
                }

                else  if(player.getTurtleName()=='R'){
                    g2.drawString("Au tour de Pi",200,50);
                }


        if(playersInGame==1){
            Font policeEnd = new Font("Arial",Font.BOLD,50);
            g2.setFont(policeEnd);
            if(players.get(0).getTurtleName()=='B'){
                g2.drawString("Fin de la partie! Beep a perdu",300,400);
            }
            else if(players.get(0).getTurtleName()=='P'){
                g2.drawString("Fin de la partie! Pangle a perdu",300,400);
            }
            else  if(players.get(0).getTurtleName()=='D'){
                g2.drawString("Fin de la partie! Dot a perdu",300,400);
            }

            else  if(players.get(0).getTurtleName()=='R'){
                g2.drawString("Fin de la partie! Pi à perdu",300,400);
            }

        }
        }


    private Player turn(){
        printBoard();
        Player ans;

            if(z>playersInGame-1){
                z=0;
            }
            ans =players.get(z);
            repaint();

            //}


        return ans;
    }



    private static void initializeBoard()
    {

            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    plateau[i][j] = ' ';
                }
            }
        if(numberOfPlayers==2||numberOfPlayers==3) {
            for (int i = 0; i <= 7; i++) {
                    plateau[i][7] = 'S';
                }
            }


    }

    private static void updateBoard(int[] position,char object){

        plateau[position[0]][position[1]]= object;
    }





    private void addToProgram(){
        //On regarde si le joueur à moins de 5 cartes
        if(player.getDeck().deck.size()>0) {
            if ((player.getDeck().getPlayerHand()).size() < 5) {
                (player.getDeck()).fiveCardToPlayerHand();
            }
        }
        /*Pour chaque carte on crée un Jlabel
        * On associe une action au Jlabel
        * Si on clique dessus on ajoute la carte dans la file d'instruction
        * */
        for (int i=0;i<player.getDeck().getPlayerHand().size();i++) {
            if (player.getDeck().getPlayerHand().get(i) == 'b') {
                JLabel blueCard = new JLabel(imgBlueCard);
                cards.add(blueCard);
                cards.revalidate();

                cards.repaint();

                blueCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        player.getDeck().addCardToPlayerHand('b');
                        cards.remove(blueCard);
                        cards.revalidate();
                        cards.repaint();

                    }
                });
            } else if (player.getDeck().getPlayerHand().get(i) == 'y') {
                JLabel yellowCard = new JLabel(imgYellowCard);
                cards.add(yellowCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();
                yellowCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        player.getDeck().addCardToPlayerHand('y');
                        cards.remove(yellowCard);
                        cards.revalidate();
                        cards.repaint();
                    }
                });
            } else if (player.getDeck().getPlayerHand().get(i) == 'p') {
                JLabel purpleCard = new JLabel(imgPurpleCard);
                cards.add(purpleCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();
                purpleCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        player.getDeck().addCardToPlayerHand('p');
                        cards.remove(purpleCard);
                        cards.revalidate();
                        cards.repaint();
                    }
                });
            } else if (player.getDeck().getPlayerHand().get(i) == 'l') {
                JLabel laserCard = new JLabel(imgLaserCard);
                cards.add(laserCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();
                laserCard.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        player.getDeck().addCardToPlayerHand('l');
                        cards.remove(laserCard);
                        cards.revalidate();
                        cards.repaint();
                    }
                });
            }
        }
        //Pour changer le nom de boutons on utilise setText
        button3.setText("");
        button1.setText("Défausser");
        button2.setText("Finir le tour");
        gamePanel.revalidate();
        gamePanel.repaint();




    }

    private void executeProgram(){
        //On ajoute 5 cartes dans sa main s'il n'en à pas 5 pour qu'il puisse les défausser
        if(player.getDeck().deck.size()>0) {
            if ((player.getDeck().getPlayerHand()).size() < 5) {
                (player.getDeck()).fiveCardToPlayerHand();
            }
        }
        int departSize = player.getDeck().getHiddenCards().size();
        for (int i=0;i<departSize;i++){
            char playerCard = player.getDeck().getHiddenCards().pop();
            if (playerCard=='b'){
                player.getDeck().blueEffect(player);
                JLabel blueCard = new JLabel(imgBlueCard);
                cards.add(blueCard);
                cards.revalidate();
                cards.repaint();
                repaint();
            }
            else if(playerCard=='p'){
                player.getDeck().purpleEffect(player);
                JLabel purpleCard = new JLabel(imgPurpleCard);
                cards.add(purpleCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();
                repaint();

            }
            else if(playerCard=='y'){
                player.getDeck().yellowEffect(player);
                JLabel yellowCard = new JLabel(imgYellowCard);
                cards.add(yellowCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();
                repaint();

            }
            else if(playerCard=='l'){
                player.getDeck().laserEffect(player);
                JLabel laserCard = new JLabel(imgLaserCard);
                cards.add(laserCard,BorderLayout.EAST);
                cards.revalidate();
                cards.repaint();

            }


        }


        button1.setText(" ");
        button2.setText("Défausser");
        button3.setText("Finir le tour");
        gamePanel.repaint();

    }


    private void buildWall() {
        if(player.getDeck().deck.size()>0) {
            if ((player.getDeck().getPlayerHand()).size() < 5) {
                (player.getDeck()).fiveCardToPlayerHand();
            }
        }
        if(player.getNumberofStoneWall()>0){
        button1.setText("Mur de pierre");}
        else{
            button1.setText("");
        }
        if(player.getNumberofIceWall()>0){
        button2.setText("Mur de glace");}
        else{
            button2.setText("");
        }
        button3.setText("Finir le tour");
        gamePanel.repaint();


    }
    /*
     *Fonction pour voir si la case est vide
     *
     */

    private static boolean isEmpty(int posX, int posY) {
        boolean ans=true;
        if(plateau[posX][posY]!=' '){
            ans=false;
        }
        return ans;
    }

    /*
     *Fonction pour voir si la tortue est bloquée
     * On fait un try catch pour voir s'il y a un objet si oui
     *On regarde si c'est un joyau ou un joueur
     * si non on lui laisse placer son mur
     * Si c'est un joueur ou un joyau
     * Un refait un try catch si la case n'existe pas
     * On ajoute 1 au compteur car les bordures du plateau comptent comme un obstacle indestructible
     */

    private static boolean blocked(int posX, int posY) {


        try{
            if(plateau[posX-1][posY]!=' ') {
                if (isPlayer(posX - 1, posY)||isGem(posX-1,posY)) {
                    return checkElement(posX + 1, posY);
                }
            }

            }
        catch(IndexOutOfBoundsException e){ }
        try{
            if(plateau[posX+1][posY]!=' ') {
                if(isPlayer(posX+1,posY)||isGem(posX+1,posY)){
                return checkElement(posX+1,posY);}
            }
        }
        catch(IndexOutOfBoundsException e){ }
        try{
            if(plateau[posX][posY+1]!=' ') {
                if(isPlayer(posX,posY+1)||isGem(posX,posY+1)){
                return checkElement(posX,posY+1);}
            }
        }
        catch(IndexOutOfBoundsException e){ }
        try{
            if(plateau[posX][posY-1]!=' ') {
                if(isPlayer(posX,posY-1)||isGem(posX,posY-1)){
                    return checkElement(posX,posY-1);
                }
            }
        }
        catch(IndexOutOfBoundsException e){ }

        return false;
    }
    private static boolean checkElement(int posX, int posY){
    int counter=0;

        try{
            if(plateau[posX-1][posY]=='S') {
               counter++;
            }
        }
        catch(IndexOutOfBoundsException e){
            counter++;
        }
        try{
            if(plateau[posX+1][posY]=='S') {
                counter++;
            }
        }
        catch(IndexOutOfBoundsException e){
            counter++;
        }
        try{
            if(plateau[posX][posY+1]=='S') {
                counter++;
            }
        }
        catch(IndexOutOfBoundsException e){
                counter++;
        }
        try{
            if(plateau[posX][posY-1]=='S') {
                counter++;
            }
        }
        catch(IndexOutOfBoundsException e){
                counter++;
        }
    if(counter==3){
    return true;}

    return false;

    }

    private static boolean isPlayer(int x, int y){
    for (int i=0;i<players.size();i++){
    if (plateau[x][y]==players.get(i).getTurtleName()){
        return true;
    }
    }
    return false;

        }
    private static boolean isGem(int x, int y) {
        for (int j = 0; j < gems.size(); j++) {
            if (plateau[x][y] == gems.get(j).getGemcolor()) {
                return true;

            }
        }
        return false;
    }






//Revalidate et repaint() , servent à repeindre la fenetre

//Ici on regarde sur quel bouton à cliqué l'utilisateur
    @Override
    public void actionPerformed(ActionEvent e) {



         if(e.getActionCommand().equals("Construire un mur")){
           buildWall();
        }

        else if(e.getActionCommand().equals("Ajouter au programme")){
         addToProgram();
        }
         else if(e.getActionCommand().equals("Executer le programme")){
             executeProgram();
         }
        if(e.getActionCommand().equals("Défausser")){
            Component[] components = cards.getComponents();

            for (Component component : components) {
                cards.remove(component);
            }

            cards.revalidate();
            cards.repaint();
            for (int i=0;i<player.getDeck().getPlayerHand().size();i++) {
                if (player.getDeck().getPlayerHand().get(i) == 'b') {
                    JLabel blueCard = new JLabel(imgBlueCard);
                    cards.add(blueCard);
                    cards.revalidate();
                    cards.repaint();

                    blueCard.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            player.getDeck().cardToDiscard('b');
                            cards.remove(blueCard);
                            cards.revalidate();
                            cards.repaint();

                        }
                    });
                } else if (player.getDeck().getPlayerHand().get(i) == 'y') {
                    JLabel yellowCard = new JLabel(imgYellowCard);
                    cards.add(yellowCard,BorderLayout.EAST);
                    cards.revalidate();
                    cards.repaint();
                    yellowCard.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            player.getDeck().cardToDiscard('y');
                            cards.remove(yellowCard);
                            cards.revalidate();
                            cards.repaint();
                        }
                    });
                } else if (player.getDeck().getPlayerHand().get(i) == 'p') {
                    JLabel purpleCard = new JLabel(imgPurpleCard);
                    cards.add(purpleCard,BorderLayout.EAST);
                    cards.revalidate();
                    cards.repaint();
                    purpleCard.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            player.getDeck().cardToDiscard('p');
                            cards.remove(purpleCard);
                            cards.revalidate();
                            cards.repaint();
                        }
                    });
                } else if (player.getDeck().getPlayerHand().get(i) == 'l') {
                    JLabel laserCard = new JLabel(imgLaserCard);
                    cards.add(laserCard,BorderLayout.EAST);
                    cards.revalidate();
                    cards.repaint();
                    laserCard.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            player.getDeck().cardToDiscard('l');
                            cards.remove(laserCard);
                            cards.revalidate();
                            cards.repaint();
                        }
                    });
                }
            }
        }
        if(e.getActionCommand().equals("Finir le tour")){
            if(player.isWin()){
                this.remove(player);
                plateau[player.getPosition()[0]][player.getPosition()[1]]=' ';
                players.remove(z);
                playersInGame--;
            }
            button1.setText("Executer le programme");
           button2.setText("Ajouter au programme");
           button3.setText("Construire un mur");
           gamePanel.remove(button4);

            gamePanel.revalidate();
            gamePanel.repaint();
            repaint();

            Component[] components = cards.getComponents();

            for (Component component : components) {
                cards.remove(component);
            }

            cards.revalidate();
            cards.repaint();

            z++;
            repaint();
            player=turn();
        }

        if(e.getActionCommand().equals("Mur de pierre")){
            button2.setText("Défausser");
            button1.setText("");

            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    int x = e.getX();
                    int y = e.getY();
                    xpos = 99;
                    ypos = 1;
                    if (player.getNumberofStoneWall() == 3) {
                        xpos = player.getStoneWall().getWallPos()[0];
                        ypos = player.getStoneWall().getWallPos()[1];
                    } else if (player.getNumberofStoneWall() == 2) {
                        xpos = player.getStoneWall2().getWallPos()[0];
                        ypos = player.getStoneWall2().getWallPos()[1];
                    } else if (player.getNumberofStoneWall() == 1) {
                        xpos = player.getStoneWall3().getWallPos()[0];
                        ypos = player.getStoneWall3().getWallPos()[1];
                    }

                    if (x > 85 && x < 170) {
                        ypos = 0;
                    } else if (x > 170 && x < 256) {
                        ypos = 1;
                    } else if (x > 256 && x < 339) {
                        ypos = 2;
                    } else if (x > 339 && x < 425) {
                        ypos = 3;
                    } else if (x > 425 && x < 511) {
                        ypos = 4;
                    } else if (x > 511 && x < 594) {
                        ypos = 5;
                    } else if (x > 594 && x < 683) {
                        ypos = 6;
                    } else if (x > 683 && x < 766) {
                        ypos = 7;
                    }

                    if (y > 86 && y < 166) {
                        xpos = 0;
                    } else if (y > 166 && y < 255) {
                        xpos = 1;
                    } else if (y > 255 && y < 341) {
                        xpos = 2;
                    } else if (y > 341 && y < 423) {
                        xpos = 3;
                    } else if (y > 423 && y < 506) {
                        xpos = 4;
                    } else if (y > 506 && y < 597) {
                        xpos = 5;
                    } else if (y > 597 && y < 678) {
                        xpos = 6;
                    } else if (y > 678 && y < 766) {
                        xpos = 7;
                    }

                    if (!blocked(xpos, ypos)) {
                        if (isEmpty(xpos, ypos)) {
                            if (player.getNumberofStoneWall() == 3) {
                                player.getStoneWall().setWallPos(new int[]{xpos, ypos});
                                walls.add(player.getStoneWall());
                            } else if (player.getNumberofStoneWall() == 2) {
                                player.getStoneWall2().setWallPos(new int[]{xpos, ypos});
                                walls.add(player.getStoneWall2());
                            } else if (player.getNumberofStoneWall() == 1) {
                                player.getStoneWall3().setWallPos(new int[]{xpos, ypos});
                                walls.add(player.getStoneWall3());
                            }
                            repaint();
                            plateau[xpos][ypos] = 'S';
                            player.reduceNumberofStoneWall();
                            removeMouseListener(this);
                        }
                    }
                }



            });


        }


        if(e.getActionCommand().equals("Mur de glace")){
            button2.setText("Défausser");
            button1.setText("");



            this.addMouseListener(new MouseAdapter() {


                @Override
                public void mouseClicked(MouseEvent e) {

                        int x = e.getX();
                        int y = e.getY();
                        xpos = 99;
                        ypos = 1;
                        if (player.getNumberofIceWall() == 2) {
                            xpos = player.getIceWall().getWallPos()[0];
                            ypos = player.getIceWall().getWallPos()[1];
                        } else if (player.getNumberofIceWall() == 1) {
                            xpos = player.getIceWall2().getWallPos()[0];
                            ypos = player.getIceWall2().getWallPos()[1];
                        }


                        if (x > 85 && x < 170) {
                            ypos = 0;
                        } else if (x > 170 && x < 256) {
                            ypos = 1;
                        } else if (x > 256 && x < 339) {
                            ypos = 2;
                        } else if (x > 339 && x < 425) {
                            ypos = 3;
                        } else if (x > 425 && x < 511) {
                            ypos = 4;
                        } else if (x > 511 && x < 594) {
                            ypos = 5;
                        } else if (x > 594 && x < 683) {
                            ypos = 6;
                        } else if (x > 683 && x < 766) {
                            ypos = 7;
                        }

                        if (y > 86 && y < 166) {
                            xpos = 0;
                        } else if (y > 166 && y < 255) {
                            xpos = 1;
                        } else if (y > 255 && y < 341) {
                            xpos = 2;
                        } else if (y > 341 && y < 423) {
                            xpos = 3;
                        } else if (y > 423 && y < 506) {
                            xpos = 4;
                        } else if (y > 506 && y < 597) {
                            xpos = 5;
                        } else if (y > 597 && y < 678) {
                            xpos = 6;
                        } else if (y > 678 && y < 766) {
                            xpos = 7;
                        }
                            if (isEmpty(xpos, ypos)) {
                                if (player.getNumberofIceWall() == 2) {
                                    player.getIceWall().setWallPos(new int[]{xpos, ypos});
                                    walls.add(player.getIceWall());
                                } else if (player.getNumberofIceWall() == 1) {
                                    player.getIceWall2().setWallPos(new int[]{xpos, ypos});
                                    walls.add(player.getIceWall2());
                                }
                                repaint();
                                plateau[xpos][ypos] = 'I';
                                player.reduceNumberofIceWall();
                                removeMouseListener(this);
                            }
                        }




            });


        }








    }


    private void paintPlayersWalls(int CASE_DIM,Graphics2D g2){

        if(numberOfPlayers>=2) {
            imgIceWall.paintIcon(null, g2, (player1.getIceWall().getWallPos()[1] + 1) * CASE_DIM, (player1.getIceWall().getWallPos()[0] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player1.getIceWall2().getWallPos()[1] + 1) * CASE_DIM, (player1.getIceWall2().getWallPos()[0] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall().getWallPos()[1] + 1) * CASE_DIM, (player1.getStoneWall().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM, (player1.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM, (player1.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM);

            imgIceWall.paintIcon(null, g2, (player2.getIceWall().getWallPos()[1] + 1) * CASE_DIM, (player2.getIceWall().getWallPos()[0] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player2.getIceWall2().getWallPos()[1] + 1) * CASE_DIM, (player2.getIceWall2().getWallPos()[0] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall().getWallPos()[1] + 1) * CASE_DIM, (player2.getStoneWall().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM, (player2.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM, (player2.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM);

        }
        if (numberOfPlayers>=3){
            imgIceWall.paintIcon(null, g2, (player3.getIceWall().getWallPos()[1] + 1) * CASE_DIM, (player3.getIceWall().getWallPos()[0] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player3.getIceWall2().getWallPos()[1] + 1) * CASE_DIM, (player3.getIceWall2().getWallPos()[0] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall().getWallPos()[1] + 1) * CASE_DIM, (player3.getStoneWall().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM, (player3.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM, (player3.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM);

        }
        if(numberOfPlayers==4){
            imgIceWall.paintIcon(null, g2, (player4.getIceWall().getWallPos()[1] + 1) * CASE_DIM, (player4.getIceWall().getWallPos()[0] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player4.getIceWall2().getWallPos()[1] + 1) * CASE_DIM, (player.getIceWall2().getWallPos()[0] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall().getWallPos()[1] + 1) * CASE_DIM, (player4.getStoneWall().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM, (player4.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM, (player4.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM);
        }


        }

        private void printBoard(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(plateau[i][j]);
            }
            System.out.println('\n');
        }
        }








}



