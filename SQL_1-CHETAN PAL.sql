
create database e_commerce;
use e_commerce;
-- creating a customer table--
create table Customers(customer_id int primary key auto_increment,name varchar(50),email varchar(50),mobile varchar(15));
-- creating a products table--
create table Products(id int,name varchar(50) not null, description varchar(200),price decimal(10,2) not null,category varchar(50));

-- 3.	Modify Tables(using Alter keyword):--
-- Add not null on name and email in the Customers table
alter table Customers modify column name varchar(50) not null;
alter table customers modify column email varchar(50) not null;


-- b.	Add unique key on email in the Customers table--
alter table customers modify column email varchar(50) unique key;
-- c.	Add column age in the Customers table--
alter table customers add column age int;


-- d.	Change column name from id to product_id in the Products table;--
alter table Products rename column id to product_id;


-- e.	Add primary key and auto increment on product_id in the Products table--
alter table products modify column product_id int primary key auto_increment;



-- f.	Change datatype of description from varchar to text in the Products table
alter table products modify column description text(200);





-- 4.	Create table Order:--
/* i can't create a table named order as its a reserved word in sql that why i used a backticks so that sql server treat "order" as an identifier. */
create table `order`(order_id int primary key auto_increment, customer_id int ,product_id int ,quantity int not null,
order_date date not null, status enum('Pending','Success','Cancel'), payment_method enum('Credit','Debit''UPI'),total_amount decimal(10,2) not null,
foreign key(customer_id) references Customers(customer_id));
desc `order`;

-- 5.	Modify Orders Table(using Alter keyword):--
-- a.	Change table name Order -> Orders--
alter table `order` rename to orders;

-- b.	Set default value pending in status.--
alter table orders modify column status enum('Pending','Success','Cancel') default 'Pending';


-- c.	Modify payment_method ENUM to add one more value: 'COD'--
alter table orders modify column payment_method enum('Credit','Debit','UPI','COD');


-- d.	Make product id as foreign key--
alter table orders add foreign key(product_id) references products(product_id);
desc orders;
INSERT INTO products (name, description, price, category) VALUES
('Samsung Galaxy M14', 'Affordable smartphone with 6000mAh battery', 13999.00, 'Electronics'),
('Realme Narzo 60', 'Mid-range smartphone with AMOLED display', 17999.00, 'Electronics'),
('Boat Rockerz 255', 'Wireless Bluetooth earphones with deep bass', 999.00, 'Electronics'),
('Mi Pad 5', 'High-performance tablet with stylus support', 27999.00, 'Electronics'),
('Canon EOS 200D II', 'Compact DSLR with dual-pixel autofocus', 61990.00, 'Electronics'),
('LG Refrigerator', 'Double-door refrigerator with smart inverter', 26999.00, 'Home Appliances'),
('IFB Microwave Oven', 'Convection microwave with auto-cook menu', 8990.00, 'Home Appliances'),
('Philips Mixer Grinder', '750W mixer with advanced blades', 3499.00, 'Home Appliances'),
('Nilkamal Sofa Set', '5-seater wooden sofa with cushions', 22999.00, 'Furniture'),
('Godrej Dining Table', '6-seater dining set with glass top', 14999.00, 'Furniture'),
('IKEA Chair', 'Ergonomic office chair with lumbar support', 4999.00, 'Furniture'),
('Urban Ladder Bookshelf', '5-tier bookshelf with modern design', 7999.00, 'Furniture'),
('Puma T-shirt', 'Comfort-fit cotton T-shirt for men', 1199.00, 'Clothing'),
('Levi\'s Jeans', 'Slim-fit stretch jeans for men', 3299.00, 'Clothing'),
('Woodland Jacket', 'Water-resistant jacket for outdoor use', 5999.00, 'Clothing'),
('Adidas Sneakers', 'Running shoes with cloudfoam cushioning', 4999.00, 'Clothing'),
('Titan Watch', 'Analog wristwatch with leather strap', 7499.00, 'Accessories'),
('Skybags Backpack', 'Polyester backpack with multiple compartments', 2399.00, 'Accessories'),
('Ray-Ban Sunglasses', 'Polarized sunglasses with UV protection', 8999.00, 'Accessories'),
('Fastrack Bracelet', 'Casual bracelet for daily wear', 1499.00, 'Accessories');


-- sample data for 'customers'--

