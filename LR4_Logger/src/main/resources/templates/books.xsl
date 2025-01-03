<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
        <head>
            <title>Books List</title>
        </head>
        <body>
        <h1>Books</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
            <xsl:for-each select="books/book">
                <tr>
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="title"/></td>
                    <td><xsl:value-of select="description"/></td>
                </tr>
            </xsl:for-each>
        </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>