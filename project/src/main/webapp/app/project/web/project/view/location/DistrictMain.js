Ext.define('Project.project.web.project.view.location.DistrictMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DistrictMainController",
     "restURL": "/District",
     "defaults": {
          "split": true
     },
     "requires": ["Project.project.shared.project.model.location.DistrictModel", "Project.project.web.project.controller.location.DistrictMainController", "Project.project.shared.project.model.location.CountryModel", "Project.project.shared.project.model.location.StateModel", "Project.project.shared.project.model.location.RegionModel", "Project.project.shared.project.viewmodel.location.DistrictViewModel", "Ext.form.field.CustomDateField"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "District",
               "name": "DistrictTreeContainer",
               "itemId": "DistrictTreeContainer",
               "restURL": "/District",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "DistrictTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "C17F97CB-FFE9-41A9-8338-87CE04B98C24",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "497B6DA8-BC56-4F33-9DEF-85D37571CA4F",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.StateModel"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region",
                         "fieldId": "4FB70E30-3770-4362-938B-B13CD2B57743",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.RegionModel"
                         }
                    }, {
                         "name": "code2",
                         "itemId": "code2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Code",
                         "fieldId": "3A8C9C5A-2CA6-4EA4-BEC4-B005A5957F8F",
                         "minLength": "0",
                         "maxLength": "32"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "DistrictViewModel",
                    "xtype": "form",
                    "displayName": "District",
                    "title": "District",
                    "name": "District",
                    "itemId": "District",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C17F97CB-FFE9-41A9-8338-87CE04B98C24",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.CountryModel"
                         },
                         "forceSelection": true,
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "497B6DA8-BC56-4F33-9DEF-85D37571CA4F",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.StateModel"
                         },
                         "forceSelection": true,
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4FB70E30-3770-4362-938B-B13CD2B57743",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "store": {
                              "data": [],
                              "model": "Project.project.shared.project.model.location.RegionModel"
                         },
                         "forceSelection": true,
                         "bind": "{regionId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "name",
                         "itemId": "name",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B74CBDBF-BD96-42C7-A639-997068D20EAA",
                         "minLength": "0",
                         "maxLength": "256",
                         "bind": "{name}",
                         "columnWidth": 0.5
                    }, {
                         "name": "code2",
                         "itemId": "code2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3A8C9C5A-2CA6-4EA4-BEC4-B005A5957F8F",
                         "minLength": "0",
                         "maxLength": "32",
                         "bind": "{code2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtDescription",
                         "itemId": "districtDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "District Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Description",
                         "fieldId": "5C0E1659-D069-448A-8D5F-B8D476829FC2",
                         "bind": "{districtDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtFlag",
                         "itemId": "districtFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "751B6AEA-CDDD-4CAE-9ED1-6615DD3ACEE9",
                         "minLength": "0",
                         "maxLength": "128",
                         "bind": "{districtFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtLatitude",
                         "itemId": "districtLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "District Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Latitude",
                         "fieldId": "EF5A05FB-90E3-47A4-B1F7-3DAF92A1236E",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{districtLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtLongitude",
                         "itemId": "districtLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "District Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Longitude",
                         "fieldId": "E0DC6A64-671C-4BA7-94A2-E454EB9651CF",
                         "minValue": "0",
                         "maxValue": "11",
                         "bind": "{districtLongitude}",
                         "columnWidth": 0.5
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 274,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 274,
                              "customId": 296
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 274,
                              "customId": 297,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 274,
                              "customId": 298,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "District",
                    "title": "Details Grid",
                    "name": "DistrictGrid",
                    "itemId": "DistrictGrid",
                    "restURL": "/District",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "District Id",
                         "dataIndex": "districtId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District Name",
                         "dataIndex": "name",
                         "flex": 1
                    }, {
                         "header": "District Code",
                         "dataIndex": "code2",
                         "flex": 1
                    }, {
                         "header": "District Description",
                         "dataIndex": "districtDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "districtFlag",
                         "flex": 1
                    }, {
                         "header": "District Latitude",
                         "dataIndex": "districtLatitude",
                         "flex": 1
                    }, {
                         "header": "District Longitude",
                         "dataIndex": "districtLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "DistrictViewModel",
               "xtype": "form",
               "displayName": "District",
               "title": "District",
               "name": "District",
               "itemId": "District",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C17F97CB-FFE9-41A9-8338-87CE04B98C24",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.CountryModel"
                    },
                    "forceSelection": true,
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "497B6DA8-BC56-4F33-9DEF-85D37571CA4F",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.StateModel"
                    },
                    "forceSelection": true,
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4FB70E30-3770-4362-938B-B13CD2B57743",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "store": {
                         "data": [],
                         "model": "Project.project.shared.project.model.location.RegionModel"
                    },
                    "forceSelection": true,
                    "bind": "{regionId}",
                    "columnWidth": 0.5
               }, {
                    "name": "name",
                    "itemId": "name",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "District Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B74CBDBF-BD96-42C7-A639-997068D20EAA",
                    "minLength": "0",
                    "maxLength": "256",
                    "bind": "{name}",
                    "columnWidth": 0.5
               }, {
                    "name": "code2",
                    "itemId": "code2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "District Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3A8C9C5A-2CA6-4EA4-BEC4-B005A5957F8F",
                    "minLength": "0",
                    "maxLength": "32",
                    "bind": "{code2}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtDescription",
                    "itemId": "districtDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "District Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Description",
                    "fieldId": "5C0E1659-D069-448A-8D5F-B8D476829FC2",
                    "bind": "{districtDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtFlag",
                    "itemId": "districtFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "751B6AEA-CDDD-4CAE-9ED1-6615DD3ACEE9",
                    "minLength": "0",
                    "maxLength": "128",
                    "bind": "{districtFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtLatitude",
                    "itemId": "districtLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "District Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Latitude",
                    "fieldId": "EF5A05FB-90E3-47A4-B1F7-3DAF92A1236E",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{districtLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtLongitude",
                    "itemId": "districtLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "District Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Longitude",
                    "fieldId": "E0DC6A64-671C-4BA7-94A2-E454EB9651CF",
                    "minValue": "0",
                    "maxValue": "11",
                    "bind": "{districtLongitude}",
                    "columnWidth": 0.5
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 274,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 274,
                         "customId": 296
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 274,
                         "customId": 297,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 274,
                         "customId": 298,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});