var app = angular.module("InventoryApplication", []);
 

app.controller("MainController", function($scope, $http) {
 
 
    $scope.products = [];
    $scope.productform = {
        id : "",
        name: "",
        brand: "",
        price: ""
    };
 
    
    _refreshProductData();
 
    $scope.submit = function() {
 
        var method = "";
        var url = "";
        
        if ($scope.productform.post == true) {
            method = "POST";
            url = '/product';
        } else {
            method = "PUT";
            url = '/product';
        }
        $scope.productform.post=false;
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.productform),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
                function(res) { 
                    $scope.products = res.data;
                },
                function(res) { 
                    console.log("Error: " + res.status + " : " + res.data);
                }
            );
    };
 
    $scope.addproduct = function() {
        _clearFormData();
    }
 
    $scope.delete = function(product) {
        $http({
            method: 'DELETE',
            url: '/product/' + product.id
        }).then(function(res) { 
            $scope.products = res.data;
        },
        function(res) { 
            console.log("Error: " + res.status + " : " + res.data);
        }
        );
    };
 
    $scope.edit = function(product) {
        $scope.productform.id = product.id;
        $scope.productform.name = product.name;
        $scope.productform.brand = product.brand;
        $scope.productform.price = product.price;
    };
 
    
    function _refreshProductData() {
        $http({
            method: 'GET',
            url: '/products'
        }).then(
            function(res) { 
                $scope.products = res.data;
            },
            function(res) { 
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    function _clearFormData() {
        $scope.productform.id = "";
        $scope.productform.name = "";
        $scope.productform.department = "";
        $scope.productform.salary = "";
        $scope.productform.post=true;
    };
});