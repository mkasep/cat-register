var cat_from_server;

function Cat()
{
this.name;
this.character;
this.color;
this.age;
}

function get_cats()
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/cats' ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	display_cats(data);
        console.log(JSON.stringify(data));

    }
  });


}


function get_cat(id)
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/cat/' + id ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	cat_from_server = data;
    	display_cat(data);
        console.log(JSON.stringify(data));

    }
  });


}


function save_cat()
{
	
	cat_from_server.name=document.forms[0].name.value;
	cat_from_server.character=document.forms[0].character.value;
	cat_from_server.color=document.forms[0].color.value;
	cat_from_server.age=document.forms[0].age.value;
		
var jsonData = JSON.stringify(cat_from_server);
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/cat/' + cat_from_server.id ,
    type: "POST",
    data: jsonData,
    dataType: 'json',
    contentType : 'application/json',
    success: function(data) {
    	show_message("Salvestatud");
        console.log(JSON.stringify(data));

    }
  });


}






function display_cat(cat)
{
	 var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Muutmine. Kassi id: <b>" + cat.id + "</b></td></tr>";

		out_data = out_data + "<tr><td>Nimi:</td><td><input type=text name=name value='" + cat.name + "'></td></tr>";
		out_data = out_data + "<tr><td>Iseloom:</td><td><input type=text name=character value='" + cat.character + "'></td></tr>";
		out_data = out_data + "<tr><td>Värv:</td><td><input type=text name=color value='" + cat.color + "'></td></tr>";
		out_data = out_data + "<tr><td>Vanus:</td><td><input type=text name=age value='" + cat.age + "'></td></tr>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:save_cat()'>Salvesta</button></td>";
		out_data = out_data + "</table>";

	

	
	 $("#one_cat").html(out_data);
}




function display_cats(data)
{
	var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td colspan=4>Kasse kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var cat = data[i];
		out_data = out_data + "<tr><td>nimi:</td><td bgcolor=ffffff>" + cat.name + "</td><td>iseloom:</td><td bgcolor=ffffff>" + cat.character + "</td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:get_cat(" + cat.id + ")'>Vali</button></td>";
	 	out_data = out_data + "<td><button type='button' class='btn' onClick='javascript:delete_cat(" + cat.id + ")'>Kustuta</button></td></tr>";
	 }
	 out_data = out_data + "</table>";

	
	 $("#cats_table").html(out_data);
}


function show_message(message)
{
	
	 $("#msg_text").html(message);
}

function delete_cat(id)
{
	$.ajaxSetup({ cache: false });
	$.ajax({
		url: 'service/cat/' + id ,
		type: "DELETE",
		contentType : 'application/json',
		success: function(data) {
			show_message("Kustutatud");
			get_cats();
			console.log(JSON.stringify(data));
		}
	});
}

function add_cat()
{
	var cat_to_server = new Cat();
	cat_to_server.name=document.forms[0].new_cat_name.value;
	cat_to_server.character=document.forms[0].new_cat_character.value;
	cat_to_server.color=document.forms[0].new_cat_color.value;
	cat_to_server.age=document.forms[0].new_cat_age.value;
	var jsonData = JSON.stringify(cat_to_server);
	$.ajaxSetup({ cache: false });
	$.ajax({
		url: 'service/cat/' ,
		type: "PUT",
		data: jsonData,
		dataType: 'json',
		contentType : 'application/json',
		success: function(data) {
			show_message("Sisestatud");
			console.log(JSON.stringify(data));
			get_cats();
		}
	});
}
