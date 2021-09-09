package com.example.restservice.utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class reads and writes discounts rates to a JSON file.
 */
@Component
public class Rates {

    // A variable to hold an employee discount rate
    private double employeeDiscount;
    // A variable to hold an affiliate discount rate
    private double affiliateDiscount;
    // A variable to hold a long time customer discount rate
    private double longCustomerDiscount;
    // A variable to hold an $100 bill discount rate
    private double billDiscount;

    /**
     * This a default constructor that reads discounts rates from a JSON file
     * then initialises the class fields.
     */
    public Rates(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("discountRates.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray discountRatesList = (JSONArray) obj;

            for (Object discount: discountRatesList) {
                JSONObject rate = (JSONObject) discount;
                employeeDiscount = (double)rate.get("employeeDiscount");
                affiliateDiscount = (double)rate.get("affiliateDiscount");
                longCustomerDiscount = (double)rate.get("longCustomerDiscount");
                billDiscount = (double)rate.get("billDiscount");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This a discount service method that calculates all the possible discounts and returns the total.
     * @param employeeDiscount The discount value for an employee.
     * @param affiliateDiscount  The discount value for an affiliate.
     * @param longCustomerDiscount  The discount value for a long time customer.
     * @param billDiscount  The discount value for a $100 bill.
     * @return String This returns a success or failed message of a file writing operation.
     */
    @SuppressWarnings("unchecked")
    public String setRates(double employeeDiscount, double affiliateDiscount, double longCustomerDiscount, double billDiscount){

        //
        JSONObject discountRates = new JSONObject();
        discountRates.put("employeeDiscount", employeeDiscount);
        discountRates.put("affiliateDiscount", affiliateDiscount);
        discountRates.put("longCustomerDiscount", longCustomerDiscount);
        discountRates.put("billDiscount", billDiscount);

        JSONArray discountList = new JSONArray();
        discountList.add(discountRates);

        try (FileWriter file = new FileWriter("discountRates.json")) {
            file.write(discountList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "failed";
        }

        return "success";
    }

    /**
     * This method returns the value of the employee discount
     * @return employeeDiscount
     */
    public double getEmployeeDiscount() {
        return employeeDiscount;
    }

    /**
     * This method returns the value of the affiliate discount
     * @return affiliateDiscount
     */
    public double getAffiliateDiscount() {
        return affiliateDiscount;
    }

    /**
     * This method returns the value of the long time customer discount
     * @return longCustomerDiscount
     */
    public double getLongCustomerDiscount() {
        return longCustomerDiscount;
    }

    /**
     * This method returns the value of a $100 bill discount
     * @return billDiscount
     */
    public double getBillDiscount() {
        return billDiscount;
    }
}
