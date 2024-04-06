-- Create INVENTORY table
CREATE TABLE IF NOT EXISTS inventory (
    id INT PRIMARY KEY,
    ordered INT,
    price INT,
    available INT
);

-- Insert data into INVENTORY table
INSERT INTO inventory (id, ordered, price, available) VALUES
(1, 0, 100, 100),
(2, 10, 200, 90),
(3, 20, 300, 80),
(4, 30, 400, 70),
(5, 40, 500, 60),
(6, 50, 600, 50),
(7, 60, 700, 40),
(8, 70, 800, 30),
(9, 80, 900, 20),
(10, 90, 1000, 10);

-- Create COUPON table
CREATE TABLE IF NOT EXISTS coupon (
    id INT PRIMARY KEY,
    code VARCHAR(255),
    discount INT
);

-- Insert data into COUPON table
INSERT INTO coupon (id, code, discount) VALUES
(1, 'OFF5', 5),
(2, 'OFF10', 10),
(3, 'OFF15', 15),
(4, 'OFF20', 20),
(5, 'OFF25', 25),
(6, 'OFF30', 30),
(7, 'OFF35', 35),
(8, 'OFF40', 40),
(9, 'OFF45', 45),
(10, 'OFF50', 50);

-- Create ORDER table
CREATE TABLE IF NOT EXISTS orders (
    id INT PRIMARY KEY,
    user_id INT,
    quantity INT,
    amount INT,
    coupon_id INT,
    FOREIGN KEY (coupon_id) REFERENCES coupon(id)
);

-- Insert data into ORDER table
INSERT INTO orders (id, user_id, quantity, amount, coupon_id) VALUES
(1, 1, 10, 950, 1),
(2, 1, 20, 1800, 2),
(3, 2, 5, 475, 3),
(4, 2, 15, 1425, 4),
(5, 3, 8, 728, 5),
(6, 3, 12, 1080, 6),
(7, 4, 25, 2375, 7),
(8, 4, 30, 2700, 8),
(9, 5, 2, 190, 9),
(10, 5, 18, 1710, 10);

-- Create PAYMENT table
CREATE TABLE IF NOT EXISTS payment (
    id INT PRIMARY KEY,
    user_id INT,
    order_id INT,
    transaction_id VARCHAR(255),
    status VARCHAR(255)
);

-- Insert data into PAYMENT table
INSERT INTO payment (id, user_id, order_id, transaction_id, status) VALUES
(1, 1, 1, 'tran010100001', 'successful'),
(2, 1, 2, 'tran010100002', 'failed'),
(3, 2, 3, 'tran020100001', 'successful'),
(4, 2, 4, 'tran020100002', 'failed'),
(5, 3, 5, 'tran030100001', 'successful'),
(6, 3, 6, 'tran030100002', 'failed'),
(7, 4, 7, 'tran040100001', 'successful'),
(8, 4, 8, 'tran040100002', 'failed'),
(9, 5, 9, 'tran050100001', 'successful'),
(10, 5, 10, 'tran050100002', 'failed');
