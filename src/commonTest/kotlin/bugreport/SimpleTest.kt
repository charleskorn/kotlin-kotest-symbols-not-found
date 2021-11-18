package bugreport

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SimpleTest : FunSpec() {
   init {
      test("true should be true") {
         true shouldBe true
      }
   }
}
