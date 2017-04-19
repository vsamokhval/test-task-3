(function () {
  const REST_SERVICE_URI = '/TestTask3/message/';

  $('.delete-button').on('click', this, onDelete);


  function onDelete (event) {

    console.log($(event.currentTarget).attr('data-id'));

    let id = $(event.currentTarget).attr('data-id');

    $.ajax({
      url: REST_SERVICE_URI + id,
      type: 'DELETE',
      success: callback
    });

    function callback() {
      $(event.currentTarget).parent().parent().remove();
    }
  }

})();