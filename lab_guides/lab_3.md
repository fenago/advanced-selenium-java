

#### Introduction to Jenkins


In this lab, we will use Eclipse IDE to set up Selenium WebDriver
project, and additionally we add m2eclipse plugin to eclipse to help the
build process and to create POM.xml file.

### **Steps to add m2eclipse plugin to Eclipse:**

**Step 1:** Launch Eclipse IDE and click on Help \> Select Install New
Software

**Step 2: Enter the URL** [http://download.eclipse.org/technology/m2e/releases/](http://download.eclipse.org/technology/m2e/releases/)
on the Install dialog. Select Work with and m2e plugin as shown in the
below screenshot.

![](./images/image22.png)

**Step 3:** Click on Next button.

**Step 4:** Accept the License agreement and click Finish button.

**Step 5:** Click On Restart Now to restart the eclipse.

### **Configure Eclipse with Maven**

We now need to create Maven project once m2e plugin is installed.

**Step 1:** Launch Eclipse IDE
and create a New Project by selecting **File** \> **New** \> **Other**
from Eclipse menu.

**Step 2:** On the **New** dialog box, Expand **Maven** and select
**Maven Project** and click Next.

![](./images/image4.png)

**Step 3:** On the **New Maven Project**, check the **Create a simple
project** and click on Next.

![](./images/image8.png)

**Step 4:** Enter TestWebdriver in **Group Id**, **Artifact Id** and
click on **Finish**.

![](./images/image6.png)

**Step 5:** Eclipse will create **TestWebdriver** with following
structure:

![](./images/image1.png)

**Step 6:**  Right-click on **JRE System Library** and select the option
**Properties** from the menu.

![](./images/image3.png)

On **JRE System Library** **Properties**dialog box, make
sure **Workspace default JRE** is selected and click Apply and Close.

![](./images/image13.png)

**Step 7:** Double-click on **pom.xml** from **Project Explorer**.

![](./images/image2.png)

pom.xml file will Open in Editor section

![](./images/image9.png)

**Step 8:**  Add the Selenium, Maven, TestNG, Junit dependencies to pom.xml in the \<project\> node by replacing `pom.xml` content with following:


```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>TestWebdriver</groupId>
    <artifactId>TestWebdriver</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.5</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.10</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>htmlunit-driver</artifactId>
            <version>2.33.3</version>
        </dependency>
    </dependencies>

</project>
```

**Step 9:** Create a New TestNG Class. Enter Package name as "testing"
and "NewTest" in the **Name**: textbox and click on
the **Finish** button

![](./images/image11.png)

**Step 10:** Eclipse will create the NewTest class as shown in the below
screenshot:

![](./images/image5.png)

**Step 11:** Add the below code to the **NewTest** class

```
package testing;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NewTest {

    private WebDriver driver;

    @Test
    public void testEasy() {
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        assertTrue(title.contains("Facebook"));
    }
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        // Uncomment following to user HtmlUnitDriver instead of firefox
        // driver = new HtmlUnitDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
```

**Step 12:**  Right-click on the TestWebdriver and select **TestNG** and
**Convert to TestNG**. Eclipse will create testng.xml which says that
you need to run only one test with the name **NewTest** as shown in the
below screenshot:

![](./images/image19.png)

![](./images/image20.png)

Update the project and make sure that file appears in the tree **Package
Explorer** (right click on the project and click Refresh).

![](./images/image12.png)

**Step 13:** Now run the above test through this **testng.xml.**

Go to the **Run Configurations under Run**and create a new
launch **TestNG**, select the project and
field **Suite** as **testng.xml** and click Run

![](./images/image7.png)

![](./images/image29.png)

This will launch the website and finished the build successfully.

**Step 14:** Additionally, to pom.xml we need to add

1.  maven-compiler-plugin
2.  maven-surefire-plugin
3.  testng.xml

The maven-surefire-plugin is used to configure and execute the tests. To
configure the testing.xml for TestNG test and generate to test reports
this plugin is used.

The maven-compiler-plugin is used in compiling the code and using the
particular JDK version for compilation. Add all the dependencies to the pom.xml in the \<plugin\> node. Replace `pom.xml` with following: 

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>TestWebdriver</groupId>
    <artifactId>TestWebdriver</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.5</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.10</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>htmlunit-driver</artifactId>
            <version>2.33.3</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.7.0</version>
                <!-- <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration> -->
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M1</version>
                <inherited>true</inherited>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

**Step 15:**  To run th**e** tests in the Maven lifecycle, Right-click on
the TestWebdriver and select **Run As** **Maven test**. From the project
Maven will execute the test.

![](./images/image26.png)

This will launch the website and finished the build successfully.

**Installation steps for Jenkins and configure it to Run Maven with TestNg**
-----------------------------------------------------------------------------

Step 1: Go to the URL [https://www.jenkins.io/](https://www.jenkins.io/)
and download the package for your OS and click Download button.

![](./images/image23.png)

**Step 2:** Unzip the Jenkins folder and run the exe file as shown in
the below image:

![](./images/image14.png)

**Step 3:** In **Jenkins 2.233 Setup** window click on **Next** button.

![](./images/image24.png)

**Step 4:** Click on **Install** button.

![](./images/image18.png)

**Step 5:** Once installation is complete, it automatically navigate to
the Jenkins Dashboard (http://localhost:8080) in the browser window.

![](./images/image32.png)

**Step 6:** Click on the **New Item**to create a job.

![](./images/image16.png)

**Step 7:** Enter an Item Name and click OK button

![](./images/image33.png)

**Step 8:** A new job with name "TestWebdriver" is created in Jenkins
Dashboard.

![](./images/image15.png)

**Step 9:**  Go to **Manage Jenkins** and select **Global Tool Configuration** as shown in the below image.

![](./images/image31.png)

Click on JDK installations and configure JDK as in the following image:

Enter JDK Name: java 1.8.0

```
JAVA_HOME C:\Program Files\Java\jdk1.8.0_202
```

![](./images/image28.png)

**Step 10:** Go to the **Build** section of created job.

Add the pom.xml file’s path in the **Root POM** option.

![](./images/image27.png)

**Step 11:** Click on the **Apply** button.

![](./images/image21.png)

**Step 12:** On the TestWebdriver project page, click on the **Build
Now** link.

![](./images/image17.png)

Maven will build the project. It will have TestNG execute the test
cases.

**Step 13:** Once the build process is completed, in Jenkins Dashboard
click on the **TestWebdriver** project.

![](./images/image30.png)

**Step 14:**  The TestWebdriver project page displays the build history
and links to the results as shown in the below image:

![](./images/image25.png)

**Step 15:** To view the test results click on the "Latest Test Result" link.

![](./images/image301.png)

**Step 16:** Select specific build, and you will see the current status by clicking on "console output".

![](./images/image302.png)

#### Scheduling Jenkins for automatic execution.

Scheduling builds(Selenium Tests) is one of the important features of Jenkins where it automatically triggers the build, based on defined criteria. Jenkins provides multiple ways to trigger the build process under the Build Trigger configuration.

For example:
Enter `0 23 * * *` in the Schedule textbox as shown in the following screenshot. This will trigger the build process every day at 11 p.m.

![](./images/image303.png)
