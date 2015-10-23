Ext.define('Project.project.shared.project.model.location.StateModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateCode",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "stateCodeChar2",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateCodeChar3",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateFlag",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateCapital",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "stateCapitalLatitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "stateCapitalLongitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});