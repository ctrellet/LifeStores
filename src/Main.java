import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by christophe on 05/02/17.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("                      LifeStores project");

        System.out.println("======================================================================");
        System.out.println("Création de la liste des produits à partir du fichier products.csv :");
        System.out.println("----------------------------------------------------------------------");

        final String FILE_NAME = "/home/christophe/IdeaProjects/LifeStores/src/products.csv";
        final String CSV_SEPARATOR = ",";

        ArrayList<Product> listProducts = new ArrayList<Product>();

        String line ;
        String[] splittedLine;
        String productName;
        float productPrice;

        try {

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            // On parcourt les lignes du CSV
            while ((line = br.readLine()) != null) {

                // On split la ligne avec le séparateur et on affecte chaque membre à la variable voulue
                splittedLine = line.split(CSV_SEPARATOR,3); // Ce qu'il y a après le 3ème champ sera ingnoré
                productName = splittedLine[0];
                productPrice = Float.parseFloat(splittedLine[1]);

                // On instancie un nouveau Product qu'on ajoute à la liste
                Product productToAdd = new Product(productName,productPrice);
                listProducts.add(productToAdd);

                System.out.println("Produit : nom=" + splittedLine[0] + " , prix=" + splittedLine[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("======================================================================");
        System.out.println("Instanciation du Distributeur avec la liste des produits");

        Distributor aDistributor = new Distributor(listProducts);


        System.out.println("======================================================================");
        System.out.println("Tentative de vente d'un produit");

        if(aDistributor.sell(new Product("aquarius"))){
            System.out.println("Vente réussie." );
        }else{
            System.out.println("Vente avortée." );
        };


        System.out.println("======================================================================");
        System.out.println("Statut du stock :");

        System.out.println("----------------------------------------------------------------------");
        if(aDistributor.filled()){
            System.out.println("Plein." );
        }else{
            System.out.println("Non plein." );
        };


        System.out.println("======================================================================");
        System.out.println("Inventaire du distributeur" );
        System.out.println("----------------------------------------------------------------------");

        System.out.println( aDistributor.toString() );



        System.out.println("======================================================================");
        System.out.println("Instanciation du Magasin avec la liste des produits et l'employé");

        FamilyMart aFamilyMart = new FamilyMart(listProducts,1);


        System.out.println("======================================================================");
        System.out.println("Statut du stock :");

        System.out.println("----------------------------------------------------------------------");
        if(aFamilyMart.filled()){
            System.out.println("Plein." );
        }else{
            System.out.println("Non plein." );
        };


        System.out.println("======================================================================");
        System.out.println("Tentative de vente d'un produit");

        if(aFamilyMart.sell(new Product("pocky"))){
            System.out.println("Vente réussie." );
        }else{
            System.out.println("Vente avortée." );
        };


        System.out.println("======================================================================");
        System.out.println("Départ de l'employé :");

        aFamilyMart.setEmployee(0);


        System.out.println("======================================================================");
        System.out.println("Tentative de vente d'un produit");

        if(aFamilyMart.sell(new Product("evian"))){
            System.out.println("Vente réussie." );
        }else{
            System.out.println("Vente avortée." );
        };


        System.out.println("======================================================================");
        System.out.println("Inventaire du magasin" );
        System.out.println("----------------------------------------------------------------------");

        System.out.println( aFamilyMart.toString() );

    }
}
