package pl.matipol.mcvprodukty;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Mleko", 4.5, Category.GROCERIES));
        products.add(new Product(2, "Pralka", 2200.0, Category.HOUSEHOLD_ITEMS));
        products.add(new Product(3, "Buty", 320.99, Category.OTHER));
        products.add(new Product(4, "Czekolada", 5.2, Category.GROCERIES));
        products.add(new Product(5, "Lodówka", 3100.0, Category.HOUSEHOLD_ITEMS));
        products.add(new Product(6, "Jogurt", 3.2, Category.GROCERIES));
        products.add(new Product(7, "Gra komputerowa", 190.0, Category.OTHER));
        products.add(new Product(8, "Woda", 2.5, Category.GROCERIES));
    }
    public List<Product> findAll() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .toList();
    }
}
