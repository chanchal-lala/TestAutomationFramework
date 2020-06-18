set projectLocation=C:\Users\Chanchal Lala\Desktop\Tools\EclipseProjects\SeleniumFramework\SeleniumFramework

cd %projectLocation%

set classpath = %projectLocation%\lib\*;%projectLocation%\tartget\classes\*

java org.testng.TestNG %projectLocation%\testng.xml

pause