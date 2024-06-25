<?php
$json = file_get_contents('php://input');
$data = json_decode($json, true);

$password = $data['password'];
$email = $data['email'];

$temp = array();

$temp['password'] = $password;
$temp['email'] = $email;

echo json_encode($temp);