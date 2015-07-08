# QuickTapSurvey API Sample Code and Helper Libraries
 QuickTapSurvey allows businesses to collect data on mobile tablets and phones even if they are offline and aggregate that data across
 many devices in order to view, download, analyze or export that data. QuickTapSurvey also provides a RESTful JSON based API. 
 This repository contains helper libraries and sample code in various programming languages that allow our customers to connect to our API in seconds 
 without having to write most of the standard boiler plate code. These libraries have been designed to work on OSX and Linux operating systems.
 
 IMPORTANT: These helper libraries and sample code or "Sofware" is provided "as is", without warranty of any kind, express or implied,
 including but not limited to the warranties of merchantability, fitness for a particular purpose and noninfringement.
 In no event shall QuickTapSurvey or TabbleDabble Inc. be liable for any claim, damages or other liability, whether in
 an action or contract, tort or otherwise, arising from, out of or in connection with the software or the use or other 
 dealings in the Software. The Software may be used for any purpose, including paid-services, without any royalties. Use this software at your own risk.
 
The help library files for the following programming languages are within their respectively named folders in the root folder:
- [PHP](https://github.com/QuickTapSurvey/api-samples/tree/master/PHP)
- [Python](https://github.com/QuickTapSurvey/api-samples/tree/master/Python)
- [Java](https://github.com/QuickTapSurvey/api-samples/tree/master/Java)

# Overview
The helper libraries do the following:
1. Login to the QuickTapSurvey API with the given username, password and API key. You must generate your API key in 
advance in the account section of [QuickTapSurvey](https://www.quicktapsurvey.com/admin/account) while logged in as an Account Manager.
2. Retrieve a list of the first 25 surveys
3. Retrieve the first 25 survey responses of the first survey in the list

Dates must be in the following format: **2014-09-09 17:25:34 -0400**

For all the of the sample code, you must update the username, password and API key values to your own values.

More [detailed documentation](http://support.quicktapsurvey.com/support/solutions/159751) on the QuickTapSurvey API can be found [here](http://support.quicktapsurvey.com/support/solutions/159751)

## Feedback
If you have feedback, suggestions or comments on the API, please [contact us](mailto:support@quicktapsurvey.com) anytime.

# PHP
To use the PHP sample code, modify the api.php file to set your own username, password and API key. The PHP helper scripts require the PHP curl binding of the cURL C library, libcurl.
In many cases, this may already be installed with your php installation.
See [here](http://php.net/manual/en/book.curl.php) for more details. 
To run the sample code, enter the following command in the location where your helper scripts reside:
```
php api.php
```

# Python
To use the Python sample code, modify the api.php file to set your own username, password and API key. The python helper scripts require pycurl, a python binding of the cURL C library, libcurl.
To install pycurl on OSX, you can try to run the following command:
```
sudo easy_install pycurl
```
To run the sample code, enter the following command in the location where your helper scripts reside:
```
python api.py
```
# Java
To use the Java sample code, modify the Main.java file to set your own username, password and API key.The Java sample code and helper classes are contained in the format of an Eclipse project. Import the Java folder as a project in Eclipse and then use a run configuration to run it from within Eclipse. It uses Gson for JSON encoding and decoding. It also uses log4j as a logging too. These two libraries (JARs) are included in the project.

Keywords: ipad survey app tablet phone data collection lead capture acquisition retrieval audit evaluation customer satisfaction feedback form
