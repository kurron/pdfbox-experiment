package org.kurron.pdf

import org.pdfbox.pdmodel.PDDocument
import org.pdfbox.pdmodel.PDPage
import org.pdfbox.pdmodel.font.PDType1Font
import org.pdfbox.pdmodel.font.PDFont
import org.pdfbox.pdmodel.edit.PDPageContentStream
import org.codehaus.groovy.reflection.ReflectionUtils
import org.pdfbox.pdmodel.graphics.xobject.PDJpeg

/**
 * Assembles the bits and pieces of a PDF together into a single document.
 */
class PDFBuilder 
{
    def addPage()
    {
    }

    def byte[] build()
    {
        PDDocument document = new PDDocument()

        final image = PDFBuilder.class.getResourceAsStream("/superman-logo-7.jpg")
        assert image != null
        final jpeg = new PDJpeg(document, image)


        PDPage page = new PDPage()

        PDFont font = PDType1Font.HELVETICA_BOLD
        PDPageContentStream contentStream = new PDPageContentStream(document, page)
        contentStream.drawImage( jpeg, 20, 20 );

        contentStream.beginText()
        contentStream.setFont( font, 12 )
        contentStream.moveTextPositionByAmount( 100, 700 )
        contentStream.drawString( "Hello World" )
        contentStream.endText()


        contentStream.close()



        document.addPage(page)
        final stream = new ByteArrayOutputStream(1024)
        document.save(stream)
        document.close()
        stream.toByteArray()
    }
}
