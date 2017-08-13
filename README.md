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

CHELENGES:
All tests are running in Chrome browser. But 2 tests that requires to use Action failed in FireFox browser to invoke .perform() method.
I tried to provide additional geckodriver, however it has not resolved the issue. I googled it and found that there was a bug in driver which was fixed in the past. My next step would be to download geckodriver for windows and run it. I believe it should run, however I do not have windows machine at the moment. Therefore, I leave it as is. 
