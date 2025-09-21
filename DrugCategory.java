public class DrugCategory{
    private String name;
    // private String ParentCompanyID;

    public DrugCategory(String name){
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void SetName(String name){
        this.name = name;
    }

    @Override 
    public String toString(){
        return this.name;
    }
}