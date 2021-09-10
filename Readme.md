**Product Management Application - Performance Imporvement**

**Requirement**
Our requirement is to imporve the performance of an existing Product Management Application 
which provides Product metadata like Product Name, description, price, currency.

We created REST ENDPOINTs to provide these details using Spring Boot + JPA + MySql

**Problem here is**

Everytime, use try to get product information for  given productId, a database call is made.

For example, below 2 calls for the same productId (=154) results in 2 database calls.

http://localhost:8081/getproductinfo?productId=154 (DB call is made)

http://localhost:8081/getproductinfo?productId=154 (DB call is made)

As product metadata is fairly static, we can use caching here to reduce the number of database calls and improve performance.

So using REDIS caching mechanism, we are caching the results in first instance for a given productId and 
simply picking it from cache for all subsequent calls.

We configured TTL (Time-To-Live), kept Cache updation and eviction policies. 

These details can be configured as per our requirement.

In caching also we implemented multiple approaches like -

Caching only when the result is not null (It means given productId exists in the database)

Conditional Caching - Caching only if products belongs to Electronics category etc.
These caching conditions we can modify as per our requirement.

**Steps to run this application**

1. Clone the repo https://github.com/pavanuppuluri/Product-Management-Performance-Imporvment-REDIS-Cache.git
2. Make sure you have a runing REDIS server localhost:6379
3. Run the application

**Get Product Information** (Caching happens post this GET call for a given productId for the first time)

Method  **GET**

URL     **http://localhost:8081/getproductinfo**

Parameters **productId=152**

**Update Product Information** (Cache gets updated post this PUT call for a given productId in the cache)

Method  **PUT**

URL     **http://localhost:8081/updateproduct**

**Sample Payload**

{

    "productId": 154,
    
    "productName": "Laptop",
    
    "productCategory": "Electronics",
    
    "price": 3000.0,
    
    "currency": "USD",
    
    "description": "Dell Laptop"
    
}

**Delete Product Information** (Cache value for a given productId gets deleted post this DELETE call)

Method  **DELETE**

URL     **http://localhost:8081/deleteproduct?productId=153**


You can clearly see an improvement while calling the GET endpoint for a given productId from second time onwards.

Thanks to caching.

Happy Coding!!!

