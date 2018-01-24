package com.programmingskillz.zipcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ZipCodeUtilTest {

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

  @Test(expected = IllegalArgumentException.class)
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsNull() {
    zipCodeUtil.getZipCodeRegex(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsEmpty() {
    zipCodeUtil.getZipCodeRegex("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getZipCodeRegexThrowsExceptionWhenCountryCodeIsBlank() {
    zipCodeUtil.getZipCodeRegex("      ");
  }
}