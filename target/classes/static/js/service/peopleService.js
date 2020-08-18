//广告管理服务层
app.service("peopleService", function ($http) {
    //根据分类ID查询广告列表
    this.findAll = function () {
        return $http.get("people/findAll");
    }
    this.findOne = function (pid) {
        return $http.get("people/getOne?pid=" + pid);
    }
    this.search = function (page, rows, searchEntity) {
        return $http.post("people/search?page=" + page + "&rows=" + rows, searchEntity);
    }
    this.save = function (people) {
        return $http.post("people/add", people);
    }
    this.edit = function (pid, people) {
        return $http.put("people/edit?pid=" + pid, people);
    }
    this.dele = function (selectIds) {
        return $http.delete("people/delete?selectIds=" + selectIds);
    }
});