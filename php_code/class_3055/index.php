<?php
$encoded = "F9zxG546RCncjwbG0N/Vcw==";
$password = "AywPhYorF8r4lpYk";

$decoded = base64_decode($encoded);
$decrypted = openssl_decrypt($decoded, "AES-128-ECB", $password, OPENSSL_RAW_DATA);
echo $decrypted;

