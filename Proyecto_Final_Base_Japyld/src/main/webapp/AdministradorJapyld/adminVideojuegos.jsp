<%@ page import="com.example.proyecto_base_japyld.models.beans.Juegos" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jossr
  Date: 5/06/2023
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  ArrayList<Juegos> lista  =(ArrayList<Juegos>) request.getAttribute("lista");
%>
<%
  ArrayList<Juegos> lista1  =(ArrayList<Juegos>) request.getAttribute("lista1");
%>

<%
  ArrayList<Juegos> juegos  =(ArrayList<Juegos>) request.getAttribute("juegos");
%>

<html lang="en">

<head>
  <style>
    /* Estilos personalizados */
    .custom-textbox {
      border: 2px solid #ffffff;
      border-radius: 10px;
      padding: 10px;
      font-size: 18px;
      color: #333;
      background-color: #F1F7F6;
      outline: none;
    }

    .custom-textbox:focus {
      border-color: #29B6A5;
      box-shadow: 0 0 0 3px rgba(41, 182, 165, 0.2);
    }
  </style>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Página Principal Manager</title>

  <title>Gráfico de Barras con Bootstrap 4</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <!-- Custom fonts for this template-->
  <link href="recursos/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="recursos/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=request.getContextPath()%>/AdminServlet?action=lista">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">JAPYLD <sup>TM</sup></div>
    </a>

    <!-- Divider -->

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      MÓDULOS
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/AdminServlet?action=lista">
        <i class="fas fa-home"></i>
        <span>Inicio</span></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/AdminServlet?action=listasPaginaVideojuegos">
        <i class="fas fa-gamepad"></i>
        <span>Videojuegos</span>
      </a>

    </li>
    <!-- Nav Item - Charts -->
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/AdminServlet?action=listaPaginaOfertas">
        <i class="far fa-money-bill-alt"></i>
        <span>Ofertas</span></a>
    </li>

    <!-- Nav Item - Tables -->
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/JuegosReservadosServlet">
        <i class="fas fa-box-open"></i>
        <span>Reservas</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">
    <br>

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
      <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

  </ul>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Search -->
        <form
                class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
          <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                   aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- Nav Item - Search Dropdown (Visible Only XS) -->
          <li class="nav-item dropdown no-arrow d-sm-none">
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                 aria-labelledby="searchDropdown">
              <form class="form-inline mr-auto w-100 navbar-search">
                <div class="input-group">
                  <input type="text" class="form-control bg-light border-0 small"
                         placeholder="Search for..." aria-label="Search"
                         aria-describedby="basic-addon2">
                  <div class="input-group-append">
                    <button class="btn btn-primary" type="button">
                      <i class="fas fa-search fa-sm"></i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </li>

          <!-- Nav Item - Alerts -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-bell fa-fw"></i>
              <!-- Counter - Alerts -->
              <span class="badge badge-danger badge-counter">3+</span>
            </a>
            <!-- Dropdown - Alerts -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="alertsDropdown">
              <h6 class="dropdown-header">
                Alerts Center
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-primary">
                    <i class="fas fa-file-alt text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 12, 2019</div>
                  <span class="font-weight-bold">A new monthly report is ready to download!</span>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-success">
                    <i class="fas fa-donate text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 7, 2019</div>
                  $290.29 has been deposited into your account!
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="mr-3">
                  <div class="icon-circle bg-warning">
                    <i class="fas fa-exclamation-triangle text-white"></i>
                  </div>
                </div>
                <div>
                  <div class="small text-gray-500">December 2, 2019</div>
                  Spending Alert: We've noticed unusually high spending for your account.
                </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
            </div>
          </li>

          <!-- Nav Item - Messages -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-envelope fa-fw"></i>
              <!-- Counter - Messages -->
              <span class="badge badge-danger badge-counter">7</span>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="messagesDropdown">
              <h6 class="dropdown-header">
                Message Center
              </h6>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="recursos/img/undraw_profile_1.svg"
                       alt="...">
                  <div class="status-indicator bg-success"></div>
                </div>
                <div class="font-weight-bold">
                  <div class="text-truncate">Hi there! I am wondering if you can help me with a
                    problem I've been having.</div>
                  <div class="small text-gray-500">Emily Fowler · 58m</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="recursos/img/undraw_profile_2.svg"
                       alt="...">
                  <div class="status-indicator"></div>
                </div>
                <div>
                  <div class="text-truncate">I have the photos that you ordered last month, how
                    would you like them sent to you?</div>
                  <div class="small text-gray-500">Jae Chun · 1d</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="recursos/img/undraw_profile_3.svg"
                       alt="...">
                  <div class="status-indicator bg-warning"></div>
                </div>
                <div>
                  <div class="text-truncate">Last month's report looks great, I am very happy with
                    the progress so far, keep up the good work!</div>
                  <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                </div>
              </a>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <div class="dropdown-list-image mr-3">
                  <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                       alt="...">
                  <div class="status-indicator bg-success"></div>
                </div>
                <div>
                  <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                    told me that people say this to all dogs, even if they aren't good...</div>
                  <div class="small text-gray-500">Chicken the Dog · 2w</div>
                </div>
              </a>
              <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
            </div>
          </li>

          <div class="topbar-divider d-none d-sm-block"></div>

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">Tu Perfil</span>
              <img class="img-profile rounded-circle"
                   src="recursos/img/undraw_profile.svg">
            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                 aria-labelledby="userDropdown">
              <a class="dropdown-item" href="#">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Settings
              </a>
              <a class="dropdown-item" href="#">
                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                Activity Log
              </a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
              </a>
            </div>
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-xl px-4 mt-4">
        <!-- Account page navigation-->
        <hr class="mt-0 mb-4">
        <div class="row">
          <div class="col-xl-6">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
              <div class="card-header"><b>JUEGOS MÁS POPULARES DE LOS ÚLTIMOS 30 DÍAS</b></div>
              <div class="card-body text">

                <section class="intro">
                  <div class="gradient-custom-1 h-100">
                    <div class="mask d-flex align-items-center h-100">
                      <div class="container">
                        <div class="row justify-content-center">
                          <div class="col-12">
                            <div class="table-responsive bg-white">
                              <table class="table mb-0">
                                <thead>
                                <tr>
                                  <th scope="col" style="color: #666666;">JUEGO</th>
                                  <th scope="col" class="text-center" style="color: #666666;">CANTIDAD DE VENTAS</th>
                                </tr>
                                </thead>
                                <tbody>
                                <% for (Juegos j :lista) { %>
                                <tr>
                                  <td><%=j.getNombreJuegos()%>></td>
                                  <td class="text-center">15</td>
                                </tr>
                                <%}%>
                                </tbody>
                              </table>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </section>
              </div>
            </div>
            <br>
            <br>
            <div class="card mb-4 mb-xl-0">
              <div class="card-header"><b>CATEGORÍAS DE JUEGOS MÁS POPULARES EN LOS ÚLTIMOS 30 DÍAS</b></div>
              <div class="card-body text">

                <section class="intro">
                  <div class="gradient-custom-1 h-100">
                    <div class="mask d-flex align-items-center h-100">
                      <div class="container">
                        <div class="row justify-content-center">
                          <div class="col-12">
                            <div class="table-responsive bg-white">
                              <table class="table mb-0">
                                <thead>
                                <tr>
                                  <th scope="col" style="color: #666666;">JUEGO</th>
                                  <th scope="col" class="text-center" style="color: #666666;">CANTIDAD DE VENTAS</th>
                                </tr>
                                </thead>
                                <tbody>
                                <% for (Juegos j :lista) { %>
                                <tr>
                                  <td><%=j.getNombreJuegos()%>></td>
                                  <td class="text-center">30</td>
                                </tr>
                                <%}%>
                                </tbody>
                              </table>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </section>
              </div>
            </div>
          </div>
          <div class="col-xl-6">
            <!-- Account details card-->
            <div class="card mb-5">

              <div class="card-header">
                <b class="mr-5">LISTA DE JUEGOS</b>

                <form class="d-none d-sm-inline-block form-inline mr-4 ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Buscar..."
                           aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>

              <br>


              <section class="intro">
                <div class="gradient-custom-1 h-100">
                  <div class="mask d-flex align-items-center h-100">
                    <div class="container">
                      <div class="row justify-content-center">
                        <div class="col-12">
                          <div class="table-responsive bg-white">
                            <table class="table mb-0">
                              <thead>
                              <tr>
                                <th scope="col">NOMBRE</th>
                                <th scope="col">COSTO</th>
                                <th scope="col">CATEGORIA</th>
                                <th scope="col">STOCK</th>
                                <th scope="col">EDITAR</th>
                              </tr>
                              </thead>
                              <tbody>
                              <% for (Juegos j :juegos) { %>
                              <tr>
                                <td class="text-center"><%=j.getNombreJuegos()%></td>
                                <td class="text-center"><%=j.getPrecio()%></td>
                                <td class="text-center"><%=j.getCategoria().getNombre()%></td>
                                <td class="text-center"><%=j.getStock()%></td>
                                <td class="text-center">
                                  <a class="btn btn-primary" href="adminEditVideojuegos.html">
                                    Editar
                                  </a>
                                </td>
                              </tr>
                              <%}%>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </section>

              <br>

            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <br>
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Japyld</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="recursos/vendor/jquery/jquery.min.js"></script>
<script src="recursos/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="recursos/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="recursos/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="recursos/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="recursos/js/demo/chart-area-demo.js"></script>
<script src="recursos/js/demo/chart-pie-demo.js"></script>

</body>

</html>
