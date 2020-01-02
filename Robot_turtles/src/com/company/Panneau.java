package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class Panneau extends JPanel implements ActionListener {

    private static JPanel gamePanel = new JPanel();

    private JButton button1 = new JButton("Executer le programme");
    private JButton button2 = new JButton("Ajouter au programme");
    private JButton button3 = new JButton("Construire un mur");
    private JButton button4 = new JButton("");


    private ImageIcon icoBackground;
    private Image imgbackground;

    private ImageIcon stoneWall= new ImageIcon(getClass().getResource("/images/tiles/S.png"));
    public static int numberOfPlayers;

    private  ImageIcon imgYellowCard= new ImageIcon(getClass().getResource("/images/cards/y.png"));
    private  ImageIcon  imgPurpleCard= new ImageIcon(getClass().getResource("/images/cards/p.png"));
    private  ImageIcon  imgLaserCard= new ImageIcon(getClass().getResource("/images/cards/l.png"));
    private  ImageIcon  imgBlueCard= new ImageIcon(getClass().getResource("/images/cards/b.png"));
    private  ImageIcon imgBackCard = new ImageIcon(getClass().getResource("/images/cards/backCard.jpeg"));
    private  ImageIcon  imgIceWall= new ImageIcon(getClass().getResource("/images/tiles/I.png"));
    private  ImageIcon  imgStoneWall= new ImageIcon(getClass().getResource("/images/tiles/S.png"));


    private static int turn=1;
    private boolean endGame=false;

    private JPanel rightPan = new JPanel();
    private JPanel cards =new JPanel();

    public static char[][] plateau;
    //Pile de défausse
    public static ArrayList<Player> players = new ArrayList<>();
    public static ArrayList<Gem> gems = new ArrayList<>();
    public static Player player1;
    public static Player player2;
    public static Player player3;
    public static Player player4;
    public static Gem gem1;
    public static Gem gem2;
    public static Gem gem3;



    public static Player player=player1;
    public Panneau(int numberOfPlayers) {


        //int[][] tilesPosition = new int[8][2];
        //Plateau de jeu
        plateau = new char[8][8];

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
            player3 = new Player('p', 'S', new int[]{0, 6}, new int[]{0, 6}, deckP3);
            gem1 = new Gem('b', new int[]{7, 0});
            gem2 = new Gem('p', new int[]{7, 3});
            gem3 = new Gem('r', new int[]{7, 6});
            initializeBoard();

            players.add(player1);
            players.add(player2);
            players.add(player3);
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
            player3 = new Player('p', 'S', new int[]{0, 5}, new int[]{0, 5}, deckP3);
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


        this.add(gamePanel,BorderLayout.SOUTH);
        this.add(rightPan,BorderLayout.WEST);
        gamePanel.setOpaque(true);
        gamePanel.setBackground(new Color(0,0,0,0));
        cards.setOpaque(true);
        cards.setBackground(new Color(0,0,0,0));
        rightPan.setOpaque(true);
        rightPan.setBackground(new Color(0,0,0,0));
        button4.addActionListener(this);
        button3.addActionListener(this);
        button2.addActionListener(this);
        button1.addActionListener(this);
        gamePanel.add(button1);
        gamePanel.add(button2);
        gamePanel.add(button3);

        rightPan.add(cards);

        player=turn();
        this.setVisible(true);



    }



    public Panneau() {

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int CASE_DIM = 85;

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.imgbackground, 0, 0, null);

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
        switch (numberOfPlayers) {
            case 2:
                (player1.getImgPlayer()).paintIcon(null, g2, (player1.getPosition()[1]+1)* CASE_DIM, (player1.getPosition()[0]+1) * CASE_DIM);
                (player2.getImgPlayer()).paintIcon(null, g2, (player2.getPosition()[1]+1)* CASE_DIM, (player2.getPosition()[0]+1)*CASE_DIM);
                (gem1.getImggem()).paintIcon(null, g2, (gem1.getGemPosition()[1]+1) * CASE_DIM, (gem1.getGemPosition()[0]+1) * CASE_DIM);
                (gem2.getImggem()).paintIcon(null, g2, (gem2.getGemPosition()[1]+1) * CASE_DIM, (gem2.getGemPosition()[0]+1) * CASE_DIM);
                for (int i = 0; i < 8; i++) {
                    stoneWall.paintIcon(null, g2, 8 * CASE_DIM, (i + 1) * CASE_DIM);
                }


                break;
            case 3:
                (player1.getImgPlayer()).paintIcon(null, g2, (player1.getPosition()[1]+1)* CASE_DIM, (player1.getPosition()[0]+1) * CASE_DIM);
                (player2.getImgPlayer()).paintIcon(null, g2, (player2.getPosition()[1]+1)* CASE_DIM, (player2.getPosition()[0]+1)*CASE_DIM);
                (player3.getImgPlayer()).paintIcon(null, g2, (player3.getPosition()[1]+1)* CASE_DIM, (player3.getPosition()[0]+1) * CASE_DIM);
                (gem1.getImggem()).paintIcon(null, g2, (gem1.getGemPosition()[1]+1) * CASE_DIM, (gem1.getGemPosition()[0]+1) * CASE_DIM);
                (gem2.getImggem()).paintIcon(null, g2, (gem2.getGemPosition()[1]+1) * CASE_DIM, (gem2.getGemPosition()[0]+1) * CASE_DIM);
                (gem3.getImggem()).paintIcon(null, g2, (gem3.getGemPosition()[1]+1) * CASE_DIM, (gem3.getGemPosition()[0]+1) * CASE_DIM);
                for (int i = 0; i < 8; i++) {
                    stoneWall.paintIcon(null, g2, 8 * CASE_DIM, (i + 1) * CASE_DIM);
                }


                break;

            case 4:

                (player1.getImgPlayer()).paintIcon(null, g2, (player1.getPosition()[1]+1)* CASE_DIM, (player1.getPosition()[0]+1) * CASE_DIM);
                (player2.getImgPlayer()).paintIcon(null, g2, (player2.getPosition()[1]+1)* CASE_DIM, (player2.getPosition()[0]+1)*CASE_DIM);
                (player3.getImgPlayer()).paintIcon(null, g2, (player3.getPosition()[1]+1)* CASE_DIM, (player3.getPosition()[0]+1) * CASE_DIM);
                (player4.getImgPlayer()).paintIcon(null, g2, (player4.getPosition()[1]+1)* CASE_DIM, (player4.getPosition()[0]+1)*CASE_DIM);
                (gem1.getImggem()).paintIcon(null, g2, (gem1.getGemPosition()[1]+1) * CASE_DIM, (gem1.getGemPosition()[0]+1) * CASE_DIM);
                (gem2.getImggem()).paintIcon(null, g2, (gem2.getGemPosition()[1]+1) * CASE_DIM, (gem2.getGemPosition()[0]+1) * CASE_DIM);
                break;
        }
        paintPlayersWalls(CASE_DIM,g2);


        if(endGame){
            Font policeEnd = new Font("Arial",Font.BOLD,100);
            g2.setFont(policeEnd);
            g2.drawString("Fin de la partie",300,400);
        }
        }

    /* TODO : A revoir turn */
    private Player turn(){
        Player ans = null;
        JLabel playerLabel =new JLabel();
        if(numberOfPlayers==2){
        if(turn%2==0){
            if(!player1.isWin()){
                this.add(playerLabel);
                this.revalidate();
                this.repaint();
                ans = player2;}
            else{

                endGame=true;
                repaint();

            }
        }
        else {
            if(!player2.isWin()) {
                this.add(playerLabel);
                this.revalidate();
                this.repaint();
                ans = player1;
            }
            else{
                endGame=true;
                repaint();


            }
        }

        }
        return ans;
    }


    private static void initializeBoard()
    {
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++){
                plateau[i][j]=' ';
            }
        }
    }

    private static void updateBoard(int[] position,char object){

        plateau[position[0]][position[1]]= object;
    }



    private void completeProgram(Player player){
        if ((player.getDeck().getPlayerHand()).size() < 5) {
            (player.getDeck()).fiveCardToPlayerHand();
        }
        button1.setText("Ajouter des cartes");
        button2.setText("Défausser");
        button3.setText("Finir le tour");
        gamePanel.revalidate();
        gamePanel.repaint();

    }

    private void addToProgram(){
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




    }

    private void executeProgram(){

        for (int i=0;i<player.getDeck().getHiddenCards().size();i++){
            System.out.println(player.getDirection());
            if (player.getDeck().getHiddenCards().pop()=='b'){
                player.getDeck().blueEffect(player);
                repaint();
            }
            else if(player.getDeck().getHiddenCards().pop()=='p'){
                player.getDeck().purpleEffect(player);
                repaint();

            }
            else if(player.getDeck().getHiddenCards().pop()=='y'){
                player.getDeck().yellowEffect(player);
                repaint();

            }
            else if(player.getDeck().getHiddenCards().pop()=='l'){
                player.getDeck().laserEffect(player);

            }


        }
        hasWon();

        button1.setText(" ");
        button2.setText("Défausser");
        button3.setText("Finir le tour");
        gamePanel.repaint();

    }

    private void buildWall() {
        button1.setText("Mur de pierre");
        button2.setText("Mur de glace");
        button3.setText("Défausser");
        button4.setText("Finir le tour");

        gamePanel.repaint();
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("il vous reste " + player.obstacle.getNumberOfIceWall()+"mur de glace");
        System.out.println("il vous reste "+ player.obstacle.getNumberOfStoneWall()+"mur de pierre" );
        System.out.println("Quel mur veut tu placer\n");
        char choix  = scanner.next().charAt(0);
        System.out.println("Sur quelle ligne placer ton mur\n");
        int posX = scanner.nextInt();
        System.out.println("Sur quelle colonne placer ton mur\n");
        int posY = scanner.nextInt();
        if(!blocked(posX,posY)){
            if (choix==player.obstacle.getStoneWall()){
                player.obstacle.reduceNumberOfStoneWall();
                plateau[posX][posY]= choix;
            }
            else {
                    player.obstacle.reduceNumberOfIceWall();
                }
            }

        else
        {
            System.out.println("Vous ne pouvez pas placer votre mur ici");
        }*/

    }






    private static boolean blocked(int posX, int posY) {
        boolean ans = false;
        int counter = 0;
        boolean t = false;
        char plateauBis[][] = plateau;
        plateauBis[posX][posY] = 't';
        if (numberOfPlayers == 2) {
            if (checkSurrounding(plateauBis, gem1.getGemPosition()) && checktempWall(plateauBis, gem1.getGemPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player1.getPosition()) && checktempWall(plateauBis, player1.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player2.getPosition()) && checktempWall(plateauBis, player2.getPosition())) {
                ans = true;
            }
        }
        if (numberOfPlayers==3){
            if (checkSurrounding(plateauBis, gem1.getGemPosition()) && checktempWall(plateauBis, gem1.getGemPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, gem2.getGemPosition()) && checktempWall(plateauBis, gem2.getGemPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player1.getPosition()) && checktempWall(plateauBis, player1.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player2.getPosition()) && checktempWall(plateauBis, player2.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player3.getPosition()) && checktempWall(plateauBis, player3.getPosition())) {
                ans = true;
            }

        }

        if (numberOfPlayers == 4) {
            //On vérifie que les joyaux ne sont pas bloqués
            if (checkSurrounding(plateauBis, gem1.getGemPosition()) && checktempWall(plateauBis, gem1.getGemPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, gem2.getGemPosition()) && checktempWall(plateauBis, gem2.getGemPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, gem3.getGemPosition()) && checktempWall(plateauBis, gem3.getGemPosition())) {
                ans = true;
            }
            //On vérifie que les joueurs ne sont pas bloqués
            if (checkSurrounding(plateauBis, player1.getPosition()) && checktempWall(plateauBis, player1.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player2.getPosition()) && checktempWall(plateauBis, player2.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player3.getPosition()) && checktempWall(plateauBis, player3.getPosition())) {
                ans = true;
            }
            if (checkSurrounding(plateauBis, player4.getPosition()) && checktempWall(plateauBis, player4.getPosition())) {
                ans = true;
            }
        }


        return ans;
    }




    public static boolean checktempWall(char[][] plateauBis, int[] pos) {
        boolean t = false;
        //Vérification de la ligne du haut
        for (int i = pos[1] - 1; i < pos[1] + 2; i++) {
            if (pos[1] - 1>=0&&pos[1]+1<7&&pos[0]-1>=0) {
                if (plateauBis[pos[0] - 1][i] == 't') {
                    t = true;
                }
            }

        }
        //Vérification sur le coté gauche
        if(pos[1] - 1 >= 0){
        if (plateauBis[pos[0]][pos[1]-1]=='t') {

                t = true;
            }
        }
        //Vérification sur le coté droit
        if(pos[1] + 1 < 8){
        if (plateauBis[pos[0]][pos[1]+1]=='t'){
            t = true;
        }
        }
        return t;

    }



    public static boolean checkSurrounding(char[][] plateauBis, int[] pos){
        int counter = 0;
        boolean ans = false;
        for (int i = pos[1] - 1; i < pos[1] + 2; i++) {
            if (pos[1] - 1 >= 0 && pos[1] + 1 < 7 && pos[0] - 1 >= 0) {
                if (plateauBis[pos[0] - 1][i] == 'I' || plateauBis[pos[0] - 1][i] == 'S') {
                    counter++;
                }
            } else {
                counter++;
            }
        }

        //ligne du bas
        for (int i = pos[1] - 1; i < pos[1] + 2; i++) {
            if (pos[1] - 1 >= 0 && pos[1] + 1 < 7 && pos[0] + 1 < 8) {
                if (plateauBis[pos[0] + 1][i] == 'I' || plateauBis[pos[0] + 1][i] == 'S') {
                    counter++;
                }
            } else {
                counter++;
            }
        }

            if(pos[1] - 1 >= 0) {
                if (plateauBis[pos[0]][pos[1] - 1] == 'I' || plateauBis[pos[0]][pos[1] - 1] == 'S') {
                    counter++;
                }
            }
            else{
                counter++;
            }

            if(pos[1] + 1 < 8){
        if (plateauBis[pos[0]][pos[1]+1]=='I'||plateauBis[pos[0]][pos[1]+1]=='S'){
            counter++;
        }}
            else {
                counter++;
            }

        if (counter>=7){
            ans = true;
        }
        return ans;
    }


    public void hasWon(){
        if(numberOfPlayers==2||numberOfPlayers==4) {
            if (gem1.gemTaken(player)||gem2.gemTaken(player)) {
                player.setWin(true);
                System.out.println("Vous avez gagné");
            } else {
                player.setWin(false);
            }
        }
        else{
            if (gem1.gemTaken(player)||gem2.gemTaken(player)||gem3.gemTaken(player)) {
                player.setWin(true);
            } else {
                player.setWin(false);
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Ajouter au programme")){
           completeProgram(player);
        }

        else if(e.getActionCommand().equals("Executer le programme")){

            executeProgram();

        }
        else if(e.getActionCommand().equals("Construire un mur")){
           buildWall();
           gamePanel.add(button4);
        }

        if(e.getActionCommand().equals("Ajouter des cartes")){
         addToProgram();
        }
        if(e.getActionCommand().equals("Défausser")){
            if ((player.getDeck().getPlayerHand()).size() < 5) {
                (player.getDeck()).fiveCardToPlayerHand();
            }
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
            button1.setText("Executer le programme");
           button2.setText("Ajouter au programme");
           button3.setText("Construire un mur");
           gamePanel.remove(button4);

            gamePanel.revalidate();
            gamePanel.repaint();
            repaint();
            System.out.println( player.getIceWall().getWallPos()[0]);


            Component[] components = cards.getComponents();

            for (Component component : components) {
                cards.remove(component);
            }

            cards.revalidate();
            cards.repaint();

            turn++;
            repaint();
            player=turn();
        }

        if(e.getActionCommand().equals("Mur de pierre")){
            this.addMouseListener(new MouseAdapter() {


                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    int xpos=player.getStoneWall().getWallPos()[0],ypos=player.getStoneWall().getWallPos()[1];

                    System.out.println(x+","+y);
                    if(x>85&&x<170){
                        xpos=0;
                    }
                    else if (x>170&&x<256){
                        xpos=1;
                    }
                    else if (x>256&&x<339){
                        xpos=2;
                    }
                    else if (x>339&&x<425){
                        xpos=3;
                    }
                    else if (x>425&&x<511){
                        xpos=4;
                    }
                    else if (x>511&&x<594){
                        xpos=5;
                    }
                    else if (x>594&&x<683){
                        xpos=6;
                    }
                    else if (x>683&&x<766){
                        xpos=7;
                    }

                    if (y>86&&y<166){
                        ypos=0;
                    }
                    else if (y>166&&y<255){
                        ypos=1;
                    }
                    else if (y>255&&y<341){
                        ypos=2;
                    }
                    else if (y>341&&y<423){
                        ypos=3;
                    }
                    else if (y>423&&y<506){
                        ypos=4;
                    }
                    else if (y>506&&y<597){
                        ypos=5;
                    }
                    else if (y>597&&y<678){
                        ypos=6;
                    }
                    else if (y>678&&y<766){
                        ypos=7;
                    }

                    player.getStoneWall().setWallPos(new int[]{xpos, ypos});
                    repaint();
                }


            });

        }

        if(e.getActionCommand().equals("Mur de glace")){


            this.addMouseListener(new MouseAdapter() {


                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    int xpos=player.getIceWall().getWallPos()[0],ypos=player.getIceWall().getWallPos()[1];

                    System.out.println(x+","+y);
                    if(x>85&&x<170){
                        xpos=0;
                    }
                    else if (x>170&&x<256){
                        xpos=1;
                    }
                    else if (x>256&&x<339){
                        xpos=2;
                    }
                    else if (x>339&&x<425){
                        xpos=3;
                    }
                    else if (x>425&&x<511){
                        xpos=4;
                    }
                    else if (x>511&&x<594){
                        xpos=5;
                    }
                    else if (x>594&&x<683){
                        xpos=6;
                    }
                    else if (x>683&&x<766){
                        xpos=7;
                    }

                    if (y>86&&y<166){
                        ypos=0;
                    }
                    else if (y>166&&y<255){
                        ypos=1;
                    }
                    else if (y>255&&y<341){
                        ypos=2;
                    }
                    else if (y>341&&y<423){
                        ypos=3;
                    }
                    else if (y>423&&y<506){
                        ypos=4;
                    }
                    else if (y>506&&y<597){
                        ypos=5;
                    }
                    else if (y>597&&y<678){
                        ypos=6;
                    }
                    else if (y>678&&y<766){
                        ypos=7;
                    }
                    player.getIceWall().setWallPos(new int[]{xpos, ypos});

                    System.out.println( player.getIceWall().getWallPos()[0]);
                    repaint();
                }


            });

        }





    }


    private void paintPlayersWalls(int CASE_DIM,Graphics2D g2){

        if(numberOfPlayers>=2) {
            imgIceWall.paintIcon(null, g2, (player1.getIceWall().getWallPos()[0] + 1) * CASE_DIM, (player1.getIceWall().getWallPos()[1] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player1.getIceWall2().getWallPos()[0] + 1) * CASE_DIM, (player.getIceWall2().getWallPos()[1] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall().getWallPos()[0] + 1) * CASE_DIM, (player1.getStoneWall().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM, (player1.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player1.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM, (player1.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM);

            imgIceWall.paintIcon(null, g2, (player2.getIceWall().getWallPos()[0] + 1) * CASE_DIM, (player2.getIceWall().getWallPos()[1] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player2.getIceWall2().getWallPos()[0] + 1) * CASE_DIM, (player2.getIceWall2().getWallPos()[1] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall().getWallPos()[0] + 1) * CASE_DIM, (player2.getStoneWall().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM, (player2.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player2.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM, (player2.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM);

        }
        if (numberOfPlayers==3){
            imgIceWall.paintIcon(null, g2, (player3.getIceWall().getWallPos()[0] + 1) * CASE_DIM, (player3.getIceWall().getWallPos()[1] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player3.getIceWall2().getWallPos()[0] + 1) * CASE_DIM, (player3.getIceWall2().getWallPos()[1] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall().getWallPos()[0] + 1) * CASE_DIM, (player3.getStoneWall().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM, (player3.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player3.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM, (player3.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM);

        }
        if(numberOfPlayers==4){
            imgIceWall.paintIcon(null, g2, (player4.getIceWall().getWallPos()[0] + 1) * CASE_DIM, (player4.getIceWall().getWallPos()[1] + 1) * CASE_DIM);
            imgIceWall.paintIcon(null, g2, (player4.getIceWall2().getWallPos()[0] + 1) * CASE_DIM, (player.getIceWall2().getWallPos()[1] + 1) * CASE_DIM);

            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall().getWallPos()[0] + 1) * CASE_DIM, (player4.getStoneWall().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall2().getWallPos()[0] + 1) * CASE_DIM, (player4.getStoneWall2().getWallPos()[1] + 1) * CASE_DIM);
            imgStoneWall.paintIcon(null, g2, (player4.getStoneWall3().getWallPos()[0] + 1) * CASE_DIM, (player4.getStoneWall3().getWallPos()[1] + 1) * CASE_DIM);
        }
        }









}



