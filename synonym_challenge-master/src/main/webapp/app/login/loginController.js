(function () {
    'use strict';

    angular.module('sc').controller('loginController', ['$location','$http', function ($location, $http) {
        var ctrl = this;

        ctrl.userName = '';
        ctrl.password = ''; 
        ctrl.showInvalidPassword = false;

        ctrl.login = function () {
            if(ctrl.userName != '' && ctrl.password != '') {        
            	var url = '/synonym_challenge/api/players/username/'+ ctrl.userName + '/password/' + ctrl.password;
            	 $http({
                     url: url,
                     method: "GET"
                 })
                 .then(function(response) {     
                	 if(response.data == null || response.data == '')
                	 {
                		 ctrl.showInvalidPassword = true;	 
                	 }
                	 else{
                		// store player info in local storage 
                		sessionStorage.setItem("player", JSON.stringify(response.data));
                		$location.path("/dashboard");
                	 }                       
                 }, 
                 function(response) { // optional
                         // failed
                 });            	
             }
        }

    }]);

})();