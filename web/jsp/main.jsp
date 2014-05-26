<%-- 
    Document   : main
    Created on : 25.05.2014, 20:43:16
    Author     : Anna
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <html>
        <head>
            <title>laba7</title>
        </head>
        <body>
            <hr/>
            <form name="filePath" method="POST" action="controller">
            <input type="hidden" name="command" value="parser" />
                File Path:<br/>
            <input type="text" name="filePath" value=""><br/>
            Parser:<br/>
            <TABLE BORDER="2">
                <tr>
                    <td>DOM</td><td><INPUT type="radio" name="parser" value="dom" checked="true"></td>
                    <td>SAX</td><td><INPUT type="radio" name="parser" value="sax"></td>
                    <td>StAX</td><td><INPUT type="radio" name="parser" value="stax"></td>
                </tr>
            </TABLE>
            <input type="submit" value="Enter">
            </form><hr/>
        </body>
    </html>
