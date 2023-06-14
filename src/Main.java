import model.CategoriesCatalog;
import model.Category;

import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        CategoriesCatalog categoriesCatalog = new CategoriesCatalog();

        Category a = new Category("A", new HashMap<>());
        Category b = new Category("B", new HashMap<>());
        Category c = new Category("C", new HashMap<>());

        categoriesCatalog.addCategories(c, a, b);

        Category a1 = new Category("A1", new HashMap<>());
        Category a2 = new Category("A2", new HashMap<>());
        Category a3 = new Category("A3", new HashMap<>());

        categoriesCatalog.addSubCategories("A", a1, a2, a3);

        Category a20 = new Category("A20", new HashMap<>());
        Category a21 = new Category("A21", new HashMap<>());
        Category a22 = new Category("A22", new HashMap<>());
        Category a23 = new Category("A23", new HashMap<>());

        categoriesCatalog.addSubCategories("A2", a20, a21, a22, a23);

        Category b1 = new Category("B1", new HashMap<>());
        Category b2 = new Category("B2", new HashMap<>());
        Category b3 = new Category("B3", new HashMap<>());

        categoriesCatalog.addSubCategories("B", b1, b2, b3);

        Category b20 = new Category("B20", new HashMap<>());
        Category b21 = new Category("B21", new HashMap<>());
        Category b22 = new Category("B22", new HashMap<>());
        Category b23 = new Category("B23", new HashMap<>());
        categoriesCatalog.addSubCategories("B2", b20, b21, b22, b23);

        // to show the all tree
         System.out.println("All Nodes ::::");
         categoriesCatalog.showAllNodes(categoriesCatalog.root);

        // to find a specific node
        // and display a specific node and children
        System.out.println("Find Specific Node ::::");
        categoriesCatalog.findFocusNode(categoriesCatalog.root,"A2");
        System.out.print(categoriesCatalog.focusNode.getName() + " ... "  + categoriesCatalog.focusNode.getSubCategories().keySet());

    }

}