var drones = [];
var detalles = [];
window.addEventListener('load', function(){
    //Cargamos el listado de drones
    $.get('drones', 
        function(data){
            drones = data.drones;
            var tableDrones = document.querySelector('#tabla_drones');
            
            for (var indice in drones){
                tableDrones.innerHTML += '<tr>' + 
                        '<td><input type="radio" name="drones" value="' + indice + '" /></td>' + 
                        '<td>' + drones[indice].modelo + '</td>' +
                        '<td>' + drones[indice].marca + '</td>' +
                        '<td>' + drones[indice].stock + '</td>' +
                '</tr>';
            }
        }
    );
    
    document.querySelector("#butElegir").addEventListener(
            "click", function(evt){
                var indiceSeleccionado = 
                        document.querySelector('input[name=drones]:checked').value;
                var cantidad = document.querySelector('#inputCantidad').value;
                var detalle = {
                    idDrone : drones[indiceSeleccionado].id,
                    modelo: drones[indiceSeleccionado].modelo,
                    cantidad : cantidad
                };
                detalles.push(detalle);
                
                var tableDetalle = document.querySelector('#tabla_detalle');
                tableDetalle.innerHTML += '<tr>' + 
                        '<td>' + detalle.modelo + '</td>' +
                        '<td>' + detalle.cantidad+ '</td>' +
                '</tr>';
            });
    
    document.querySelector('#butGuardarPedido').addEventListener(
            'click', function(){
                var cliente = document.querySelector('#inputCliente').value;
                var request = {
                    id : 1,
                    cliente: cliente,
                    detalle : detalles
                };
                $.post('pedidos', 
                    JSON.stringify(request),
                    function(data){
                        document.querySelector('#mensaje').innerHTML = 
                                'Se guardó el pedido correctamente';
                    }
                );
            })
});