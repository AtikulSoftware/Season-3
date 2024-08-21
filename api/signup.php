<?php
// ইউজার data input দিয়েছে কিনা চেক করা হচ্ছে । 
if (isset($_POST['key'])) {

    // key get করে request চেক করা হচ্ছে। 
    $key = $_POST['key'];
    $keyPass = "AywPhYorF8r4lpYk";
    $myData = decriptData($key, $keyPass);

    if ($myData == "Atikul@123") {

        if (($_POST['email']) && isset($_POST['password']) && isset($_POST['name']) && isset($_POST['image'])) {
            $email = $_POST['email'];
            $password = $_POST['password'];
            $name = $_POST['name'];
            $image = $_POST['image'];

            // database এর তথ্য
            $hostname = "localhost";
            $dbusername = "root";
            $dbpassword = "";
            $database = "section_7";

            // database connect করা হচ্ছে।
            $con = mysqli_connect($hostname, $dbusername, $dbpassword, $database);

            // database সঠিক ভাবে connect হয়েছে কিনা চেক করা হচ্ছে। 
            if (mysqli_connect_errno()) {
                echo "Connection Faild <br> " . mysqli_connect_error();
            } else {

                // একই ইমেইল আছে কিনা চেক করা হচ্ছে । 
                $sqlRow = "SELECT * FROM my_table WHERE email LIKE '$email'";
                $resultRow = mysqli_query($con, $sqlRow);
                $rowCount = mysqli_num_rows($resultRow);

                if ($rowCount <= 0) {
                    // ছবি কে base64 এ decode করা হয়েছে। 
                    $decodedImage = base64_decode($image);

                    // ছবির নাম এবং path তৈরি করা হয়েছে।
                    $fileName = time() . '_' . rand(1000, 10000) . '.jpg';
                    $imagePath = "images/" . $fileName;

                    // ছবি কে upload করা হয়েছে। 
                    if (file_put_contents($imagePath, $decodedImage)) {
                        $sql = "INSERT INTO `my_table`(`name`, `email`, `password`, `image`) VALUES ('$name','$email','$password','$fileName')";
                        $result = mysqli_query($con, $sql);
                        if ($result) {
                            echo "Signup_Successfully";
                        } else {
                            echo "Signup Failed";
                        }
                        mysqli_close($con);
                    } else {
                        echo "image upload হয়নি।";
                    }
                } else {
                    echo "এই ইমেইলে দিয়ে already অ্যাকাউন্ট করা আছে";
                }
            }

        } else {
            echo "সব গুলা input দিয়ে তারপর API hit করুন";
        }
    } else {
        echo "API TOKEN ভুল দিয়েছেন";
    }

} else {
    echo "API TOKEN দিন";
}


function decriptData($text, $keyPass)
{
    $decoded = base64_decode($text);
    $decrypted = openssl_decrypt($decoded, "AES-128-ECB", $keyPass, OPENSSL_RAW_DATA);
    return $decrypted;
}






