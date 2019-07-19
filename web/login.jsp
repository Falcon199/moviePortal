
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="limages/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lfonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lfonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lvendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="lcss/util.css">
    <link rel="stylesheet" type="text/css" href="lcss/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55" >
            <form class="login100-form validate-form flex-sb flex-w" action="/login" method="post">
					<span class="login100-form-title p-b-32">
						Account Login
					</span>

                <span class="txt1 p-b-11">
						Username
					</span>
                <div class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
                    <input class="input100" type="text" name="email" >
                    <span class="focus-input100"></span>
                </div>

                <span class="txt1 p-b-11">
						Password
					</span>
                <div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
                    <input class="input100" type="password" name="password" >
                    <span class="focus-input100"></span>
                </div>



                <div class="container-login100-form-btn" style="float: left; width: 45%" >
                    <button class="login100-form-btn">
                        Login
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="lvendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="lvendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="lvendor/bootstrap/js/popper.js"></script>
<script src="lvendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="lvendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="lvendor/daterangepicker/moment.min.js"></script>
<script src="lvendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="lvendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="ljs/main.js"></script>

</body>
</html>