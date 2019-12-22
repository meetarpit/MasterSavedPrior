/**
 * 
 */

var app=angular.module("registration",[]);

app.controller("ctrl",function($scope,$http){
	$scope.email='';
	$scope.phone='';
	$scope.gender='';
	$scope.address='';
	$scope.password='';
	$scope.listArray=[];
	$scope.treatArray=[];
	$scope.showForm=false;
	$scope.showList=true;
	getAllList();
	$scope.subform={
	         "treatId":-1,
		    "name":$scope.name,
			"type":$scope.type,
			"treatedBy":$scope.treatedBy
	};
	
	$scope.patId='';
	
	$scope.onSaveSubForm=function(){
		//alert("text"+$scope.subform.name);
		var method='';
		var url='';
		if($scope.subform.treatId==-1){
			method="POST";
			url="saveTreatment/"+$scope.patId;
		}
		else{
			method="PUT";
			url="editTreatment/"+$scope.subform.treatId;
		}
		$http({
			method:method,
			url:url,
			data:$scope.subform
		}).then(function sucess(){
			alert("Data Inserted SuccessFully");
			getAllTreatments();
		},_error);
	}
	
	$scope.onSaveForm=function(){
		//alert("aaaaaaaa"+$scope.email);
		var data={
				"email":$scope.email,
				"password":	$scope.password,
				"gender":$scope.gender,
				"address":$scope.address,
				"phone":$scope.phone
		}
	
		$http({
			method:"POST",
			url:"save",
			data:data
		}).then(_success,_error);
		
	}

	function getAllList(){
		$http({
			method:"GET",
			url:"list"
		}).then(function success(response){
			$scope.listArray=response.data;
			console.log("response",$scope.listArray);
		},_error);
	}
	function _error(){
		alert("Error Occured");
	}
	function _success(){
		alert("Data Inserted SuccessFully");
		 $scope.showForm=false;
			$scope.showList=true;
	 getAllList();
	 clearForm();
	
	}
	function clearForm(){
		$scope.email='';
		$scope.phone='';
		$scope.gender='';
		$scope.address='';
		$scope.password='';
	}
	$scope.onshowForm=function(){
		 $scope.showForm=true;
			$scope.showList=false;
	}
	
	$scope.onClickShow=function(id){
		//alert("id"+id);
		
		$scope.patId=id;
		 getAllTreatments();
		$scope.subform.name='';
		$scope.subform.treatedBy='';
		$scope.subform.type='';
	}
	
	function getAllTreatments(){
		$http({
			method:"GET",
			url:"treatmentlist/"+$scope.patId,
		}).then(function success(response){
			$scope.treatArray=response.data;
			console.log("response",$scope.treatArray);
		},_error)
		
	}
	
	$scope.onEditTreatment=function(treatObj){
		$scope.subform.treatId=treatObj.treatId;
		$scope.subform.name=treatObj.name;
		$scope.subform.treatedBy=treatObj.treatedBy;
		$scope.subform.type=treatObj.type;
	}
	
	$scope.onDeleteTreatment=function(x,i){
		$http({
			method:"DELETE",
			url:"deleteTreatment/"+x.treatId,
		}).then(_success,_error);
		$scope.treatArray.splice(i,1);
	}
	
});
