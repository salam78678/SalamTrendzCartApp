# SalamTrendzCartApp
E-commerce REST API based on Java Spring, Spring Boot, Hibernate ORM with MySQL, Spring Fox (Swagger API docs).
REST API Endpoints

All inputs and outputs use JSON format.

To open Swagger (interactive) API documentation, navigate your browser to [YOUR-URL]/swagger-ui.html

/login
  POST / - Login using username: b and password:b

/Items
  GET / - List of Items
  POST / - Add Items - 
  GET /{id} - View Items
  POST /{id} - Update product
  
  DELETE /{id}/ - Remove Items with ID {id} from cart with ID {id}
/Customer
  GET / - List of customer
  POST / - Add customer
  GET /{id} - View customer
  POST /{id} - Update group

/order
  GET / - List of orders
  POST / - Add order
  GET /{id} - View order
  POST /{id} - Update order
   DELETE /{id}/ - Remove Order with ID {id} from cart with ID {id}



