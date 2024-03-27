

let login = {
    url:'',
    init:function(url){
        this.url = url;
        $('#login_form > button').click(function(){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            if(id == '' || id == null){
                alert('ID를 입력 하세요');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null){
                alert('PWD를 입력 하세요');
                $('#pwd').focus();
                return;
            }
            login.send();
        });
    },
    send:function(){
        $('#login_form').attr({
            'method':'post',
            'action':this.url
        });
        $('#login_form').submit();
    }
};
let register = {
    url:'',
    init:function(url){
        this.url = url;
        $('#register_form > button').click(function(){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            let name = $('#name').val();
            if(id == '' || id == null){
                alert('ID를 입력 하세요');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null){
                alert('PWD를 입력 하세요');
                $('#pwd').focus();
                return;
            }
            if(name == '' || name == null){
                alert('NAME를 입력 하세요');
                $('#name').focus();
                return;
            }
            register.send();
        });
    },
    send:function(){
        $('#register_form').attr({
            'method':'post',
            'action':this.url
        });
        $('#register_form').submit();
    }
};
// JSON (JavaScript Object Notation)
let datas = [
    {"id":"id01","name":"james1"},
    {"id":"id02","name":"james2"},
    {"id":"id03","name":"james3"},
    {"id":"id04","name":"james4"},
    {"id":"id05","name":"james5"}
];
let html2 = {

    init:function (){
        $('#btn').click(function(){
            html2.display(datas);
        });
    },
    display:function(datas){
        let result = '';
        $(datas).each(function(index, data){
            result += '<tr>';
            result += '<td>'+data.id+'</td>';
            result += '<td>'+data.name+'</td>';
            result += '</tr>';
        });
        $('#cust_tb > tbody').html(result);
    }
};
