
	function addNewRow() {
	  new insertView(new dataModel());
	  $("input[name^='datePicker']").datepicker({dateFormat: "yy-mm-dd"});
	}

   function removeRow(){
        $("input[name^='delTrue']").each(function() {
            if($(this).prop("checked") == true){
               this.parentElement.parentElement.remove();
            }
         });
   }
   function renderTableWithData(type){
        var fetchData = new DataCollection();
        fetchData.setRestCall($("#from").val(),$("#to").val(),type);
        fetchData.fetchData();
   }

   function submitForApp(){
          var appCollection = new DataCollection();
          $("input[name^='delTrue']").each(function() {
               if($(this).prop("checked") == true){
                  appCollection.add(new dataModel({id:$(this).val()}));
               }
            });
            appCollection.setUrl("/submitForApproval");
            appCollection.save();
   }
   function submitAccOrRe(status){
          var appCollection = new DataCollection();
          $("input[name^='delTrue']").each(function() {
               if($(this).prop("checked") == true){
                  appCollection.add(new dataModel({id:$(this).val(),approvalStatus:status}));
               }
            });
            appCollection.setUrl("/acceptOrReject");
            appCollection.save();
   }

   function saveRow(){
      var type;
      var row = [];
      var saveDataCollection = new DataCollection();
      $('#rowTable').children().each(function(){
        $(this).children().each(function(){
            type = $(this).children().attr('type');
            if(type == "text"){
                row.push($(this).children().val());
            }
        })
        if(row.length>0){
            saveDataCollection.add(new dataModel(
            {
             projectCode:row[0],
             projectName:row[1],
             projectPhase:row[2],
             classification:row[3],
             activity:row[4],
             bugRef:row[5],
             date:row[6],
             effort:row[7],

            }
            ));
            row=[];
        }
      });
   saveDataCollection.setUrl('/saveTimesheet');
   saveDataCollection.save();
   }
   function clearDivs(){
        $("#main").empty();
        $("#rangePicker").empty();
   }

   //==========================================================
   //                   view
   //===========================================================

   var tableHeadingsView = Backbone.View.extend({
       initialize:function(){
            this.render();
       }
       ,
       render: function() {
            var theTemplateScript = $("#tableHeadings").html();
            $("#main").append(theTemplateScript);
       }
   });

    var insertView = Backbone.View.extend({
       initialize:function(model){
            this.render(model);
       }
       ,
       render: function(model) {
            //alert(JSON.stringify(model));
            var theTemplateScript = $("#tableRows").html();
            var template = Handlebars.compile(theTemplateScript);
            var compile = template(model.toJSON());
            $("#rowTable").append(compile);
       }
   });

   var buttonsView = Backbone.View.extend({
          render: function(types) {
               var theTemplateScript = $("#renderButton").html();
               var template = Handlebars.compile(theTemplateScript)
               theTemplateScript = template(types);
               $("#main").append(theTemplateScript);
          }
      });

     var rangePicker = Backbone.View.extend({
            initialize:function(){
                 this.render();
            }
            ,
            render: function() {
                 var theTemplateScript = $("#dateRange").html();
                 $("#rangePicker").append(theTemplateScript);
            }
        });


   //==========================================================
   //                   models
   //===========================================================
    var dataModel = Backbone.Model.extend({
	defaults : {
		projectCode : '',
		projectName : '',
		projectPhase : '',
		classification : '',
		activity : '',
		bugRef : '',
		date : '',
		effort : '',
		approvalStatus : ''
	},

	initialize : function() {
		console.log("Model Initialized");
	}
    })

   //========================================================
   //                   Collection
   //========================================================
    var DataCollection = Backbone.Collection.extend({
        model:dataModel,
        save: function(){
    	  Backbone.sync('create', this, {
    		  success: function() {
    			  alert("Saved");
    			  }
			});
    	},
    	setRestCall:function(startDate,endDate,type){
    	    this.url = "listTimesheet?startDate="+startDate+"&endDate="+endDate+"&type="+type;
    	},
    	fetchData:function(){
            this.fetch({
                        success: this.fetchSuccess,
                        error: this.fetchError
                    });
       	},
       	fetchSuccess:function(collection, response){
           collection.each(function(model, index, list)
                          {    new insertView(model);
                          });
       	},
        fetchError:function(collection, response){
            alert("No record Found !! ");
        },
        setUrl:function(newUrl){
            this.url = newUrl;
        }
    });


   //==========================================================
   //                   Routes
   //===========================================================
       var appRouter = Backbone.Router.extend({
           routes: {
             'insert': 'renderInsert',
             'view': 'renderView',
             'admin': 'renderAdmin'
           },
           renderInsert: function() {
               clearDivs();
               var tableHeadings = new tableHeadingsView();
               var buttonsViewRender = new buttonsView();
               buttonsViewRender.render({insert:'show'});
               $("#addNewBtn").bind("click", function(){addNewRow();});
               $("#deleteRow").bind("click", function(){removeRow();});
               $("#save").bind("click", function(){saveRow();});
           },
           renderView: function() {
               clearDivs();
               var tableHeadings = new tableHeadingsView();
               var buttonsViewRender = new buttonsView();
               buttonsViewRender.render({view:'show'});
               new rangePicker();
               $("#to").datepicker({dateFormat: "yy-mm-dd"});
               $("#from").datepicker({dateFormat: "yy-mm-dd"});
               $("#addNewBtn").bind("click", function(){addNewRow();});
               $("#deleteRow").bind("click", function(){removeRow();});
               $("#load").bind("click", function(){renderTableWithData("view");});
               $("#sendForApproval").bind("click", function(){submitForApp();});
           },
           renderAdmin: function() {
               clearDivs();
               var tableHeadings = new tableHeadingsView();
               var buttonsViewRender = new buttonsView();
               buttonsViewRender.render({admin:'show'});
               new rangePicker();
               $("#to").datepicker({dateFormat: "yy-mm-dd"});
               $("#from").datepicker({dateFormat: "yy-mm-dd"});
               $("#addNewBtn").bind("click", function(){addNewRow();});
               $("#deleteRow").bind("click", function(){removeRow();});
               $("#load").bind("click", function(){renderTableWithData("admin");});
               $("#approve").bind("click", function(){submitAccOrRe("approve");});
               $("#reject").bind("click", function(){submitAccOrRe("reject");});

           }
         });
      var app_router = new appRouter();
      Backbone.history.start();
