<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/31
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<jsp:include page="include-head.jsp"></jsp:include>

<body>
<jsp:include page="include-nav.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="include-sidebar.jsp"></jsp:include>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;" action="do/admin/selectAdminByKeywordAndPage">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input class="form-control has-success" name="keyword" value="${keyword}" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <a  class="btn btn-primary" style="float:right;" href="/to/pages/add"><i class="glyphicon glyphicon-plus"></i> 新增</a>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${empty requestScope.pageInfo.list}">
                                <tr>
                                    <td>对不起没有查询到数据</td>

                                </tr>
                            </c:if>
                            <c:if test="${!empty requestScope.pageInfo.list}">
                                <c:forEach items="${requestScope.pageInfo.list}" var="admin" varStatus="varStatus">
                                    <tr>
                                        <td>${varStatus.count}</td>
                                        <td><input type="checkbox"></td>
                                        <td>${admin.loginAcct}</td>
                                        <td>${admin.userName}</td>
                                        <td>${admin.email}</td>
                                        <td>
                                            <a type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></a>
                                            <button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>
                                            <a href="do/admin/remove/${admin.id}/${pageInfo.pageNum}/${keyword}.do" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <ul class="pagination">
                                        <li><a href="do/admin/selectAdminByKeywordAndPage?pageNum=1&keyword=${keyword}">首页</a></li>
                                        <c:if test="${pageInfo.prePage == 0}">
                                            <li class="disabled"><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.prePage}&keyword=${keyword}">上一页</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.prePage != 0}">
                                            <li ><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.prePage}&keyword=${keyword}">上一页</a></li>
                                        </c:if>

                                        <c:forEach  begin="${pageInfo.pageNum}" end="${pageInfo.pageNum + 5}" var="index">
                                          <c:if test="${(pageInfo.pageNum==index) && (index <= pageInfo.pages)}">
                                              <li class="active"><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.pageNum}&keyword=${keyword}">${pageInfo.pageNum} <span class="sr-only">${index}</span></a></li>
                                          </c:if>
                                          <c:if test="${(pageInfo.pageNum!=index) && (index <= pageInfo.pages)}">
                                            <li><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${index}&keyword=${keyword}">${index}</a></li>
                                          </c:if>
                                        </c:forEach>


                                        <c:if test="${pageInfo.pageNum + 1 > pageInfo.pages}">
                                            <li class="disabled"><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.pageNum +1}&keyword=${keyword}">下一页</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum + 1  <= pageInfo.pages}">
                                            <li ><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.pageNum +1}&keyword=${keyword}">下一页</a></li>
                                        </c:if>
                                        <li><a href="do/admin/selectAdminByKeywordAndPage?pageNum=${pageInfo.pages}&keyword=${keyword}">末页</a></li>
                                    </ul>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

