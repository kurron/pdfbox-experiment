package org.kurron.pdf

import spock.lang.Specification

/**
 * Unit-level test of the PDFBuilder.
 */
class PDFBuilderUnitTest extends Specification
{
    def "given_when_then"() {
        given: "concrete builder"
        def builder = new PDFBuilder()

        when: "build is called"
        builder.build()

        then:  "pdf file is created"
        println 'done!'
    }
}
