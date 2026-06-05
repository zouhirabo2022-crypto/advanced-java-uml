package Exercise2;

import java.util.Date;

// Créez une classe de base appelée Vehicule avec les attributs et
// méthodes suivants :
class Vehicule{
    //  • Attributs :
    //  ▪ nom : Une chaîne de caractères représentant le nom du véhicule.
    String nom;
    //  ▪ prix : Un double représentant le prix du véhicule.
    Double prix;

    public Vehicule(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }
    //  • Méthodes :
    //  ▪ emettreSon(): Une méthode qui affiche un son générique du
    //  véhicule (par exemple, "Le véhicule émet un son inconnu.").
    public void emettreSon (){
        System.out.println("Le véhicule émet un son inconnu.");
    }
    //  ▪ afficherInformations(): Une méthode qui affiche des informations
    //  de base sur le véhicule, y compris son nom et son prix.
    public String afficherInformations(){
         return "son nom est :" + this.nom + " le prix est :" + this.prix;
    }
}
// Créez des sous-classes pour différents types de véhicules, par exemple :
//  • Voiture : une classe qui hérite de Vehicule et a les attributs supplémentaires
//  modele, annee, et redéfinit la méthode emettreSon() pour afficher "La voiture vrombit.".
class Voiture extends Vehicule{
    String modele;
    Date annee;
    public Voiture(String nom, Double prix,String modele, Date annee) {
        super(nom, prix);
        this.modele = modele;
        this.annee = annee;
    }

    public void emettreSon (){
        System.out.println("La voiture vrombit");
    }

}
//  • Moto : une classe qui hérite de Vehicule et a les attributs supplémentaires marque,
//  puissance, et redéfinit la méthode emettreSon() pour afficher "La moto rugit.".
class Moto extends Vehicule{
    String marque;
    int puissance;

    public Moto(String nom, Double prix, String marque, int puissance) {
        super(nom, prix);
        this.marque = marque;
        this.puissance = puissance;
    }
    public void emettreSon (){
        System.out.println("La moto rugit");
    }
}
//  • Avion : une classe qui hérite de Vehicule et a les attributs supplémentaires compagnie,
//  vitesseMax, et redéfinit la méthode emettreSon() pour afficher "L'avion fait un bruit de moteur puissant.".
class Avion extends Vehicule{
    String compagnie;
    int vitesseMax;

    public Avion(String nom, Double prix, String compagnie, int vitesseMax) {
        super(nom, prix);
        this.compagnie = compagnie;
        this.vitesseMax = vitesseMax;
    }

    public void emettreSon (){
        System.out.println("L'avion fait un bruit de moteur puissant");
    }
}
// Créez un programme principal (une classe) pour tester vos classes en créant des objets de différents
// types de véhicules, en définissant les attributs spécifiques à chaque véhicule, y compris le prix,
// et en appelant la méthode emettreSon() pour faire émettre le son spécifique de chaque véhicule. Enfin,
// affichez toutes les informations, y compris les attributs supplémentaires et le prix, avec
// la méthode afficherInformations().
public class Main {
    public static void main(String[] args) {
        Vehicule v1 = new Vehicule("test",1200.00);
        System.out.println(v1.afficherInformations());
        v1.emettreSon();
        Vehicule v2 = new Voiture("test",1200.00,"KIA", new Date());
        v2.emettreSon();
        Vehicule m1 = new Moto("test",1200.00, "honda",20);
        m1.emettreSon();
        Vehicule a1 = new Avion("test",1200.00, "Alis",20);
        a1.emettreSon();

    }
}