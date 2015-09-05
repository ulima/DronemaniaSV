var onLogin = function(evt){
    var request = {
        usuario: document.querySelector('#inputUsuario').value,
        password: document.querySelector('#inputPassword').value
    };
    
    $.post('login', 
        JSON.stringify(request),
        function(data){
            console.log(data);
        }
    );
};

window.addEventListener('load', function(){
    document.querySelector('#butLogin').addEventListener('click', onLogin);
});


