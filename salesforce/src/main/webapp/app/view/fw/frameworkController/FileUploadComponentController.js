Ext.define('Buzzor.view.fw.frameworkController.FileUploadComponentController', 
{
	extend : 'Ext.app.ViewController',
	alias : 'controller.FileUploadComponentController',
	
	sendFile : function(btn, e, eOpts) {
		debugger;
		currentView = this.getView();
		if (btn.action == "dataUpload") {
			var form = this.getView().down('#entityDataUpload');//reference
			if(form!=null) {
					var entMask = new Ext.LoadMask({
							    msg    : 'Uploading your entity data...',
							    target : this.getView()
					}).show();
							
					if (form.isValid()) {
								form.submit({
											url : 'secure/UploadService/upload',
											method:'POST',
											entMask:entMask,
											scope:this,
											success : function(opts, response) {
												var responseData = Ext.JSON.decode(opts.response.responseText);
												Ext.Msg.alert('Server Response', responseData.response.message);
												this.view.up().down('#filePathHidden').setValue(responseData.response.data);
												this.view.down('#uploadButton').setDisabled(true);
												opts.entMask.hide();
											},
											failure : function(response, opts) {
												var responseData = Ext.JSON.decode(opts.response.responseText);
												Ext.Msg.alert('Server Response', responseData.response.message);
												this.view.up().down('#filePathHidden').setValue(responseData.response.data);
												this.view.down('#uploadButton').setDisabled(true);
												opts.entMask.hide();
											}
										});
						}
			    }
		}
	}
});
	