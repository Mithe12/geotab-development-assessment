# README #

# Random Joke Generator Application

Random Joke Generator application takes inputs from user through the choices made while using the application.It will substitutes people name with Chuck Norris and gives random jokes based on user response.

##Overview of the Main Components

**API**:  Contains the class that establishes the connection to the endpoint ( Chuck Norris API and Name Generator API) and gets the response data.

**Service**: Contains the class that has business logic to generate random jokes based on user given input.

**Model**:  Contains the class that store the incoming JSON data into Model object or Data Transfer Object.

**Deserializer**: Contains the class to transform JSON data into given Model.

**Http**: Contains the class to create HTTP client connection and HTTP request.

**Exception**: Contains the class of custom Exception.

**IO**: Contains the class to read user inputs and properties files and writes the output in console.

**View**: Contains the class to interacts with user.

**Test**: Contains the class to test various part of the application.

**Main.java**: Entry point to the application.

**Config.properties** : Contains configuration details for the application.
