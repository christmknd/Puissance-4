import java.util.Scanner;

public class Joueur {
  protected int couleur;
  protected String nom;
  
  public Joueur (String n, int c) {
    this.couleur = c;
    this.nom = n;
  }

  public int getCouleur () {
    return couleur;
  }
 
  public String getNom () {
    return nom;
  }

  public void joue (Jeu jeu) {
    jeu.afficher (); 
    boolean valide = false;
    while (!valide) {
      Scanner sc = new Scanner(System.in);
      System.out.println (this.getNom() + ", veuillez saisir le numero de la colonne dans laquelle vous souhaitez jouer.");
      int c = sc.nextInt ();
      valide = jeu.joueCoup(c, this.getCouleur());
      if (valide == false) {
        System.out.println("-> Coup NON valide.");
      }
   }
  }
}
