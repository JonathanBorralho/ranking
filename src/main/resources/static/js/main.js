
$('.js-moneymask').maskMoney({
    thousands: '.',
    decimal: ',',
    allowZero: false,
    precision: 2
});

$('#modalExcluirPosto').on('show.bs.modal', function(event){
	
	var botao = $(event.relatedTarget);
	var postoId = botao.data('codigo');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if( !action.endsWith("/") ) {
		action += "/";
	}
	
	form.attr('action', action + postoId);
	
});


$(function () {
    $('[data-toggle="tooltip"]').tooltip()
})