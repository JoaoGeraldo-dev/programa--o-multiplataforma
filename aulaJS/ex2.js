function opcao(){
    let op = document.getElementById("op").value;

    switch(op){
        case "1":
        document.getElementById("respostas").innerHTML = "digite o valor para calculo da raiz quadrada: <br> <input type='Number' id='r1'> <input type='button' value='calcular'> <br><p id='res1'>Resultado: </p> "
         break;
         case "2":
        document.getElementById("respostas").innerHTML = "digite os numeros para a exponensiação de 2 numero: <br> <input type='Number' id='exp1'> <br> <input type='Number' id='exp2'> <input type='button' value='calcular'> <br><p id='res2'>Resultado: </p> "
        break;
        case "3":
             document.getElementById("respostas").innerHTML = "Digite o valor de a: <input type='Number' id='a'> <br> Digite o valor de b:<input type='Number' id='b'> <br><br><input type='button' value='calcular'> <br><br><p id='res2'>Resultado: </p> "

    }

}