<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dronemania - Sistema de Ventas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Dronemania</h1>
        <div class="container">
            <form >
              <h2 >Registrar Venta</h2>
              <h4 id="mensaje"></h4>
              <label for="inputCliente" class="sr-only">Cliente</label>
              <input type="text" id="inputCliente" class="form-control" placeholder="Ingrese nombre de cliente" required autofocus>
              <button id="butGuardarPedido" class="btn btn-primary" type="button">Guardar</button>
              <button id="butAgregarLinea" 
                      class="btn btn-primary" 
                      data-toggle="modal" data-target="#modal_detalle"
                      type="button">
                  Agregar Línea
              </button>
            </form>
            <hr/>
            <h3>Detalle de Pedido</h3>
            <table class="table" id="tabla_detalle">
                <tr>
                    <th>Drone</th>
                    <th>Cantidad</th>
                </tr>
            </table>
            <div class="modal fade"
                 id="modal_detalle" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title">Elegir un drone</h4>
                        </div>
                        <div class="modal-body">
                            <input type="text" id="inputCantidad" class="form-control" placeholder="Ingrese cantidad" required autofocus>
                            <table class="table table-striped" id="tabla_drones">
                                <tr>
                                    <th>Selec.</th>
                                    <th>Modelo</th>
                                    <th>Marca</th>
                                    <th>Stock</th>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" id="butElegir" class="btn btn-default" data-dismiss="modal">Elegir</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>
        
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/registrar_pedido.js"></script>
    </body>
</html>
