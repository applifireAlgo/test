Ext.define('Buzzor.view.fw.MainDataPointPanel',{
	extend : 'Ext.panel.Panel',
	xtype: 'mainDataPointPanel',
	//title:"main panel",
	requires: ['Buzzor.view.fw.DataPointPanel'],
	/*
	controller:'dataPointPanelController',*/
	
	items: [/*{
        xtype: 'component',
        itemId:'dataPointPanelId', 
      //  cls: 'kpi-tiles',

        tpl: [
            '<div class="kpi-meta">',
                '<tpl for=".">',
                    '<span style="width:{width};" >',
                        '<div >{statistic}</div> {description}',
                    '</span>',
                '</tpl>',
            '</div>'
        ],

        
	}*/]
});