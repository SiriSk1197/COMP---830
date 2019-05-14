(function () {
    'use strict';

    angular.module('sc').controller('dashboardController', ['$state', '$http', '$timeout', function ($state, $http, $timeout) {

        var ctrl = this;
        ctrl.showChallengeStart = true;
        ctrl.counter = 60;
        
        ctrl.startChallenge = function () {
        	var request = { playerId: ctrl.player.playerId,
        			 score: 0, response1: '', response2: '', response3: ''};
        	  $http({
                  url: '/synonym_challenge/api/game',
                  method: "POST",
                  data: request
              })
              .then(function(response) {
            	  if(response.data != null){
                  ctrl.showChallengeStart = false;
                  ctrl.gameId = response.data.gameId;
                  ctrl.wordDetails = response.data.wordId;
                  $timeout(countDown, 1000);
            	  }
              }, 
              function(response) { // optional
                      // failed
              });
        	  
        }

        var countDown = function () {
            ctrl.counter--;
            if (ctrl.counter > 0)
                $timeout(countDown, 1000);
            else {
                ctrl.submit();
                return;
            }
        }

        ctrl.submit = function () {
        	var request = {response1: ctrl.synonym1, response2: ctrl.synonym2,
        			response3: ctrl.synonym3};
        	$http({
                url: '/synonym_challenge/api/game/' + ctrl.gameId,
                method: "PUT",
                data: request
            })
            .then(function(response) {    
            	$state.go("results", {"gameId": ctrl.gameId});
            }, 
            function(response) { // optional
                    // failed
            });
        }
        
        ctrl.getPlayerInfo = function(){
            ctrl.player = JSON.parse(sessionStorage.getItem("player"));
            if(ctrl.player == '')
            	 $state.go("login");
        }
        
        ctrl.getPlayerInfo();
    }]);

})();