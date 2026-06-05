package Exercise6;
/*
    On souhaite développer une application pour gérer les paiement, pour cela, vous Créez les
    classes suivantes :
    1. Classe abstraite de Paiement :
    • Créez une classe abstraite de base appelée Paiement avec une méthode abstraite
    effectuerPaiement(double montant).
    • La classe Paiement peut avoir des attributs communs à tous les moyens de
    paiement, par exemple, le montant, le numéro de transaction, etc.
 */
abstract class Paiement{
    double montant;
    int numTransaction;
    abstract double effectuerPaiement(double montant);
}
/*
    2. Classes Dérivées CarteCredit et PayPal :
    • Héritez de la classe Paiement pour créer deux classes dérivées : CarteCredit et
    PayPal.
    • Chaque classe dérivée peut ajouter des attributs spécifiques, tels que le numéro
    de carte pour CarteCredit ou l'adresse email pour PayPal.
    • Implémentez la méthode effectuerPaiement(double montant) dans chaque
    classe dérivée pour simuler le processus de paiement en affichant un message
    approprié.
 */
class CarteCredit extends Paiement{
    double solde;
    int numCartCredit;

    @Override
    double effectuerPaiement(double montant) {
        System.out.println("----- Carte Credit --------");
        this.solde -= montant;
        return this.solde;
    }
}
class Paypal extends Paiement{
    String email;
    double solde;

    @Override
    double effectuerPaiement(double montant) {
        System.out.println("----- Paypal --------");
        this.solde -= montant;
        return this.solde;
    }
}
/*
    3. Classe Commande :
    • Créez une classe Commande qui représente une transaction d'achat.
    • Ajoutez un attribut pour le montant de la commande et un attribut pour le moyen
    de paiement (CarteCredit ou PayPal), de type Paiement.
    • Implémentez une méthode, par exemple processPayment(), qui utilise le
    polymorphisme pour effectuer le paiement, indépendamment du type de moyen
    de paiement.
 */
class Commande<T extends Paiement>{
    double montantCommande;
    String moyennePayement;
    T payment;

    Commande(double montantCommande, T payment) {
        this.montantCommande = montantCommande;
        this.payment = payment;
    }
    public void processPayment(){
        System.out.println(payment.effectuerPaiement(this.montantCommande));
    }
}
/*
    4. Classe GestionPaiementApp :
    • Dans une classe principale appelée GestionPaiementApp, créez des instances de
    Commande avec différents moyens de paiement (CarteCredit et PayPal).
    • Appelez la méthode processPayment() pour chaque commande et observez
    comment le polymorphisme permet d'utiliser la même méthode pour différents
    types d'objets.
 */
class GestionPaiementApp {
    public static void main(String[] args) {
        Paypal p1 = new Paypal();
        p1.solde = 5000;

        CarteCredit c1 = new CarteCredit();
        c1.solde = 1400;



        Commande<Paypal> cm1 = new Commande<>(250, p1);
        Commande<CarteCredit> cm2 = new Commande<>(300, c1);

        cm1.processPayment();
        cm2.processPayment();

    }
}
