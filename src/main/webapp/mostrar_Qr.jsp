<%@ page import="java.util.List" %>
<%@ page import="com.google.zxing.qrcode.QRCodeWriter" %>
<%@ page import="com.google.zxing.EncodeHintType" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="com.google.zxing.common.BitMatrix" %>
<%@ page import="com.google.zxing.BarcodeFormat" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="com.google.zxing.client.j2se.MatrixToImageWriter" %>
<%@ page import="java.util.Base64" %><%--
  Created by IntelliJ IDEA.
  User: ASUS TUF
  Date: 24/05/2024
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<String> lista = (List<String>) request.getAttribute("parametros");
    if (lista == null || lista.isEmpty()) {
%>
    //la lissta no se envia
<% } else {

        //Gererar los datos para el codigo
         StringBuilder datosQR = new StringBuilder();
         for (String dt : lista){
             datosQR.append(dt).append("/n");
         }
         //Generar el codigo
         QRCodeWriter QrEscritura = new QRCodeWriter();
         Hashtable<EncodeHintType, String> claves = new Hashtable<>();
         claves.put(EncodeHintType.CHARACTER_SET, "UTF-8");
         BitMatrix ConjuntoBits = QrEscritura.encode(datosQR.toString(), BarcodeFormat.QR_CODE, 200, 200, claves);

         //Convertili en imagen byte[]
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         MatrixToImageWriter.writeToStream(ConjuntoBits, "PNG", outputStream);
         byte[] qrCodeBytes = outputStream.toByteArray();

         //codificar la imagen
         String qrCodeBase64 = Base64.getEncoder().encodeToString(qrCodeBytes);


%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AppChanchitaQr</title>
</head>

<body>
<h1>Código QR generado</h1>
<img src="data:image/png;base64, <%= qrCodeBase64 %>" alt="Código QR">

</body>
</html>
<%
    }
%>