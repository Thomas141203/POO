package demineur;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author Thomas
 */

public final class Demineur extends javax.swing.JFrame implements ActionListener, MouseListener{
    
    private int lignes;
    private int colonnes;
    private int difficulte;
    private int nbMines = (lignes * colonnes * difficulte)/10;
    private boolean[] mines;
    private boolean[] clickable;
    private boolean[] clickdone;
    private int[] numbers;
    private JButton[] buttons;
    private Plateau plateau;
    private boolean gagne; 
    private boolean perdu;
    
    
    public Demineur(){
        initComponents();
        initAttributs();
        initialisationJeu();
        mettreMines();
        mettreNombres();
        initPanel();
        this.setLocationRelativeTo(null);
    }
    
    public void initAttributs(){
        this.plateau = new Plateau(difficulte, lignes, colonnes);
        this.lignes = plateau.getNblig();
        this.colonnes = plateau.getNbcol();
        this.mines = new boolean[this.lignes * this.colonnes];
        this.clickable = new boolean[this.lignes * this.colonnes];
        this.clickdone = new boolean[this.lignes * this.colonnes];
        this.numbers = new int[this.lignes * this.colonnes];
        this.buttons = new JButton[this.lignes * this.colonnes];
        this.gagne = false;
        this.perdu = false;
    }
    
    public void initPanel(){
        Grille.setLayout(new GridLayout(this.lignes, this.colonnes));
        for(int i=0; i<this.lignes; i++){
            for(int j=0; j<this.colonnes; j++){
                Grille.add(this.plateau.getCase(i, j));
            }
        }
    }
    
    public void initialisationJeu(){
        for (int x = 0; x < this.lignes; x++) {
            for (int y = 0; y < this.colonnes; y++) {
                mines[(this.lignes * y) + x] = false;
                clickdone[(this.lignes * y) + x] = false;
                clickable[(this.lignes * y) + x] = true;
                buttons[(this.lignes * y) + x] = new JButton();
                buttons[(this.lignes * y) + x].setPreferredSize(new Dimension(50, 50));
                buttons[(this.lignes * y) + x].addActionListener(this);
                buttons[(this.lignes * y) + x].addMouseListener(this);
            }
        }
    }
    
    public void mettreMines(){
        int avonsBesoin = this.nbMines;
        while (avonsBesoin > 0) {
            int x = (int) Math.floor(Math.random() * lignes);
            int y = (int) Math.floor(Math.random() * colonnes);
            if (!mines[(lignes * y) + x]){
                mines[(lignes * y) + x] = true;
                avonsBesoin--;
            }
        }
    }
    
    public void mettreNombres() {
        for (int x = 0; x < this.lignes; x++) {
            for (int y = 0; y < this.colonnes; y++) {
                int cur = (this.lignes * y) + x;
                if (mines[cur]) {
                    numbers[cur] = 0;
                    continue;
                }
                int temp = 0;
                boolean l = (x - 1) >= 0;
                boolean r = (x + 1) < this.lignes;
                boolean u = (y - 1) >= 0;
                boolean d = (y + 1) < this.colonnes;
                int left = (this.lignes * (y)) + (x - 1);
                int right = (this.lignes * (y)) + (x + 1);
                int up = (this.lignes * (y - 1)) + (x);
                int upleft = (this.lignes * (y - 1)) + (x - 1);
                int upright = (this.lignes * (y - 1)) + (x + 1);
                int down = (this.lignes * (y + 1)) + (x);
                int downleft = (this.lignes * (y + 1)) + (x - 1);
                int downright = (this.lignes * (y + 1)) + (x + 1);
                if (u) {
                    if (mines[up]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[upleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[upright]) {
                            temp++;
                        }
                    }
                }
                if (d) {
                    if (mines[down]) {
                        temp++;
                    }
                    if (l) {
                        if (mines[downleft]) {
                            temp++;
                        }
                    }
                    if (r) {
                        if (mines[downright]) {
                            temp++;
                        }
                    }
                }
                if (l) {
                    if (mines[left]) {
                        temp++;
                    }
                }
                if (r) {
                    if (mines[right]) {
                        temp++;
                    }
                }
                numbers[cur] = temp;
            }
        }
    }
    
