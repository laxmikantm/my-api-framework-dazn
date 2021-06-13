

# ==  Instructions ==


All tests are build using standard packaging solution: Maven. & could be centrally deployed using standard POM.XML Test are written in Cucumber BDD fashion

#### System Requirements: 

OS: Mac OS X or Win 8

Java 8 SDK


## To Run the Tests

#### Option1 (preferred)
a) Import Maven Dependencies 

b) Check the BDD Feature files located at:

```> src/test/resources/features```

b) In IntelliJ Go to **src> test> runners> RunCucumberIT** 

c) Right click and Run

#### Option2

a) From commandline invoke `mvn clean test` 

#### Option3

a) From commandline invoke `mvn clean test` 
b) Install cucumber plugin for your IDE of choice (viz- IntelliJ)
b) Open the BDD Feature files & Right click and select Run on the feature:
```> src/test/resources/features```


### Note:

1) The Test Runner will create Cucumber report at below folder `target/cucumber-html-report`

2) Also, a interactive Donut report will be created in ${project.build.directory}/donut
Command: `mvn clean integration-test generate` * Note: This plugin might need some local customisation.

3) Logs will be generated under /log folder present under root directory

## Future Improvements Planned

1) Modularise Wiremock functionality.
2) Add more granular assertions
3) Add API tests for other requests GET, PUT, DELETE
4) Implement Wiremock server start and stop through cucumber hook implementation


Please feel free to get back to me on the below email:
`laxmi.somni@gmail.com`

Many Thanks

(c) L Somni 
