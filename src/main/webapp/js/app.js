$(function(){	
		
	var collection = new BackCollection();	
	var addUser = new AddUserView({collection: collection});
	var view = new BackView({el: "#content", collection: collection});

	$(".datepicker").datepicker();
})
