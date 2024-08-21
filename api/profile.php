<?php
$json = file_get_contents('php://input');
$data = json_decode($json, true);



if (isset($data['key'])) {
    // key get করে request চেক করা হচ্ছে। 
    $key = $data['key'];
    $myData = decriptData($key);

    // চেক করা হচ্ছে । সঠিক pass দিয়েছে কিনা । 
    if ($myData == "Atikul@123") {
        $email = $data['email'];
        if (isset($email)) {

            // database এর তথ্য
            $hostname = "localhost";
            $dbusername = "root";
            $dbpassword = "";
            $database = "section_7";

            // database connect করা হচ্ছে।
            $con = mysqli_connect($hostname, $dbusername, $dbpassword, $database);

            $sql = "SELECT * FROM my_table WHERE email LIKE '$email'";
            $result = mysqli_query($con, $sql);
            $temp = [];

            foreach ($result as $item) {
                $name = $item['name'];
                $email = $item['email'];
                $image = $item['image'];
                $temp['name'] = $name;
                $temp['email'] = $email;
                $temp['image'] = "http://192.168.0.104/Apps/section_7/images/" . $image;
            }

            echo json_encode($temp);
        } else {
            echo "ইমেইল পাওয়া যায়নি";
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
