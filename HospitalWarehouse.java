import java.time.LocalDate;
import java.util.*;

// import WarehouseMovement.MovementType;
// import 
public class HospitalWarehouse {
    private List<Drug> drugInventory;
    private List<WarehouseMovement> movementHistory;

    public HospitalWarehouse(){
        this.drugInventory = new ArrayList<>();
        this.movementHistory = new ArrayList<>();
    }

    public Drug createDrug(String name, String code, double price, int initialInventory, DrugCategory category){
        Drug newDrug = new Drug(name, code, price, initialInventory, category);
        drugInventory.add(newDrug);
        return newDrug;
    }

    public void displayAllDrugs(){
        System.out.println("\n== Current Drug Inventory ==");
        if(drugInventory.isEmpty()){
            System.out.println("No drugs in inventory");
        } else {
            drugInventory.forEach(System.out::println);
        }
    }

    public void createMovement(WarehouseMovement.MovementType type, Drug drug, int quantity, LocalDate date ){
        if (type == WarehouseMovement.MovementType.Export && drug.getInventory() < quantity) {
            throw new IllegalArgumentException("Cannot export " + quantity + " units of " + drug.getName() + ". There are only  " + drug.getInventory() + " units available.");
        }

        WarehouseMovement movement = new WarehouseMovement(type, drug, quantity, date);
        movementHistory.add(movement);
        if (type == WarehouseMovement.MovementType.Import){
            drug.updateInventory(quantity);
        }else {
            drug.updateInventory(-quantity);
        }
        System.out.println("Movement " + movement + " recorded with success");
    }


    public void displayExportMovements(Drug drug, LocalDate startDate, LocalDate endDate){
        List<WarehouseMovement> filtered = new ArrayList<>();

        for(WarehouseMovement movement: movementHistory){
            if(movement.getType() != WarehouseMovement.MovementType.Export){
                continue;
            }
            if(!movement.getDrug().equals(drug)){
                continue;
            }
            if(movement.getDate().isBefore(startDate) || movement.getDate().isAfter(endDate)){
                continue;
            }

            filtered.add(movement);
            if(filtered.isEmpty()){
                System.out.println("No exports found in the specified period");
            }else{
                for( WarehouseMovement m : filtered){
                    System.out.println(m);
                }
            }

        }

    }

}
