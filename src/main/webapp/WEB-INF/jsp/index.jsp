<%--
    Document   : index
    Created on : Mar 28, 2015, 3:02:29 PM
    Author     : Jordan
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-2.1.3.js" />"></script>
    <script src="<c:url value="/resources/js/javascript.js" />"></script>
    <head>
        <meta charset="UTF-8">
        <title>Calculadora científica-Spring MVC</title>
    </head>
    <body>
        <meta charset="UTF-8">
        <h1>
            Calculadora científica-Spring MVC
        </h1>

        <table align="center">
            
            <tbody >
                <tr>
                    <td colspan="8"><div class="display"><input type="text" readonly value="" size="18" id="d"></div></td>
                </tr>
                <tr> 
                    <td><input type="button" class="button green" value="x!" onclick='ader("!")'></td>
                    <td><input type="button" class="button green" value="(" onclick='ader("(")'></td>
                    <td><input type="button" class="button green" value=")" onclick='ader(")")'></td>
                    <td><input type="button" class="button green" value="%" onclick='ader("%")'></td>
                    <td><input type="button" class="button pink" value="MC" onclick='memory("MC")'></td>
                    <td><input type="button" class="button pink" value="M+" onclick='memory("M%2B")'></td>
                    <td><input type="button" class="button pink" value="M-" onclick='memory("M-")'></td>
                    <td><input type="button" class="button pink" value="MR" onclick='memory("MR")'></td>
                </tr>
                <tr>
                    <td><input type="button" class="button green" value="1/x" onclick='ader("1/")'></td>
                    <td><input type="button" class="button green" value="x²" onclick='ader("²")'></td>
                    <td><input type="button" class="button green" value="x³" onclick='ader("³")'></td>
                    <td><input type="button" class="button green" value="y×" onclick='ader("^")'></td>
                    <td><input type="button" class="button aqua" value="AC" onclick='reemp("")'></td>
                    <td><input type="button" class="button aqua" value="DEL" onclick='borr()'></td>
                    <td><input type="button" class="button green" value="÷" onclick='ader("/")'></td>
                    <td><input type="button" class="button green" value="x" onclick='ader("*")'></td>
                </tr>
                <tr>
                    <td><input type="button" class="button green" value="²√x" onclick='ader("2√")'></td>
                    <td><input type="button" class="button green" value="³√x" onclick='ader("3√")'></td>
                    <td><input type="button" class="button green" value="×√y" onclick='ader("√")'></td>
                    <td><input type="button" class="button green" value="+/_" onclick='ante("-")'></td>
                    <td><input type="button" class="button blueviolet" value="7" onclick='ader("7")'></td>
                    <td><input type="button" class="button blueviolet" value="8" onclick='ader("8")'></td>
                    <td><input type="button" class="button blueviolet" value="9" onclick='ader("9")'></td>
                    <td><input type="button" class="button green" value="-" onclick='ader("-")'></td>
                </tr>
                <tr>
                    <td><input type="button" class="button green" value="sin" onclick='ader("sin(")'></td>
                    <td><input type="button" class="button green" value="cos" onclick='ader("cos(")'></td>
                    <td><input type="button" class="button green" value="tan" onclick='ader("tan(")'></td>
                    <td><input type="button" class="button green" value="ln" onclick='ader("ln(")'></td>
                    <td><input type="button" class="button blueviolet" value="4" onclick='ader("4")'></td>
                    <td><input type="button" class="button blueviolet" value="5" onclick='ader("5")'></td>
                    <td><input type="button" class="button blueviolet" value="6" onclick='ader("6")'></td>
                    <td><input type="button" class="button green" value="+" onclick='ader("+")'></td>
                </tr>
                <tr>
                    <td><input type="button" class="button green" value="asin" onclick='ader("asin(")'></td>
                    <td><input type="button" class="button green" value="acos" onclick='ader("acos(")'></td>
                    <td><input type="button" class="button green" value="atan" onclick='ader("atan(")'></td>
                    <td><input type="button" class="button green" value="log" onclick='ader("log(")'></td>
                    <td><input type="button" class="button blueviolet" value="1" onclick='ader("1")'></td>
                    <td><input type="button" class="button blueviolet" value="2" onclick='ader("2")'></td>
                    <td><input type="button" class="button blueviolet" value="3" onclick='ader("3")'></td>
                    <td rowspan="2"> <input type="submit" class="btnDoble green" value="=" onclick=' calcular()'> </td>
                </tr>
                <tr>
                    <td><input type="button" class="button green" value="e×" onclick='ader("e^")'></td>
                    <td><input type="button" class="button green" value="π" onclick='ader("π")'></td>
                    <td><input type="button" class="button green" value="x10×" onclick='ader("*10^")'></td>
                    <td><input type="button" class="button green" value="Rand()" onclick='ader("rand()")'></td>
                    <td colspan="2"> <input type="button" class="btnDoble blueviolet" value="0" onclick='ader("0")'></td>
                    <td><input type="button" class="button blueviolet" value="." onclick='ader(".")'></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td colspan="4"><input type="button" class="btnSpace aqua" value="Space" onclick='ader(" ")'></td>
                </tr>
            </tbody>
            
        </table>

    </body>
    <footer>
        <h2>Developed by: Jordan Espinoza</h2>
    </footer>
</html>