package org.kurron.pdf

import org.pdfbox.pdmodel.PDDocument
import org.pdfbox.pdmodel.PDPage

/**
 * Assembles the bits and pieces of a PDF together into a single document.
 */
class PDFBuilder 
{
    def build()
    {
        PDDocument document = new PDDocument()
        PDPage blankPage = new PDPage()
        document.addPage(blankPage)
        document.save( "blank.pdf")
        document.close()
    }
}
