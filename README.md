# OsgiTesting sample
## Verify ability to invoke code in an OSGi 'bundle' from JUnit tests

## Todo
1. Need to make sure we can pass parameters to service in bundle
1. Need to test chain of bundles
1. Need to have examples of various calling strategies
 * Activator registration
 * SCR (Declarative Services?)
 * Blueprint

### Issues resolved
* Can now build via maven3 from the command line
* ServiceOneBundleTest now figures out where it's class file is and goes relative to that to find the ServiceOneModule bundle.

### Issues remaining
* IntelliJ does not build the bundle, so you need the command line
 + _or run the Maven build for the ServiceOneModule from within IntelliJ_
* You cannot run a single test when the class has the `@RunWith` annotation, run all the tests in that class
* Haven't figured out how to use hamcrest matchers in the tests run by pax exam
 + `mavenBundle("org.hamcrest", "hamcrest-library", "1.3).startLevel(30)` did not work


