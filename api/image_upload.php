<?php
$image = $_POST['image'];
$decodedImage = base64_decode($image);

// image name & path
$fileName = time() . '_' . rand(1000, 10000) . '.jpg';
$imagePath = "images/" . $fileName;

if (isset($image)) {
    if (file_put_contents($imagePath, $decodedImage)) {
        echo "image সঠিক ভাবে upload হয়েছে।";
    } else {
        echo "image upload হয়নি।";
    }
} else {
    echo "কোনো image নেই।";
}
