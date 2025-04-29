# Employee_database_application

This application demonstrates on how to connect database created in MySql using java for various data manipulation tasks.
It is used to insert data, update data and also delete the data in database.

## Instructions for project.

# 1.) downloading jdbc(java database connector) from mysql: https://dev.mysql.com/downloads/connector/j/
select the os type and download the connector.

# 2.) create java project in java supported IDE in this case vscode
create a java project template from settings without build tools and name your application.

It creates three folders bin, src, lib.

Add your jdbc connector in lib folder.

create a java main code in src folder and compile it using terminal or vs code.

It automatically creates a class in bin folder.

It is recommended to create properties file and add your username, password and database name with url for keeping sensitive data from access.

# 3.) code results

create a database and table with some columns.

make sure column names match with java code and check for data type.

After running the code it prompts user to enter id, first_name, last_name, age, income, Address to store the results in the database.
