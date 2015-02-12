
function verificaValidade(){
  evt = window.event;
  var tecla = evt.keyCode;

  if(tecla > 4 && tecla < 1){
    alert('Um mês pode ter apenas 4 semanas! Tecle um número de 1 a 4.');
    evt.preventDefault();
  }
}
