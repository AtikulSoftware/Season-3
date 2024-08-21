<?php
// ইউজার data input দিয়েছে কিনা চেক করা হচ্ছে । 
if (isset($_POST['key'])) {

    // key get করে request চেক করা হচ্ছে। 
    $key = $_POST['key'];
    $myData = decriptData($key, $keyPass);

    if ($myData == "Atikul@123") {

        if (isset($_POST['email']) && isset($_POST['password'])) {

            // input get করা হচ্ছে। 
            $email = $_POST['email'];
            $password = $_POST['password'];

            // database এর তথ্য
            $hostname = "localhost";
            $dbusername = "root";
            $dbpassword = "";
            $database = "section_7";

            // database connect করা হচ্ছে।
            $con = mysqli_connect($hostname, $dbusername, $dbpassword, $database);
            $sql = "SELECT * FROM my_table WHERE email='$email' AND password='$password'";
            $result = mysqli_query($con, $sql);
            $rowCount = mysqli_num_rows($result);

            if ($rowCount > 0) {
                echo "Login Success";
            } else {
                echo "Login Faild";
            }

        } else {
            echo "email এবং password দুই টাই দিতে হবে";
        }

    } else {
        echo "API TOKEN ভুল দিয়েছেন";
    }

} else {
    echo "API TOKEN দিন";
}


function decriptData($text)
{
    $decoded = base64_decode($text);
    $keyPass = "AywPhYorF8r4lpYk";
    $decrypted = openssl_decrypt($decoded, "AES-128-ECB", $keyPass, OPENSSL_RAW_DATA);
    return $decrypted;
}
