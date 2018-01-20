package com.programmingskillz.zipcode;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ZipCodeUtils {

  /**
   * Don't let anyone instantiate this class.
   */
  private ZipCodeUtils() {
    throw new AssertionError("Helper class");
  }

  /**
   * The Zip Code Regular Expressions per ISO Country Code
   */
  private static final Map<String, String> zipCodeRegExes;

  static {
    zipCodeRegExes = new HashMap<>();
    zipCodeRegExes.put("AT", "\\d{4}");                                 // Austria
    zipCodeRegExes.put("BE", "\\d{4}");                                 // Belgium
    zipCodeRegExes.put("BG", "\\d{4}");                                 // Bulgaria
    zipCodeRegExes.put("CY", "\\d{4}");                                 // Cyprus
    zipCodeRegExes.put("CZ", "\\d{3}\\s\\d{2}");                        // Czech Republic
    zipCodeRegExes.put("DE", "\\d{5}");                                 // Germany
    zipCodeRegExes.put("DK", "\\d{4}");                                 // Denmark
    zipCodeRegExes.put("EE", "\\d{5}");                                 // Estonia
    zipCodeRegExes.put("ES", "\\d{5}");                                 // Spain
    zipCodeRegExes.put("FI", "\\d{5}");                                 // Finland
    zipCodeRegExes.put("FR", "\\d{5}");                                 // France
    zipCodeRegExes.put("GB", "[A-Z][A-Z]?\\d([A-Z]|\\d)?\\s");          // United Kingdom
    zipCodeRegExes.put("GR", "\\d{3}\\s\\d{2}");                        // Greece
    zipCodeRegExes.put("HR", "\\d{5}");                                 // Croatia
    zipCodeRegExes.put("HU", "\\d{4}");                                 // Hungary
    zipCodeRegExes.put("IE", "[A-Z]\\d(\\d|W)\\s[A-Z][A-Z\\d]{3}\\s");  // Ireland
    zipCodeRegExes.put("IT", "\\d{5}");                                 // Italy
    zipCodeRegExes.put("LT", "LT-\\d{5}\\s");                           // Lithuania
    zipCodeRegExes.put("LU", "\\d{4}");                                 // Luxembourg
    zipCodeRegExes.put("LV", "LV-\\d{4}\\s");                           // Latvia
    zipCodeRegExes.put("MT", "[A-Z]{3}\\s\\d{4}\\s");                   // Malta
    zipCodeRegExes.put("NL", "\\d{4}(\\s[A-Z]{2})?\\s");                // Netherlands
    zipCodeRegExes.put("PL", "\\d{2}-\\d{3}\\s");                       // Poland
    zipCodeRegExes.put("PT", "\\d{4}(-\\d{3})?\\s");                    // Portugal
    zipCodeRegExes.put("RO", "\\d{6}\\s");                              // Romania
    zipCodeRegExes.put("SE", "\\d{3}\\s\\d{2}");                        // Sweden
    zipCodeRegExes.put("SI", "(SI-)?\\d{4}\\s");                        // Slovenia
    zipCodeRegExes.put("SK", "\\d{3}\\s\\d{2}");                        // Slovakia
  }

  /**
   * The Zip Code java.util.regex.Patterns per ISO Country Code
   */
  private static final Map<String, Pattern> zipCodePatterns;

  static {
    zipCodePatterns = new HashMap<>();
    zipCodeRegExes.forEach((key, value) -> zipCodePatterns.put(key, Pattern.compile(value)));
  }

  /**
   * Provides an array of Regular Expressions
   * @return a String array of Regular Expressions
   */
  public static String[] getRegExArray() {
    return zipCodeRegExes.values().toArray(new String[0]);
  }

  /**
   * Provides a list of Regular Expressions
   * @return a List of Strings of Regular Expressions
   */
  public static List<String> getRegExList() {
    return new ArrayList<>(zipCodeRegExes.values());
  }

  /**
   * Provides the java.util.regex.Pattern array of Regular Expressions
   * @return a java.util.regex.Pattern array of Regular Expressions
   */
  public static Pattern[] getRegExPatternsArray() {
    return zipCodePatterns.values().toArray(new Pattern[0]);
  }

  /**
   * Provides the List of java.util.regex.Patterns of Regular Expressions
   * @return a List of java.util.regex.Patterns of Regular Expressions
   */
  public static List<Pattern> getRegExPatternsList() {
    return new ArrayList<>(zipCodePatterns.values());
  }

  /**
   * Provides the Zip Code Regular Expression as String per given country
   * @param countryCode the ISO Country Code
   * @return the Zip Code Regular Expression as String per given country
   * or null if can't find regex per that country
   * @throws IllegalArgumentException if countryCode is null, empty or blank
   */
  public static String getZipCodeRegEx(String countryCode) {
    Assert.hasText(countryCode, "'countryCode' must not be null, empty or blank");
    return zipCodeRegExes.get(countryCode.toUpperCase());
  }

  /**
   * Provides the Zip Code Regular Expression as java.util.regex.Pattern per given country
   * @param countryCode the ISO Country Code
   * @return the Zip Code Regular Expression as java.util.regex.Pattern per given country
   * or null if can't find regex per that country
   * @throws IllegalArgumentException if countryCode is null, empty or blank
   */
  public static Pattern getZipCodePattern(String countryCode) {
    Assert.hasText(countryCode, "'countryCode' must not be null, empty or blank");
    return zipCodePatterns.get(countryCode.toUpperCase());
  }
}
