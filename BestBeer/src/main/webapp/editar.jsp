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
  <title>The BEST BEER - EDITAR</title>
  <!-- Bootstrap core CSS-->
  <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="resources/bootstrap/vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
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
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
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
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="dashboard">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Edição</li>
      </ol>
      <div class="row">
        <div class="col-12">
        	<div class="container">
    			<div class="card card-register-product mx-auto mt-5">
      			<div class="card-header">Edição de Produto</div>
     				<div class="card-body">		
				        <form action="editar" method="post" enctype="multipart/form-data">
				        	<div class="form-group">
				            	<div class="form-row">
				              		<div class="input-group mb-3">
					              		<div class="input-group-prepend">
					              		<span class="input-group-text">Imagem</span>
					              		</div>
						              		<div class="custom-file">
						              			<label class="custom-file-label" for="inputImage">Escolha a Foto</label>
						              			<input type="file" name="imagem" class="custom-file-input" id="inputImage">
						              		</div>
						              		<br>
				              		</div>
						              		<div class="nomeFile"> </div>
				           		</div>
				          	</div>
				          	<div class="form-group">
            					<div class="form-row">
            						<div class="col-md-6">
										<img width="64" class="img-fluid" id="imgFile" alt="Responsive image" src="foto?nome=${beer.path}">				          	
            						</div>
            						<div class="col-md-6">
				                		<label for="inputId">ID</label>
				                		<input class="form-control" name="id" id="inputId" type="text" readonly="readonly"  value="${beer.id}">
				              		</div>
            					</div>
            					<div class="form-row">
            						<div class="col-md-6">
				                		<label for="inputName">Nome</label>
				                		<input class="form-control" name="nome" id="inputName" type="text"  placeholder="Nome do produto" value="${beer.name}">
				              		</div>
            						<div class="col-md-6">
		            					<label for="inputNacionalidade">Nacionalidade</label>
		            					<input class="form-control" name="nacionalidade" id="inputNacionalidade" type="text"  placeholder="Nacionalidade" value="${beer.nationality}"">
          							</div>
          							<div class="col-md-6">
						                <label for="inputCategoria">Categoria</label>
						                <input class="form-control" name="categoria" id="inputCategoria" type="text" placeholder="Categoria" value="${beer.category}">
              						</div>
					              	<div class="col-md-6">
					              		<label for="inputPreco">Preço</label>
					              		<div class="input-group mb-3">
						              		<div class="input-group-prepend">
						              			<span class="input-group-text">R$ 0.00</span>
						              		</div>
							                <input class="form-control" name="preco" id="inputPreco" aria-label="Amount" type="text" value="${beer.price}" placeholder="0.00">
					              		</div>
					              	</div>
          						</div>
            				</div>
   				
          						 <div class = "alert alert-danger" style="display: ${empty erro ? 'none' : ''}" > 
									<a class="close text-center" data-dismiss="alert"> × </a> 
									<a class="text-center"> ${erro} </a>
								 </div> 
          					<input type="submit" class="btn btn-primary btn-block" value="Cadastrar">
				        </form>
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
            <a class="btn btn-primary" href="login.jsp">SAIR</a>
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
    <script>
    	var div = document.getElementsByClassName("nomeFile")[0];
    	var input  = document.getElementById("inputImage");
    	
    	div.addEventListener("click", function(){
    	input.click();
			});
			input.addEventListener("change", function(){
			    var nome = "Não há arquivo selecionado. Selecionar arquivo...";
			    if(input.files.length > 0){
			     	nome = input.files[0].name;
			    	document.getElementById("imgFile").style.display = 'none';
			    }
			    div.innerHTML = nome;
			});
    	
    </script>
  </div>
</body>

</html>
