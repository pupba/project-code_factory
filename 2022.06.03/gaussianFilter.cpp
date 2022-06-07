#include "opencv2/opencv.hpp"
#include <iostream>
using namespace std;
using namespace cv;

int main()
{
	Mat src = imread("./img/rose.bmp_std20.bmp");
	resize(src, src, Size(500, 500));
	imshow("Origin", src);
	
	Mat dst;
	GaussianBlur(src, dst, Size(5, 5), 1);
	// kernal size = (5 X 5) , stdX = 1
	imshow("Gaussian", dst);

	waitKey(0);
	return 0;
}
