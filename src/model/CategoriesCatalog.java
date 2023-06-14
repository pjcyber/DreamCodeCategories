package model;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.HashSet;

public class CategoriesCatalog {

    public final Category root = new Category("Root", new HashMap<>());
    // to get the focus Node for a specific key
    public Category focusNode;

    public int level = 0;
    private final HashSet<String> nodes = new HashSet<>();

    public void addCategories(Category... subCategories) {
        if (subCategories == null) return;

        for (Category child : subCategories) {
            root.getSubCategories().put(child.getName(), child);
        }
    }

    public void addSubCategories(String categoryName, Category... subCategories) {
        findFocusNode(root, categoryName);
        for (Category child : subCategories) {
            focusNode.getSubCategories().put(child.getName(), child);
        }
        focusNode = null;
    }

    public void showAllNodes(@NotNull Category currentNode) {
        if (currentNode == null) { currentNode = root; }

        System.out.println(currentNode.getName());

        if (!currentNode.getSubCategories().isEmpty()) {
            for (Category node : currentNode.getSubCategories().values()) {
                showAllNodes(node);
            }
        }
    }

    public void findFocusNode(@NotNull Category currentNode, @NotNull String key) {
        if (currentNode == null) { currentNode = root; }

        if (key.equals(currentNode.getName())) {
            focusNode = currentNode;
            return;
        }

        if (!currentNode.getSubCategories().isEmpty()) {
            for (Category node : currentNode.getSubCategories().values()) {
                findFocusNode(node, key);
            }
        }
    }

    public void setLevelByKey(@NotNull  Category currentNode, String key) {
        if (currentNode == null) { currentNode = root; }

//        if (root.getSubCategories().containsKey(currentNode.getName())) {
//            level = 2;
//        }
//
//        if (!currentNode.getSubCategories().isEmpty() && !nodes.containsAll(currentNode.getSubCategories().keySet())) {
//            level++;
//            //System.out.println(level);
//        }

        nodes.addAll(currentNode.getSubCategories().keySet());
        //System.out.println(nodes);

        if (currentNode.getName().equals(key)) {
            return;
        }
        for(Category node: currentNode.getSubCategories().values()) {
            setLevelByKey(node, key);
        }
    }
}
