package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class ItemParser {
//I'm going to assume you are a mile and cookie fan since they are the items that show up the most.
// Cue the Bernie Mac
// Milk & Cookie joke...'
//([A-Za-z])\w+|([\d*\.\d{2}])|(\d{1}\/\d{2}\/\d{4})

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }



    public Item parseStringIntoItem(String rawItem) throws ItemParseException{
//        ArrayList<String> keyName = findKeyValuePairsInRawItemData(rawItem);
//        ArrayList<String> keyPrice = findKeyValuePairsInRawItemData(rawItem);
//        ArrayList<String> keyType = findKeyValuePairsInRawItemData(rawItem);
//        ArrayList<String> keyExp = findKeyValuePairsInRawItemData(rawItem);
//        Matcher theName = Pattern.compile("name:", Pattern.CASE_INSENSITIVE).matcher(rawItem);
//        Matcher theType = Pattern.compile("type:", Pattern.CASE_INSENSITIVE).matcher(rawItem);
//        Matcher thePrice = Pattern.compile("price: (([\\d\\.\\d{2}]))", Pattern.CASE_INSENSITIVE).matcher(rawItem);
//        Matcher theExp = Pattern.compile("expiration: (\\d{1}\\d{2}\\d{4})", Pattern.CASE_INSENSITIVE).matcher(rawItem);


        //  return new Item(toString(theName).replace("0", "o"), Double.parseDouble(toString(thePrice)), toString(theType), toString(theExp));

//
        Pattern patName = Pattern.compile("([nN][aA][mM][eE]):([a-zA-z0-9]+)");
        Pattern patType = Pattern.compile("([tT][yY][pP][eE]):([a-zA-z]+)");
        Pattern patPrice = Pattern.compile("([pP][rR][iI][cC][eE]):([0-9]+\\.[0-9]+)");
        Pattern patExp = Pattern.compile("([eE][xX][pP][iI][rR][aA][tT][iI][oO0][nN]):([0-9]+\\/[0-9]+\\/[0-9]+)");

        ArrayList<String> keyPairs = findKeyValuePairsInRawItemData(rawItem);

        String name = keyPairs.get(0);
        name = compareMatches(patName, name);

        String type = keyPairs.get(1);
        type = compareMatches(patType, type);

        String price = keyPairs.get(2);
        price = compareMatches(patPrice, price);

        String exp = keyPairs.get(3);
        exp = compareMatches(patExp, exp);


        return new Item(name,Double.parseDouble(price),type, exp);

    }

    private String compareMatches(Pattern patern, String keyField) {
        return null;
    }

//    private String toString(Matcher theName) {
//        return "this is a test";
//    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^|!|@|%|*]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }



}