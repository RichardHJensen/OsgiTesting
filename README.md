# OsgiTesting sample
## Verify ability to invoke code in an OSGi 'bundle'

* Cannot build via maven3 from the command line
 + Build and package while skipping tests: mvn clean package -DskipTests
* IntelliJ does not build the bundle, so you need the command line (see above)
* ServiceOneBundleTest uses a relative path to the jar (built from the command line), so doesn't work from command line
* You cannot run a single test when the class has the @RunWith annotation, run all the tests in that class

