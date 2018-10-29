import java.util.Scanner;

class Puissance4 {
    protected static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("Entrez votre nom: ");
    String j1 = scanner.nextLine();
    System.out.println("--");
   
    System.out.println("Entrez votre nom: ");
    String j2 = scanner.nextLine();
    System.out.println("--");

    Partie p = new Partie(new Joueur (j1, Jeu.ROUGE), new Joueur (j2, Jeu.JAUNE));
    p.joue();
  }
} 
