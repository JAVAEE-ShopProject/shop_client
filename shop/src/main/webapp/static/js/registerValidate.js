$(function () {
    //页面加载完成之后
    $("#registerForm").validate({
        rules: {
            "username": {
                required: true,
                "validateName":true
            },
            "password": {
                required: true,
                rangelength:[6,12]
            },
            "confirmpwd": {
                required: true,
                equalTo:"#password"
            },
            "email": {
                required: true,
                email:true
            },
            "telephone": {
                required: true
            },
            "name": {
                required: true
            },
            "address": {
                required: true
            },
            "birthday":{
                required: true,
                date:true
            },
            "sex": {
                required: true
            },
            "code": {
                required: true
            }
        },
        messages: {
            "username": {
                required: "用户名必填",
                "validateName":"用户名已存在"
            },
            "password": {
                required: "密码必填",
                rangelength:"密码长度在6到12位"
            },
            "confirmpwd": {
                required: "重复密码必填",
                equalTo:"两次密码不一致"
            },
            "email": {
                required: "邮箱必填",
                email:"邮箱格式不正确"
            },
            "telephone": {
                required: "手机号必填"
            },
            "name": {
                required: "真实姓名必填"
            },
            "address": {
                required: "地址必填"
            },
            "birthday":{
                required: "出生日期必填",
                date:"日期格式不正确"
            },
            "sex": {
                required:"性别必选"
            },
            "code": {
                required: "验证码必填"
            }
        },
        errorPlacement: function (error, element) { //指定错误信息位置
            if (element.is(':radio') ) { //如果是radio或checkbox
                var eid = element.attr('name'); //获取元素的name属性
                error.appendTo(element.parent().parent()); //将错误信息添加当前元素的父结点后面
            } else if ( element.is('#code')){
                var eid = element.attr('name'); //获取元素的name属性
                error.appendTo(element.parent()); //将错误信息添加当前元素的父结点后面
            }else{
                error.insertAfter(element);
            }
        }
    });

    //需自定义两个校验规则  验证用户名 验证 验证码
    $.validator.addMethod("validateName",function(value,element,params){
        var isValid = false;
        $.ajax({
            "async":false,
            url:"user",
            type:"post",
            data:"method=validateName&username="+value,
            dataType:"json",
            success:function (data) {
                isValid = data.isValid;
            }
        });
        return isValid;
    });
    //给验证码图片绑定点击事件
    $("#codeImg").click(function () {
        this.src = "code.jpg?date="+Date.now();
    })
});