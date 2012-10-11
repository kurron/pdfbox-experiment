package org.kurron.pdf

import org.pdfbox.pdmodel.PDDocument
import org.pdfbox.pdmodel.PDPage
import org.pdfbox.pdmodel.font.PDType1Font
import org.pdfbox.pdmodel.font.PDFont
import org.pdfbox.pdmodel.edit.PDPageContentStream

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
        PDPage page = new PDPage()

        PDFont font = PDType1Font.HELVETICA_BOLD
        PDPageContentStream contentStream = new PDPageContentStream(document, page)
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
