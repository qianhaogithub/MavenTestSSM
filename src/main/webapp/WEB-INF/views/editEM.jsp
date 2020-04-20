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
                <button id="add_btn" class="btn btn-primary"><span class="glyphicon glyphicon-plus-sign"></span>新增</button>
                <button id="delete_btn" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span>删除</button>
            </div>
        </div>
        <div class="row">
            <table class="table table-hover table-condensed">
                <tr>
                    <th>操作</th>
                    <th>#</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>email</th>
                    <th>dept</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <td>
                            <button class="btn btn-xs btn-primary">
                                <span class="glyphicon glyphicon-edit"></span>编辑
                            </button>
                            <button class="btn btn-xs btn-danger">
                                <span class="glyphicon glyphicon-remove-sign"></span>删除
                            </button>
                        </td>
                        <td>${emp.empId}</td>
                        <td>${emp.emoName}</td>
                        <td>${emp.empGender=="0"?"男":"女"}</td>
                        <td>${emp.empEmail}</td>
                        <td>${emp.dept.deptName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="col-lg-5"><span>总记录数:${pageInfo.total}</span></div>
            <div class="col-lg-7">
                <nav aria-label="Page navigation">
                    <ul class="pagination pagination-sm">
                        <c:if test="${pageInfo.pageNum != 1}">
                            <li><a href="${webRoot}/emp/getEmp?pageNo=1">首页</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum == 1}">
                            <li class="disabled"><span>首页</span></li>
                        </c:if>

                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${webRoot}/emp/getEmp?pageNo=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${!pageInfo.hasPreviousPage}">
                            <li class="disabled">
                                <span aria-hidden="true">&laquo;</span>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                            <c:if test="${pageInfo.pageNum==page}">
                                <li class="active"><a href="${webRoot}/emp/getEmp?pageNo=${page}">${page}</a></li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum!=page}">
                                <li><a href="${webRoot}/emp/getEmp?pageNo=${page}">${page}</a></li>
                            </c:if>
                        </c:forEach>
                        <li class="${pageInfo.hasNextPage?"":"disabled"}">
                            <c:if test="${pageInfo.hasNextPage}">
                                <a href="${webRoot}/emp/getEmp?pageNo=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:if>
                            <c:if test="${!pageInfo.hasNextPage}">
                                <span aria-hidden="true">&raquo;</span>
                            </c:if>
                        </li>
                        <c:if test="${pageInfo.pageNum != pageInfo.pages}">
                            <li class="${pageInfo.hasNextPage?"":"disabled"}"><a href="${webRoot}/emp/getEmp?pageNo=${pageInfo.pages}">尾页</a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                            <li class="disabled"><span>尾页</span></li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
<script>
</script>


