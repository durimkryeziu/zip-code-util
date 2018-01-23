# ZipCodeUtil: Utility class for International Zip Code validation

[![Travis branch](https://img.shields.io/travis/durimkryeziu/zip-code-util/master.svg?style=flat-square)](https://travis-ci.org/durimkryeziu/zip-code-util)

Lightweight Zip Code library which offers some convenience methods to work with international Zip Codes

## Usage
```java
ZipCodeUtil zipCodeUtil = ZipCodeUtil.getInstance();

// Get Regular Expression for Ireland:
String regex = zipCodeUtil.getZipCodeRegex("IE"); // [\dA-Z]{3} ?[\dA-Z]{4}

// Get pre-compiled Pattern for Ireland:
Pattern pattern = zipCodeUtil.getZipCodePattern("IE");
Matcher matcher = pattern.matcher("A65 F4E2");
boolean isValid = matcher.matches(); // true

// Validate a Zip Code:
if (zipCodeUtil.isValid("GB", "GU16 7HF")) {
  // Yep! Valid United Kingdom Zip Code
}
```

## License
MIT License

Copyright (c) 2018 Durim Kryeziu

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
