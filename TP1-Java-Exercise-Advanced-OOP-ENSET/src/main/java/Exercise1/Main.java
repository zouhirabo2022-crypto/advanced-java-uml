*/
    Package Exercise1;
/*
On souhaite créer une application JAVA pour la gestion des livres et des adhèrents d’une
bibliothèque.
1. Créez une classe Personne avec les attributs privés : nom, prenom, email, tel, et age.
Ajoutez le constructeur avec paramètres pour initialiser les différents attributs et la méthode
toString() qui retourne une chaîne de caractères contenant les valeurs des attributs.
 */
class Personne{
    String nom;
    String prenom;
    String email;
    String tel;
    int age;

    public Personne(String nom, String prenom, String email, String tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Personne [ " + "Nom=" + nom + ", Prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", age=" + age + "]";
    }
}
/*
    2. Créez une deuxième classe Adherent qui hérite de la classe Personne et qui contient
    l’attribut numAdherent et redéfinit la méthode toString().
 */
class Adherent extends Personne{
    int numAdherent;

    public Adherent(String nom, String prenom, String email, String tel, int age, int numAdherent) {
        super(nom, prenom, email, tel, age);
        this.numAdherent = numAdherent;

    }

    @Override
    public String toString() {
        return "Adherent [ " + "numAdherent=" + numAdherent + ", nom=" + nom + ", Prenom" +  prenom + ", email=" + email + ", tel=" + tel + ", age=" + age + "]";
    }
}

/*
    3. Créez une troisième classe Auteur qui hérite de la classe Personne, qui contient l’attribut
    numAuteur et redéfinit la méthode toString().
*/
class Auteur extends Personne {
    int numAuteur;


    public Auteur(String nom, String prenom, String email, String tel, int age,  int numAuteur) {
        super(nom, prenom, email, tel, age);
        this.numAuteur = numAuteur;
    }

    @Override
    public String toString() {
        return "Auteur [ " + "numAuteur=" + numAuteur + ", nom=" + nom + ", Prenom=" + prenom + ", email=" + email + ", tel=" + tel + ", age=" + age + "]";
    }
}
/*
    4. Créez la classe Livre qui contient un attribut ISBN (entier), un titre (chaîne ) et un auteur.
    Ajoutez également la méthode toString() qui retourne le ISBN, le titre et les informations de
    l’auteur.
*/
class Livre{
    int ISBN;
    String titre;
    Auteur auteur;

    public Livre(int ISBN, String titre, Auteur auteur) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre [ " + "ISBN=" + ISBN + ", titre=" + titre + ", auteur=" + auteur + " ]";
    }
}

/*
    5. Créez une application qui contient une méthode main() pour tester les différentes classes,
    dans laquelle :
    — déclarez et intentiez un adhèrent ;
    — déclarez et instanciez un livre qui est écrit par un auteur ;
    — affichez les informations de l’adhèrent et du livre.
 */
public class Main {
    public static void main(String[] args) {
        Adherent a1 = new Adherent("saad","yassine","saad@yassine.com","0633333333",23,23);
        Auteur auteur1 = new Auteur("said","sardi","said@sardi.com","0666666666",21,432);
        Livre l1 = new Livre(321,"titre",auteur1);
        System.out.println(l1.toString());
    }
}