<%--
  Created by IntelliJ IDEA.
  User: jossr
  Date: 4/06/2023
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  <title>Editar Videojuego</title>

  <title>Gráfico de Barras con Bootstrap 4</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

  <!-- Custom fonts for this template-->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../css/sb-admin-2.min.css" rel="stylesheet">

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
                  <img class="rounded-circle" src="../img/undraw_profile_1.svg"
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
                  <img class="rounded-circle" src="../img/undraw_profile_2.svg"
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
                  <img class="rounded-circle" src="../img/undraw_profile_3.svg"
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
              <a class="dropdown-item" href="<%=request.getContextPath()%>/PerfilAdmiServlet">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
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
      <div id="layoutSidenav_content">
        <main>
          <!-- Main page content-->
          <div class="container-xl px-4 mt-4">
            <div class="col-12 col-xl-auto mb-3">
              <a class="btn btn-sm btn-light text-primary" href="adminVideojuegos.html">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left me-1"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>
                Volver a la lista de juegos
              </a>
            </div>


            <div class="row">
              <div class="col-xl-4">
                <!-- Profile picture card-->
                <div class="card mb-4 mb-xl-0">
                  <div class="card-header m-0 font-weight-bold text-primary">EDITAR JUEGO</div>
                  <div class="card-body text-center">
                    <!-- Profile picture image-->

                    <img class="img-account-profile mb-2" src="../img/Legend_of_Zelda.jpg" alt="">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                    <!-- Profile picture upload button-->
                    <button class="btn btn-primary" type="button">Upload new image</button>
                  </div>


                  <div class="container">
                    <br>
                    <h6 class="text-primary" style="color:#31a290;">PRECIO</h6>
                    <div class="d-flex">
                      <div id="texto-editable3" contenteditable="false" class="flex-grow-1 pr-3 custom-textbox">S/ 170</div>
                      <div>
                        <button id="editar-btn3" class="btn btn-primary"><i class="fas fa-edit"></i></button>
                        <button id="guardar-btn3" class="btn btn-success" style="display: none;"><i class="fas fa-save"></i></button>
                      </div>
                    </div>
                  </div>

                  <script3 src="https://code.jquery.com/jquery-3.6.0.min.js"></script3>
                  <script>
                    $(document).ready(function() {
                      // Obtener el cuadro de texto editable y los botones
                      var textoEditable3 = $('#texto-editable');
                      var editarBtn3 = $('#editar-btn');
                      var guardarBtn3 = $('#guardar-btn');

                      // Al hacer clic en el botón "Editar"
                      editarBtn3.click(function() {
                        // Habilitar la edición del cuadro de texto
                        textoEditable3.attr('contenteditable', 'true');
                        textoEditable3.focus();

                        // Ocultar el botón "Editar" y mostrar el botón "Guardar"
                        editarBtn3.hide();
                        guardarBtn3.show();
                      });

                      // Al hacer clic en el botón "Guardar"
                      guardarBtn3.click(function() {
                        // Deshabilitar la edición del cuadro de texto
                        textoEditable3.attr('contenteditable', 'false');

                        // Ocultar el botón "Guardar" y mostrar el botón "Editar"
                        guardarBtn3.hide();
                        editarBtn3.show();
                      });
                    });
                  </script>
                  <BR>
                </div>
              </div>
              <div class="col-xl-8">
                <!-- Account details card-->
                <div class="card mb-4">
                  <div class="card-header m-0 font-weight-bold text-primary">DETALLES DEL JUEGO</div>

                  <div class="container">
                    <br>
                    <h6 class="text-primary" style="color:#31a290;">NOMBRE DEL JUEGO</h6>
                    <div class="d-flex">
                      <div id="texto-editable" contenteditable="false" class="flex-grow-1 pr-3 custom-textbox"><b>THE LAST OF US</b></div>
                      <div>
                        <button id="editar-btn" class="btn btn-primary"><i class="fas fa-edit"></i></button>
                        <button id="guardar-btn" class="btn btn-success" style="display: none;"><i class="fas fa-save"></i></button>
                      </div>
                    </div>
                  </div>

                  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
                  <script>
                    $(document).ready(function() {
                      // Obtener el cuadro de texto editable y los botones
                      var textoEditable = $('#texto-editable');
                      var editarBtn = $('#editar-btn');
                      var guardarBtn = $('#guardar-btn');

                      // Al hacer clic en el botón "Editar"
                      editarBtn.click(function() {
                        // Habilitar la edición del cuadro de texto
                        textoEditable.attr('contenteditable', 'true');
                        textoEditable.focus();

                        // Ocultar el botón "Editar" y mostrar el botón "Guardar"
                        editarBtn.hide();
                        guardarBtn.show();
                      });

                      // Al hacer clic en el botón "Guardar"
                      guardarBtn.click(function() {
                        // Deshabilitar la edición del cuadro de texto
                        textoEditable.attr('contenteditable', 'false');

                        // Ocultar el botón "Guardar" y mostrar el botón "Editar"
                        guardarBtn.hide();
                        editarBtn.show();
                      });
                    });
                  </script>
                  <br>
                  <div class="container">
                    <br>
                    <h6 class="text-primary" style="color:#31a290;">DESCRIPCIÓN DEL JUEGO</h6>
                    <div class="d-flex">
                      <div id="texto-editable2" contenteditable="false" class="flex-grow-1 pr-3 custom-textbox">The Last of Us es un videojuego de terror, acción y aventura. La trama describe las vivencias de Joel y Ellie, un par de supervivientes de una pandemia en Estados Unidos que provoca la mutación de los seres humanos en criaturas caníbales.</div>
                      <div>
                        <button id="editar-btn2" class="btn btn-primary"><i class="fas fa-edit"></i></button>
                        <button id="guardar-btn2" class="btn btn-success" style="display: none;"><i class="fas fa-save"></i></button>
                      </div>
                    </div>
                  </div>

                  <script2 src="https://code.jquery.com/jquery-3.6.0.min.js"></script2>
                  <script>
                    $(document).ready(function() {
                      // Obtener el cuadro de texto editable y los botones
                      var textoEditable2 = $('#texto-editable');
                      var editarBtn2 = $('#editar-btn');
                      var guardarBtn2 = $('#guardar-btn');

                      // Al hacer clic en el botón "Editar"
                      editarBtn2.click(function() {
                        // Habilitar la edición del cuadro de texto
                        textoEditable2.attr('contenteditable', 'true');
                        textoEditable2.focus();

                        // Ocultar el botón "Editar" y mostrar el botón "Guardar"
                        editarBtn2.hide();
                        guardarBtn2.show();
                      });

                      // Al hacer clic en el botón "Guardar"
                      guardarBtn2.click(function() {
                        // Deshabilitar la edición del cuadro de texto
                        textoEditable2.attr('contenteditable', 'false');

                        // Ocultar el botón "Guardar" y mostrar el botón "Editar"
                        guardarBtn2.hide();
                        editarBtn2.show();
                      });
                    });
                  </script>



                  <div class="card-body center-h center-h">

                    <br>
                    <h6 class="text-primary" style="color:#31a290;">CATEGORÍA DE JUEGO</h6>
                    <br>
                    <div class="text-center">
                      <button class="btn btn-info" type="button">ACCIÓN</button>
                      <button class="btn btn-info" type="button">ARCADE</button>
                      <button class="btn btn-info" type="button">ESTRATEGIA</button>
                      <button class="btn btn-info" type="button">TERROR</button>
                      <button class="btn btn-info" type="button">CARRERA</button>
                    </div>

                    <br>
                    <br>
                    <h6 class="text-primary" style="color:#31a290;">TIPO DE CONSOLA</h6>
                    <div class="text-center">
                      <button class="btn btn-primary btn-xl">
                        <i class="fab fa-playstation fa-3x"></i>
                      </button>
                      <button class="btn btn-primary btn-xl">
                        <i class="fab fa-xbox fa-3x"></i>
                      </button>
                      <button class="btn btn-primary btn-xl">
                        <i class="fas fa-keyboard fa-3x"></i>
                      </button>
                      <br>
                      <br>
                      <br>
                    </div>


                    <div class="col-12 col-xl-auto mb-3">
                      <div class="d-flex justify-content-between">
                        <button class="btn btn-outline-danger" onclick="window.location.href='adminDeleteVideojuego.html'" type="button">Eliminar juego del catálogo</button>
                        <button class="btn btn-primary" onclick="window.location.href='adminVideojuegos.html'" type="button">Guardar cambios</button>

                      </div>

                      <!-- Submit button-->
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </main>
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

<!-- Earnings (Monthly) Card Example -->

<!-- Pending Requests Card Example -->

<!-- Earnings (Monthly) Card Example -->

<!-- Earnings (Monthly) Card Example -->


<!-- Pending Requests Card Example -->


<!-- Bootstrap core JavaScript-->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="../vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="../js/demo/chart-area-demo.js"></script>
<script src="../js/demo/chart-pie-demo.js"></script>

</body>

</html>