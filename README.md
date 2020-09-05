# TestFramework

### This project has main three files.

<b> 1. RegistrationTest.java </b> :- This is the main test class, which includes test method in it. <br>
<b> 2. RegistrationObjectRepo.java </b> :- This is the page object class, which has all elements and getter/setter method for the test class. <br>
<b> 3. RegistrationDataReader.java </b> :- This is the data provider class, which reads data from the excel file and pass it to the test class.

Apart from these three java files, I created test cases that are in the "TestData.xls" under the "resources" folder. I am using data of these test cases as input data for RegistrationTest.java.

For the driver, I created the "Drivers" folder, which include webdriver for the chrome. 
You will find "index.html" under "test-output" folder for the testNG report.


### Note:- I used chromedirver for MAC. For any other platform, please add the driver compatible with that platform in the "Drivers" folder.  
