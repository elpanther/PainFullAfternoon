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


    public Item parseStringIntoItem(String rawItem) throws ItemParseException{

        Pattern patName = Pattern.compile("(n..e:\\w+)", Pattern.CASE_INSENSITIVE);
        Pattern patType = Pattern.compile("t..e:f..d([;|@|%|!|*|^])", Pattern.CASE_INSENSITIVE);
        Pattern patPrice = Pattern.compile("p...e:\\d...", Pattern.CASE_INSENSITIVE);
        Pattern patExp = Pattern.compile("e........n:\\d.......6", Pattern.CASE_INSENSITIVE);
       // Pattern patSplit = Pattern.compile(":");

        Matcher matchName = patName.matcher(rawItem);
        Matcher matchType = patType.matcher(rawItem);
        Matcher matchPrice = patPrice.matcher(rawItem);
        Matcher matchExp = patExp.matcher(rawItem);

//        while(matchName.find()){
//            try{
//                String name = matchName.group(0);
//                String[] keyValue = patSplit.split(name);
//                String nameValue = keyValue[1];
//
//            }
//            catch (ItemParseException e){
//                count++;
//
//            }
//            return new Item(name,Double.parseDouble(price),type, exp);
//        }
       return null;

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