# TeddyMadile

## How it can be run

1. Clone repository @ https://github.com/tedmad/RetailStore.git
2. Import the repository into InteliJ
3. Navigate to src>main>java>com>example>restservice and open RestServiceApplication.java
4. Run the class 
5. Go to web browser and go this link http://localhost:8080/swagger-ui/
6. Click on the invoice-controller link
7. Click the second get button (the one labelled /api/invoice)
8. Click try-it-out button
9. Fill the fields:
    bill: 100.0
    billType: 0
    user: 1
   
10. Click execute button
11. You should get the following response
    {
    "id": 1,
    "amountPaid": 100,
    "discount": 35,
    "netPayable": 65
    }
    

## Code Coverage
1. Right click "rest-service" on the project explorer
2. Navigate to "Run 'All Test' with Coverage
3. The coverage explorer should appear on the right, then navigate to com>example>restservice 

    
