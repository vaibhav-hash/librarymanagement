<%-- 
    Document   : user_home
    Created on : Jun 15, 2020, 7:55:45 AM
    Author     : Admin1
--%>

<%@page import="beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection" />
    <link type="text/css" rel="stylesheet" href="css/main.css" />

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <style>
        header,
        main,
        footer,
        .content {
            padding-left: 300px;
        }

        @media only screen and (max-width: 992px) {

            header,
            main,
            footer,
            .content {
                padding-left: 0;
            }
        }
    </style>
</head>

<body>
    <%--<v:if test="${session!=null}">--%>
    <nav class="blue">
        <div class="nav wrapper">
            <div class="container" style="margin-top: 8px; margin-left: 0px; width: 30%;">
                <a href="" class="button-collapse show-on-large" data-activates="sidenav"><i class="material-icons"
                        style="size: 20px;">person_pin</i></a>
            </div>
        </div>
        <ul class="right">
            <li><a href="user_home.jsp"><i class="material-icons">refresh</i></a></li>
            <li><a href=""><i class="material-icons">more_vert</i></a></li>
        </ul>
        </div>
    </nav>
        <!--% User user=(User)((session.getAttribute("user")));
                String userName=user.getUserName().toString();
                String name=user.getFirstName().toString()+user.getLastName().toString();
                String email=user.getEmail().toString();
        
                %-->
    <ul class=" side-nav fixed" id="sidenav">
        <li>
            <!-- <div class="user-view"> -->
            <div class="background">
                <div class="card">
                    <div class="card-image">
                        <img src="img/admin_10.jpg" />
                    </div>
                </div>
            </div>
        </li>
        <li>
            <a href="" class="tooltipped" data-position="top" data-tooltip="<!--%= userName %-->"><i
                    class="material-icons blue-text">person</i><!--%= name %-->
            </a>
        </li>

        <li>
            <a href=""><i class="material-icons blue-text">email</i><!-%= email %--></a>
        </li>
        <li>
            <a href=""><i class="material-icons blue-text">book</i>IssueBook </a>
        </li>
        <li>
            <a href=""><i class="material-icons blue-text">rate_review</i>See Books
            </a>
        </li>
        <li>
            <a href=""><i class="material-icons blue-text">delete_forever</i>Return Book
            </a>
        </li>
        <div class="divider"></div>

        <li>
            <a href=""><i class="material-icons blue-text">help</i>Help </a>
        </li>
        <li>
            <a href=""><i class="material-icons blue-text">exit_to_app</i>Logout
            </a>
        </li>
    </ul>

    <!--SideNav Finished-->
    <div class="content">
        <div class="row">
            <div class="col s12 l4 m4">
                <div class="card">
                    <div class="card-image">
                        <img src="img/img1.jpg" />
                        <span class="card-title">Card Title</span>
                    </div>
                    <div class="card-content">
                        <ul class="collection with-header">
                            <li class="collection-header">
                                <h4>BOOK Information</h4>
                            </li>
                            <li class="collection-item">
                                <div>BOOKID:<a href="#!" class="secondary-content"><i
                                            class="material-icons">send</i></a>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div>BOOKNAMe:<a href="#!" class="secondary-content"><i
                                            class="material-icons">send</i></a>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div>Category<a href="#!" class="secondary-content"><i
                                            class="material-icons">send</i></a>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div>Author:<a href="#!" class="secondary-content"><i
                                            class="material-icons">send</i></a>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div>Availbility:<a href="#!" class="secondary-content"><i
                                            class="material-icons">send</i></a>
                                </div>
                            </li>
                        </ul>
                        <p style="margin-left: 5px;">Description:</p>
                    </div>
                </div>
            </div>
            </div>
        </div>
    <!-- 
    
<div class="fixed-action-btn">
  <a href="" class="btn-floating btn-large red white-text pulse tooltipped" data-tooltip="Add New Post" data-position="left"><i class="material-icons ">edit</i></a>
</div> -->


    <!-- ha bhag tasach rahu de -->

    <!-- Import jQuery before materialize.js -->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script>
        $(document).ready(function () {
            // Custom JS & jQuery here
            $(".button-collapse").sideNav();
        });
    </script>
    <script type="text/javascript"></script>
    <%--</v:if>--%>
    <%--<v:if test="${session==null}">--%>
        <!--% response.sendRedirect("InvalidUser.jsp"); %-->
    <%--</v:if>--%>
</body>
</html>
