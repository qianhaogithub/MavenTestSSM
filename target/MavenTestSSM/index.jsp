<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CRUD</title>
    <jsp:include page="/include_Jsp/common_include.jsp"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8"></div>
        <div class="col-lg-4">
            <button id="add_btn" class="btn btn-primary" data-toggle="modal"><span class="glyphicon glyphicon-plus-sign"></span>新增</button>
            <button id="delete_btn" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span>删除</button>
        </div>
    </div>
    <div class="row">
        <table class="table table-hover table-condensed">
            <thead>
                <tr>
                    <th>操作</th>
                    <th>#</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>dept</th>
                </tr>
            </thead>
            <tbody id="emp_content">

            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-lg-5">
            总共<span id="totalRecord" class="badge"></span>笔
        </div>
        <div class="col-lg-7" id="page_nav_content">
        </div>
    </div>
</div>



<!-- Modal -->
<div class="modal fade" id="emp_add_model" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="emoName" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input class="form-control"  name="emoName"  id="emoName" placeholder="empName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="empEmail" class="col-sm-2 control-label">empEmail</label>
                        <div class="col-sm-10">
                            <input name="empEmail" class="form-control" id="empEmail" placeholder="empEmail">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gender" class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <select id="gender" name="gender" class="form-control">
                                <option></option>
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="deptId" class="col-sm-2 control-label">dept</label>
                        <div class="col-sm-10">
                            <select id="deptId" name="deptId" class="form-control">
                                <option></option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="btn_save_emp">保存</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        var initParams = {
            pageNo:"1",
            pageSize:"10"
        }
        listEmps(initParams);

        $("#add_btn").click(function(){
            initDeptSelectOption("deptId");
            $('#emp_add_model').modal('show')
        });

        $("#emp_add_model form").submit(function(ev){ev.preventDefault();});
        $("#btn_save_emp").click(function(){
            var bootstrapValidator = $("#emp_add_model form").data('bootstrapValidator');
            bootstrapValidator.validate();
            var flag =  bootstrapValidator.isValid();
            alert(flag);
            alert(123);
            if (false) {//验证通过
                //提交表单数据
                $.ajax({
                    url : "${webRoot}/emp/saveEmp",
                    data : $("#emp_add_model form").serializeObject(),
                    type : "POST",
                    success : function(data){
                        alert(data.msg);
                        $('#emp_add_model').modal('hide');
                        initParams.pageNo = 9999999;
                        listEmps(initParams);
                    },
                    error : function(){
                        alert("保存员工信息失败!");
                    }
                });
            }

        });
        //http://bootstrapvalidator.votintsev.ru/getting-started/
        //bootstrapValidator用法
        $('#emp_add_model form').bootstrapValidator({
            live: 'disabled',
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                emoName: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {  //长度限制
                            min: 4,
                            max: 100,
                            message: '用户名长度必须在4到10位之间,中文字符占2位'
                        },
                    }
                },
                empEmail: {
                    validators: {
                        notEmpty: {
                            message: '邮箱地址不能为空'
                        },
                        emailAddress: {
                            message: '邮箱地址格式有误'
                        }
                    }
                }
            }
        });
    });

    function listEmps(param){
        $.ajax({
            url:"${webRoot}/emp/listEmpByJson",
            data:param,
            type:"GET",
            success:function (data) {
                console.log(data);
                buildEmpsTable(data); //构建员工表格
                bulidPageNav(data);
            }
        })
    }
    
    function buildEmpsTable(data) {
        $("#emp_content").html("");
        var emps = data.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            var $opertationTd_edit_btn = $("<button></button>").addClass("btn btn-xs btn-info")
                                                .append($("<span></span>").addClass("glyphicon glyphicon-edit").html("编辑"))
                                                .click(function(){
                                                    editEmp(emps.empId);
                                                });
            var $opertationTd_del_btn = $("<button></button>").addClass("btn btn-xs btn-danger")
                                                .append($("<span></span>").addClass("glyphicon glyphicon-remove-sign").html("删除"))
                                                .click(function () {
                                                    deleteEmp(emps.empId);
                                                });
            var $operationTd = $("<td></td>").append($opertationTd_edit_btn).append($opertationTd_del_btn);
            var $empIdTd = $("<td></td>").html(item.empId);
            var $empName = $("<td></td>").html(item.emoName);
            var $empGender = $("<td></td>").html(item.empGender=="0"?"男":"女");
            var $empEmail = $("<td></td>").html(item.empEmail);
            var $empDeptEmpname = $("<td></td>").html(item.dept.deptName);
            var $empTr = $("<tr></tr>").append($operationTd).append($empIdTd).append($empName).append($empGender)
                                    .append($empEmail).append($empDeptEmpname);
            $("#emp_content").append($empTr);
        });
    }

    function bulidPageNav(data){
        var pageInfo = data.extend.pageInfo;
        $("#totalRecord").html(pageInfo.total);
        var headPageliContent = "";
        var prePageLiContent = "";
        var $pageNavUl = $("<ul class=\"pagination pagination-sm\"></ul>");
        var params = {
            pageNo : 1,
            pageSize : 10
        }
        $("#page_nav_content").html("");
        if(pageInfo.pageNum=="1") {
            headPageliContent = $("<li class=\"disabled\"><span>首页</span></li>");
        } else {
            headPageliContent = $("<li></li>").append($("<a>首页</a>")).click(function () {
                listEmps(params);
            });
        }
        if(pageInfo.hasPreviousPage){
            prePageLiContent = $("<li><a aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>")
                                .click(function(){
                                    params.pageNo = pageInfo.pageNum-1;
                                    listEmps(params);
                                });
        } else {
            prePageLiContent = $("<li class='disabled'><span aria-hidden=\"true\">&laquo;</span></li>");
        }
        $pageNavUl.append(headPageliContent).append(prePageLiContent);
        var pageNumsLi = "";
        $.each(pageInfo.navigatepageNums,function (index,item) {
            pageNumsLi = $("<li></li>").append($("<a>" + item + "</a>"));
           if(item == pageInfo.pageNum){
               pageNumsLi.addClass("active");
           }else{
               pageNumsLi.click(function(){
                   params.pageNo = item;
                   listEmps(params);
               });
           }
            $pageNavUl.append(pageNumsLi);
        })
        var tailPageLiContent = "";
        if(pageInfo.pageNum==pageInfo.pages) {
            tailPageLiContent = $("<li class=\"disabled\"><span>尾页</span></li>");
        } else {
            tailPageLiContent = $("<li></li>").append($("<a>尾页</a>")).click(function () {
                params.pageNo = pageInfo.pages;
                listEmps(params);
            });
        }
        var nextpageLiContent = "";
        if(pageInfo.hasNextPage){
            nextpageLiContent = $("<li><a aria-label=\"Previous\"><span aria-hidden=\"true\">&raquo;</span></a></li>")
                .click(function(){
                    params.pageNo = pageInfo.pageNum+1;
                    listEmps(params);
                });
        } else {
            nextpageLiContent = $("<li class='disabled'><span aria-hidden=\"true\">&raquo;</span></li>");
        }
        $pageNavUl.append(nextpageLiContent).append(tailPageLiContent);
        var $pageNav = $("<nav aria-label=\"Page navigation\"></nav>").append($pageNavUl);
        $("#page_nav_content").append($pageNav);
    }

    function editEmp(empId){

    }

    function deleteEmp(empId){

    }

    function initDeptSelectOption(deptHtmlId){
        $.ajax({
            url : "${webRoot}/dept/getAllDept",
            params : {},
            type : "GET",
            success : function (data) {
                var depts = data.extend.depts;
                var deptOption = "";
                $.each(depts,function (item,dept) {
                    deptOption += "<option value='" + dept.deptId + "'>" + dept.deptName + "</option>"
                })
                $("#" + deptHtmlId).html("").append($(deptOption));
            }
        })
    }
</script>


