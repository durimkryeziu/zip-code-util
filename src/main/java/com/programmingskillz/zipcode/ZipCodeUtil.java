package com.programmingskillz.zipcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility which helps you work with international Zip Codes. Functionality includes retrieving Zip Code
 * regular expression as String per ISO country code, retrieving Zip Code as java.util.Pattern per ISO
 * country code and validation a given Zip Code.
 *
 * Patterns are taken from Google's open-source address metadata site:
 * https://chromium-i18n.appspot.com/ssl-address
 *
 * @author Durim Kryeziu
 */
public enum ZipCodeUtil {

  INSTANCE;

  /**
   * The Zip Code Regular Expressions per ISO Country Code
   */
  private static final Map<String, String> REGULAR_EXPRESSIONS;

  static {
    Map<String, String> regularExpressions = new HashMap<>();
    regularExpressions.put("AC", "ASCN 1ZZ");
    regularExpressions.put("AD", "AD[1-7]0\\d");
    regularExpressions.put("AF", "\\d{4}");
    regularExpressions.put("AI", "(?:AI-)?2640");
    regularExpressions.put("AL", "\\d{4}");
    regularExpressions.put("AM", "(?:37)?\\d{4}");
    regularExpressions.put("AR", "((?:[A-HJ-NP-Z])?\\d{4})([A-Z]{3})?");
    regularExpressions.put("AS", "(96799)(?:[ \\-](\\d{4}))?");
    regularExpressions.put("AT", "\\d{4}");
    regularExpressions.put("AU", "\\d{4}");
    regularExpressions.put("AX", "22\\d{3}");
    regularExpressions.put("AZ", "\\d{4}");
    regularExpressions.put("BA", "\\d{5}");
    regularExpressions.put("BB", "BB\\d{5}");
    regularExpressions.put("BD", "\\d{4}");
    regularExpressions.put("BE", "\\d{4}");
    regularExpressions.put("BG", "\\d{4}");
    regularExpressions.put("BH", "(?:\\d|1[0-2])\\d{2}");
    regularExpressions.put("BL", "9[78][01]\\d{2}");
    regularExpressions.put("BM", "[A-Z]{2} ?[A-Z0-9]{2}");
    regularExpressions.put("BN", "[A-Z]{2} ?\\d{4}");
    regularExpressions.put("BR", "\\d{5}-?\\d{3}");
    regularExpressions.put("BT", "\\d{5}");
    regularExpressions.put("BY", "\\d{6}");
    regularExpressions.put("CA", "[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z] ?\\d[ABCEGHJ-NPRSTV-Z]\\d");
    regularExpressions.put("CC", "6799");
    regularExpressions.put("CH", "\\d{4}");
    regularExpressions.put("CL", "\\d{7}");
    regularExpressions.put("CN", "\\d{6}");
    regularExpressions.put("CO", "\\d{6}");
    regularExpressions.put("CR", "\\d{4,5}|\\d{3}-\\d{4}");
    regularExpressions.put("CV", "\\d{4}");
    regularExpressions.put("CX", "6798");
    regularExpressions.put("CY", "\\d{4}");
    regularExpressions.put("CZ", "\\d{3} ?\\d{2}");
    regularExpressions.put("DE", "\\d{5}");
    regularExpressions.put("DK", "\\d{4}");
    regularExpressions.put("DO", "\\d{5}");
    regularExpressions.put("DZ", "\\d{5}");
    regularExpressions.put("EC", "\\d{6}");
    regularExpressions.put("EE", "\\d{5}");
    regularExpressions.put("EG", "\\d{5}");
    regularExpressions.put("EH", "\\d{5}");
    regularExpressions.put("ES", "\\d{5}");
    regularExpressions.put("ET", "\\d{4}");
    regularExpressions.put("FI", "\\d{5}");
    regularExpressions.put("FK", "FIQQ 1ZZ");
    regularExpressions.put("FM", "(9694[1-4])(?:[ \\-](\\d{4}))?");
    regularExpressions.put("FO", "\\d{3}");
    regularExpressions.put("FR", "\\d{2} ?\\d{3}");
    regularExpressions.put("GB", "GIR ?0AA|(?:(?:AB|AL|B|BA|BB|BD|BF|BH|BL|BN|BR|BS|BT|BX|CA|CB|CF|CH|CM|CO|CR|CT|CV|CW|DA|DD|DE|DG|DH|DL|DN|DT|DY|E|EC|EH|EN|EX|FK|FY|G|GL|GY|GU|HA|HD|HG|HP|HR|HS|HU|HX|IG|IM|IP|IV|JE|KA|KT|KW|KY|L|LA|LD|LE|LL|LN|LS|LU|M|ME|MK|ML|N|NE|NG|NN|NP|NR|NW|OL|OX|PA|PE|PH|PL|PO|PR|RG|RH|RM|S|SA|SE|SG|SK|SL|SM|SN|SO|SP|SR|SS|ST|SW|SY|TA|TD|TF|TN|TQ|TR|TS|TW|UB|W|WA|WC|WD|WF|WN|WR|WS|WV|YO|ZE)(?:\\d[\\dA-Z]? ?\\d[ABD-HJLN-UW-Z]{2}))|BFPO ?\\d{1,4}");
    regularExpressions.put("GE", "\\d{4}");
    regularExpressions.put("GF", "9[78]3\\d{2}");
    regularExpressions.put("GG", "GY\\d[\\dA-Z]? ?\\d[ABD-HJLN-UW-Z]{2}");
    regularExpressions.put("GI", "GX11 1AA");
    regularExpressions.put("GL", "39\\d{2}");
    regularExpressions.put("GN", "\\d{3}");
    regularExpressions.put("GP", "9[78][01]\\d{2}");
    regularExpressions.put("GR", "\\d{3} ?\\d{2}");
    regularExpressions.put("GS", "SIQQ 1ZZ");
    regularExpressions.put("GT", "\\d{5}");
    regularExpressions.put("GU", "(969(?:[12]\\d|3[12]))(?:[ \\-](\\d{4}))?");
    regularExpressions.put("GW", "\\d{4}");
    regularExpressions.put("HM", "\\d{4}");
    regularExpressions.put("HN", "\\d{5}");
    regularExpressions.put("HR", "\\d{5}");
    regularExpressions.put("HT", "\\d{4}");
    regularExpressions.put("HU", "\\d{4}");
    regularExpressions.put("ID", "\\d{5}");
    regularExpressions.put("IE", "[\\dA-Z]{3} ?[\\dA-Z]{4}");
    regularExpressions.put("IL", "\\d{5}(?:\\d{2})?");
    regularExpressions.put("IM", "IM\\d[\\dA-Z]? ?\\d[ABD-HJLN-UW-Z]{2}");
    regularExpressions.put("IN", "\\d{6}");
    regularExpressions.put("IO", "BBND 1ZZ");
    regularExpressions.put("IQ", "\\d{5}");
    regularExpressions.put("IR", "\\d{5}-?\\d{5}");
    regularExpressions.put("IS", "\\d{3}");
    regularExpressions.put("IT", "\\d{5}");
    regularExpressions.put("JE", "JE\\d[\\dA-Z]? ?\\d[ABD-HJLN-UW-Z]{2}");
    regularExpressions.put("JO", "\\d{5}");
    regularExpressions.put("JP", "\\d{3}-?\\d{4}");
    regularExpressions.put("KE", "\\d{5}");
    regularExpressions.put("KG", "\\d{6}");
    regularExpressions.put("KH", "\\d{5}");
    regularExpressions.put("KR", "\\d{5}");
    regularExpressions.put("KW", "\\d{5}");
    regularExpressions.put("KY", "KY\\d-\\d{4}");
    regularExpressions.put("KZ", "\\d{6}");
    regularExpressions.put("LA", "\\d{5}");
    regularExpressions.put("LB", "(?:\\d{4})(?: ?(?:\\d{4}))?");
    regularExpressions.put("LI", "948[5-9]|949[0-8]");
    regularExpressions.put("LK", "\\d{5}");
    regularExpressions.put("LR", "\\d{4}");
    regularExpressions.put("LS", "\\d{3}");
    regularExpressions.put("LT", "\\d{5}");
    regularExpressions.put("LU", "\\d{4}");
    regularExpressions.put("LV", "LV-\\d{4}");
    regularExpressions.put("MA", "\\d{5}");
    regularExpressions.put("MC", "980\\d{2}");
    regularExpressions.put("MD", "\\d{4}");
    regularExpressions.put("ME", "8\\d{4}");
    regularExpressions.put("MF", "9[78][01]\\d{2}");
    regularExpressions.put("MG", "\\d{3}");
    regularExpressions.put("MH", "(969[67]\\d)(?:[ \\-](\\d{4}))?");
    regularExpressions.put("MK", "\\d{4}");
    regularExpressions.put("MM", "\\d{5}");
    regularExpressions.put("MN", "\\d{5}");
    regularExpressions.put("MP", "(9695[012])(?:[ \\-](\\d{4}))?");
    regularExpressions.put("MQ", "9[78]2\\d{2}");
    regularExpressions.put("MT", "[A-Z]{3} ?\\d{2,4}");
    regularExpressions.put("MU", "\\d{3}(?:\\d{2}|[A-Z]{2}\\d{3})");
    regularExpressions.put("MV", "\\d{5}");
    regularExpressions.put("MX", "\\d{5}");
    regularExpressions.put("MY", "\\d{5}");
    regularExpressions.put("MZ", "\\d{4}");
    regularExpressions.put("NC", "988\\d{2}");
    regularExpressions.put("NE", "\\d{4}");
    regularExpressions.put("NF", "2899");
    regularExpressions.put("NG", "\\d{6}");
    regularExpressions.put("NI", "\\d{5}");
    regularExpressions.put("NL", "\\d{4} ?[A-Z]{2}");
    regularExpressions.put("NO", "\\d{4}");
    regularExpressions.put("NP", "\\d{5}");
    regularExpressions.put("NZ", "\\d{4}");
    regularExpressions.put("OM", "(?:PC )?\\d{3}");
    regularExpressions.put("PE", "(?:LIMA \\d{1,2}|CALLAO 0?\\d)|[0-2]\\d{4}");
    regularExpressions.put("PF", "987\\d{2}");
    regularExpressions.put("PG", "\\d{3}");
    regularExpressions.put("PH", "\\d{4}");
    regularExpressions.put("PK", "\\d{5}");
    regularExpressions.put("PL", "\\d{2}-\\d{3}");
    regularExpressions.put("PM", "9[78]5\\d{2}");
    regularExpressions.put("PN", "PCRN 1ZZ");
    regularExpressions.put("PR", "(00[679]\\d{2})(?:[ \\-](\\d{4}))?");
    regularExpressions.put("PT", "\\d{4}-\\d{3}");
    regularExpressions.put("PW", "(969(?:39|40))(?:[ \\-](\\d{4}))?");
    regularExpressions.put("PY", "\\d{4}");
    regularExpressions.put("RE", "9[78]4\\d{2}");
    regularExpressions.put("RO", "\\d{6}");
    regularExpressions.put("RS", "\\d{5,6}");
    regularExpressions.put("RU", "\\d{6}");
    regularExpressions.put("SA", "\\d{5}");
    regularExpressions.put("SE", "\\d{3} ?\\d{2}");
    regularExpressions.put("SG", "\\d{6}");
    regularExpressions.put("SH", "(?:ASCN|STHL) 1ZZ");
    regularExpressions.put("SI", "\\d{4}");
    regularExpressions.put("SJ", "\\d{4}");
    regularExpressions.put("SK", "\\d{3} ?\\d{2}");
    regularExpressions.put("SM", "4789\\d");
    regularExpressions.put("SN", "\\d{5}");
    regularExpressions.put("SO", "[A-Z]{2} ?\\d{5}");
    regularExpressions.put("SV", "CP [1-3][1-7][0-2]\\d");
    regularExpressions.put("SZ", "[HLMS]\\d{3}");
    regularExpressions.put("TA", "TDCU 1ZZ");
    regularExpressions.put("TC", "TKCA 1ZZ");
    regularExpressions.put("TH", "\\d{5}");
    regularExpressions.put("TJ", "\\d{6}");
    regularExpressions.put("TM", "\\d{6}");
    regularExpressions.put("TN", "\\d{4}");
    regularExpressions.put("TR", "\\d{5}");
    regularExpressions.put("TW", "\\d{3}(?:\\d{2})?");
    regularExpressions.put("TZ", "\\d{4,5}");
    regularExpressions.put("UA", "\\d{5}");
    regularExpressions.put("UM", "96898");
    regularExpressions.put("US", "(\\d{5})(?:[ \\-](\\d{4}))?");
    regularExpressions.put("UY", "\\d{5}");
    regularExpressions.put("UZ", "\\d{6}");
    regularExpressions.put("VA", "00120");
    regularExpressions.put("VC", "VC\\d{4}");
    regularExpressions.put("VE", "\\d{4}");
    regularExpressions.put("VG", "VG\\d{4}");
    regularExpressions.put("VI", "(008(?:(?:[0-4]\\d)|(?:5[01])))(?:[ \\-](\\d{4}))?");
    regularExpressions.put("VN", "\\d{6}");
    regularExpressions.put("WF", "986\\d{2}");
    regularExpressions.put("XK", "[1-7]\\d{4}");
    regularExpressions.put("YT", "976\\d{2}");
    regularExpressions.put("ZA", "\\d{4}");
    regularExpressions.put("ZM", "\\d{5}");
    REGULAR_EXPRESSIONS = Collections.unmodifiableMap(regularExpressions);
  }

