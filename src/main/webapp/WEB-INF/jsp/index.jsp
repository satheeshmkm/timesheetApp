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

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


    <script id="dateRange" type="text/x-handlebars-template">
    <b>From </b><input type = "text" id="from" style="width:250px;display: inline;" class = "form-control"/>
    <b>To </b><input type = "text" id="to"  style="width:250px;display: inline;" class = "form-control"/>
    <button type="button" id="load" class="btn-default">Show</button>
    </script>


    <script id="renderButton" type="text/x-handlebars-template">
            {{#if this.insert}}
                <button type = "button" id ="addNewBtn" class = "btn btn-info">Add New Row</button>
                <button type="button" id="deleteRow" class="btn btn-danger">Delete</button>
                <button type = "button" id="save" class = "btn btn-success">Save</button>
            {{/if}}
            {{#if this.admin}}
                <button type = "button" id="approve" class = "btn btn-success">Approve</button>
                <button type="button" id="reject" class="btn btn-danger">Reject</button>
            {{/if}}
            {{#if this.view}}
                <button type = "button" id="sendForApproval" class = "btn btn-success">Send For Approval</button>
                <button type="button" id="deleteRow" class="btn btn-danger">Delete</button>
            {{/if}}
    </script>

    <script id="tableHeadings" type="text/x-handlebars-template">
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
    </script>

    <script id="tableRows" type="text/x-handlebars-template">
      <tr>
        <td class="tdHeight"><input type="checkbox" name="delTrue" {{#if this.id}} value="{{this.id}}"{{/if}}>&nbsp</td>
      	<td class="tdHeight"><input type = "text" {{#if this.projectCode}} value="{{this.projectCode}}" disabled {{/if}} class = "form-control" /></td>
	    <td class="tdHeight"><input type = "text" {{#if this.projectName}} value="{{this.projectName}}" disabled {{/if}} class = "form-control" /></td>
      	<td class="tdHeight"><input type = "text" {{#if this.projectPhase}} value="{{this.projectPhase}}" disabled {{/if}} class = "form-control" /></td>
      	<td class="tdHeight"><input type = "text" {{#if this.classification}} value="{{this.classification}}" disabled {{/if}} class = "form-control"/></td>
	    <td class="tdHeight"><input type = "text" {{#if this.activity}} value="{{this.activity}}" disabled {{/if}} class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" {{#if this.bugRef}} value="{{this.bugRef}}" disabled {{/if}} class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" {{#if this.date}} value="{{this.date}}" disabled {{/if}} name="datePicker" class = "form-control"/></td>
      	<td class="tdHeight"><input type = "text" {{#if this.effort}} value="{{this.effort}}" disabled {{/if}} class = "form-control"/></td>
      </tr>
   </script>
<script src="js/ModelView.js"></script>

</head>
<body text="white">
<img src="img/topImg.jpg" width="100%" height="100px"/>
<h2 class="heading">Time Sheet Management System</h2>
<div class="menu" >
    <ul class="nav">
        <li><a href="">Home</a></li>
        <li><a href="">Time Sheet</a>
            <ul class="subs">
                <li><a href="#insert">Insert</a></li>
                <li><a href="#view">View</a></li>
           </ul>
        </li>
        <li><a href="">Admin</a>
            <ul class="subs">
                <li><a href="#admin">View</a></li>
            </ul>
        </li>
        <li><a href="">About</a></li>
    </ul>
</div>

<div id="rangePicker" style="position:relative;left:30%;top:25px;"></div>
<div class="contents" id="main">
<img src="http://www.timesheettips.com/wp-content/uploads/2015/08/Time-Tracker-App.png"/>
<h3 style="position:relative;top:-250px;left:50%;">TimeSheet Management System</h3>
</div>
</body>
</html>
