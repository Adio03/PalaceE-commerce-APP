use `palace_e-commerce`;
  insert into `palace_e-commerce`.merchant(id,email,first_name,last_name,password,phone_number,user_name,is_merchant_login)
  value (100,'adio@gmail.com','adio','awal','adio1234','07049182688','adios',true),
      (101,'adio01@gmail.com','adio01','awal','adio1234','07049182601','adis',true),
      (102,'adio02@gmail.com','adio','awal','adio1234','07049182602','adisa',true),
      (103,'adio03@gmail.com','adio','awal','adio1234','07049182603','adise',true),
      (104,'adio04@gmail.com','adio','awal','adio1234','07049182604','adisi',true),
      (105,'adio05@gmail.com','adio','awal','adio1234','07049182605','adisu',true),
      (106,'adio06@gmail.com','adio','awal','adio1234','07049182606','adisiba',true),
      (107,'adio07@gmail.com','adio','awal','adio1234','07049182607','cool',true),
      (108,'adio08@gmail.com','adio','awal','adio1234','07049182608','coolest',true),
      (109,'adio09@gmail.com','adio','awal','adio1234','07049182609','culs',true),
      (110,'adio00@gmail.com','adio','awal','adio1234','07049182600','adi',true);


insert into store_table(id,merchant_Id,store_description,store_name,store_url)
value
    (101,103,'SportWear','Sportty','www.sportty.com'),
    (102,104,'Traditional Clothe Dealer','Traddy','www.traddy.com'),
    (103,105,'Computer Hardwares','Computy','www.computy.com'),
    (104,106,'Soft Drink','Softy','www.Softy.com'),
    (105,107,'Food Vendor','Foodie','www.foodie.com'),
    (106,108,'Fast Food','Snackie','www.snackie.com'),
    (107,109,'Fast Food','Snackie_G','www.snackie_G.com'),
    (108,110,'Computer Hardwares','Royal_computer','www.royalComputer.com');

insert into `palace_e-commerce`.product_table(id,categories, description, merchant_id, product_name, quantity, store_id)
value (100,'FASHION','fashion Designer',100,'Kaftan',20,2),
    (101,'FASHION','fashion Designer',100,'Kaftan',20,2),
    (102,'FASHION','fashion Designer',100,'Kaftan',20,2),
    (103,'FASHION','fashion Designer',100,'Kaftan',20,2),
    (104,'FASHION','fashion Designer',100,'Kaftan',20,2),
    (105,'FASHION','fashion Designer',100,'Kaftan',20,2);

insert into  `palace_e-commerce`.product_price(id, global_price, price_currency, sale_price)
value (100,500,'NGN',400),
    (101,200,'NGN',100),
    (102,800,'NGN',500),
    (103,500,'NGN',300),
    (104,500,'NGN',100),
    (105,500,'NGN',500);
