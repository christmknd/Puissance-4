public class Partie {
  protected Jeu jeu;
  protected Joueur [] joueurs;

  public Partie (Joueur j1, Joueur j2) {
    this.joueurs = new Joueur [2];
    this.joueurs [0] = j1;
    this.joueurs [1] = j2;
    jeu = new Jeu ();
  }
  public Partie (Joueur j1, Joueur j2, int taille) {
    this.joueurs = new Joueur [2];
    this.joueurs [0] = j1;
    this.joueurs [1] = j2;
    jeu = new Jeu (taille);
  }
  
  public void joue () {
   int vainqueur = -1;
   int tour = 0;
   while (vainqueur == -1) {
    joueurs[tour].joue(jeu);
    if (jeu.plein()) {
      vainqueur = -1;
    }
 
    if (jeu.quatreALaSuite()) {
      vainqueur = tour;
    }
    tour++;
    tour %= 2;
  }
 
    System.out.println("La partie est finie.");
    jeu.afficher();
    if (vainqueur == -1) {
      System.out.println("Match nul.");
    } else {
      System.out.println("Le vainqueur est " + joueurs[vainqueur].getNom());
    }
  }
}
