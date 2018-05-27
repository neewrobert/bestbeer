<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>The BEST BEER - DASHBOARD</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="resources/bootstrap/css/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="dashboard">BestBeer</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="dashboard">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="cadastro.jsp">
            <i class="fa fa-fw fa-file-text-o"></i>
            <span class="nav-link-text">Cadastro de Produtos</span>
          </a>
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Charts">
          <a class="nav-link" href="register.jsp">
            <i class="fa fa-fw fa-user-plus"></i>
            <span class="nav-link-text">Cadastro de Usuario</span>
          </a>
        </li>
       
        
      <!-- BARRA DE TAREFAS -->        
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2" action="buscar" method="post">
            <div class="input-group">
              <input class="form-control" type="text" name="busca" placeholder="Buscar por...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="submit">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Sair</a>
        </li>
      </ul>
    </div>
  </nav>
  
  <!-- conteido -->
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="dashboard">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">DashBoard - Lista</li>
      </ol>
      <div class="row">
        <div class="col-12">
         	<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Lista de Produtos
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
         						<tr class="text-center">
         							<th>ID</th>
									<th>Foto</th>
									<th>Nome</th>
									<th>Categoria</th>
									<th>Nacionalidade</th>
									<th>Preço</th>
									<th colspan="2">Ação</th>
								</tr>
         					</thead>
         					<tfoot>
         						<tr class="text-center">
         							<th>ID</th>
									<th>Foto</th>
									<th>Nome</th>
									<th>Categoria</th>
									<th>Nacionalidade</th>
									<th>Preço</th>
									<th colspan="2">Ação</th>
								</tr>
         					</tfoot>
         					<tbody>
         						<c:forEach items="${beers}" var="beer">
         							<tr class="text-center">
         								<td> ${beer.id} </td>
         								<td><img width="64" src="foto?nome=${beer.path}"></td>
         								<td> ${beer.name} </td>
         								<td> ${beer.category} </td>
         								<td> ${beer.nationality} </td>
         								<td> ${beer.price} </td>
         								<td>
         									<a href="editar?id=${beer.id}" class="nav-link">
            								<i class="fa fa-fw fa-edit"></i>Editar</a>
         								</td>
         								<td>
         									<a href="" class="nav-link" id="idExcluir" data-id="${beer.id}" data-toggle="modal"  data-target="#excluirModal" onclick="populaModalExcluir(${beer.id})">
            								<i class="fa fa-fw fa-window-close"></i>Excluir</a>
         								 </td>
         							</tr>
         						</c:forEach>
         					</tbody>
         				</table>
         			</div>
         		</div>
         	</div>
        </div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright BestBeer Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Deseja Sair?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">X</span>
            </button>
          </div>
          <div class="modal-body">Aperte "SAIR" abaixo se você deseja sair da sessão.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <a class="btn btn-primary" href="sair">SAIR</a>
          </div>
        </div>
      </div>
    </div>
    
      <!-- Excluir Modal-->
    <div class="modal fade" id="excluirModal" tabindex="-1" role="dialog" aria-labelledby="excluirModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="excluirModalLabel">Excluir</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">X</span>
            </button>
          </div>
          <div class="modal-body">Deseja excluir o produto ? </div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
            <div class="btn-excluir" id="btn-excluir">
            <a class="btn btn-primary" id="excluirModalBtn" >Excluir</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="resources/bootstrap/vendor/jquery/jquery.min.js"></script>
    <script src="resources/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="resources/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="resources/bootstrap/js/sb-admin.min.js"></script>
    <script src="resources/bootstrap/js/jquery-3.3.1.js"></script>
    
    <script type="text/javascript">
    	
    	function populaModalExcluir(id){
    		element = document.getElementById('btn-excluir');
   			var excluir = 'Excluir' 
    		element.innerHTML = '<a href="excluir?id=' + id +'"' + 'class="btn btn-primary" id="excluirModalBtn" >' + excluir + '</a>';
    		
    	}
    
    </script>
 
  </div>
</body>

</html>
