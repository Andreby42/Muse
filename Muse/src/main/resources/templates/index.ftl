<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Muse</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${ctx!}/assets/plugins/bootstarp/css/bootstrap.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${ctx!}/assets/plugins/font-awesome/css/font-awesome.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${ctx!}/assets/plugins/Ionicons/css/ionicons.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${ctx!}/assets/css/AdminLTE.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="${ctx!}/assets/plugins/iCheck/square/blue.css">
    <!--favicon-->
 	<link rel="icon" type="image/x-icon" href="/static/favicon.ico">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
<div class="login-box" id="app">
    <div class="login-logo">
        <a href="../../index.ftl"><b>缪斯</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
    <#--<p class="login-box-msg"></p>-->
        <#if message??>
        <div class="alert alert-danger alert-dismissible">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4><i class="icon fa fa-ban"></i> Error!</h4>
            ${message}
        </div>
        </#if>
        <form id="form-login" action="${ctx!}/muse/song" method="post">
            <div class="form-group has-feedback">
                <input type="username" name="songName" class="form-control" placeholder="歌曲名称">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4 col-xs-offset-8">
                    <button type="submit" class="btn btn-primary btn-block btn-flat btn-sign">获得链接</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="${ctx!}/assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${ctx!}/assets/plugins/bootstarp/js/bootstrap.js"></script>
<!-- iCheck -->
<script src="${ctx!}/assets/plugins/iCheck/icheck.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
