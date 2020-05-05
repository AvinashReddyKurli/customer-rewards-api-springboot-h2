# customer-rewards
customer rewards API using Spring Boot

To run application follow below instructions:
1. Right click on the CustomerRewardsApplication.java and Run As -> Java Application
2. Once spring boot app is up and running go to the Postman tool
3. Use the URL for getting rewards for all customers :http://localhost:8095/customersRewardCalculator/rewards
4. Use the URL for getting rewards for each customer as :http://localhost:8095/customersRewardCalculator/rewards/{customerId}
   * Unique CustomerId's :- 101,102,103..
5. Select the HTTP type: GET
6. Click on the Authorization tab and provide the 
	Username: admin
	password: password
6. To see rest call response click on send button
7. If user provide invalid username/password then service will return the 401-unauthorized error
8. *** You can see all the endpoints at below swagger URL ***
   http://localhost:8095/swagger-ui.html#/customer-rewards-controller