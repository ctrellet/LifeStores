import java.util.ArrayList;

/**
 * Created by christophe on 05/02/17.
 */
public class FamilyMart implements ConvenienceStore {

    private ArrayList<Product> products = new ArrayList<Product>();
    private int employee;

    public FamilyMart(ArrayList<Product> products, int employee) {
        this.products.addAll( products );
        this .employee = employee;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Magasin chargé avec "+products.size()+" produit(s)." );
        System.out.println("Il y a "+employee+" employé(s)." );
    }

    public void setEmployee(int employee) {
        this.employee = employee;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Il y a "+employee+" employé(s)." );
    }

    public boolean sell(Product sellProduct) {

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Demande de vente du produit "+sellProduct.getName() );

        if(this.employee>0){

            for (Product prod:products) {

                if(prod.getName().equals(sellProduct.getName())){

                    // Le produit trouvé est retiré de la liste et on renvoie true
                    products.remove( prod);
                    return true;
                }
            }
        }

        // Le produit n'a pas été trouvé ou il n'y a pas d'employé, on retourne False
        return false;
    }

    public boolean filled() {
        final int maxStock = 2;
        return (boolean)(products.size()>=maxStock);
    }

    @Override
    public String toString() {
        return products.toString();
    }

}
