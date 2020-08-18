//广告控制层（运营商后台）
app.controller("peopleController", function ($scope, $controller, peopleService) {

    //继承baseController,本质上继承的是$scope
    $controller('baseController', {$scope: $scope});

    $scope.list = [];//集合
    $scope.findAll = function () {
        peopleService.findAll().success(
            function (response) {
                $scope.list = response;
            }
        );
    }
    $scope.findOne = function (pid) {
        peopleService.findOne(pid).success(
            function (response) {
                $scope.people = response;
            }
        );
    }
    $scope.searchEntity = {};
    /**
     * 条件查询
     */
    $scope.search = function (page, rows) {
        peopleService.search(page, rows, $scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;

                //把后台的总条数给$scope.paginationConf
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }

    $scope.save = function () {
        if ($scope.people.pid == null) {
            peopleService.save($scope.people).success(
                function (response) {
                    if (response.success) {
                        alert(response.message);
                        $scope.searchEntity = {};
                        $scope.reloadList();
                    } else {
                        alert(response.message);
                        $scope.searchEntity = {};
                        $scope.reloadList();
                    }
                }
            );
        } else {
            peopleService.edit($scope.people.pid, $scope.people).success(
                function (response) {
                    if (response) {
                        $scope.searchEntity = {};
                        $scope.reloadList();
                    }
                }
            );

        }

    }
    $scope.dele = function () {
        if ($scope.selectIds.length == 0) {
            alert("请先选择");
        } else {
            if (confirm("确定要删除？")) {
                peopleService.dele($scope.selectIds).success(
                    function (response) {
                        alert("删除成功！");
                        $scope.searchEntity = {};
                        $scope.reloadList();
                        $scope.selectIds = [];
                    }
                );
            } else {
                $scope.reloadList();
                $scope.selectIds = [];

            }
        }
    }

    $scope.export=function () {
        if ($scope.selectIds.length == 0) {
            alert("请先选择要导出的文件");
        } else {
            if (confirm("确定要导出？")) {
                window.location="people/export?selectIds=" + $scope.selectIds;

                        $scope.searchEntity = {};
                        $scope.reloadList();
                        $scope.selectIds = [];
                        alert("导出成功！");
                    }
         else {
                $scope.reloadList();
                $scope.selectIds = [];

            }
        }
    }
});