  /**
   * Pre-compiled Zip Code java.util.regex.Patterns per ISO Country Code
   */
  private static final Map<String, Pattern> PATTERNS;

  static {
    Map<String, Pattern> patterns = new HashMap<>();
    REGULAR_EXPRESSIONS.forEach((key, value) -> patterns.put(key, Pattern.compile(value)));
    PATTERNS = Collections.unmodifiableMap(patterns);
  }

  /**
   * Provides you with the Regular Expressions map per ISO Country code to manipulate with it on your way
   * @return the unmodifiable String Regular Expressions map
   */
  public Map<String, String> getRegularExpressionsMap() {
    return REGULAR_EXPRESSIONS;
  }

  /**
   * Provides you with the Regular Expressions map per ISO Country code to manipulate with it on your way
   * @return the unmodifiable pre-compiled java.util.regex.Patterns map
   */
  public Map<String, Pattern> getPatternsMap() {
    return PATTERNS;
  }

  /**
   * Provides the Zip Code Regular Expression as String per given country code
   * @param countryCode the ISO Country Code
   * @return the Zip Code Regular Expression as String per given country
   * or null if can't find the regular expression for that country
   * @throws IllegalArgumentException if countryCode is null, empty or blank
   */
  public String getZipCodeRegex(String countryCode) {
    if (countryCode == null || countryCode.trim().isEmpty()) {
      throw new IllegalArgumentException("'countryCode' must not be null, empty or blank");
    }
    return REGULAR_EXPRESSIONS.get(countryCode.toUpperCase());
  }

