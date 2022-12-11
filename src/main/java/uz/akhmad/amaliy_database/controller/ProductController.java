package uz.akhmad.amaliy_database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.akhmad.amaliy_database.dto.ProductsCreationDto;
import uz.akhmad.amaliy_database.entity.Product;
import uz.akhmad.amaliy_database.service.ProductService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
//
//    @Autowired
//    ProductService productService;
//
//    @GetMapping("/all")
//    public String getAll(Model model) {
//        List<Product> products = productService.getAll();
//        model.addAttribute("products", products);
//        return "product/index";
//    }
//
//    @GetMapping("/add")
//    public String add() {
//        return "product/save";
//    }
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute("product") Product product, Model model) {
//        productService.save(product);
//        return "product/success";
//    }
//
//    @GetMapping(value = "/edit")
//    public String showEditForm(Model model) {
//        List<Product> products = new ArrayList<>();
//        productService.getAll()
//                .iterator()
//                .forEachRemaining(products::add);
//
//        model.addAttribute("form", new BooksCreationDto(books));
//
//        return "editBooksForm";
//    }
@Autowired
private ProductService productService;

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        model.addAttribute("products", productService.findAll());

        return "product/allProducts";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        ProductsCreationDto productForm = new ProductsCreationDto();

        for (int i = 1; i <= 3; i++) {
            productForm.addProduct(new Product());
        }

        model.addAttribute("form", productForm);

        return "product/createProductsForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        List<Product> products = new ArrayList<>();
        productService.findAll()
                .iterator()
                .forEachRemaining(products::add);

        model.addAttribute("form", new ProductsCreationDto(products));

        return "product/editBooksForm";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute ProductsCreationDto form, Model model) {
        productService.saveAll(form.getProducts());

        model.addAttribute("products", productService.findAll());

        return "product/allProducts";
    }
}
