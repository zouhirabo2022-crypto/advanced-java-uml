package Exercise3;

/*
    On souhaite créer une application en java qui permet de gérer les salaires des ingénieurs et
    des managers d’une entreprise de développement informatique.
*/

/*
    1. Créez la classe abstraite Employe avec les attributs nom, prenom, email, telephone,
    et salaire. Ajoutez les constructeurs avec et son paramètres, puis la méthode abstraite
    calculerSalire() qui retourne le salaire d’un employé.
*/
abstract class Employe{
    String nom;
    String prenom;
    String email;
    String telephone;
    Double salaire;

    public Employe(String nom, String prenom, String email, String telephone, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.salaire = salaire;
    }
    abstract public Double calculerSalire();
}

/*
    2. Créez la classe Ingénieur avec l’attribut spécialité. Redéfinissez la méthode
    calculerSalire() sachant qu’on prévoit une augmentation de 15% par rapport à son
    salaire normal.
*/
class Ingenieur extends Employe{
    String specialite;
    public Ingenieur(String nom, String prenom, String email, String telephone, Double salaire,String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }

    @Override
    public Double calculerSalire() {
        super.salaire += super.salaire * 0.15;
        return super.salaire;
    }

    @Override
    public String toString() {
        return "Ingenieur [ " + "specialite=" + specialite + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", salaire=" + salaire +" ]";
    }
}
/*
    3. Créez la classe Manager avec l’attribut service. Redéfinissez la méthode
    calculerSalire() sachant qu’on prévoit une augmentation de 20% par rapport à son
    salaire normal.
*/
class Manager extends Employe{
    String service;
    public Manager(String nom, String prenom, String email, String telephone, Double salaire, String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }
    @Override
    public Double calculerSalire() {
        super.salaire += super.salaire * 0.20;
        return super.salaire;
    }

    @Override
    public String toString() {
        return "Manager [ " + "service=" + service + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", salaire=" + salaire + " ]";
    }
}
/*
    4. Créez une application qui contient une méthode main() pour tester les différentes
    classes, dans laquelle :
    — déclarez et intentiez un ingénieur ;
    — déclarez et intentiez un manager ;
    — affichez les informations de l’ingénieur et du manager (nom, prénom, salaire,
    service, et spécialité)
*/
public class Main {
    public static void main(String[] args) {
        /*
            — déclarez et intentiez un ingénieur ;
            — déclarez et intentiez un manager ;
            — affichez les informations de l’ingénieur et du manager (nom, prénom, salaire, service, et spécialité)
         */
        Ingenieur ing1= new Ingenieur("Ahmed", "Hamada", "Ahmed@hamada.com", "064344313", 3500.0,"Dev");
        Manager mng1= new Manager("Noufel", "Aduma", "Noufel@Aduma.com","064321875",15000.0,"IT");
        System.out.println(ing1);
        System.out.println(mng1);
        System.out.println(ing1.calculerSalire());
        System.out.println(mng1.calculerSalire());
    }
}