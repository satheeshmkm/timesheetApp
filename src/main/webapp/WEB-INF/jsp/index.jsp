<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <link rel="stylesheet" href="../css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.4/handlebars.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.2.3/backbone-min.js" type="text/javascript"></script>



    <script id="tableRows" type="text/x-handlebars-template">
      <tr>
        <td class="tdHeight"><input type="checkbox">&nbsp</td>
      	<td class="tdHeight"><input type = "text" class = "form-control" /></td>
	    <td class="tdHeight"><input type = "text" class = "form-control" /></td>
      	<td class="tdHeight"><input type = "text" class = "form-control" /></td>
      	<td class="tdHeight"><input type = "text" class = "form-control"/></td>
	    <td class="tdHeight"><input type = "text" class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" name="datePicker" class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" class = "form-control"/></td>
      </tr>
   </script>

   <script>

	$(document).ready(function(){
    		$("#addNewBtn").bind("click", function(){addNewRow();});
	});

	function addNewRow() {

	  var theTemplateScript = $("#tableRows").html();
	  $("#rowTable").append(theTemplateScript);
	  $("input[name^='datePicker']").datepicker();
	}

   </script>
   <script>
   function removeChld(element){
        alert(element.parentNode.parentNode);
       document.getElementByID('tableRows').removeChild(element.parentNode.parentNode);
   }
   </script>

</head>
<body text="white">
<img src="img/topImg.jpg" width="100%" height="100px"/>
<h2 class="heading">Time Sheet Management System</h2>
<div class="menu" >
    <ul class="nav">
        <li><a href="home.html">Home</a></li>
        <li><a href="">Time Sheet</a>
            <ul class="subs">
                <li><a href="insert.html">Insert</a></li>
                <li><a href="view.html">View</a></li>
           </ul>
        </li>
        <li><a href="">Admin</a>
            <ul class="subs">
                <li><a href="adminView.html">View</a></li>
            </ul>
        </li>
        <li><a href="">About</a></li>
    </ul>
</div>
<div class="contents">
<table class="table table-condensed" id="rowTable">
<tr class = "active">
    <th></th>
    <th>Project Code</th>
    <th>Project Name</th>
    <th>Project Phase</th>
    <th>Classification</th>
    <th>Activity</th>
    <th>BugRef</th>
    <th>Date</th>
    <th>Effort(Hours)</th>
</tr>
</table>
<button type = "button" id ="addNewBtn" class = "btn btn-info">Add New Row</button>
<button type="button" class="btn btn-danger">Delete</button>
<button type = "button" class = "btn btn-success">Save</button>
</div>

</body>
</html>
