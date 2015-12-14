//Model
var TimesheetModel = Backbone.Model.extend({
	defaults : {
		approvalStatus : 'false',
	},

	initialize : function() {
		console.log("Model Initialized");
	},

	validate : function(attrs) {
		alert(attrs);
		if (!attrs.projectCode) {
			return 'Please fill Project Code.';
		}
		if (!attrs.projectName) {
			return 'Please fill Project Name field.';
		}
		if (!attrs.projectPhase) {
			return 'Please fill Project Phase field.';
		}
		if (!attrs.classification) {
			return 'Please fill Project Classification field.';
		}
		if (!attrs.activity) {
			return 'Please fill Project Activity field.';
		}
		if (!date.date) {
			return 'Please fill Date field.';
		}
		if (!date.effort) {
			return 'Please fill Effort field.';
		}
	},

	url : '/'
})

//View
var SubmitView = Backbone.View.extend({
	
	initialize: function(){				
		console.log("Submit View Initialized");
		
	},
	render: function(){
		this.$el.html(this.template({solutions: this.collection.toJSON()}))
	}
});

//Associating view with model
var timesheet = new TimesheetModel({projectCode:'P1', projectName:'PName',projectPhase:'Pphase',classification:'Classif',date:'13-12-2015',effort:'0'});
var submitView = new SubmitView({model:timesheet});