  /**
   * Provides the Zip Code Regular Expression as java.util.regex.Pattern per given country code
   * @param countryCode the ISO Country Code
   * @return the Zip Code Regular Expression as java.util.regex.Pattern per given country
   * or null if can't find the regular expression for that country
   * @throws IllegalArgumentException if countryCode is null, empty or blank
   */
  public Pattern getZipCodePattern(String countryCode) {
    if (countryCode == null || countryCode.trim().isEmpty()) {
      throw new IllegalArgumentException("'countryCode' must not be null, empty or blank");
    }
    return PATTERNS.get(countryCode.toUpperCase());
  }

  /**
   * Checks if the given Zip Code is valid for given country code
   * @param countryCode the ISO Country code
   * @param zipCode the Zip Code to validate
   * @return true if Zip Code is valid, false if Zip Code is invalid or no regex found for given country code
   * @throws IllegalArgumentException if countryCode or zipCode is null, empty or blank
   */
  public boolean isValid(String countryCode, String zipCode) {
    if (countryCode == null || countryCode.trim().isEmpty()) {
      throw new IllegalArgumentException("'countryCode' must not be null, empty or blank");
    }
    if (zipCode == null || zipCode.trim().isEmpty()) {
      throw new IllegalArgumentException("'zipCode' must not be null, empty or blank");
    }
    Pattern pattern = PATTERNS.get(countryCode);
    if (pattern != null) {
      Matcher matcher = pattern.matcher(zipCode);
      return matcher.matches();
    }
    return false;
  }

  /**
   * Returns a singleton instance of the ZipCodeUtil utility class
   * @return a singleton instance of the ZipCodeUtil
   */
  public static ZipCodeUtil getInstance() {
    return INSTANCE;
  }
}
