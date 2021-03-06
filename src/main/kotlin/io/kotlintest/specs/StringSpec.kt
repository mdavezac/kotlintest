package io.kotlintest.specs

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.Spec
import io.kotlintest.TestCase
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class) // required to let IntelliJ discover tests
abstract class StringSpec(body: StringSpec.() -> Unit = {}) : Spec() {

  init {
    body()
  }

  operator fun String.invoke(test: () -> Unit): TestCase {
    val tc = TestCase(suite = rootTestSuite, name = this, test = test, config = defaultTestCaseConfig)
    rootTestSuite.addTestCase(tc)
    return tc
  }
}