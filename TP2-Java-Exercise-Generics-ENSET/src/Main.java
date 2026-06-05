import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    L’objectif de cet exercice est d’utiliser la généricité avec une collection d'objets de type
    produit .
    - Créez une classe Produit avec les attributs id, nom, marque, prix, description,
    et nombre en stock.
*/

class Produit{
    int id;
    String nom;
    String marque;
    Double prix;
    String description;
    int nbrStock = 0;

    public Produit(int id, String nom, String marque, Double prix, String description, int nbrStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    @Override
    public String toString(){
        return "| id = '" + this.id + "'| nom = '" + this.nom + "'| marque = '" + this.marque + "'| prix = '" + this.prix + "DH'| description = '" + this.description + "'| nbrStock = '" + this.nbrStock + "'|\n";
    }
}

/*
    - Créer une Interface générique IMetier qui va déclarer les méthodes pour gérer
    nos entités Produit. Cette interface a un type générique T et contient les
    méthodes suivantes :
    o public void add(T o) : qui permet d’ajouter un objet à la liste.
    o public List<T> getAll() : qui retourne la liste des objets sous forme d’une
    liste.
    o public T findById(long id) : qui retourne un produit par id.
    o public void delete(long id) : qui supprime un objet par id.
 */
interface IMetier<T>{
    public void add(T o);
    public List<T> getAll();
    public T findById(long id);
    public void delete(long id);
}
/*
    - Créer une classe MetierProduitImpl qui implémente l’interface IMetier. Cette classe
    contient un attribut qui représente une liste de produits.
 */
class MetierProduitImpl implements IMetier<Produit>{
    List<Produit> listProduit;

    public MetierProduitImpl() {
        this.listProduit = new ArrayList<>();
    }

    @Override
    public void add(Produit o) {
        this.listProduit.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return this.listProduit;
    }

    @Override
    public Produit findById(long id) {
        for (Produit produit : this.listProduit) {
            if(produit.id == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        for (Produit produit : this.listProduit) {
            if(produit.id == id) {
                this.listProduit.remove(produit);
                break;
            }
        }
    }
}
/*
    - Ecrire une classe Application contenant la méthode main qui propose à l’utilisateur
    dans une boucle while le menu suivant :
    1. Afficher la liste des produits.
    2. Rechercher un produit par son id.
    3. Ajouter un nouveau produit dans la liste.
    4. Supprimer un produit par id.
    5. Quitter ce programme.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produit p1 = new Produit(265, "Clavier", "Logitech", 250.25, "Clavier sans fils", 20);
        Produit p2 = new Produit(336, "Souris", "Logitech", 150.25, "Souris sans fils", 12);
        Produit p3 = new Produit(25, "Casque", "Reddragon", 120.25, "Casque sans fils", 18);
        MetierProduitImpl metier = new MetierProduitImpl();
        metier.add(p1);
        metier.add(p2);
        metier.add(p3);

        while (true) {
            System.out.println("=========Menu=========");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");

            System.out.print("Votre choix: ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1 -> {
                    if(metier.getAll().isEmpty()){
                        System.out.println("La liste des produits est vide.\n");
                        break;
                    }
                    System.out.println("|   ID  |   Nom |   Marque  |   Prix    |   Description    |    Nombre Stock    |");
                    metier.getAll().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Entrer l'id du produit à rechercher: ");
                    long id = scanner.nextLong();
                    if (metier.findById(id) == null) {
                        System.out.println("Produit Introuvable");
                        break;
                    }
                    System.out.println(metier.findById(id));
                }
                case 3 -> {
                    System.out.print("Entrer ID du produit: ");
                    int id_prod = scanner.nextInt();
                    if(metier.findById(id_prod) != null){
                        System.out.println("Un produit avec cet ID existe déjà.");
                        break;
                    }

                    System.out.print("Entrer le nom du produit: ");
                    String nom = scanner.next();

                    System.out.print("Entrer la marque du produit: ");
                    String marque = scanner.next();

                    System.out.print("Entrer le prix du produit: ");
                    Double prix = scanner.nextDouble();

                    System.out.print("Entrer la description du produit: ");
                    String description = scanner.next();

                    System.out.print("Entrer le nombre en stock du produit: ");
                    int nbrStock = scanner.nextInt();

                    metier.add(new Produit(id_prod, nom, marque, prix, description, nbrStock));
                }

                case 4 -> {
                    System.out.print("Entrer ID du produit: ");
                    int id_to_remove = scanner.nextInt();
                    if(metier.findById(id_to_remove) == null){
                        System.out.println("le produit n'existe pas");
                        break;
                    }

                    metier.delete(id_to_remove);
                }

                case 5 -> {
                    System.out.println("Au revoir");
                    return;
                }

                default -> System.out.println("Choix invalid");
            }
        }


    }
}
