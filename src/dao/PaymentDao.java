package dao;
import java.util.ArrayList;
import java.util.List;

import model.Amount;
import model.Category;

public class PaymentDao {
    private static PaymentDao instance = null;

    private PaymentDao() {}

    protected List<Category> categoryList = null;

    protected List<Amount> amountList = new ArrayList<Amount>();

    public static PaymentDao getInstance() {
        if (instance == null) {
            synchronized (PaymentDao .class){
                if (instance == null) {
                    instance = new PaymentDao();
                }
            }
        }
        return instance;
    }

    /**
     *
     * @return List<Category>
     */
    public List<Category> getCategoryList() {
        if (categoryList == null) {
            categoryList = new ArrayList<Category>();

            categoryList.add(new Category("first"));
            categoryList.add(new Category("second"));
            categoryList.add(new Category("third"));
        }
        return categoryList;
    }

    public List<Amount> getAmountList() {
        return amountList;
    }

    public Category getCategoryByName(String name) {
        Category selectedCategory = null;
        for(Category category:getCategoryList()) {
            if (category.getName().equals(name)) {
                selectedCategory = category;
                break;
            }
        }
        return selectedCategory;



    }




}
