Pre-Req:

1.Eclipse (Editor) installed.
2.Chrome Installed
3.TestNG installed(if not, from eclipse marketplace download testNg plugin )
4.Maven installed.
5.Set maven environment variables
	1: C:\Program Files\apache-maven-3.6.1\bin


---Run tests through test-runner(testNG)
Right click on testng.xml file and choose 'Run As' and the Testng suite.

---Run through cmd:
mvn clean install

---To check extent Report:
To open report go to test-output folder
click TestNgSelenideTest.html

--To check Logs:

Go to log Folder and click application.log