package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemParserTest {

    private String rawSingleItem = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

    private String rawSingleItemIrregularSeperatorSample = "naMe:MiLK;price:3.23;type:Food!expiration:1/11/2016##";

    private String rawBrokenSingleItem = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

    private String rawMultipleItems = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"
            + "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##"
            + "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    private ItemParser itemParser;

    @Before
    public void setUp() {
        itemParser = new ItemParser();
    }

    @Test
    public void parseRawDataIntoStringArrayTest() {
        Integer expectedArraySize = 3;
        ArrayList<String> items = itemParser.parseRawDataIntoStringArray(rawMultipleItems);
        Integer actualArraySize = items.size();
        assertEquals(expectedArraySize, actualArraySize);
    }


    @Test
    public void parseStringIntoItemTest() throws ItemParseException {
        Item expected = new Item("milk", 3.23, "food", "1/25/2016");
        Item actual = itemParser.parseStringIntoItem(rawSingleItem);
        assertEquals(expected.toString(), actual.toString());
    }

    @Test(expected = ItemParseException.class)
    public void parseBrokenStringIntoItemTest() throws ItemParseException {
        itemParser.parseStringIntoItem(rawBrokenSingleItem);
    }

    @Test
    public void findKeyValuePairsInRawItemDataTest() {
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItem).size();
        assertEquals(expected, actual);
    }

    @Test
    public void findKeyValuePairsInRawItemDataTestIrregular() {
        Integer expected = 4;
        Integer actual = itemParser.findKeyValuePairsInRawItemData(rawSingleItemIrregularSeperatorSample).size();
        assertEquals(expected, actual);
    }

///////////////   Test of the methods I created /////////////////////

    private String nothing = " ";

    ///  True - False
    @Test
    public void patternMatcherNameTest() {
        boolean expected = true;
        //Then
        boolean actual = itemParser.patternMatcherName(rawSingleItem);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherPriceTest() {
        boolean expected = true;
        //Then
        boolean actual = itemParser.patternMatcherPrice(rawSingleItem);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherTypeTrue() {
        boolean expected = true;
        //Then
        boolean actual = itemParser.patternMatcherType(rawSingleItem);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherExpTrue() {
        boolean expected = true;
        //Then
        boolean actual = itemParser.patternMatcherExp(rawSingleItem);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherNameTestFalse() {
        boolean expected = false;
        //Then
        boolean actual = itemParser.patternMatcherName(nothing);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherPriceFalse() {
        boolean expected = false;
        //Then
        boolean actual = itemParser.patternMatcherPrice(nothing);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherTypeFalse() {
        boolean expected = false;
        //Then
        boolean actual = itemParser.patternMatcherType(nothing);
        //When
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void patternMatcherExpFalse() {
        boolean expected = false;
        //Then
        boolean actual = itemParser.patternMatcherExp(nothing);
        //When
        Assert.assertEquals(expected, actual);
    }

    /// Sting Value
    @Test
    public void getStringValuePairTest() {


    String expected = "name:milk";

    String actual = itemParser.getStringValuePair(rawSingleItem);

    Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStringValueandItemTest() {
        String expected = "milk";
        String actual = itemParser.getStringValueandItem(rawSingleItem);
        Assert.assertEquals(expected, actual);
    }



}
