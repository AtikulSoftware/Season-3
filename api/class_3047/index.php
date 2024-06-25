<?php
$json = file_get_contents('php://input');
$jsonArray = json_decode($json, true);
$data = $jsonArray[0];

$password = $data['password'];
$email = $data['email'];

$myArray = array();

$temp = array();
$temp['password'] = $password;
$temp['email'] = $email;

array_push($myArray, $temp);
echo json_encode($myArray);