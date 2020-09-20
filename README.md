# business-rule-engine

##Java Spring boot - Command line runner application

### How to build?
Maven Build: mvn clean install<br/><br/>


Main Class: PaymentBusinessRuleApplication<br/><br/>

### How to run?
Go to target directory once build is done<br/>
Run the following command in command prompt<br/>
java -jar business-rule-engine-0.0.1-SNAPSHOT.jar

### Where do I locate test cases?
All the test cases are located in PaymentBusinessRuleApplicationTests.java under test source<br/>
This class covers all the test scienarios.<br/>

### Design patterns used
1. Factory - PaymentPostProcessorFactory.java - to get appropriate post processor chain for item type<br/>
2. Singleton - Spring internally uses<br/>
3. Prototype - Direct object instantiation as needed<br/>
4. Facade - PaymentDelegate.java - to hide non-business logic (creation of post processor) from business logic<br/>
5. Flyweight - Slip cloning for Royalty dept functionality<br/>
6. Chain of responsibility - PostProcessorChain.java - To add post processors after payment is processed<br/>
7. Mediator - PaymentService accepts Abstract PostProcessor chain to execute the post processor chains<br/>
8. Template - Interface, Implementation strategy on PaymentService interface to DefaultPaymentProcessor concrete implementation<br/>

### Important
Please observe the console log message while running test cases.<br/>
Every operation is logged by the logger<br/>
