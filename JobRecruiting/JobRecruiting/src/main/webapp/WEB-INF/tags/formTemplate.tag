<%-- 
    Document   : formTemplate
    Created on : Jan 10, 2021, 4:50:08 PM
    Author     : DENISA
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- any content can be specified here e.g.: --%>
<style>
    main.container{
        max-width: 1560px!important;
    }

    body{
        background-image: linear-gradient(to right, #5f72bd 0%, #9b23ea 100%);
    }

    .register{
        margin-top: 3%;
        padding: 3%;
    }
    .register-left{
        text-align: center;
        color: #fff;
        margin-top: 4%;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;

    }
    textarea.form-control {
        min-height: calc(5.4em + 0.85rem + 2px);
    }

    .text-purple{
        color: #5f72bd;
    }

    .register-left input{
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        width: 60%;
        background: #f8f9fa;
        font-weight: bold;
        color: #383d41;
        margin-top: 30%;
        margin-bottom: 3%;
        cursor: pointer;
    }
    .register-right{
        background: #f8f9fa;
        border-top-left-radius: 10% 50%;
        border-bottom-left-radius: 10% 50%;
    }
    .register-left img{
        margin-top: 15%;
        margin-bottom: 5%;
        width: 25%;
        -webkit-animation: mover 2s infinite  alternate;
        animation: mover 1s infinite  alternate;
    }
    @-webkit-keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    @keyframes mover {
        0% { transform: translateY(0); }
        100% { transform: translateY(-20px); }
    }
    .register-left p{
        font-weight: lighter;
        padding: 12%;
        margin-top: -9%;
    }
    .register .register-form{
        padding: 10%;
        margin-top: 10%;
    }
    .btnRegister{
        float: right;
        margin-top: 32px;
        border: none;
        border-radius: 1.5rem;
        padding: 2%;
        background: #5f72bd;
        color: #fff;
        font-weight: 600;
        width: 50%;
        cursor: pointer;
    }

    .register-heading{
        text-align: center;
        margin-top: 8%;
        margin-bottom: -15%;
        color: #495057;
    }
</style>

<div class="register">
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Hello there!</h3>
            <p>Have fun filling out this form!</p>
        </div>
        <div class="col-md-9 register-right">
            <jsp:doBody />
        </div>
    </div>

</div>
