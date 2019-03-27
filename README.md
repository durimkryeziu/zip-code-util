# ZipCodeUtil: Utility class for International Zip Code validation

[![Travis branch](https://img.shields.io/travis/durimkryeziu/zip-code-util/master.svg?style=flat-square)](https://travis-ci.org/durimkryeziu/zip-code-util) [![Coveralls branch](https://img.shields.io/coveralls/durimkryeziu/zip-code-util/master.svg?style=flat-square)](https://coveralls.io/github/durimkryeziu/zip-code-util?branch=master) [![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg?style=flat-square)](https://github.com/durimkryeziu/zip-code-util/blob/master/LICENSE)

Lightweight Zip Code library which offers some convenience methods to work with international Zip Codes

## Usage
```java
ZipCodeUtil zipCodeUtil = ZipCodeUtil.getInstance();

// Get Regular Expression for Ireland:
String regex = zipCodeUtil.getZipCodeRegexBy("IE"); // [\dA-Z]{3} ?[\dA-Z]{4}

// Get pre-compiled Pattern for Ireland:
Pattern pattern = zipCodeUtil.getZipCodePattern("IE");
Matcher matcher = pattern.matcher("A65 F4E2");
boolean isValid = matcher.matches(); // true

// Validate a Zip Code:
if (zipCodeUtil.isValid("GB", "GU16 7HF")) {
  // code
}
```

## 178 countries supported
Library accepts country codes of **ISO 3166-1 alpha-2** format

AC, AD, AF, AI, AL, AM, AR, AS, AT, AU, AX, AZ, BA, BB, BD, BE, BG, BH, BL, BM, BN, BR, BT, BY, CA, CC, CH, CL, CN, CO, CR, CV, CX, CY, CZ, DE, DK, DO, DZ, EC, EE, EG, EH, ES, ET, FI, FK, FM, FO, FR, GB, GE, GF, GG, GI, GL, GN, GP, GR, GS, GT, GU, GW, HM, HN, HR, HT, HU, ID, IE, IL, IM, IN, IO, IQ, IR, IS, IT, JE, JO, JP, KE, KG, KH, KR, KW, KY, KZ, LA, LB, LI, LK, LR, LS, LT, LU, LV, MA, MC, MD, ME, MF, MG, MH, MK, MM, MN, MP, MQ, MT, MU, MV, MX, MY, MZ, NC, NE, NF, NG, NI, NL, NO, NP, NZ, OM, PE, PF, PG, PH, PK, PL, PM, PN, PR, PT, PW, PY, RE, RO, RS, RU, SA, SE, SG, SH, SI, SJ, SK, SM, SN, SO, SV, SZ, TA, TC, TH, TJ, TM, TN, TR, TW, TZ, UA, UM, US, UY, UZ, VA, VC, VE, VG, VI, VN, WF, XK, YT, ZA, ZM

## License
MIT License

Copyright (c) 2017 - 2019 Durim Kryeziu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
