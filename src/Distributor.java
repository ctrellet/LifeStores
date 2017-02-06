import java.util.ArrayList;

/**
 * Created by christophe on 05/02/17.
 */
public class Distributor implements ConvenienceStore {

    protected ArrayList<Product> products = new ArrayList<Product>();

    public Distributor(ArrayList<Product> products) {
        this.products.addAll( products );
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Distibuteur chargé avec "+products.size()+" produit(s)." );
    }

    public boolean sell(Product sellProduct) {

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Demande de vente du produit "+sellProduct.getName()+" produit(s)." );

        for (Product prod:products) {

            if(prod.getName().equals(sellProduct.getName())){

                // Le produit trouvé est retiré de la liste et on renvoie true
                products.remove( prod);
                return true;
            }
        }
        // Le produit n'a pas été trouvé, on retourne False
        return false;
    }

    public boolean filled() {
        final int maxStock = 5;
        return (boolean)(products.size()>=maxStock);
    }

    @Override
    public String toString() {
        return products.toString();
    }

}
