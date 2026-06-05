package exercice2;
/*
    Créez une classe CompteBancaire avec les attributs suivants : numéro de
    compte, solde, nom du titulaire.
    Écrivez un constructeur et des méthodes pour effectuer les opérations suivantes:
*/
class CompteBancaire {
    int numeroCompte;
    double solde;
    String nomTitulaire;

    public CompteBancaire(int numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    CompteBancaire() {
    }

    // • Dépôt d'argent sur le compte.
    public double depotArgent(int argent){
        this.solde += argent;
        return this.solde;
    }
    // • Retrait d'argent du compte (gérez les exceptions pour les fonds insuffisants).
    public double retraitArgent(int argent) throws FondsInsuffisantsException {
        if(this.solde<argent){
            throw new FondsInsuffisantsException("Solde est insuffisant");
        }
        this.solde -= argent;
        return this.solde;
    }
    // • Affichage du solde du compte.
    public String affichageSolde(){
        return "le solde est : " + this.solde + " DH";
    }
    // • Transfert d'argent entre deux comptes (gérez les exceptions pour les fonds insuffisants et les comptes inexistants).
    public String transfertArgent(CompteBancaire reciever, int argent) throws FondsInsuffisantsException{
        if(this.solde<argent){
            throw new FondsInsuffisantsException("Solde est insuffisant");
        }
        if(reciever == null){
            throw new FondsInsuffisantsException("Compte est inexistant");
        }
        this.solde -= argent;
        reciever.solde += argent;
        return "le virement a été envoyer avec success";
    }
}
/*
    Créez deux classes, CompteCourant et CompteEpargne, qui héritent de
    CompteBancaire et ajoutent des fonctionnalités spécifiques. Par exemple,
    CompteCourant pourrait autoriser un découvert tandis que CompteEpargne
    pourrait générer des intérêts.
*/
class CompteCourant extends CompteBancaire{
    int decouvertAutorise;
    /*
        Gérez les exceptions dans ces classes :
        • Si un retrait est effectué sur un solde insuffisant, lancez une exception
        personnalisée FondsInsuffisantsException.
        • Si un transfert est effectué vers un compte inexistant, lancez une exception
        personnalisée CompteInexistantException.
        Créez une classe Main qui déclare une liste de type ArrayList et qui effectuer les
        opérations suivantes :
        • Ajouter des comptes
        • Supprimer des comptes,
        • Effectuer des opérations sur les comptes. Assurez-vous de gérer les
        exceptions correctement en affichant des messages d'erreur appropriés
        lorsque cela est nécessaire.
    */

    public CompteCourant(int numeroCompte, double solde, String nomTitulaire, int decouvertAutorise) {
        super(numeroCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }
    public double retraitArgent(int argent) throws FondsInsuffisantsException {
        if(this.solde - argent < -this.decouvertAutorise){
            throw new FondsInsuffisantsException("Solde est insuffisant");
        }
        this.solde -= argent;
        return  this.solde;
    }
}
class CompteEpargne extends CompteBancaire{
    double tauxInteret;

    public CompteEpargne(int numeroCompte, double solde, String nomTitulaire, double tauxInteret) {
        super(numeroCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }
    public double depotArgent(int argent){
        this.solde += (argent+argent*this.tauxInteret);
        return this.solde;
    }
}
public class Main {
    public static void main(String[] args) throws FondsInsuffisantsException {
        // CompteBancaire client1 = new CompteBancaire(123,4000.0,"Ahmed");
        // CompteBancaire client2 = new CompteBancaire(124, 1000.0,"yassin");

        // System.out.println("-----Compte Bancaire-----");
        // System.out.println(client1.depotArgent(200));
        // System.out.println(client2.retraitArgent(100));
        // System.out.println(client1.affichageSolde());
        // System.out.println(client2.affichageSolde());
        // System.out.println(client1.transfertArgent(client2,200));
        // System.out.println(client2.affichageSolde());
        // System.out.println(client1.affichageSolde());
        CompteCourant cC1 = new CompteCourant(12,5000.0,"tata",500);
        CompteCourant cC2 = new CompteCourant(13,2000.0,"toto",600);

        CompteEpargne cE1 = new CompteEpargne(11,1500.0,"momo",0.02);
        CompteEpargne cE2 = new CompteEpargne(10,3000.0,"soso",0.03);

        System.out.println(cC1.depotArgent(200));
        System.out.println(cC2.retraitArgent(2300));
        System.out.println(cC1.transfertArgent(cC2,300));
        System.out.println(cC2.affichageSolde());
        System.out.println(cE1.depotArgent(200));
        System.out.println(cE2.depotArgent(400));
    }
}
