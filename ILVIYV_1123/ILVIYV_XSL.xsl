<?xml version="1.0" encoding="UTF-8"?>
<html xsl:version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">

    <table>
        <xsl:for-each select="vizsgák/vizsga"></xsl:for-each>
        <tr>
            <td><xsl:value-of select="kurzus"/></td>
            <td><xsl:value-of select="helyszín"/></td>
            <td><xsl:value-of select="oktató"/></td>
            <td><xsl:value-of select="jegy"/></td>
        </tr>
    </table>
</body>
</html>