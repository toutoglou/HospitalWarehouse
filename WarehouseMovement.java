import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WarehouseMovement {
    
    public enum MovementType {
        Import, 
        Export
    }


    private MovementType type;
    private Drug drug;
    private int quantity;
    private LocalDate date;

    public WarehouseMovement(MovementType type, Drug drug, int quantity, LocalDate date ){
        this.type = type;
        this.drug = drug;
        this.quantity = quantity;
        this.date = date;
    }

    public MovementType getType() { return type; }
    public Drug getDrug() { return drug; }
    public int getQuantity() { return quantity; }
    public LocalDate getDate() { return date; }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format(
            "Movement{Type=%s, Drug='%s', Quantity=%d, Date=%s}",
            type, drug.getName(), quantity, date.format(formatter)
        );
    }
}
