<?php
$text = "Atikul Islam";
$password = "AywPhYorF8r4lpYk";


$decrypted = openssl_encrypt($text, "AES-128-ECB", $password, OPENSSL_RAW_DATA);
$decoded = base64_encode($decrypted);
echo $decoded;

