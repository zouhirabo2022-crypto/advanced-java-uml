package Exercise5;
/*
    1. Interface Empruntable :
    • Créez une interface appelée Empruntable qui définit deux méthodes :
    emprunter() et retourner().
    • Cette interface représente le comportement commun à tous les objets qui peuvent
    être empruntés et retournés.
 */
interface Empruntable {
    public void emprunter();
    public String retourner();
}
/*
    2. Classes Concrètes Livre et DVD :
    • Implémentez l'interface Empruntable avec deux classes concrètes : Livre et
    DVD.
    • Chaque classe doit avoir des attributs spécifiques, tels que le titre, l'auteur pour
    le livre, et le titre, le réalisateur pour le DVD.
    • Créer un attribut booléen pour suivre l'état d'emprunt de chaque objet.
*/
class Livre implements Empruntable {
    String titre;
    String auteur;
    boolean etatEmprunt;

    @Override
    public void emprunter() {
        this.etatEmprunt = true;
    }

    @Override
    public String retourner() {
        return "the title is" + this.titre + " , and auteur are " + this.auteur;
    }
}

class DVD implements Empruntable {
    String titre;
    String realisateur;
    boolean etatEmprunt;

    @Override
    public void emprunter() {
        this.etatEmprunt = true;
    }

    @Override
    public String retourner() {
        return "the title are : " + this.titre + ", and realisator :" + this.realisateur;
    }
}
/*
    3. Classe Utilisateur :
    • Créez une classe Utilisateur avec un attribut pour le nom de l'utilisateur.
    • Ajoutez une méthode emprunterObjet(Empruntable objet) qui prend en
    paramètre un objet empruntable et appelle la méthode emprunter() sur cet objet.
*/
class Utilisateur {
    String nomUtilisateur;
    public void emprunterObjet(Empruntable objet){
        objet.emprunter();
    }
}
/*
    4. Classe GestionBibliothequeApp :
    • Dans une classe principale appelée GestionBibliotheque, créez quelques
    instances de Livre, DVD et Utilisateur.
    • Appelez la méthode emprunterObjet() sur l'utilisateur en passant différentes
    combinaisons d'objets empruntables (livres et DVD).
    • Appelez également la méthode retourner() sur certains objets empruntés.
 */
class GestionBibliothequeApp{
    static void main() {
        Livre livre = new Livre();
        DVD dvd =  new DVD();
        Utilisateur utilisateur =  new Utilisateur();

        // livre
        livre.titre = "titre 1";
        livre.auteur = "auteur 1";
        // dvd
        dvd.titre = "titre 2";
        dvd.realisateur = "realisateur 1";
        // utilisateur
        utilisateur.nomUtilisateur = "nomUtilisateur 1";

        utilisateur.emprunterObjet(livre);
        utilisateur.emprunterObjet(dvd);
        System.out.println(livre.retourner());
        System.out.println(dvd.retourner());
        System.out.println(dvd.etatEmprunt);
    }
}
