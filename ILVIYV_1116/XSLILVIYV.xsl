<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl = "http://www.w3.org/1999/Transform">

    <xsl:template match= "/">

        <html>
            <body>
                <h2>Hallgatók adatai - for each, value of </h2>

                <table border="4">
                    <tr bgcolor="#ffffff">
                        <th>ID</th>
                        <th>Vezetéknév</th>
                        <th>Keresztnév</th>
                        <th>Becenév</th>
                        <th>Kor</th>
                        <th>Ösztöndíj</th>
                    </tr>
                <xsl:for-each select="class/student">
                    <tr>
                        <td>
                            <xsl:value-of select ="id"/>
                        </td>
                        <td>
                            <xsl:value-of select ="vezetéknév"/>
                        </td>
                        <td>
                            <xsl:value-of select ="keresztnév"/>
                        </td>
                        <td>
                            <xsl:value-of select ="becenév"/>
                        </td>
                        <td>
                            <xsl:value-of select ="kor"/>
                        </td>
                        <td>
                            <xsl:value-of select ="ösztöndíj"/>
                        </td>
                    </tr>
                </xsl:for-each>

                </table>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>