INSERT INTO customers (name, email, mobile, age) VALUES
('Amit Sharma', 'amit.sharma@example.com', '9876543210', 28),
('Priya Singh', 'priya.singh@example.com', '8765432109', 35),
('Rajesh Kumar', 'rajesh.kumar@example.com', '7654321098', 22),
('Sneha Patel', 'sneha.patel@example.com', '6543210987', 45),
('Vikram Mehra', 'vikram.mehra@example.com', '5432109876', 30),
('Anjali Das', 'anjali.das@example.com', '4321098765', 29),
('Rohit Verma', 'rohit.verma@example.com', '3210987654', 40),
('Pooja Nair', 'pooja.nair@example.com', '2109876543', 26),
('Karan Kapoor', 'karan.kapoor@example.com', '1098765432', 38),
('Neha Joshi', 'neha.joshi@example.com', '9987654321', 50),
('Arjun Reddy', 'arjun.reddy@example.com', '8876543210', 33),
('Meera Iyer', 'meera.iyer@example.com', '7765432109', 27),
('Suresh Rao', 'suresh.rao@example.com', '6654321098', 41),
('Divya Menon', 'divya.menon@example.com', '5543210987', 23),
('Rahul Chawla', 'rahul.chawla@example.com', '4432109876', 29),
('Nisha Khanna', 'nisha.khanna@example.com', '3321098765', 31),
('Tushar Jain', 'tushar.jain@example.com', '2210987654', 37),
('Isha Malhotra', 'isha.malhotra@example.com', '1109876543', 24),
('Siddharth Bhatia', 'siddharth.bhatia@example.com', '9098765432', 42),
('Rina Mukherjee', 'rina.mukherjee@example.com', '8987654321', 34);

-- sample data for 'orders'--
INSERT INTO orders (customer_id, product_id, quantity, order_date, status, payment_method, total_amount) VALUES
(1, 1, 1, '2024-01-10', 'Success', 'Credit', 13999.00),
(2, 2, 2, '2024-01-12', 'Pending', 'UPI', 35998.00),
(3, 3, 1, '2024-01-14', 'Success', 'Debit', 999.00),
(4, 4, 1, '2024-01-16', 'Cancel', 'COD', 27999.00),
(5, 5, 1, '2024-01-18', 'Success', 'Credit', 61990.00),
(6, 6, 1, '2024-01-20', 'Pending', 'Debit', 26999.00),
(7, 7, 2, '2024-01-22', 'Success', 'UPI', 17980.00),
(8, 8, 1, '2024-01-24', 'Success', 'Credit', 3499.00),
(9, 9, 1, '2024-01-26', 'Pending', 'COD', 22999.00),
(10, 10, 1, '2024-01-28', 'Success', 'UPI', 14999.00),
(11, 11, 1, '2024-02-01', 'Success', 'Credit', 4999.00),
(12, 12, 2, '2024-02-03', 'Pending', 'Debit', 15998.00),
(13, 13, 1, '2024-02-05', 'Success', 'UPI', 1199.00),
(14, 14, 1, '2024-02-07', 'Success', 'Credit', 3299.00),
(15, 15, 1, '2024-02-09', 'Pending', 'COD', 5999.00),
(16, 16, 1, '2024-02-11', 'Success', 'Debit', 4999.00),
(17, 17, 1, '2024-02-13', 'Success', 'Credit', 7499.00),
(18, 18, 1, '2024-02-15', 'Pending', 'UPI', 2399.00),
(19, 19, 1, '2024-02-17', 'Success', 'Debit', 8999.00),
(20, 20, 1, '2024-02-19', 'Success', 'COD', 1499.00);




-- a.	Count the number of products as product_count in each category.--
SELECT category, COUNT(*) AS product_count FROM products GROUP BY category;



-- b.	Retrieve all products that belong to the 'Electronics' category, have a price between $50(4250inr) and $500(42500inr), and whose name contains the letter 'a'.
SELECT * FROM products WHERE category = 'Electronics' AND price BETWEEN 4250 AND 42500 AND name LIKE '%a%';



-- c.	Get the top 5 most expensive products in the 'Electronics' category, skipping the first 2.--
SELECT * FROM products WHERE category = 'Electronics' ORDER BY price DESC LIMIT 2, 5;



-- d. Customers who have not placed any orders
SELECT * FROM customers WHERE customer_id NOT IN (SELECT DISTINCT customer_id FROM orders);



-- f. Products with price less than average price of all products
SELECT * FROM products WHERE price < (SELECT AVG(price) FROM products);

-- g. Total quantity of products ordered by each customer
SELECT c.customer_id, c.name, SUM(o.quantity) AS total_quantity FROM customers c JOIN orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id;

-- h. List all orders with customer name and product name
SELECT o.order_id, c.name AS customer_name, p.name AS product_name, o.order_date FROM orders o JOIN customers c ON o.customer_id = c.customer_id JOIN products p ON o.product_id = p.product_id;

-- i. Products never ordered
SELECT * FROM products WHERE product_id NOT IN (SELECT DISTINCT product_id FROM orders);


