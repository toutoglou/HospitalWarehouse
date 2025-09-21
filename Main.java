import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        HospitalWarehouse warehouse = new HospitalWarehouse();

        
        DrugCategory antibiotics = new DrugCategory("Antibiotics");
        DrugCategory vitamins = new DrugCategory("Vitamin");
        DrugCategory painkillers = new DrugCategory("Painkillers");
        
        Drug aspirin = warehouse.createDrug("Aspirin", "ASP1435", 5.12, 34, painkillers);
        Drug sulfonamide = warehouse.createDrug("Sulfomanide", "SLF3431", 12.3, 12, antibiotics);
        Drug penicillin = warehouse.createDrug("Penicillin", "PEN029", 5.99, 100, antibiotics);
        Drug supplementC = warehouse.createDrug("VitaminC", "VTC102", 2.32, 29, vitamins);
        
        warehouse.displayAllDrugs();

        warehouse.createMovement(WarehouseMovement.MovementType.Import, penicillin,50, LocalDate.of(2025, 9, 21));
        warehouse.createMovement(WarehouseMovement.MovementType.Export, sulfonamide, 3, LocalDate.of(2024, 10, 29));
        warehouse.createMovement(WarehouseMovement.MovementType.Export, sulfonamide, 3, LocalDate.of(2024, 02, 29));
        warehouse.createMovement(WarehouseMovement.MovementType.Import,  supplementC, 99, LocalDate.of(2024, 12, 04));
        
        
        warehouse.displayExportMovements(penicillin, LocalDate.of(2025, 9, 1), LocalDate.of(2024, 9, 30));

         try {
            warehouse.createMovement(
                    WarehouseMovement.MovementType.Export,
                    aspirin,
                    300, // Trying to export more than available
                    LocalDate.of(2024, 9, 7)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }   
}