    public void checker(int x, int y){
        int cur = (this.lignes * y) + x;
        boolean l = (x - 1) >= 0;
        boolean r = (x + 1) < this.lignes;
        boolean u = (y - 1) >= 0;
        boolean d = (y + 1) < this.colonnes;
        int left = (this.lignes * (y)) + (x - 1);
        int right = (this.lignes * (y)) + (x + 1);
        int up = (this.lignes * (y - 1)) + (x);
        int upleft = (this.lignes * (y - 1)) + (x - 1);
        int upright = (this.lignes * (y - 1)) + (x + 1);
        int down = (this.lignes * (y + 1)) + (x);
        int downleft = (this.lignes * (y + 1)) + (x - 1);
        int downright = (this.lignes * (y + 1)) + (x + 1);
 
        clickdone[cur] = true;
        buttons[cur].setEnabled(false);
        if (numbers[cur] == 0 && !mines[cur] && !this.perdu && !this.gagne) {
            if (u && !this.gagne) {
                if (!clickdone[up] && !mines[up]) {
                    clickdone[up] = true;
                    buttons[up].doClick();
                }
                if (l && !this.gagne) {
                    if (!clickdone[upleft] && numbers[upleft] != 0
                            && !mines[upleft]) {
                        clickdone[upleft] = true;
                        buttons[upleft].doClick();
                    }
                }
                if (r && !this.gagne) {
                    if (!clickdone[upright] && numbers[upright] != 0
                            && !mines[upright]) {
                        clickdone[upright] = true;
                        buttons[upright].doClick();
                    }
                }
            }
            if (d && !this.gagne) {
                if (!clickdone[down] && !mines[down]) {
                    clickdone[down] = true;
                    buttons[down].doClick();
                }
                if (l && !this.gagne) {
                    if (!clickdone[downleft] && numbers[downleft] != 0
                            && !mines[downleft]) {
                        clickdone[downleft] = true;
                        buttons[downleft].doClick();
                    }
                }
                if (r && !this.gagne) {
                    if (!clickdone[downright]
                            && numbers[downright] != 0
                            && !mines[downright]) {
                        clickdone[downright] = true;
                        buttons[downright].doClick();
                    }
                }
            }
            if (l && !this.gagne) {
                if (!clickdone[left] && !mines[left]) {
                    clickdone[left] = true;
                    buttons[left].doClick();
                }
            }
            if (r && !this.gagne) {
                if (!clickdone[right] && !mines[right]) {
                    clickdone[right] = true;
                    buttons[right].doClick();
                }
            }
        } else {
            buttons[cur].setText("" + numbers[cur]);
            if (!mines[cur] && numbers[cur] == 0) {
                buttons[cur].setText("");
            }
        }
        if (mines[cur] && !this.gagne) {
            buttons[cur].setText("0");
            defaite();
        }
    }
    
    public void defaite(){
        if(!this.perdu && !this.gagne){
            this.perdu = true;
            for (int i = 0; i < this.lignes * this.colonnes; i++){
                if (!clickdone[i]){
                    buttons[i].doClick(0);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "you lose!n starting a new game", "you lose",
                    JOptionPane.ERROR_MESSAGE);
            //setup();
        }
    }
    
    public void checkWin() {
        for (int x = 0; x < this.lignes; x++){
            for (int y = 0; y < this.colonnes; y++){
                int cur = (this.lignes * y) + x;
                if (!clickdone[cur]) {
                    if (mines[cur]) {
                        continue;
                    } else {
                        return;
                    }
                }
            }
        }
        victoire();
    }
 
    public void victoire() {
        if (!this.perdu && !this.gagne) {
            this.gagne = true;
            JOptionPane.showMessageDialog(null,
                    "you win!nstarting a new game", "you lose",
                    JOptionPane.INFORMATION_MESSAGE);
            newGame.doClick();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Grille = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        creer = new javax.swing.JMenu();
        nbLignes = new javax.swing.JMenuItem();
        nbColonnes = new javax.swing.JMenuItem();
        niveauDifficulte = new javax.swing.JMenuItem();
        options = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        recommencer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout GrilleLayout = new javax.swing.GroupLayout(Grille);
        Grille.setLayout(GrilleLayout);
        GrilleLayout.setHorizontalGroup(
            GrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 801, Short.MAX_VALUE)
        );
        GrilleLayout.setVerticalGroup(
            GrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        creer.setText("Créer");

        nbLignes.setText("Lignes");
        nbLignes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbLignesActionPerformed(evt);
            }
        });
        creer.add(nbLignes);

