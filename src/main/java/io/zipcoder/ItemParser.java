package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class ItemParser {
//I'm going to assume you are a mile and cookie fan since they are the items that show up the most.
// Cue the Bernie Mac
// Milk & Cookie joke...'
//^n..e:\w+;p...e:\d...;t..e:f..d([;|@|%|!|*|^])e........n:\d.......6

    int count = 0;

    public ArrayList<String> parseRawDataIntoStringArray(String rawData){
        String stringPattern = "##";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawData);
        return response;
    }

    public boolean patternMatcherName (String rawItem){

        Pattern patName = Pattern.compile("(n..e:\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matchName = patName.matcher(rawItem);

        return matchName.find();
    }

    public boolean patternMatcherPrice (String rawItem){

        Pattern patPrice = Pattern.compile("(n..e:\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matchPrice = patPrice.matcher(rawItem);

        return matchPrice.find();
    }

    public boolean patternMatcherType (String rawItem){

        Pattern patType = Pattern.compile("(n..e:\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matchType = patType.matcher(rawItem);

        return matchType.find();
    }

    public boolean patternMatcherExp (String rawItem){

        Pattern patExp = Pattern.compile("(n..e:\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matchExp = patExp.matcher(rawItem);

        return matchExp.find();
    }

    public String getStringValuePair(String rawItem){
        ArrayList<String> tofind = findKeyValuePairsInRawItemData(rawItem);
        String toReturn = tofind.get(0).toLowerCase();
        return toReturn;
    }

    public String getStringValueandItem(String rawItem){
        ArrayList<String> name = new ArrayList<String>();
        if(patternMatcherName(rawItem)){
            ArrayList<String>keyValue =findKeyValuePairsInRawItemData(rawItem);
            name = splitStringWithRegexPattern(":", keyValue.get(0));
        }
              return name.get(1).toLowerCase();
    }



//    public Item parseStringIntoItem(String rawItem) throws ItemParseException{
//
//
//
//        return new Item(name, Double.parseDouble(price), type, expiration);
//
//    }

    private String compareMatches(Pattern patern, String keyField) {


        return null;

    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawItem){
        String stringPattern = "[;|^|!|@|%|*]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern , rawItem);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString){
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }



}