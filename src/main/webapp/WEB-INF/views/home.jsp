<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script src="resources/app.js"></script>
    </head>
    <body>
        <h1>REST World!</h1>
        <a href=${uri}>Kassiaabits</a>
      <form>
      <input type=button value="Koik kassid" onClick="javascript:get_cats()">
      
      
      <br><br>
      <table bgcolor=000000>
      <tr><td bgcolor=cccccc>Teated</td></tr>
      <tr><td bgcolor=ffffff><div id="msg_text"> </div></td></tr>
      </table>
      <br>
      <div id="one_cat"></div>
      <br><br>
      <div id="cats_table"></div>
      <br> 
      
      <br><br>

      <table bgcolor=eeeeee><tr><td>Uue kassi lisamine</td></tr>
          <tr><td>Nimi:</td><td><input type=text name=new_cat_name value=''></td></tr>
          <tr><td>Iseloom:</td><td><input type=text name=new_cat_character value=''></td></tr>
          <tr><td>Värv:</td><td><input type=text name=new_cat_color value=''></td></tr>
          <tr><td>Vanus:</td><td><input type=text name=new_cat_age value=''></td></tr>
          <tr><td><button type='button' class='btn' onClick='javascript:add_cat()'>Saada
              uus serverile</button></td></tr>
      </table>
	  
	  </form>
	  
    </body>
</html>
