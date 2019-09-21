# microserviceExample with 2 services communicating through rabbitMQ a message broker.
To run this you need to start rabbitMQ server and then build the given maven project or just run the jar file on target.
- First run the sender and it prompts you to enter the name from the console, then sends a message: "Hello my name is, {name}"
- Then run the receiver and observe the message sent from the sender is displayed on the receiver as : "Hello {name}, I am your father!"

Running server Hint : Install the rabbitMQ server on your machine or use docker to provision the rabbit server service.

Once install navigate to the server folder on terminal/commandline, then start the server : start RabbitMQ Server


