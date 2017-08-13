# todomvcangular

BEFORE RUNNING:
Default browser is set to FireFox. You may to set it to chrome. For that change comments in file BaseTest.java
    public final String BROWSER_NAME = "FireFox";
//    public final String BROWSER_NAME = "Chrome";
IMPORTANT: I developed in MAC and Chrome driver attached to the project is for MAC OS. You need to download windows driver if you run on windows.
 
RUN ALL THE TESTS BY: 
gradle clean build 
or 
./gradlew clean build

CHALLENGES:
All tests are running in Chrome browser in MAC. But 2 tests that requires to use Action failed in FireFox browser to invoke .perform() method.
I tried to provide additional geckodriver, however it did not resolve the issue. My next step would be to download geckodriver for windows and try to run it in windows. I think it may be driver problem and in windows it will run, however I do not have windows machine at the moment. Therefore, I leave it as is.
