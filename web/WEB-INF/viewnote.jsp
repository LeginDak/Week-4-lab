<%-- 
    Document   : viewnote
    Created on : Feb 3, 2023, 12:00:11 PM
    Author     : Legin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p>Title: ${Note.title} </p>
        <p>Contents: ${Note.body}</p>
    </body>
</html>
