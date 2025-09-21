public class Drug {
    private String name;
    private String drugCode;
    private double price;
    private int inventory;
    private DrugCategory category;

    public Drug(String name, String drugCode, double price, int stock, DrugCategory category){
        this.name = name;
        this.drugCode = drugCode;
        this.price = price; 
        this.inventory = stock;
        this.category = category;
    }

    public String getName(){return name;}
    public String getDrugCode(){return drugCode;}
    public double getPrice(){return price;}
    public int getInventory(){return inventory;}
    public DrugCategory getDrugCategory(){return category;}

    public void setName(String name) {this.name = name;}
    public void setId(String drugCode) {this.drugCode = drugCode;}
    public void setPrice(double price) {this.price = price;}
    public void setInventory(int inventory) {this.inventory = inventory;}
    // public void setDrugCategory(DrugCategory Category) {this.category = category;}

    
    public void updateInventory(int quantity){
        this.inventory += quantity;
    }

    @Override 
    public String toString(){
        return String.format("Drug{Name='%s, DrugCode='%s', Price=%.2f, Stock=%d, Category='%s'}",
            name, drugCode, price, inventory, category.getName());
    }

}
