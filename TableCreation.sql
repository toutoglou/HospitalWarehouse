
CREATE TABLE drug_categories(
    category_id INT AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE drugs(
    drugid INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code varchar(50) NOT NULL UNIQUE,
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    inventory int NOT NULL CHECK (inventory >= 0),
    FOREIGN KEY (category_id) references drug_categories(category_id) 
);

CREATE TABLE warehouse_movements (
    movementID INT AUTO_INCREMENT PRIMARY KEY, 
    type ENUM('Import', 'Export') NOT NULL,
    drug_id INT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    movement_date DATA not null, 
    FOREIGN key (drugid) references drugs(drugid)
)