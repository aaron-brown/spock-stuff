/*
 * Copyright 2020 Aaron Brown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.aarocode.spock

import spock.lang.Specification
import spock.lang.Unroll

class FooSpec extends Specification {
    Foo foo

    static int i
    static int j
    static int k

    def setupSpec() {
        i = 0
        j = 0
        k = 0
    }

    def setup() {
        foo = new Foo()

        j += 1
    }

    @Unroll
    void 'Validate isDivisibleBy(#value, #divisor) == #expect'() {
        setup:
        k += 2

        expect:
        foo.isDivisibleBy(value, divisor) == expect
        i == _i
        j == _j
        k == _k

        where:
        value | divisor || expect | _i | _j | _k
        1     | 1       || true   | 0  | 1  | 2
        2     | 2       || true   | 0  | 2  | 4
        3     | 2       || false  | 0  | 3  | 6
        4     | 2       || true   | 0  | 4  | 8
    }

    @Unroll
    void 'Validate isDivisibleBy(#value, #divisor) == #expect (again)'() {
        setup:
        k += 2

        expect:
        foo.isDivisibleBy(value, divisor) == expect
        i == _i
        j == _j
        k == _k

        where:
        value | divisor || expect | _i | _j | _k
        1     | 1       || true   | 0  | 5  | 10
        2     | 2       || true   | 0  | 6  | 12
        3     | 2       || false  | 0  | 7  | 14
        4     | 2       || true   | 0  | 8  | 16
    }
}
