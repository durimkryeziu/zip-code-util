package com.programmingskillz.zipcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.regex.Pattern;

public class ZipCodeUtilTest {

  @Rule
  public ExpectedException exception = ExpectedException.none();

  private static ZipCodeUtil zipCodeUtil = ZipCodeUtil.getInstance();

  @Test
  public void getZipCodeRegexReturnsRegexForGivenCountryCode() {
    String regex = zipCodeUtil.getZipCodeRegex("AR");

    assertThat(regex).isNotNull();
    assertThat(regex).isEqualTo("((?:[A-HJ-NP-Z])?\\d{4})([A-Z]{3})?");
  }

  @Test
  public void getZipCodeRegexReturnsNullWhenCantFindRegexPerGivenCountryCode() {
    String regex = zipCodeUtil.getZipCodeRegex("ABC");

    assertThat(regex).isNull();
  }

  @Test
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsNull() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodeRegex(null);
  }

  @Test
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsEmpty() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodeRegex("");
  }

  @Test
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsBlank() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodeRegex("      ");
  }

  @Test
  public void getZipCodePatternReturnsThePatternPerGivenCountryCode() {
    Pattern pattern = zipCodeUtil.getZipCodePattern("XK");

    assertThat(pattern).isNotNull();
    assertThat(pattern.pattern()).isEqualTo("[1-7]\\d{4}");
  }

  @Test
  public void getZipCodePatternReturnsNullWhenCantFindPatternPerGivenCountryCode() {
    Pattern pattern = zipCodeUtil.getZipCodePattern("XYZ");

    assertThat(pattern).isNull();
  }

  @Test
  public void getZipCodePatternThrowsExceptionWhenCountryCodeIsNull() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodePattern(null);
  }

  @Test
  public void getZipCodePatternThrowsExceptionWhenCountryCodeIsEmpty() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodePattern("");
  }

  @Test
  public void getZipCodePatternThrowsExceptionWhenCountryCodeIsBlank() {
    exception.expect(IllegalArgumentException.class);
    exception.expectMessage("'countryCode' must not be null, empty or blank");

    zipCodeUtil.getZipCodePattern("      ");
  }
}