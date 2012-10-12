package org.kurron.pdf

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream
import org.apache.pdfbox.pdmodel.font.PDFont
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg

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

        //PDFont font = PDType1Font.HELVETICA_BOLD
        InputStream fontStream = PDFBuilder.class.getResourceAsStream("/HeiT.ttf")
        assert fontStream != null
        PDFont font = PDTrueTypeFont.loadTTF(document, fontStream)
        PDPageContentStream contentStream = new PDPageContentStream(document, page)
        contentStream.drawImage( jpeg, 0, 0 );

        contentStream.beginText()
        contentStream.setFont( font, 72 )
        contentStream.moveTextPositionByAmount( 0, 600 )
        contentStream.drawString( new StringBuilder().append( '\u4e1e').toString() )
        contentStream.endText()

        contentStream.close()

        document.addPage(page)
        final stream = new ByteArrayOutputStream(1024)
        document.save(stream)
        document.close()
        stream.toByteArray()
    }
}
