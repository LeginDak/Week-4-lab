<%-- 
    Document   : editnote
    Created on : Feb 3, 2023, 12:00:21 PM
    Author     : Legin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form action="note" method="post">
            <label for="editTitle">Title:</label>
            <input type="text" name="editTitle" value=${note.title}>
            <br>
            <label for="editcontents">Contents:</label>
            <textarea name="editBody"> ${note.body}</textarea><br>
            
            <input type="submit" name="save" value="Save Changes">
            <input type="hidden" name="mode" value="view">
            
        </form>
    </body>
</html>
