(function () {
    'use strict';

    angular.module('sc').controller('registrationController', ['$location', '$http', function ($location, $http) {
        var ctrl = this;
        
        ctrl.player = {
        		firstName: '',
        		lastName: '',
        		emailId: '',
        		userId: '',
        		userPassword: ''
        }

        ctrl.register = function () {   
        	
          $http({
                url: '/synonym_challenge/api/players',
                method: "POST",
                data: ctrl.player
            })
            .then(function(response) {
                    alert('sucessfully registerd')
                    $location.path("/login");
            }, 
            function(response) { // optional
                    // failed
            });  
        }
        
     
        
    }]);

})();