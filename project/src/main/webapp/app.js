/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Project',

    extend: 'Project.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Buzzor.view.mainleftmenutree.MainPanel':'Buzzor.view.mobileview.login.LoginPage',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Project.view.login.LoginPage':'Project.view.mobileview.login.LoginPage',//'Project.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Project.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
