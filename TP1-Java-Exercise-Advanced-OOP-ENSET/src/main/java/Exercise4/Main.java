package Exercise4;

/*
    On souhaite créer une hiérarchie de classes pour représenter différentes figures géométriques
    en utilisant des classes abstraites en Java. Vous devrez définir une classe abstraite Figure qui
    servira de base pour les différentes figures, telles que les cercles, les rectangles et les triangles.
    Chaque sous-classe de Figure devra implémenter les méthodes calculerAire() et
    calculerPerimetre() pour calculer l'aire et le périmètre de la figure.

    1. Créez une classe abstraite Figure avec les caractéristiques suivantes :
    • Un attribut protégé pour le nom de la figure.
    • Une méthode abstraite calculerAire() pour calculer l'aire de la figure.
    • Une méthode abstraite calculerPerimetre() pour calculer le périmètre de la figure.
    • Une méthode afficherDetails() pour afficher le nom de la figure, son aire et son périmètre.
 */

abstract class Figure{
    protected String nom_figure;
    public abstract double calculerAire();
    public abstract double calculerPerimetre();
    public String afficherDetails(){
        return this.nom_figure+ " " + this.calculerAire() + " " + this.calculerPerimetre();
    }

    public Figure(String nom_figure) {
        this.nom_figure = nom_figure;
    }
}
/*
    Créez des sous-classes pour différentes figures géométriques (par exemple, Cercle, Rectangle, Triangle) qui étendent la classe Figure. Pour chaque sous-classe :
    2. Classe Cercle :
    • Attributs :
    ▪ rayon (double) : Le rayon du cercle.
    • Constructeur :
    ▪ Cercle(String nom, double rayon) : Initialise un cercle avec un nom et un rayon.
    • Méthodes :
    ▪ calculerAire() : Calcule l'aire du cercle (π * rayon^2).
    ▪ calculerPerimetre() : Calcule le périmètre du cercle (2 * π * rayon).

 */

class Cercle extends Figure{
    Double rayon;

    public Cercle(String nom_figure, Double rayon) {
        super(nom_figure);
        this.rayon = rayon;
    }

    @Override
    public double calculerAire(){
        return Math.PI * Math.pow(this.rayon, 2);
    }
    @Override
    public double calculerPerimetre(){
        return 2 * Math.PI * this.rayon;
    }
}
/*
    3. Classe Rectangle :
    • Attributs :
    ▪ longueur (double) : La longueur du rectangle.
    ▪ largeur (double) : La largeur du rectangle.
    • Constructeur :
    ▪ Rectangle(String nom, double longueur, double largeur) : Initialise un rectangle avec un nom, une longueur et une largeur.
    • Méthodes :
    ▪ calculerAire() : Calcule l'aire du rectangle (longueur * largeur).
    ▪ calculerPerimetre() : Calcule le périmètre du rectangle (2 * (longueur + largeur)).

    Dans une classe principale, créez des objets de différentes figures géométriques, calculez leur aire et leur périmètre en utilisant les méthodes des sous-classes, et affichez les détails de chaque figure à l'aide de la méthode afficherDetails.
 */

class Rectangle extends Figure{
    double longueur;
    double largeur;

    public Rectangle(String nom_figure,double longueur,double largeur) {
        super(nom_figure);
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double calculerAire(){
        return this.longueur * this.largeur;
    }
    @Override
    public double calculerPerimetre(){
        return 2 * (this.longueur + this.largeur);
    }
}

class Triangle extends Figure{
    double base;
    double hauteur;
    double cote1;
    double cote2;

    public Triangle(String nom_figure,double base,double hauteur,double cote1,double cote2) {
        super(nom_figure);
        this.base = base;
        this.hauteur = hauteur;
        this.cote1 = cote1;
        this.cote2 = cote2;
    }


    @Override
    public double calculerAire(){
        return (this.base * this.hauteur) / 2;
    }

    @Override
    public double calculerPerimetre(){
        return (this.base + this.cote1 + this.cote2);
    }
}

public class Main {
    public static void main(String[] args) {
        Cercle c1 = new Cercle("Cercle", 1.5);
        Rectangle r1 = new Rectangle("Rectangle", 1.5, 1.5);
        Triangle t1 = new Triangle("Triange",5.0,3.2,4.3,4.8);

        System.out.println(c1.afficherDetails());
        System.out.println(r1.afficherDetails());
        System.out.println(t1.afficherDetails());
    }
}