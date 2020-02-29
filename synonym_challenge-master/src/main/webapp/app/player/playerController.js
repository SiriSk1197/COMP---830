(function () {
    'use strict';

    angular.module('sc').controller('playerController', ['$location', '$http','$state',
    	function ($location, $http, $state) {
        var ctrl = this;
        
        ctrl.gameId = $state.params.gameId;
        
        ctrl.getScore = function(){
       	  $http({
                 url: '/synonym_challenge/api/game/'+ ctrl.gameId ,
                 method: "GET"
             })
             .then(function(response) {
           	  if(response.data != null){
                ctrl.score = response.data.score;  
           	  }
             }, 
             function(response) { // optional
                     // failed
             });
        }

        ctrl.getScore();
        ctrl.newGame = function () {
            $location.path("/dashboard");
        }
    }]);

})();
