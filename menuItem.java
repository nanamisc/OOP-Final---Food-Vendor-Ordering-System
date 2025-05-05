public class menuItem {
    private String name;
    private double price;
    private String ingredients;
    //constrcutor
    public menuItem(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;

    }

    //getters and setters

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
       
    }

}



