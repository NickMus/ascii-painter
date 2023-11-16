ASCii-Painter

This is an example of a simple web application that is capable of processing user files or video received from a web camera.
By default applicition starts on port :8080.
The algorithm is pretty simple. 
The application receives a user image, then reads information about each pixel(RGB), after which it receives the average value of the color and matches it to the character in the array.
For getting an image from web camera call http://localhost:8080/api/webcam
For uploading your file call http://localhost:8080/api/upload-image
The basic character set can be changed in Convertable -> char[] asciiTable.
The brightness of the image can be adjusted by adding spaces at the start or end of the array asciiTable. 
I suggest you experiment with this yourself!
