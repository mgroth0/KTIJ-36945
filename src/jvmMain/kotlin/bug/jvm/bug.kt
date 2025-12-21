package bug.jvm

import bug.commonFunction
import sub.commonFunctionFromAnotherModule


fun aFunction() {
    commonFunction()
    commonFunctionFromAnotherModule()
}