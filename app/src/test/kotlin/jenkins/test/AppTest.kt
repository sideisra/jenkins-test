/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package jenkins.test

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    @Test fun appHasAGreeting() {
        val classUnderTest = App()
        assertThat(classUnderTest.greeting).isEqualTo("Hello world")
    }
}
