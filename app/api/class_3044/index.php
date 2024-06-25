<?php
$password = $_POST["password"];

if ($password == '123456') {
    echo "Login Success";
} else {
    echo "Login Faild";
}