package model;

public class Amount {

    protected String name;

    protected Integer amount;

    protected Category category;

    public Amount(String name, int amount, Category category) {
        super();
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }


    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }


    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }


}
