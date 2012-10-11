package org.kurron.pdf

import spock.lang.Specification

/**
 * Unit-level test of the PDFBuilder.
 */
class PDFBuilderUnitTest extends Specification
{
    def sut = new PDFBuilder()

    def "given_no_added_text_when_build_is_called_then_blank_page_is_generated"() {
        given: "no added text"

        when: "build is called"
        final bytes = sut.build()

        then:  "pdf file is created"
        assert bytes != null
        assert bytes.length > 0

        saveToFile(bytes, "blank.pdf")

        println 'done!'
    }

    def "given_added_text_when_build_is_called_then_page_contains_text"() {
        given: "no added text"

        when: "build is called"
        final bytes = sut.build()

        then:  "pdf file is created"
        assert bytes != null
        assert bytes.length > 0

        saveToFile(bytes, "text.pdf")

        println 'done!'
    }

    def void saveToFile(byte[] bytes, final String name) {
        File file = new File(name)
        final stream = file.newOutputStream()
        stream.write(bytes)
        stream.flush()
        stream.close()
    }
}
