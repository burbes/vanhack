
I'm using mysql data base, the database creator script is at 
src\main\resources\db\migration\v1_init.sql

To insert data run file  
scripts\init.sql

======================================================================
Using Basic Auth 
User: vanhack
Pass: vanhack
======================================================================
Cousine

GET /api/v1/Cousine
GET /api/v1/Cousine/search/{searchText}
GET /api/v1/Cousine/{cousineId}/stores

======================================================================
Customer

POST /api/v1/Customer/auth
POST /api/v1/Customer
======================================================================
Order

GET /api/v1/Order/{orderId}
POST /api/v1/Order
GET /api/v1/Order/customer
======================================================================
Product

GET /api/v1/Product
GET /api/v1/Product/search/{searchText}
GET /api/v1/Product/{productId}
======================================================================
Store

GET /api/v1/Store
GET /api/v1/Store/search/{searchText}
GET /api/v1/Store/{storeId}
GET /api/v1/Store/{storeId}/products
