package exercice1;

/*
    On souhaite réaliser une application Java contenant une classe EntierNaturel
    permettant de gérer des entiers naturels (positifs ou nuls) et un nouveau type
    d'exception personnalisé en écrivant une classe NombreNegatifException qui
    spécialise la classe Exception. La classe EntierNaturel dispose :
 */

class EntierNaturel {
    /*
        - d’un constructeur avec un argument de type int pour initialiser l’attribut
        val; il générera une exception de type NombreNegatifException si la
        valeur de son argument est négative ;
     */
    private int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if(val < 0) throw new NombreNegatifException("Le Nombre doit etre Positif");
        this.val = val;
    }
    /*
        - un accesseur en lecture getVal() qui fournira sous forme d’un int la valeur
        encapsulée dans un objet de type EntierNaturel;
     */
    public int getVal() {
        return val;
    }
    /*
        - un accesseur en écriture setVal() qui modifiera la valeur de l'entier
        naturel grâce à un int passé en paramètre; cette méthode générera
        une exception de type NombreNegatifException si la valeur passée
        en paramètre est négative ;
     */
    public void setVal(int val) throws NombreNegatifException {
        if (val < 0) throw new NombreNegatifException("Le nombre doit etre Positif");
        this.val = val;
    }
    /*
        - une méthode decrementer() qui décrémente de 1 l’attribut val de l’objet
        EntierNaturel; cette méthode devra pouvoir lever une exception de
        type NombreNegatifException;
     */
    public int decrementer() throws NombreNegatifException {
        if (val-1 < 0) throw new NombreNegatifException("\uD83D\uDEA8 le nombre est negatif");
        return --val;
    }

    public String toString(){
        return "value (" + val +")";
    }
}
/*
    Écrire une méthode main qui utilise les méthodes de la classe EntierNaturel,
    en capturant les exceptions susceptibles d’être générées.
    On souhaite également mémoriser la valeur erronée qui a entrainé sa génération.
    Modifier la classe d’exception NombreNegatifException de façon à ce qu’elle
    permet le stockage de cette valeur, et fournir une méthode permettant de
    consulter cette valeur. Testez à nouveau.
 */

public class Main{
    public static void main(String[] args) {
        try {
            EntierNaturel e1 = new EntierNaturel(5);

            System.out.println(e1);

            e1.setVal(5);
            int count = e1.getVal();
            for(int i =0 ; i < count; ++i){
                System.out.println(e1.decrementer());
            }
        } catch (NombreNegatifException e) {
            System.out.println(e.getMessage());
        }
    }
}