this.messages([{
	featureName: null,
	style: 'list-group-item-danger',
	message: errorThrown + " " + textStatus
}]);

//Modal resizing to address error messages.
var modalBody = $('#{{app-id}}-modal .modal-body');
var form = modalBody.find('form');
modalBody.height((form.height() + 30) + "px");	
