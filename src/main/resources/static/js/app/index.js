var main = {
    init : function(){
        var _this = this;
        //id : btn-save 받아오기.
        $('#btn-save').on('click',function(){
            _this.save();
        });
    },
    save : function() {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        //data 변수에 key:value 값들을 입력하여 그것을 json 형태로 만든 뒤 url로 전송하는 api
        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
            contentType:'application/json; charset = utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type    : 'PUT',
            url     : '/api/v1/posts/'+id,
            dataType: 'json',
            contentType : 'application/json; charset=utf-8',
            data    : JSON.stringify(data)
        }).done(function(){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();