        nbColonnes.setText("Colonnes");
        nbColonnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbColonnesActionPerformed(evt);
            }
        });
        creer.add(nbColonnes);

        niveauDifficulte.setText("Difficulté");
        niveauDifficulte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niveauDifficulteActionPerformed(evt);
            }
        });
        creer.add(niveauDifficulte);

        jMenuBar1.add(creer);

        options.setText("Options");

        newGame.setText("Nouvelle partie");
        options.add(newGame);

        recommencer.setText("Recommencer");
        options.add(recommencer);

        jMenuBar1.add(options);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Grille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Grille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void actionPerformed(ActionEvent evt){
        if(!this.gagne){
            for(int x = 0; x < this.lignes; x++){
                for (int y = 0; y < this.colonnes; y++) {
                    if(evt.getSource() == buttons[(this.lignes * y) + x] && !this.gagne && clickable[(this.lignes * y) + x]){
                        checker(x, y);
                    }
                }
            }
        }
        checkWin();
    }
    
    public void mousePressed(MouseEvent e){
        if(e.getButton() == 3){
            int n = 0;
            for(int x = 0; x < this.lignes; x++){
                for(int y = 0; y < this.colonnes; y++){
                    if(e.getSource() == buttons[(this.lignes * y) + x]){
                        clickable[(this.lignes * y) + x] = !clickable[(this.lignes * y) + x];
                    }
                    if(!clickdone[(this.lignes * y) + x]){
                        if(!clickable[(this.lignes * y) + x]){
                            buttons[(this.lignes * y) + x].setText("X");
                            n++;
                        }else{
                            buttons[(this.lignes * y) + x].setText("");
                        }
                    }
                }
            }
        }
    }
    
    private void nbLignesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbLignesActionPerformed
        // Quand on clic sur Lignes pour choisir le nombre
        if(evt.getSource() == nbLignes){
            lignes = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Lignes", "Lignes", JOptionPane.PLAIN_MESSAGE, null, null, 10));
        }
    }//GEN-LAST:event_nbLignesActionPerformed

    private void nbColonnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbColonnesActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == nbColonnes){
            colonnes = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Colonnes", "Colonnes", JOptionPane.PLAIN_MESSAGE, null, null, 10));
        }
    }//GEN-LAST:event_nbColonnesActionPerformed

    private void niveauDifficulteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_niveauDifficulteActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == niveauDifficulte){
            difficulte = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Difficulté entre 1 et 9", "Difficulté", JOptionPane.PLAIN_MESSAGE, null, null, 10));
            //if(difficulte < 0 && difficulte > 9)
            while(difficulte < 0 || difficulte > 9){
                difficulte = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Difficulté entre 1 et 9", "Difficulté", JOptionPane.PLAIN_MESSAGE, null, null, 10));
            }
        }
    }//GEN-LAST:event_niveauDifficulteActionPerformed

    public static void main(String args[]){
        new Demineur();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Grille;
    private javax.swing.JMenu creer;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem nbColonnes;
    private javax.swing.JMenuItem nbLignes;
    private javax.swing.JMenuItem newGame;
    private javax.swing.JMenuItem niveauDifficulte;
    private javax.swing.JMenu options;
    private javax.swing.JMenuItem recommencer;
    // End of variables declaration//GEN-END:variables
 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
    
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
}
