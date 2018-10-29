public class Jeu {
  public static final int VIDE  = 0;
  public static final int ROUGE = 1;
     public static final int JAUNE = 2;
  
  protected int [][] table;
  protected int taille;
  public Jeu () {
    table = new int [8][8];
    taille = 8;
  }
 
  public Jeu (int taille) {
    table = new int [taille][taille];
    this.taille = taille; 
  }

  public boolean joueCoup (int colonne, int couleur) {
    for (int i =0; i<taille; i++) {
      if (table [i][colonne] == 0) {
        table [i][colonne] = couleur;
        return true;
      }
    }
    return false;
  }
 
  public boolean plein () {
    for (int i=0; i < taille; i++)
      for (int j=0; j < taille; j++)
        if (table [i][j] == VIDE)
          return false;
    return true; 
  }
  
  public boolean quatreALaSuite () {
    // Vérifie les horizontales ( - )
    for (int ligne = 0; ligne < taille; ligne++) {
      if (cherche4alignes(0, ligne, 1, 0)) {
        return true;
      }
    }
 
    // Vérifie les verticales ( ¦ )
    for (int col = 0; col < taille; col++) {
      if (cherche4alignes(col, 0, 0, 1)) {
        return true;
      }
    }
 
    // Diagonales (cherche depuis la ligne du bas)
    for (int col = 0; col < taille; col++) {
      // Première diagonale ( / )
      if (cherche4alignes(col, 0, 1, 1)) {
        return true;
      }
      // Deuxième diagonale ( \ )
      if (cherche4alignes(col, 0, -1, 1)) {
        return true;
      }
    }
 
    // Diagonales (cherche depuis les colonnes gauches et droites)
    for (int ligne = 0; ligne < taille; ligne++) {
      // Première diagonale ( / )
      if (cherche4alignes(0, ligne, 1, 1)) {
        return true;
      }
      // Deuxième diagonale ( \ )
      if (cherche4alignes(taille - 1, ligne, -1, 1)) {
        return true;
      }
    }
 
    // On n'a rien trouvé
    return false;
  }

  protected boolean cherche4alignes(int oCol, int oLigne, int dCol, int dLigne) {
    int couleur = VIDE;
    int compteur = 0;
 
    int curCol = oCol;
    int curRow = oLigne;
 
    while ((curCol >= 0) && (curCol < taille) && (curRow >= 0) && (curRow < taille)) {
      if (table[curRow][curCol] != couleur) {
        couleur = table[curRow][curCol];
        compteur = 1;
      } else {
        compteur++;
      }
 
      if ((couleur != VIDE) && (compteur == 4)) {
        return true;
      }
 
      curCol += dCol;
      curRow += dLigne;
    }
 
    return false;
  }
 

  public void afficher () {
    for (int i = taille-1 ; i>=0 ; i--) {
      for (int j = 0 ; j < taille-1 ; j++) {
        switch (table [i][j]) {
          case VIDE : 
            System.out.print (' ');
            break;
          case ROUGE :
            System.out.print ('R');
            break;
          case JAUNE : 
            System.out.print ('J');
            break;
        }
      }
      System.out.println ();
    }
    for (int i=0; i<taille; i++)
      System.out.print ('-');
    System.out.println ();
    for (int i=0; i<taille; i++)
      System.out.print (i);
    System.out.println ();
  }
}
