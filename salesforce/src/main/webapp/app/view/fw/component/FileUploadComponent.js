Ext.define('Buzzor.view.fw.component.FileUploadComponent', 
{
	
	getValue : function() {
		return this.view.up().down('#filePathHidden').setValue();
	},
	
	 xtype : "fileupload",
     extend : "Ext.form.Panel",
     requires :['Buzzor.view.fw.frameworkController.FileUploadComponentController'],
     controller :'FileUploadComponentController',
     restURL : "/FileUpload",
     items: [{
			xtype : 'fieldset',
			itemId : 'dataUploadFieldSet',
			cls : 'entity-fieldset',
			title : 'File Upload',
			collapsed : false,
			collapsible : false,
			margin:'5',
			items : 
			[{
				xtype : 'form',
				layout : 'hbox',
				itemId : 'entityDataUpload',
				defaults : {
					margin : 10
				},
				items : [{
					xtype : 'filefield',
					name : 'file',
					flex : 2,
					listeners : {
						change : function(button, e, value) {
							var newValue = e.replace(/^c:\\fakepath\\/i, ''); 
							this.setRawValue(newValue);
							this.up().down('#uploadButton').setDisabled(false);
							
						},
						render : function() {
							var view = this.up();
							this.setFieldLabel(view.fileUploadCaption);
						}
					}
				  },{
					xtype : 'button',
					action:'dataUpload',
					text : 'Upload',
					itemId : 'uploadButton',
					disabled : true,
					margin : 10,
					flex : 1,
					handler : 'sendFile'
				  }]
			}]
      }]
});