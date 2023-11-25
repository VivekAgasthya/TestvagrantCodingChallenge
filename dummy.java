import java.util.ArrayList;

class Product 
{
    String var;
    double up;
    double gst;
    int quantity;

    public Product(String var, double up, double gst, int quantity) 
    {
        this.var = var;
        this.up = up;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double calculateTotalPrice() {
        return up * quantity;
    }

    public double calculateGSTAmount() {
        return calculateTotalPrice() * (gst / 100.0);
    }
}

public class dummy 
{
    public static void main(String[] args)
     {
        ArrayList<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather Wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));
        Product maxGSTProduct = basket.get(0);
        double maxGSTAmount = maxGSTProduct.calculateGSTAmount();

        for (Product product : basket) {
            double currentGSTAmount = product.calculateGSTAmount();
            if (currentGSTAmount > maxGSTAmount) {
                maxGSTAmount = currentGSTAmount;
                maxGSTProduct = product;
            }
        }

        System.out.println("Product for which we paid maximum GST amount: " + maxGSTProduct.var);

        double totalamnt = 0;
        for (Product product : basket) {
            totalamnt += product.calculateTotalPrice();
        }

        System.out.println("\n Total Amount to be Paid to shopkeeper: " + totalamnt);
    }
}