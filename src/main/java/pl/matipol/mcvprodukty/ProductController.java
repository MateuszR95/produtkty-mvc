package pl.matipol.mcvprodukty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/list")
    public String list(@RequestParam(required = false) Category category, Model model) {
        List<Product> products;
        if (category == null) {
            products = productRepository.findAll();
        } else {
            products = productRepository.findByCategory(category);
        }
        model.addAttribute("products", products);
        return "list";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productRepository.addProduct(product);
        return "redirect:/list";
    }
}


