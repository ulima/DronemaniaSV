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

var onLoginSocial = function(evt){
    var network = evt.target.id === 'butLoginFacebook' ? "facebook" : "twitter";
    $.post('login-social?network=' + network, 
        function(data){
            document.location.href = data.urlCallback;
        }
    );
};

var onLoginFacebook = function(evt){
    $.post('login-facebook', 
        function(data){
            document.location.href = data.urlCallback;
        }
    );
};

var onLoginTwitter = function(evt){
    $.post('login-twitter', 
        function(data){
            document.location.href = data.urlCallback;
        }
    );
};

window.addEventListener('load', function(){
    document.querySelector('#butLogin').addEventListener('click', onLogin);
    document.querySelector('#butLoginFacebook').addEventListener(
            'click', onLoginSocial);
    document.querySelector('#butLoginTwitter').addEventListener(
            'click', onLoginSocial);
});


