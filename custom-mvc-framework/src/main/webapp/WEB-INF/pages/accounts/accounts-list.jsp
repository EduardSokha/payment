<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Payment System</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/WEB-INF/pages/common/css-include.jsp"></jsp:include>

</head>
<body class="hold-transition sidebar-mini">
    <!-- Site wrapper -->
    <div class="wrapper">

        <jsp:include page="/WEB-INF/pages/common/nav-bar.jsp"></jsp:include>

        <jsp:include page="/WEB-INF/pages/common/main-menu.jsp"></jsp:include>

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>Accounts</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="">Home</a></li>
                                <li class="breadcrumb-item active">Blank Page</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <section class="content">

                <!-- Default box -->
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">List Accounts</h3>

                        <jsp:include page="/WEB-INF/pages/common/card-panel-tools.jsp"></jsp:include>
                    </div>

                    <div class="card-body">
                        <div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
                            <div class="row">
                                <div class="col-sm-12 col-md-6"></div>
                                <div class="col-sm-12 col-md-6"></div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <a href="add-account" class="btn btn-success">Add Account</a> <br> <br>

                                    <table id="example2" class="table table-bordered table-hover dataTable" role="grid" aria-describedby="example2_info">
                                        <thead>
                                            <tr role="row">
                                                <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending"
                                                    aria-label="Rendering engine: activate to sort column descending">Id</th>
                                                <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending"
                                                    aria-label="Rendering engine: activate to sort column descending">Number Account</th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                                    aria-label="Platform(s): activate to sort column ascending">Balance</th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                                    aria-label="Platform(s): activate to sort column ascending">Date</th>
                                                <th class="sorting_asc" tabindex="0" aria-controls="example2" rowspan="1" colspan="1" aria-sort="ascending"
                                                    aria-label="Rendering engine: activate to sort column descending">Id User</th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                                    aria-label="Platform(s): activate to sort column ascending">Status</th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                                    aria-label="Browser: activate to sort column ascending">Currency</th>
                                                <th class="sorting" tabindex="0" aria-controls="example2" rowspan="1" colspan="1"
                                                    aria-label="Browser: activate to sort column ascending">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach var="account" items="${allAccounts}">
                                                <tr role="row" class="odd">
                                                    <td class="sorting_1">${account.id}</td>
                                                    <td>${account.number}</td>
                                                    <td>${account.balance}</td>
                                                    <td>${account.date}</td>
                                                    <td>${account.userName}</td>
                                                    <td>${account.statusName}</td>
                                                    <td>${account.currencyName}</td>
                                                    
                                                    <td>
                                                        <c:url value="edit-account" var="editUrl">
                                                            <c:param name="accountId" value="${account.id}" />
                                                        </c:url>
                                                        
                                                        <c:url value="delete-account" var="deleteUrl">
                                                            <c:param name="accountId" value="${account.id}" />
                                                        </c:url>
                                                        
                                                        <c:url value="lock-unlock-account" var="lockUrl">
                                                            <c:param name="accountId" value="${account.id}" />
                                                            <c:param name="idStatus" value="1" />                                                            
                                                        </c:url>
                                                        
                                                        <c:url value="lock-unlock-account" var="unlockUrl">
                                                            <c:param name="accountId" value="${account.id}" />
                                                            <c:param name="idStatus" value="2" />                                                            
                                                        </c:url>
                                                        
                                                        <a href="${editUrl}" type="button" class="btn btn-info btn-xs">Edit</a>
                                                        &nbsp;
                                                        <a href="${deleteUrl}" class="btn btn-danger btn-xs">Delete</a>
                                                        &nbsp;
                                                        <a href="${lockUrl}" type="button" class="btn btn-info btn-xs">Lock</a>
                                                        &nbsp;
                                                        <a href="${unlockUrl}" type="button" class="btn btn-info btn-xs">Unlock</a>
                                                        &nbsp;
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>

                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-md-5">
                                    <div class="dataTables_info" id="example2_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>
                                </div>
                                <div class="col-sm-12 col-md-7">
                                    <div class="dataTables_paginate paging_simple_numbers" id="example2_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button page-item previous disabled" id="example2_previous"><a href="#" aria-controls="example2"
                                                data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li>
                                            <li class="paginate_button page-item active"><a href="#" aria-controls="example2" data-dt-idx="1" tabindex="0"
                                                class="page-link">1</a></li>
                                            <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="2" tabindex="0"
                                                class="page-link">2</a></li>
                                            <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="3" tabindex="0"
                                                class="page-link">3</a></li>
                                            <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="4" tabindex="0"
                                                class="page-link">4</a></li>
                                            <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="5" tabindex="0"
                                                class="page-link">5</a></li>
                                            <li class="paginate_button page-item "><a href="#" aria-controls="example2" data-dt-idx="6" tabindex="0"
                                                class="page-link">6</a></li>
                                            <li class="paginate_button page-item next" id="example2_next"><a href="#" aria-controls="example2" data-dt-idx="7"
                                                tabindex="0" class="page-link">Next</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- /.card-body -->
                    <div class="card-footer">Footer</div>
                    <!-- /.card-footer-->
                </div>
                <!-- /.card -->

            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->

        <jsp:include page="/WEB-INF/pages/common/footer.jsp"></jsp:include>

        <jsp:include page="/WEB-INF/pages/common/control-sidebar.jsp"></jsp:include>

    </div>
    <!-- ./wrapper -->

    <jsp:include page="/WEB-INF/pages/common/js-include.jsp"></jsp:include>

</body>
</html>
